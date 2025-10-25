package com.civiletti;

/**
 * Es. 3 - 2
 *
 * Numero più grande tra N numeri interi (con costruttori e metodi di istanza)
 *
 * Crea una classe chiamata ConfrontoNumeri che accetta N numeri nel costruttore.
 * Aggiungi un metodo chiamato trovaMassimo che restituisce il numero più grande.
 *
 */

import java.util.Scanner;

public class ConfrontoNumeri_v2 {
    private int[] numeri;

    // Costruttore: riceve un array di interi
    public ConfrontoNumeri_v2(int[] numeri) {
        this.numeri = numeri;
    }

    // Metodo per trovare il massimo
    public int trovaMassimo() {
        int max = numeri[0];
        for (int n : numeri) {
            if (n > max)
                max = n;
        }
        return max;
    }
}

class TestConfrontoNumeri_v2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("Quanti numeri vuoi inserire?");
            int n = sc.nextInt();

            int[] valori = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Inserisci valore [" + (i + 1) + "]: ");
                valori[i] = sc.nextInt();
            }

            // Uso del costruttore
            ConfrontoNumeri_v2 confronto = new ConfrontoNumeri_v2(valori);
            System.out.println("Il numero massimo è: " + confronto.trovaMassimo());

            System.out.println("Vuoi continuare? (s/n)");
            String risposta = sc.next();
            if (risposta.equalsIgnoreCase("n")) {
                continua = false;
                System.out.println("Arrivederci!");
            }
        }
        sc.close();
    }
}


