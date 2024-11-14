package com.civiletti;

import java.util.Scanner;

/**
 * Questo programma permette all'utente di inserire un numero variabile di valori in un array
 * e di stamparli. L'utente può specificare la dimensione dell'array e inserire i valori uno per uno.
 * Viene anche fornito un metodo statico per la stampa dell'array in formato leggibile.
 *
 * @author Ing. Civiletti
 * @version 1.0
 */
public class ArrayInserireValori {

    // Dichiarazione di un array per contenere i numeri inseriti dall'utente
    int[] numeri;

    /**
     * Metodo per inserire i valori in un array.
     * L'utente inserisce la dimensione e i valori dell'array.
     *
     * @param sc Scanner per la lettura dell'input
     * @return L'array popolato con i valori inseriti dall'utente
     */
    public int[] inserireValori(Scanner sc) {
        // Chiede all'utente di inserire la dimensione dell'array
        System.out.println("Quanti numeri vuoi inserire?");
        int dim = sc.nextInt();
        this.numeri = new int[dim]; // Inizializzazione dell'array con la dimensione specificata

        // Ciclo per inserire i valori nell'array
        for (int index = 0; index < numeri.length; index++) {
            System.out.print("Elemento (" + (index + 1) + "): "); // Richiesta di input all'utente
            numeri[index] = sc.nextInt(); // Lettura e memorizzazione del valore inserito
        }
        return numeri; // Restituisce l'array popolato
    }

    /**
     * Metodo statico per stampare un array in formato leggibile.
     *
     * @param array L'array da stampare
     * @return Una stringa rappresentante l'array in formato leggibile
     */
    public static String printArray(int[] array) {
        // Costruzione della stringa per rappresentare l'array
        String arrayString = "Array: [ ";
        int index = 0;
        for (int num : array) { // Ciclo for-each per scorrere gli elementi dell'array
            if (index != array.length - 1) {
                arrayString += num + ", ";
            } else {
                arrayString += num + " ]";
            }
            index++;
        }
        return arrayString; // Restituisce la rappresentazione dell'array
    }

    public static void main(String[] args) {
        // Creazione di un oggetto ArrayInserireValori per utilizzare i metodi non statici
        ArrayInserireValori aiv = new ArrayInserireValori();

        // Creazione di un oggetto Scanner per leggere l'input dell'utente
        Scanner scanner = new Scanner(System.in);

        // Chiamata al metodo per inserire i valori e ottenere l'array popolato
        int[] nuovoArray = aiv.inserireValori(scanner);

        // Chiusura dello scanner per evitare memory leak
        scanner.close();

        // Stampa dell'array utilizzando il metodo statico
        System.out.println(printArray(nuovoArray));
    }
}
