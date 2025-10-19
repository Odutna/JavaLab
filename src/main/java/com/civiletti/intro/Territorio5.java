package com.civiletti.intro;

/**
 * Modifichiamo il codice della classe Territorio4 in modo tale che
 * possiamo avere il totale relativo a ogni oggetto istanziato.
 *
 */

import java.util.Scanner;

public class Territorio5 {
    // Variabili di istanza
    double superficie; // valore in Kmq
    int abitanti;

    // Variabile statica condivisa tra tutte le istanze
    double popolazioneTotale = 0;

    // Costruttore
    public Territorio5(double s, int a) {
        superficie = s;
        abitanti = a;
        aggiornaPopolazioneTotale(a);
    }

    // Metodo densita
    double densita() {
        return abitanti / superficie;
    }

    // Metodo statico per incrementare la popolazione totale
    void aggiornaPopolazioneTotale(double nuovaPopolazione) {
        popolazioneTotale += nuovaPopolazione;
    }

    // Sovrascrittura di toString per visualizzare le informazioni dettagliate dell'oggetto
    @Override
    public String toString() {
        return "\n" + getClass().getSimpleName() + "{ \n" +
                "   superficie=" + superficie + " kmq, \n" +
                "   abitanti=" + abitanti + ", \n" +
                "   densita=" + densita() + " ab/kmq\n" +
                "   popolazioneTotale=" + popolazioneTotale + " (static)\n" +
                "}";
    }

    public static void main(String[] args) {

        // Creazione di due istanze
        Territorio5 t = new Territorio5(257.3, 12250);
        Territorio5 t2 = new Territorio5(475.98, 98750);
        // Eliminando static nelle dichiarazioni, della variabile popolazioneTotale e
        // nel metodo aggiornaPopolazioneTotale(), separiamo il totale per territorio.

        Scanner sc = new Scanner(System.in);
        System.out.println("Di quanto è variata la popolazione totale?");
        double variazionePololazione = sc.nextDouble();

        // Stampa le informazioni delle istanze e della popolazione totale
        System.out.println("+--------------------------+");
        System.out.println("Oggetto t: " + t);
        System.out.println("+--------------------------+");
        System.out.println("Oggetto t2: " + t2);
        System.out.println("+--------------------------+");

        // Modifica della variabile statica da un'istanza
        System.out.println("Variazione popolazione totale di " + variazionePololazione +" da t2...");
        t2.aggiornaPopolazioneTotale(variazionePololazione );  // Modifica la variabile statica
        System.out.println("+--------------------------+");
        System.out.println("Oggetto t dopo modifica: " + t);
        System.out.println("Oggetto t2 dopo modifica: " + t2);
        System.out.println("+--------------------------+");

        // Output della popolazione totale
        double totale = t.popolazioneTotale + t2.popolazioneTotale;
        System.out.println("Popolazione totale: " + totale);
    }
}

