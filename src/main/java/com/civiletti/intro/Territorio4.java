package com.civiletti.intro;

/**
 * Per dimostrare il funzionamento delle variabili e dei metodi static,
 * aggiungiamo una variabile e un metodo static nella classe Territorio4.
 *
 * Quando una variabile è dichiarata come static, essa è condivisa tra
 * tutte le istanze della classe, quindi qualsiasi modifica a questa
 * variabile avrà effetto su tutte le istanze.
 *
 * Questa implementazione presenta, inoltre, una modifica al metodo
 * toString(), che utilizza i metodi introdotti nella precedente
 * implementazione, per ottenere il nome della classe a cui ci stiamo
 * riferendo:
 *
 *     return "\n" + getClass().getSimpleName() + "{\n" +
 *            ...
 */

import java.util.Scanner;

public class Territorio4 {
    // Variabili di istanza
    double superficie; // valore in Kmq
    int abitanti;

    // Variabile statica condivisa tra tutte le istanze
    static double popolazioneTotale = 0;

    // Costruttore
    public Territorio4(double s, int a) {
        superficie = s;
        abitanti = a;
        aggiornaPopolazioneTotale(a);
    }

    // Metodo densita
    double densita() {
        return abitanti / superficie;
    }

    // Metodo statico per incrementare la popolazione totale
    static void aggiornaPopolazioneTotale(double nuovaPopolazione) {
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

        Scanner sc = new Scanner(System.in);
        System.out.println("Di quanto è variata la popolazione totale?");
        double variazionePololazione = sc.nextDouble();

        // Creazione di due istanze
        Territorio4 t = new Territorio4(257.3, 12250);
        Territorio4 t2 = new Territorio4(475.98, 98750);
        // Attenzione!!! la popolazione totale sarà data da: (abitanti di t + abitanti di t2)
        // Se però ci serve il totale per territorio con una variazione relativa dobbiamo
        // cambiare approccio.



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

        // Output della popolazione totale senza oggetto specifico
        System.out.println("Popolazione totale (accesso diretto): " + Territorio4.popolazioneTotale);
    }
}

