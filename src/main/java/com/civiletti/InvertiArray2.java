package com.civiletti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Questa classe implementa diverse metodologie per invertire un array di interi.
 * Fornisce funzionalità per:
 * - Inserimento dell'array da tastiera
 * - Inversione dell'array usando diversi approcci (ottimizzato, base, Collections, StringBuilder)
 * - Visualizzazione dell'array originale e invertito
 *
 * @author civiletti
 * @version 1.1
 */
public class InvertiArray2 {
    int dim;
    int[] numeri;
    int[] arrayInvertito;

    /**
     * Costruttore che inizializza l'array e lo inverte
     * @param sc Scanner per l'input da tastiera
     */
    InvertiArray2(Scanner sc) {
        this.numeri = inserisciArray(sc);
        this.arrayInvertito = invertiArrayOttimizzato(this.numeri.clone());
    }

    /**
     * Metodo per inserire i numeri nell'array da tastiera
     * @param sc Scanner per l'input
     * @return array di interi inseriti
     */
    public int[] inserisciArray(Scanner sc){
        System.out.print("Quanti numeri vuoi inserire? ");
        this.dim = sc.nextInt();
        this.numeri = new int[dim];

        System.out.println("Inserisci " + this.dim + " numeri:");
        for (int i = 0; i < this.dim; i++) {
            System.out.print("Numero (" + (i + 1) + "): ");
            this.numeri[i] = sc.nextInt();
        }
        return this.numeri;
    }

    /**
     * Metodo ottimizzato che usa l'approccio "two pointers" per invertire l'array in-place
     * Complessità temporale: O(n/2) = O(n)
     * Complessità spaziale: O(1) - solo scambi in-place
     * @param numeri array da invertire
     * @return array invertito
     */
    public int[] invertiArrayOttimizzato(int[] numeri) {
        int sinistra = 0;
        int destra = numeri.length - 1;

        while (sinistra < destra) {
            // Scambia gli elementi agli indici sinistra e destra
            int temp = numeri[sinistra];
            numeri[sinistra] = numeri[destra];
            numeri[destra] = temp;

            // Sposta i 'puntatori' verso il centro
            sinistra++;
            destra--;
        }
        return numeri;
    }

    /**
     * Metodo base per invertire l'array usando un ciclo for
     * Complessità temporale: O(n)
     * Complessità spaziale: O(n) - richiede un nuovo array
     * @param numeri array da invertire
     * @return array invertito
     */
    public int[] invertiArrayBase(int[] numeri) {
        this.arrayInvertito = new int[numeri.length];
        for (int i = numeri.length - 1; i >= 0; i--) {
            this.arrayInvertito[numeri.length -1 - i] = this.numeri[i];
        }
        return this.arrayInvertito;
    }

    /**
     * Metodo che utilizza Collections per invertire l'array
     * Complessità temporale: O(n)
     * Complessità spaziale: O(n) - richiede conversione in ArrayList
     * @param numeri array da invertire
     * @return array invertito
     */
    public int[] invertiArrayCollection(int[] numeri) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int num : numeri) {
            list.add(num);
        }
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * Metodo che utilizza Arrays e StringBuilder per invertire l'array
     * Complessità temporale: O(n)
     * Complessità spaziale: O(n) - richiede conversione in string e parsing
     * @param numeri array da invertire
     * @return array invertito
     */
    public int[] invertiArrayStringBuilder(int[] numeri) {
        StringBuilder sb = new StringBuilder(Arrays.toString(numeri));
        String numeriStringa = sb.substring(1, sb.length()-1).replaceAll("\\s+", "");
        String[] numeriArray = numeriStringa.split(",");
        int[] risultato = new int[numeriArray.length];

        for (int i = numeriArray.length - 1; i >= 0; i--) {
            risultato[numeriArray.length - 1 - i] = Integer.parseInt(numeriArray[i]);
        }
        return risultato;
    }

    /**
     * Metodo che stampa l'array in formato stringa
     * @param array array da stampare
     * @return stringa formattata dell'array
     */
    public static String printArray(int[] array) {
        String arrayString = " [ ";
        int index = 0;
        for (int num : array) {
            if(index != array.length - 1) {
                arrayString += num + ", ";
            } else arrayString += num + " ]";
            index++;
        }
        return arrayString;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +"{\n" +
                "\t  array inserito:" + printArray(this.numeri) + "\n" +
                "\t array invertito:" + printArray(this.arrayInvertito) + "\n" +
                "}";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvertiArray2 ia = new InvertiArray2(scanner);

        System.out.println("Array originale:" + printArray(ia.numeri));

        // Test dei diversi metodi di inversione con misurazione del tempo
        long startTime, endTime;

        startTime = System.nanoTime();
        ia.arrayInvertito = ia.invertiArrayOttimizzato(ia.numeri.clone());
        endTime = System.nanoTime();
        System.out.println("\nInversione con metodo ottimizzato (two pointers):");
        System.out.println(ia);
        System.out.println("Tempo: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        ia.arrayInvertito = ia.invertiArrayBase(ia.numeri);
        endTime = System.nanoTime();
        System.out.println("\nInversione con metodo base:");
        System.out.println(ia);
        System.out.println("Tempo: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        ia.arrayInvertito = ia.invertiArrayCollection(ia.numeri);
        endTime = System.nanoTime();
        System.out.println("\nInversione con Collections:");
        System.out.println(ia);
        System.out.println("Tempo: " + (endTime - startTime) + " ns");

        startTime = System.nanoTime();
        ia.arrayInvertito = ia.invertiArrayStringBuilder(ia.numeri);
        endTime = System.nanoTime();
        System.out.println("\nInversione con StringBuilder:");
        System.out.println(ia);
        System.out.println("Tempo: " + (endTime - startTime) + " ns");

        scanner.close();
    }
}