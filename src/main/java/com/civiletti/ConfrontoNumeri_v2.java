package com.civiletti;

import java.util.*;

public class ConfrontoNumeri_v2 {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        // Dichiarazione variabili
        int max, num, i, n;
        String continua;

        // Inizio sezione iterativa do-while
        do {
            System.out.println("Quanti numeri vuoi inserire?");

            // Lettura
            n = input.nextInt();
            max = 0;

            // Ciclo for per la valutazione del massimo
            for (i = 1; i <= n; i++) {
                System.out.println("Inserisci valore [" + i + "]: ");
                num = input.nextInt();
                if (num > max) {
                    max = num;
                }
            }

            // Visualizzazione del valore massimo
            System.out.println("Il numero massimo è: " + max);

            // Verifica se continuare
            System.out.println("Continuare? [s/n]");
            continua = input.next();
        }
        while (continua.equals("s") || continua.equals("S"));
        System.out.println("Arrivederci!");
    }
}
