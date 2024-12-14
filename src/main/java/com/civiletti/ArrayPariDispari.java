package com.civiletti;

import java.util.Scanner;

/**
 * Classe per memorizzare i dati dell'array e i contatori
 * degli elementi pari e dispari.
 *
 * I campi numeri, pari e dispari nella classe Dati sono
 * dichiarati come static, questo significa che:
 *
 *     - Questi campi appartengono alla classe Dati
 *       stessa e non alle singole istanze
 *     - Tutti gli oggetti Dati condividono gli stessi
 *       valori per questi campi
 *     - Possiamo accedere a questi campi anche senza
 *       creare un'istanza di Dati
 *
 */
class Dati {
    int dim;                // dimensione dell'array
    static int[] numeri;    // array di numeri
    static int pari;        // contatore numeri pari
    static int dispari;     // contatore numeri dispari
}

/**
 * Questa classe implementa funzionalità per analizzare un array di interi,
 * contando gli elementi pari e dispari.
 *
 * Fornisce funzionalità per:
 * - Inserimento dell'array da tastiera
 * - Conteggio elementi pari e dispari
 * - Visualizzazione dell'array e dei risultati
 *
 * @author civiletti
 * @version 1.0
 */
public class ArrayPariDispari {

    Dati d = new Dati();

    /**
     * Costruttore che inizializza l'array attraverso l'input utente
     * @param sc Scanner per l'input da tastiera
     */
    ArrayPariDispari(Scanner sc) {
        d.numeri = inserisciArray(sc);
    }

    /**
     * Metodo per inserire i numeri nell'array da tastiera
     * @param sc Scanner per l'input
     * @return array di interi inseriti
     */
    public int[] inserisciArray(Scanner sc){
        System.out.print("Quanti numeri vuoi inserire? ");
        d.dim = sc.nextInt();
        d.numeri = new int[d.dim];

        System.out.println("Inserisci " + d.dim + " numeri:");
        for (int i = 0; i < d.dim; i++) {
            System.out.print("Numero (" + (i + 1) + "): ");
            d.numeri[i] = sc.nextInt();
        }
        return d.numeri;
    }

    /**
     * Metodo che conta gli elementi pari e dispari nell'array
     * Complessità temporale: O(n) dove n è la lunghezza dell'array
     * @param numeri array da analizzare
     * @return oggetto Dati contenente i contatori aggiornati
     */
    public Dati contaPari(int[] numeri) {
        d.pari = 0;
        d.dispari = 0;

        for (int numero : numeri) {  // Utilizzo del for-each per maggiore leggibilità
            if (numero % 2 == 0) {
                d.pari++;
            } else {
                d.dispari++;
            }
        }
        return d;
    }

    /**
     * Metodo statico per convertire un array in una stringa formattata
     * @param array array da convertire in stringa
     * @return stringa formattata dell'array
     */
    public static String printArray(int[] array) {
        // Stampa dei numeri inseriti
        String arrayString = " [ ";
        int index = 0;
        for (int num : array) { // for-each
            if(index != array.length - 1) {
                arrayString += num + ", ";
            } else arrayString += num + " ]";
            index++;
        }
        return arrayString;
    }

    /**
     * Override del metodo toString per visualizzare l'array
     * e il conteggio degli elementi pari e dispari
     * @return stringa formattata con array e risultati
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{\n" +
                "\t array inserito:"  + printArray(d.numeri) + "\n" +
                "\t elementi pari: " + d.pari + "\n" +
                "\t elementi dispari: " + d.dispari + "\n" +
                "}";
    }

    /**
     * Metodo main per testare la classe
     * @param args argomenti da linea di comando (non utilizzati)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayPariDispari apd = new ArrayPariDispari(scanner);
        scanner.close();

        apd.contaPari(apd.d.numeri);  // Non è necessario creare un nuovo oggetto Dati, perché static
        System.out.println(apd);
    }
}