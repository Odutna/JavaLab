package com.civiletti.cifrariocesare;

import java.util.Scanner;

/**
 *  ===========================
 *  = Matrice di Permutazione =
 *  ===========================
 *
 * Selezione della Permutazione
 *
 * La permutazione scelta dipende dalla lunghezza della stringa.
 *
 * Supponiamo che la lunghezza sia 5:
 *
 *      int indicePermutazione = lunghezza % PERMUTAZIONI.length;
 *
 * Con una lunghezza di 5 e 3 permutazioni disponibili (PERMUTAZIONI.length = 3), il modulo restituisce:
 *
 *      indicePermutazione = 5 % 3 = 2.
 *
 * Quindi useremo la terza permutazione, {1, 0, 4, 3, 2}.
 */

public class TranspositionePermutationeFix {

    // Matrice di permutazioni predefinite
    private static final int[][] PERMUTAZIONI = {
            {3, 1, 4, 0, 2},   // Prima permutazione
            {2, 4, 0, 1, 3},   // Seconda permutazione
            {1, 0, 4, 3, 2}    // Terza permutazione
    };

    private String originale;
    private String cifrata;
    private static int[] permutazione;
    private static int[] permutazioneInversa;

    // Metodo per selezionare una permutazione
    public static void selezionaPermutazione(int lunghezza) {

        // Scegli una permutazione in base alla lunghezza
        int indicePermutazione = lunghezza % PERMUTAZIONI.length;

        permutazione = new int[lunghezza];
        permutazioneInversa = new int[lunghezza];

        // Copia la permutazione predefinita
        for (int i = 0; i < lunghezza; i++) {
            // Se l'indice è fuori dalla permutazione predefinita, usa l'indice originale
            if (i < PERMUTAZIONI[indicePermutazione].length) {
                permutazione[i] = PERMUTAZIONI[indicePermutazione][i];
            } else {
                permutazione[i] = i;
            }
        }

        // Genera la permutazione inversa
        for (int i = 0; i < lunghezza; i++) {
            permutazioneInversa[permutazione[i]] = i;
        }
    }

    // Modifica il metodo cifratura per usare selezionaPermutazione
    public static char[] cifratura(char[] input, int[] shift) {

        CodDecodChar cdc = new CodDecodChar();
        char[] risultato = new char[input.length];

        // Usa la nuova selezione di permutazione
        selezionaPermutazione(input.length);

        for (int i = 0; i < input.length; i++) {
            int indicePermutato = permutazione[i];
            int shiftIndex = i % shift.length; // Cicla lo shift
            risultato[i] = cdc.codificaCaratteri(input[i], shift[shiftIndex]);
        }
        return risultato;
    }

    // Modifica analoga per decifratura
    public static char[] decifratura(char[] input, int[] shift) {
        CodDecodChar cdc = new CodDecodChar();
        char[] risultato = new char[input.length];

        // Usa la stessa permutazione della cifratura
        // (già generata durante la cifratura)
        for (int i = 0; i < input.length; i++) {
            int indiceOriginale = permutazioneInversa[i];
            int shiftIndex = i % shift.length; // Cicla lo shift
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

        TranspositionePermutationeFix cc = new TranspositionePermutationeFix();

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
