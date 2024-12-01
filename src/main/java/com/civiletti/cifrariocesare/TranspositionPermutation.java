package com.civiletti.cifrariocesare;


import java.util.Random;
import java.util.Scanner;

/**
 * Questo esempio rappresenta un miglioramento del cifrario di Cesare.
 *
 * Il modulo (%), utilizzato nel calcolo della codifica, è essenziale per garantire
 * una ciclazione circolare. Ciò significa che, se si supera il limite massimo
 * rappresentabile per un carattere (es. nel set Unicode), si riparte dal minimo.
 * Questo evita errori o risultati fuori dall'intervallo dei caratteri validi.
 *
 * # Ciclazione con il Modulo (%)
 *
 * La tabella mostra il comportamento del modulo ('%') per numeri da 0 a 15 con divisore 5:
 *
 * | Numero | Divisione Intera (÷) | Resto | Risultato Modulo (%) |
 * |--------|----------------------|-------|----------------------|
 * | 0      | 0 ÷ 5 = 0            | 0     | 0 % 5 = 0            |
 * | 1      | 1 ÷ 5 = 0            | 1     | 1 % 5 = 1            |
 * | 2      | 2 ÷ 5 = 0            | 2     | 2 % 5 = 2            |
 * | 3      | 3 ÷ 5 = 0            | 3     | 3 % 5 = 3            |
 * | 4      | 4 ÷ 5 = 0            | 4     | 4 % 5 = 4            |
 * | 5      | 5 ÷ 5 = 1            | 0     | 5 % 5 = 0            |
 *
 * 1. Il modulo è "circolare": quando il numero raggiunge un multiplo del divisore, torna a '0'.
 * 2. I valori del modulo sono sempre compresi tra '0' e il divisore.
 *
 * # Algoritmo di Cifratura con Diffusione e Shift
 *
 * ## Principi della Crittografia Utilizzati
 * 1. **Confusione**: Aggiunta tramite lo `shift` sui caratteri per alterare i loro valori originali.
 * 2. **Diffusione**: Implementata usando una permutazione casuale degli indici, così che i caratteri siano distribuiti
 *    in posizioni non sequenziali.
 *
 * ## Passaggi Esemplificativi
 * - Input: "TESTO" → Array di caratteri: ['T', 'E', 'S', 'T', 'O']
 * - **Shift** (es. +2):
 *   - ['T', 'E', 'S', 'T', 'O'] → ['V', 'G', 'U', 'V', 'Q'] (ASCII incrementato di 2)
 * - **Permutazione** casuale degli indici (es. permutazione = [3, 0, 4, 1, 2]):
 *   - Prima: ['V', 'G', 'U', 'V', 'Q']
 *   - Dopo:  ['V', 'V', 'Q', 'G', 'U'] (caratteri riorganizzati secondo la permutazione)
 * - Output cifrato: "VVQGU"
 *
 * ## Decifratura
 * 1. Inverso della permutazione: Ripristina la posizione originale dei caratteri.
 * 2. Shift inverso (-2): Riporta i caratteri al valore originale.
 *
 * ## Cosa Manca per una Cifratura Perfetta
 * 1. **Resistenza al brute force**: Lo shift è prevedibile; un numero limitato di tentativi può rivelare il messaggio.
 * 2. **Chiave unica per ogni sessione**: La permutazione è statica; un attaccante che la scopre può decodificare altri messaggi.
 * 3. **Non ha entropia sufficiente**: Non introduce rumore (es. padding casuale o XOR con dati imprevedibili).
 * 4. **Non verifica l'integrità**: Mancano firme o checksum per rilevare modifiche non autorizzate.
 *
 * ## Come Migliorarlo
 * - Usare chiavi complesse e uniche per ogni sessione.
 * - Integrare un algoritmo moderno come AES o RSA.
 * - Aggiungere un meccanismo di verifica dell'integrità (es. MAC o HMAC).
 *
 */

public class TranspositionPermutation {

    private String originale;
    private String cifrata;
    private static int[] permutazione;
    private static int[] permutazioneInversa;

    // Genera permutazioni casuali con array e Random
    public static void generaPermutazioni(int lunghezza) {
        permutazione = new int[lunghezza];
        permutazioneInversa = new int[lunghezza];
        Random rand = new Random();

        // Riempie l'array con valori sequenziali
        for (int i = 0; i < lunghezza; i++) {
            permutazione[i] = i;
        }

        // Mescola gli indici
        for (int i = 0; i < lunghezza; i++) {
            int randomIndex = rand.nextInt(lunghezza);
            // Scambio
            int temp = permutazione[i];
            permutazione[i] = permutazione[randomIndex];
            permutazione[randomIndex] = temp;
        }

        // Genera la permutazione inversa
        for (int i = 0; i < lunghezza; i++) {
            permutazioneInversa[permutazione[i]] = i;
        }
    }

    // Cifra il testo con la permutazione
    public static char[] cifratura(char[] input, int[] shift) {
        CodDecodChar cdc = new CodDecodChar();
        char[] risultato = new char[input.length];
        // Genera permutazioni
        generaPermutazioni(input.length);
        for (int i = 0; i < input.length; i++) {
            int indicePermutato = permutazione[i];
            int shiftIndex = i % shift.length; // Cicla lo shift
//            risultato[indicePermutato] = (char) ((input[i] + shiftIndex) % 65536);
            risultato[i] = cdc.codificaCaratteri(input[i], shift[shiftIndex]);
        }
        return risultato;
    }

    // Decifra il testo con la permutazione inversa
    public static char[] decifratura(char[] input, int[] shift) {
        CodDecodChar cdc = new CodDecodChar();
        char[] risultato = new char[input.length];
        // Genera permutazioni
        //generaPermutazioni(input.length);
        for (int i = 0; i < input.length; i++) {
            int indiceOriginale = permutazioneInversa[i];
            int shiftIndex = i % shift.length; // Cicla lo shift
//            risultato[indiceOriginale] = (char) ((input[i] - shiftIndex + 65536) % 65536); // + 65536 assicura che non ci siano valoli negativi
            risultato[i] = cdc.decodificaCaratteri(input[i], shift[shiftIndex]);
        }
        return risultato;
    }

    public char[] inserisciStringa(Scanner sc){
        System.out.println("Inserisci la stringa:");
        this.originale = sc.nextLine();
        return this.originale.toCharArray();
    }

    public void visualizzaStringa(char[] stringa){
        for(int i = 0; i < stringa.length; i++){
            System.out.print(stringa[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        TranspositionPermutation cc = new TranspositionPermutation();

        int[] traslazione = {2,3,4,5,6,7,2,4,6,8,9,1,2,1,2,6,12,2,7,4,3,3,1,2,2,1}; // 26 shift diversi da usare ciclicamente

        char scelta;

        System.out.println("======================================================");
        System.out.println("=     Cifrario di Cesare Confusione + Diffusione     =");
        System.out.println("======================================================");

        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("\t\t[0] Cifra [1] Decifra [n] Esci");
            scelta = sc.nextLine().charAt(0);  // Attenzione next() legge solo fino al primo spazio e non prende l'enter '\n'

            switch (scelta) {
                case '0':
                    char[] codifica = cc.inserisciStringa(sc);
                    codifica = cc.cifratura(codifica, traslazione);
                    cc.visualizzaStringa(codifica);
                    break;
                case '1':
                    char[] decodifica = cc.inserisciStringa(sc);
                    decodifica = cc.decifratura(decodifica, traslazione);
                    cc.visualizzaStringa(decodifica);
                    break;
                default:
                    System.out.println("Arrivederci!");
                    break;

            }
        } while(scelta != 'n');

        sc.close();
    }
}
