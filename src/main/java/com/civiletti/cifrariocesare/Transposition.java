package com.civiletti.cifrariocesare;

import java.util.Scanner;

/**
 * Questo esempio rappresenta l'implementazione di un cifrario di Cesare che prevede uno shift
 * diverso a seconda della posizione aumentando la confusione.
 *
 *                                         # CONFUSIONE #
 *
 * Lo shift variabile agisce sulla confusione del messaggio, ovvero sulla modifica del valore dei
 * caratteri per rendere il testo non leggibile senza la chiave. Lo shift, essendo variabile e
 * ciclico, aumenta la complessità rispetto a uno statico.
 *
 *                                         # DIFFUSIONE #
 * CHIAVE1:
 * Il set di valori usato nello shift costituisce una parte della chiave crittografica.
 *
 *
 * Gli array di permutazione spostano i caratteri in posizioni diverse, aumentando la diffusione,
 * che distribuisce le informazioni del testo originale su tutto il messaggio cifrato.
 *
 * CHIAVE2
 *    Permutazione diretta: usata per cifrare.
 *    Permutazione inversa: usata per decifrare
 *
 *                                   # SIGNIFICATO DEL MODULO #
 *
 * Il modulo (%), utilizzato nel calcolo della codifica, è essenziale per garantire una ciclazione
 * circolare. Ciò significa che, se si supera il limite massimo rappresentabile per un carattere
 * (es. nel set Unicode), si riparte dal minimo.
 *
 * Questo evita errori o risultati fuori dall'intervallo dei caratteri validi.
 *
 *
 *                                 # Ciclazione con il Modulo (%) #
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
 * | 6      | 6 ÷ 5 = 1            | 1     | 6 % 5 = 1            |
 * | 7      | 7 ÷ 5 = 1            | 2     | 7 % 5 = 2            |
 * | 8      | 8 ÷ 5 = 1            | 3     | 8 % 5 = 3            |
 * | 9      | 9 ÷ 5 = 1            | 4     | 9 % 5 = 4            |
 *
 * 1. Il modulo è "circolare": quando il numero raggiunge un multiplo del divisore, torna a '0'.
 * 2. I valori del modulo sono sempre compresi tra '0' e il divisore.
 *
 */

public class Transposition {
    String originale;
    String cifrata;


    public char[] inserisciStringa(Scanner sc){
        System.out.println("Inserisci la stringa:");
        this.originale = sc.nextLine();
        return this.originale.toCharArray();
    }


    public char[] cifratura(char[] cifrata, int[] shift){
        CodDecodChar cdc = new CodDecodChar();
        char[] c = new char[cifrata.length];
        for(int i = 0; i < cifrata.length; i++){
            int shiftIndex = i % shift.length; // Cicla lo shift
            c[i] = cdc.codificaCaratteri(cifrata[i], shift[shiftIndex]);
        }
        return c;
    }

    public char[] decifratura(char[] cifrata, int[] shift){
        CodDecodChar cdc = new CodDecodChar();
        char[] c = new char[cifrata.length];
        for(int i = 0; i < cifrata.length; i++){
            int shiftIndex = i % shift.length; // Cicla lo shift
            c[i] = cdc.decodificaCaratteri(cifrata[i], shift[shiftIndex]);
        }
        return c;
    }

    public void visualizzaStringa(char[] stringa){
        for(int i = 0; i < stringa.length; i++){
            System.out.print(stringa[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {

        Transposition cc = new Transposition();
        int[] trasposizione = {2,3,4,5,6,7,2,4,6,8,9,1,2,1,2,6,12,2,7,4,3,3,1,2,2,1}; // 26 shift diversi da usare ciclicamente

        char scelta;

        System.out.println("=========================================");
        System.out.println("=   Cifrario di Cesare con Confusione   =");
        System.out.println("=========================================");

        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("\t[0] Cifra [1] Decifra [n] Esci");
            scelta = sc.nextLine().charAt(0);  // Attenzione next() legge solo fino al primo spazio e non prende l'enter '\n'

            switch (scelta) {
                case '0':
                    char[] codifica = cc.inserisciStringa(sc);
                    codifica = cc.cifratura(codifica, trasposizione);
                    cc.visualizzaStringa(codifica);
                    break;
                case '1':
                    char[] decodifica = cc.inserisciStringa(sc);
                    decodifica = cc.decifratura(decodifica, trasposizione);
                    cc.visualizzaStringa(decodifica);
                    break;
                default:
                    System.out.println("Arrivederci!");
                    break;
            }
        } while(scelta != 'n');

    }
}
