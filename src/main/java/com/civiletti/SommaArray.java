package com.civiletti;

import java.util.Scanner;

/**
 * Classe che gestisce un array di numeri interi e ne calcola la somma
 * Fornisce metodi per la somma degli elementi e la rappresentazione testuale
 * @author Ing. Civiletti
 * @version 1.0
 */
public class SommaArray {
    static int[] numeri;    // Array per memorizzare i numeri
    static int somma;       // Variabile per memorizzare la somma

    /**
     * Calcola la somma di tutti gli elementi nell'array fornito
     * @param numeri array di interi da sommare
     * @return la somma di tutti gli elementi dell'array
     */
    static int sommaArray(int[] numeri){
        somma = 0;
        // Itera su ogni elemento dell'array e accumula la somma
        for(int num : numeri){
            somma += num;
        }
        return somma;
    }

    /**
     * Override del metodo toString per fornire una rappresentazione testuale dell'oggetto
     * @return stringa formattata contenente i valori dell'array e la loro somma
     */
    @Override
    public String toString(){
        return getClass().getSimpleName() + "{\n" +
                "\t" + ArrayInserireValori.printArray(numeri) + "\n" +
                "\tSomma: " + sommaArray(numeri) + "\n" +
                "}";
    }

    /**
     * Metodo principale che gestisce l'input dell'utente e mostra i risultati
     * @param args argomenti da linea di comando (non utilizzati)
     */
    public static void main(String[] args) {
        // Inizializza gli oggetti necessari
        ArrayInserireValori aiv = new ArrayInserireValori();
        Scanner sc = new Scanner(System.in);

        // Ottiene l'input dell'utente
        numeri = aiv.inserireValori(sc);

        // Visualizza la somma degli elementi
        System.out.println("La somma degli elementi dell'array è: " + sommaArray(numeri));

        // Chiude lo scanner per evitare memory leak
        sc.close();

        // Crea un'istanza della classe e visualizza la rappresentazione testuale
        SommaArray sa = new SommaArray();
        System.out.println(sa);
    }
}