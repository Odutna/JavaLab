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

public class BubbleSort {

    private int[] numeri;
    private int[] numeriOrdinati;
    private int num;
    private static int cont = 1;

    // Metodi getter e setter
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setNumeri(int[] numeri) {
        this.numeri = numeri;
    }

    public int[] getNumeri() {
        return numeri.clone();
    }

    public void setNumeriOrdinati(int[] numeri) {
        this.numeriOrdinati = numeri;
    }

    public int[] getNumeriOrdinati() {
        return this.numeriOrdinati.clone();
    }

    // Fine metodi getter e setter

//    OrdinaArrayCrescente(Scanner sc){
//        chiediDati(sc);
//    }

    int inserisciDato(Scanner sc) {
        System.out.println("Inserisci un numero (" + cont +"): ");
        this.num = sc.nextInt();
        cont++;
        return this.num;
    }

    public void popolaArray(Scanner sc) {

        System.out.println("Inserisci la dimensione dell'array: ");
        final int DIM = sc.nextInt(); // Dichiarazione e inizializzazione della costante
        this.numeri = new int[DIM];   // Allocazione della memoria per l'array numeri di lunghezza DIM

        int minIndex = 0;   // Dichiaro e inizializzo l'indice massimo

        while (minIndex < this.numeri.length) { // Inserisco i dati a partire dal primo elemento
            //SelectionSort oac = new SelectionSort();  // Ridondante
            this.numeri[minIndex] = inserisciDato(sc);  // Inserimento dal "basso"
            minIndex++;
        }
        setNumeri(numeri);
    }

    /**
     * Ordina un array di interi utilizzando l'algoritmo Bubble Sort.
     *
     * Funzionamento:
     * - Confronta elementi adiacenti e li scambia se sono in ordine sbagliato
     * - Ad ogni iterazione esterna, l'elemento più grande "bolla" finisce alla fine
     *   dell'array
     *
     * Complessità temporale: O(n²)
     * - Due cicli annidati che confrontano ogni elemento con gli altri
     * - Peggiore tra gli algoritmi di ordinamento standard
     *
     * Complessità spaziale: O(1)
     * - Ordinamento in-place, non richiede memoria aggiuntiva
     *
     * @param array Array di interi da ordinare
     * @return Array ordinato in ordine crescente
     */
    public int[] ordinaBubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    // Scambio elementi
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        setNumeriOrdinati(array);
        return array;
    }

    void printArray(int[] array){
        System.out.println();
        System.out.println("Numeri ordinati in ordine crescente:");

        System.out.print("ArrayOrdinato = [ ");
        int i = 1;
        for (int elemento : array) {
            if( i != array.length)
                System.out.print(elemento + ", ");
            else System.out.print(elemento + " ]");
            i++;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BubbleSort bs = new BubbleSort();

        bs.popolaArray(sc);

        bs.printArray(bs.getNumeri());
        int[] arrayOrdinato = bs.ordinaBubbleSort(bs.getNumeri());

        //////////////////////////////////////////////////////////////////////////////////////////////////
        // !!! Attenzione !!!                                                                           //
        // Il metodo getNumeri() restituisce il riferimento diretto all'array numeri.                   //
        // Questo significa che qualsiasi modifica effettuata sull'array restituito                     //
        // (ad esempio, durante l'ordinamento in ordinaBubbleSort) si riflette                          //
        // direttamente sull'array numeri originale, così come su numeriOrdinati.                       //
        // Per evitare questo comportamento indesiderato e garantire l'indipendenza                     //
        // dei dati, è necessario restituire una copia dell'array originale nei metodi getter.          //
        // Usare il metodo clone() nei getter consente di lavorare su una copia dell'array              //
        // senza alterare l'originale. Se clone() viene rimosso, i due array (numeri e numeriOrdinati)  //
        // risulteranno identici perché condividono lo stesso riferimento in memoria.                   //
        //////////////////////////////////////////////////////////////////////////////////////////////////


        // Stampa i numeri ordinati
        bs.printArray(arrayOrdinato);

        // Test per visualizzare le modifiche: Rimuovere il metodo clone() dai metodi getter e osservare i cambiamenti
        bs.printArray(bs.getNumeri());
        bs.printArray(bs.getNumeriOrdinati());
    }
}
