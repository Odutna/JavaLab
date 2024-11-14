package com.civiletti;

import java.util.Scanner;

/**
 * Questa classe fornisce funzionalità per trovare l'indice del valore massimo
 * all'interno di un array di interi.
 *
 * @author Ing. Civiletti
 * @version 1.0
 */
public class IndiceMassimoArray {

    /**
     * Trova l'indice del valore massimo in un array di interi.
     * Se ci sono più occorrenze del valore massimo, restituisce l'indice
     * della prima occorrenza.
     *
     * Complessità temporale: O(n) dove n è la lunghezza dell'array
     * Complessità spaziale: O(1) poiché usa solo variabili primitive
     *
     * @param array l'array in cui cercare il valore massimo
     * @return l'indice del primo valore massimo trovato nell'array
     * @throws IllegalArgumentException se l'array è null o vuoto
     */
    public static int findMaxIndex(int[] array) {
        // Controllo che l'array non sia vuoto
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("L'array non può essere vuoto");
        }

        // Inizializzazione delle variabili per l'indice e il valore massimo
        int maxIndex = 0;                    // Indice del valore massimo
        int maxValue = array[0];             // Primo elemento come valore massimo iniziale

        // Scorro l'array per trovare l'indice del valore massimo
        // Parto da 1 perché il primo elemento è già stato considerato
        for (int i = 1; i < array.length; i++) {
            // Se trovo un valore maggiore, aggiorno sia il valore che l'indice
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /**
     * Metodo main per testare la funzionalità di ricerca del massimo.
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

        // Ricerca dell'indice del valore massimo
        int max = findMaxIndex(mioArray);

        // Stampa del risultato
        System.out.println("Indice dove si trova il valore massimo: " + max);
    }
}