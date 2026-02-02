package com.civiletti.esercizi.refactored;

import java.util.Scanner;

/**
 * Classe di utilità contenente metodi comuni per la gestione degli array.
 * Questa classe fornisce funzionalità riutilizzabili per:
 * - Richiesta della dimensione dell'array
 * - Inserimento dei valori nell'array
 * - Stampa formattata dell'array
 *
 * @author civiletti
 * @version 1.0
 */
public class ArrayMethods {

    /**
     * Richiede all'utente di inserire il numero di elementi da gestire
     *
     * @param sc Scanner per l'input da tastiera
     * @return il numero di elementi scelto dall'utente
     */
    public static int richiediDimensione(Scanner sc) {
        System.out.print("Quanti numeri vuoi inserire? ");
        int dimensione = sc.nextInt();

        // Validazione input
        while (dimensione <= 0) {
            System.out.print("Errore: inserisci un numero positivo: ");
            dimensione = sc.nextInt();
        }

        return dimensione;
    }

    /**
     * Permette all'utente di inserire i valori nell'array
     *
     * @param sc Scanner per l'input da tastiera
     * @param dimensione numero di elementi da inserire
     * @return array popolato con i valori inseriti dall'utente
     */
    public static int[] inserisciValori(Scanner sc, int dimensione) {
        int[] array = new int[dimensione];

        System.out.println("Inserisci " + dimensione + " numeri:");
        for (int i = 0; i < dimensione; i++) {
            System.out.print("Numero " + (i + 1) + ": ");
            array[i] = sc.nextInt();
        }

        return array;
    }

    /**
     * Crea una rappresentazione formattata dell'array in formato stringa
     * Esempio di output: [ 1, 2, 3, 4, 5 ]
     *
     * @param array array da formattare
     * @return stringa formattata dell'array
     */
    public static String printArray(int[] array) {
        if (array == null || array.length == 0) {
            return " [ ]";
        }

        StringBuilder sb = new StringBuilder(" [ ");

        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }

        sb.append(" ]");
        return sb.toString();
    }

    /**
     * Metodo di test per verificare il corretto funzionamento della classe
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Test ArrayMethods ===\n");

        // Test richiesta dimensione
        int dim = richiediDimensione(sc);

        // Test inserimento valori
        int[] numeri = inserisciValori(sc, dim);

        // Test stampa formattata
        System.out.println("\nArray inserito: " + printArray(numeri));

        sc.close();
    }
}
