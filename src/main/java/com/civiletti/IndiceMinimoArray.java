package com.civiletti;

import java.util.Scanner;

/**
 * Questa classe fornisce funzionalità per trovare l'indice del valore minimo
 * all'interno di un array di interi.
 *
 * @author Ing. Civiletti
 * @version 1.0
 */
public class IndiceMinimoArray {

    /**
     * Trova l'indice del valore minimo in un array di interi.
     * Se ci sono più occorrenze del valore minimo, restituisce l'indice
     * della prima occorrenza.
     *
     * Complessità temporale: O(n) dove n è la lunghezza dell'array
     * Complessità spaziale: O(1) poiché usa solo variabili primitive
     *
     * @param array l'array in cui cercare il valore minimo
     * @return l'indice del primo valore minimo trovato nell'array
     * @throws IllegalArgumentException se l'array è null o vuoto
     */
    public static int findMinIndex(int[] array) {
        // Controllo che l'array non sia vuoto o null
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("L'array non può essere vuoto");
        }

        // Inizializzazione delle variabili per l'indice e il valore minimo
        int minIndex = 0;                    // Indice del valore minimo
        int minValue = array[0];             // Primo elemento come valore minimo iniziale

        // Scorro l'array per trovare l'indice del valore minimo
        // Parto da 1 perché il primo elemento è già stato considerato come minimo iniziale
        for (int i = 1; i < array.length; i++) {
            // Se trovo un valore minore dell'attuale minimo, aggiorno sia il valore che l'indice
            if (array[i] < minValue) {
                minValue = array[i];         // Aggiorno il valore minimo
                minIndex = i;                // Memorizzo l'indice del nuovo minimo
            }
        }

        return minIndex;
    }

    /**
     * Metodo main per testare la funzionalità di ricerca del minimo.
     * Utilizza la classe ArrayInserireValori per ottenere l'input dall'utente.
     *
     * @param args argomenti da linea di comando (non utilizzati)
     */
    public static void main(String[] args) {
        // Inizializzazione dello scanner per l'input
        Scanner scanner = new Scanner(System.in);

        // Creazione dell'oggetto per inserire i valori
        ArrayInserireValori aiv = new ArrayInserireValori();

        // Ottenimento dell'array dall'utente
        int[] mioArray = aiv.inserireValori(scanner);

        try {
            // Ricerca dell'indice del valore minimo
            int min = findMinIndex(mioArray);

            // Stampa del risultato
            System.out.println("Indice dove si trova il valore minimo: " + min);
            System.out.println("Il valore minimo è: " + mioArray[min]);
        } catch (IllegalArgumentException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}