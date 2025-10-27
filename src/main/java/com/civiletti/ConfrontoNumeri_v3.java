package com.civiletti;

/**
 * Esercizio 3.3 - Confronto di numeri
 *
 * La classe {@code ConfrontoNumeri_v3} consente di individuare il valore massimo
 * all’interno di una serie di numeri inseriti dall’utente.
 *
 * <p>Funzionalità principali:</p>
 * <ul>
 *   <li>Richiede all’utente il numero di valori da confrontare.</li>
 *   <li>Memorizza i numeri inseriti tramite input da tastiera.</li>
 *   <li>Determina e restituisce il valore massimo attraverso il metodo {@link #trovaMassimo()}.</li>
 * </ul>
 *
 * <p>La logica è incapsulata all’interno della classe per favorire la modularità
 * e la riusabilità del codice. Il costruttore si occupa della fase di acquisizione dei dati,
 * mentre il metodo {@code trovaMassimo()} effettua l’elaborazione logica.</p>
 *
 * @author  Civiletti
 * @version 1.3
 */

import java.util.Scanner;

public class ConfrontoNumeri_v3 {
    private int[] numeri;

    // Costruttore: riceve un array di interi
    public ConfrontoNumeri_v3(int[] numeri) {
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

class TestConfrontoNumeri_v3 {
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
            ConfrontoNumeri_v3 confronto = new ConfrontoNumeri_v3(valori);
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


