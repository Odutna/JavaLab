package com.civiletti.esercizi.refactored;

import java.util.Scanner;

/**
 * Classe che gestisce l'inversione di un array di numeri interi.
 * Versione refactorizzata che utilizza ArrayMethods per le operazioni comuni.
 *
 * @author civiletti
 * @version 2.0 (refactored)
 */
public class InvertiArray {

    private int[] numeri;
    private int[] arrayInvertito;

    /**
     * Costruttore che inizializza l'array tramite input utente
     * e lo inverte automaticamente
     *
     * @param sc Scanner per l'input da tastiera
     */
    public InvertiArray(Scanner sc) {
        // Utilizzo dei metodi comuni da ArrayMethods
        int dimensione = ArrayMethods.richiediDimensione(sc);
        this.numeri = ArrayMethods.inserisciValori(sc, dimensione);
        this.arrayInvertito = invertiArray();
    }

    /**
     * Inverte l'ordine degli elementi nell'array
     *
     * @return nuovo array con gli elementi invertiti
     */
    private int[] invertiArray() {
        int[] invertito = new int[this.numeri.length];

        for (int i = 0; i < this.numeri.length; i++) {
            invertito[i] = this.numeri[this.numeri.length - 1 - i];
        }

        return invertito;
    }

    /**
     * Getter per ottenere l'array originale
     *
     * @return array originale
     */
    public int[] getNumeri() {
        return this.numeri;
    }

    /**
     * Getter per ottenere l'array invertito
     *
     * @return array invertito
     */
    public int[] getArrayInvertito() {
        return this.arrayInvertito;
    }

    /**
     * Rappresentazione testuale dell'oggetto
     *
     * @return stringa formattata contenente array originale e invertito
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " {\n" +
                "\tArray originale: " + ArrayMethods.printArray(this.numeri) + "\n" +
                "\tArray invertito: " + ArrayMethods.printArray(this.arrayInvertito) + "\n" +
                "}";
    }

    /**
     * Metodo principale per testare la classe
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Inversione Array ===\n");

        // Creazione oggetto e inversione automatica
        InvertiArray ia = new InvertiArray(sc);

        // Visualizzazione risultati
        System.out.println("\n" + ia);

        sc.close();
    }
}
