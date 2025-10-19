package com.civiletti.ordinamento_array;

import java.util.Scanner;

public class QuickSort {

    private int[] numeri;
    private int[] numeriOrdinati;
    private int num;

    private int DIM;
    private static int cont = 1;

    // Metodi getter e setter
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDIM() {
        return DIM;
    }

    public void setDIM(int DIM) {
        this.DIM = DIM;
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


    int inserisciDato(Scanner sc) {
        System.out.println("Inserisci un numero (" + cont +"): ");
        this.num = sc.nextInt();
        cont++;
        return this.num;
    }

    public void popolaArray(Scanner sc) {
        System.out.println("Inserisci la dimensione dell'array: ");
        this.DIM = sc.nextInt(); // Dichiarazione e inizializzazione della costante
        setDIM(this.DIM);

        this.numeri = new int[DIM];   // Allocazione della memoria per l'array numeri di lunghezza DIM

        int minIndex = 0;   // Dichiaro e inizializzo l'indice massimo

        while (minIndex < this.numeri.length) { // Inserisco i dati a partire dal primo elemento
            //SelectionSort oac = new SelectionSort();  // Ridondante
            this.numeri[minIndex] = inserisciDato(sc);  // Inserimento dal "basso"
            minIndex++;
        }

        setNumeri(this.numeri);
    }

    /**
     * Ordina un array di interi utilizzando l'algoritmo QuickSort.
     *
     * Il principio fondamentale di QuickSort è "divide et impera":
     * dividiamo il problema in sottoproblemi più piccoli, li risolviamo
     * e poi combiniamo le soluzioni.
     *
     * Funzionamento:
     * - Sceglie un elemento pivot
     * - Partiziona l'array mettendo gli elementi minori del pivot a sinistra
     *   e quelli maggiori a destra
     * - Applica ricorsivamente lo stesso processo alle due partizioni
     *
     * Complessità temporale:
     * - Caso medio: O(n log n)
     * - Caso peggiore: O(n²) quando l'array è già ordinato o inversamente ordinato
     *
     * Complessità spaziale: O(log n)
     * - Richiede spazio aggiuntivo per la ricorsione
     *
     * Vantaggi:
     * - Molto efficiente nella maggior parte dei casi
     * - Ordinamento in-place
     * - Ottimo per array di grandi dimensioni
     *
     * Svantaggi:
     * - Non stabile (può modificare l'ordine relativo di elementi uguali)
     * - Performance degradata in casi particolari (array già ordinato)
     *
     * @param arr Array di interi da ordinare
     * @param low Indice iniziale della porzione da ordinare
     * @param high Indice finale della porzione da ordinare
     */
    public int[] ordinaQuickSort(int[] arr, int low, int high) {

        if (low < high) {
            // Trova l'indice del pivot dopo il partizionamento
            int pivotIndex = partition(arr, low, high);

            // Ordina ricorsivamente le due partizioni
            ordinaQuickSort(arr, low, pivotIndex - 1);   // Partizione sinistra
            ordinaQuickSort(arr, pivotIndex + 1, high);   // Partizione destra
        }
        // setNumeriOrdinati(arr);
        return arr;
    }

    /**
     * Esempio di esecuzione di QuickSort sull'array [7, 2, 1, 6, 8, 5, 3, 4]
     *
     * Parametri chiave:
     * - low: indice di inizio della porzione di array da ordinare
     * - high: indice di fine della porzione di array da ordinare
     * - pivot: elemento scelto come riferimento per partizionare l'array
     *
     * PASSO 1: Prima chiamata
     * quickSort(arr, 0, 7)  // low=0, high=7 (tutto l'array)
     * pivot = 4 (ultimo elemento)
     *
     * Prima del partizionamento:
     * [7, 2, 1, 6, 8, 5, 3, 4]
     *  ↑                    ↑
     * low                 high
     *
     * Dopo il partizionamento:
     * [2, 1, 3, 4, 8, 5, 7, 6]
     *           ↑
     *        pivotIndex=3
     *
     * PASSO 2: Ricorsione sulla parte sinistra
     * quickSort(arr, 0, 2)  // Elementi minori del pivot
     * [2, 1, 3] → [1, 2, 3]
     *
     * PASSO 3: Ricorsione sulla parte destra
     * quickSort(arr, 4, 7)  // Elementi maggiori del pivot
     * [8, 5, 7, 6] → [5, 6, 7, 8]
     *
     * Risultato finale:
     * [1, 2, 3, 4, 5, 6, 7, 8]
     */


    /**
     * Partiziona l'array attorno a un pivot.
     * Sposta gli elementi minori del pivot a sinistra e quelli maggiori a destra.
     *
     * @param arr Array da partizionare
     * @param low Indice iniziale della porzione da partizionare
     * @param high Indice finale della porzione da partizionare
     * @return Indice finale del pivot
     */
    private int partition(int[] arr, int low, int high) {

        /**
         * Il metodo partition funziona così:
         * 1. Prende come pivot l'ultimo elemento
         * 2. Sposta tutti gli elementi minori del pivot a sinistra
         * 3. Inserisce il pivot nella sua posizione finale
         *
         * Esempio di partizionamento su [7, 2, 1, 6, 8, 5, 3, 4]:
         * pivot = 4
         *
         * Passi:
         * 1. [7, 2, 1, 6, 8, 5, 3, 4]  // Stato iniziale
         * 2. [2, 7, 1, 6, 8, 5, 3, 4]  // 2 < 4, sposta a sinistra
         * 3. [2, 1, 7, 6, 8, 5, 3, 4]  // 1 < 4, sposta a sinistra
         * 4. [2, 1, 3, 6, 8, 5, 7, 4]  // 3 < 4, sposta a sinistra
         * 5. [2, 1, 3, 4, 8, 5, 7, 6]  // Posiziona il pivot
         */

        // Scegliamo come pivot l'elemento più a destra
        int pivot = arr[high];

        // Indice dell'elemento più piccolo
        int i = (low - 1);

        // Scorriamo l'array e spostiamo gli elementi minori del pivot a sinistra
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Scambia arr[i] e arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Posiziona il pivot nella sua posizione finale
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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
        QuickSort is = new QuickSort();

        is.popolaArray(sc);

        is.printArray(is.getNumeri());
        int[] arrayOrdinato = is.ordinaQuickSort(is.getNumeri(), 0, is.getDIM()-1);
        //is.printArray(arrayOrdinato);
        is.setNumeriOrdinati(arrayOrdinato);

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
        is.printArray(arrayOrdinato);

        // Test per visualizzare le modifiche: Rimuovere il metodo clone() dai metodi getter e osservare i cambiamenti
        is.printArray(is.getNumeri());
        is.printArray(is.getNumeriOrdinati());
    }
}
