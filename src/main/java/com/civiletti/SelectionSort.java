package com.civiletti;

import java.util.Scanner;

/**
 * Leggenda riassuntiva di alcune regole importanti che spesso si dimenticano
 *
 * Regola generale per invocare i metodi:
 *
 *      • Metodi statici NON possono chiamare metodi di istanza direttamente
 *      • Metodi di istanza possono chiamare metodi statici
 *      • Metodi di istanza possono chiamare altri metodi di istanza della stessa classe
 *      • Nel main (statico) serve sempre un'istanza per metodi non statici
 *
 *          ------------------------------------------------
 *                Regole di Chiamata dei Metodi in Java
 *          ------------------------------------------------
 *          Metodo Statico → Metodo NON Statico
 *          ❌ NON CONSENTITO
 *          Soluzione: Creare un'istanza
 *
 *          Metodo Statico → Metodo Statico
 *          ✅ CONSENTITO
 *
 *          Metodo NON Statico → Metodo Statico
 *          ✅ CONSENTITO
 *
 *          Metodo NON Statico → Metodo NON Statico (stessa classe)
 *          ✅ CONSENTITO
 *
 *          Metodo Main (Statico) → Metodi NON Statici
 *          ❌ NON CONSENTITO
 *          Soluzione: Creare un'istanza della classe
 *
 *
 *                 SINTESI DELLE REGOLE DI VISIBILITA'
 *      ------------------------------------------------------
 *      Visibilità     Stessa   Stesso   Sottoclassi   Altri
 *                     Classe   Package  (Eredità)     Package
 *     -------------------------------------------------------
 *      public           ✓       ✓           ✓           ✓
 *      protected        ✓       ✓           ✓           ✗
 *      default          ✓       ✓           ✗           ✗
 *      private          ✓       ✗           ✗           ✗
 *
 *
 */

public class SelectionSort {

    private int[] numeri;

    private int num;

    // Metodi getter e setter
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int[] getNumeri() {
        return numeri;
    }

    public void setNumeri(int[] numeri) {
        this.numeri = numeri;
    }
    // Fine metodi getter e setter

//    OrdinaArrayCrescente(Scanner sc){
//        chiediDati(sc);
//    }

    int chiediDati(Scanner sc) {
        System.out.println("Inserisci un numero: ");
        this.num = sc.nextInt();
        return this.num;
    }

    public void popolaArray(Scanner sc) {

        System.out.println("Inserisci la dimensione dell'array: ");
        final int DIM = sc.nextInt(); // Dichiarazione e inizializzazione della costante
        this.numeri = new int[DIM];   // Allocazione della memoria per l'array numeri di lunghezza DIM

        int maxIndex = this.numeri.length;   // Dichiaro e inizializzo l'indice massimo

        while (maxIndex > 0) { // Inserisco i dati a partire dall'ultimo elemento
            //SelectionSort oac = new SelectionSort();  // Ridondante
            this.numeri[maxIndex - 1] = chiediDati(sc);  // Inserimento dal "basso"
            maxIndex--;
        }

        setNumeri(this.numeri);
    }

    /**
     * Ordina l'array di numeri in ordine crescente utilizzando l'algoritmo Selection Sort.
     *
     * Funzionamento:
     * - Scorre l'array trovando il minimo elemento non ordinato
     * - Ad ogni iterazione, sposta il minimo elemento nella sua posizione corretta
     *
     * Complessità temporale: O(n²)
     * - Due cicli annidati che confrontano ogni elemento con gli altri
     *
     * Complessità spaziale: O(1)
     * - Ordinamento in-place, non richiede memoria aggiuntiva
     *
     * @param array Array di interi da ordinare
     * @return array ordinato in ordine crescente
     */
    int[] ordinaSelectionSort1(int[] array) {
        // Scorre l'array dall'inizio alla penultima posizione
        for (int z = 0; z < array.length - 1; z++) {
            // Cerca il minimo elemento nella parte non ordinata dell'array
            for (int k = z + 1; k < array.length; k++) {
                // Se trova un elemento più piccolo, lo scambia
                if (array[z] > array[k]) {
                    int tmp = array[z];
                    array[z] = array[k];
                    array[k] = tmp;
                }
            }
        }
        return array;
    }

    // Forma più efficiente in termini di scambi di elementi
    int[] ordinaSelectionSort2(int[] array) {
        for (int z = 0; z < array.length - 1; z++) {
            // Trovo prima l'indice del minimo elemento
            int minIndex = z;
            for (int k = z + 1; k < array.length; k++) {
                if (array[k] < array[minIndex]) {
                    minIndex = k;
                }
            }

            // Scambia il minimo trovato con l'elemento corrente
            int tmp = array[minIndex];
            array[minIndex] = array[z];
            array[z] = tmp;
        }
        return array;
    }

    void printArray(int[] arrayOrdinato){
        System.out.println();
        System.out.println("Numeri ordinati in ordine crescente:");

        System.out.print("ArrayOrdinato = [ ");
        int i = 1;
        for (int elemento : arrayOrdinato) {
            if( i != arrayOrdinato.length)
                System.out.print(elemento + ", ");
            else System.out.print(elemento + " ]");
            i++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        SelectionSort oac = new SelectionSort();

        oac.popolaArray(sc);

        int[] arrayOrdinato = oac.ordinaSelectionSort1(oac.getNumeri());
        // Stampa i numeri ordinati
        oac.printArray(arrayOrdinato);

        arrayOrdinato = oac.ordinaSelectionSort2(arrayOrdinato);
        // Stampa i numeri ordinati
        oac.printArray(arrayOrdinato);

    }
}
