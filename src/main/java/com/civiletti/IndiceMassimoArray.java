package com.civiletti;

import java.util.Scanner;

public class IndiceMassimoArray {

    public static int findMaxIndex(int[] array) {

        // Controllo che l'array non sia vuoto
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("L'array non può essere vuoto");
        }

        // Inizializzazione delle variabili per l'indice e il valore massimo
        int maxIndex = 0;
        int maxValue = array[0]; // Assegno il valore massimo

        // Scorro l'array per trovare l'indice del valore massimo
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayInserireValori aiv = new ArrayInserireValori();
        int[] mioArray = aiv.inserireValori(scanner);

        int max = findMaxIndex(mioArray);

        System.out.println("Indice dove si trova il valore massimo: " + max);
    }

}
