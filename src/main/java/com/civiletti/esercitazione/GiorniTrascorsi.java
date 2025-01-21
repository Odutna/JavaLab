package com.civiletti.esercitazione;

/**
 * Scrivere un programma che accetta in input una data (giorno, mese ed anno)
 * e calcoli il numero di giorni trascorsi dall’inizio dell’anno.
 *
 *                               4        6        9          11
 * Mesi composti da 30 giorni (aprile, giugno, settembre, novembre), mentre
 * febbraio può avere 28 o 29 giorni a seconda se l'anno è bisestile.
 *
 *     2
 * Febbraio: Si verifica se l'anno è bisestile (divisibile per 400 oppure
 * divisibile per 4 ma non per 100) e, in tal caso, si considerano 29 giorni.
 * Altrimenti si considerano 28 giorni.
 *
 *    if (anno % 400 == 0 || (anno % 4 == 0 && !(anno % 100 == 0)))
 *              giorniTrascorsi += 29; // anno bisestile
 *    else
 *              giorniTrascorsi += 28;
 *
 *                                1       3       5       7      8        10
 *  31 giorni i restanti mesi (gennaio, marzo, maggio, luglio, agosto, ottobre,
 *   12
 * dicembre) sono composti da 31 giorni.
 *
 *
 */

import java.util.Scanner;

public class GiorniTrascorsi {

    public static void printResults(int giorno, int mese, int anno, int giorniTrascorsi) {
        System.out.println();
        System.out.println("+============================================================+");
        System.out.println("|                       Risultato                            |");
        System.out.println("+============================================================+");
        System.out.println("| Il " + String.format("%2d", giorno) + "/" + String.format("%2d", mese) + "/" + String.format("%3d", anno) + " è il " + String.format("%3d", giorniTrascorsi) + "° giorno dell'anno " + String.format("%3d", anno) + "\t\t\t     |");
        System.out.println("+============================================================+");
    }

    public static int calcolaGiorniTrascorsi(int giorno, int mese, int anno, boolean stampaRisultati) {

        int giorniTrascorsi = 0;

        // Calcolo dei giorni trascorsi dall'inizio dell'anno
        for (int m = 1; m < mese; m++) {
            switch (m) {
                case 4, 6, 9, 11:
                    giorniTrascorsi += 30;
                    break;
                case 2:
                    giorniTrascorsi +=  (anno % 400 == 0 || (anno % 4 == 0 && !(anno % 100 == 0))) ? 29 : 28;
                    break;
                default:
                    giorniTrascorsi += 31;
            }
        }
        giorniTrascorsi += giorno;
        // Stampa risultati solo se il flag `stampaRisultati` è true
        if (stampaRisultati) {
            printResults(giorno, mese, anno, giorniTrascorsi);
        }

        return giorniTrascorsi;
    }

    public static void main(String args[]) {

        System.out.println("Inserisci la data di nascita: ");
        Scanner sc = new Scanner(System.in);

        // Acquisizione della data dall'utente
        int giorno = 0, mese = 0, anno = 0;

        // Acquisizione del giorno, mese e anno
        System.out.print("Giorno: ");
        giorno = sc.nextInt();

        System.out.print("Mese: ");
        mese = sc.nextInt();

        System.out.print("Anno: ");
        anno = sc.nextInt();

        calcolaGiorniTrascorsi(giorno, mese, anno, true);
    }
}
