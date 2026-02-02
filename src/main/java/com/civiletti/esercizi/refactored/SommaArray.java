package com.civiletti.esercizi.refactored;

import java.util.Scanner;

/**
 * Classe che gestisce un array di numeri interi e ne calcola la somma.
 * Versione refactorizzata che utilizza ArrayMethods per le operazioni comuni.
 *
 * @author civiletti
 * @version 2.0 (refactored)
 */
public class SommaArray {

    private int[] numeri;
    private int somma;

    /**
     * Costruttore che inizializza l'array tramite input utente
     * e calcola automaticamente la somma
     *
     * @param sc Scanner per l'input da tastiera
     */
    public SommaArray(Scanner sc) {
        // Utilizzo dei metodi comuni da ArrayMethods
        int dimensione = ArrayMethods.richiediDimensione(sc);
        this.numeri = ArrayMethods.inserisciValori(sc, dimensione);
        this.somma = calcolaSomma();
    }

    /**
     * Calcola la somma di tutti gli elementi nell'array
     *
     * @return la somma di tutti gli elementi
     */
    private int calcolaSomma() {
        int sum = 0;
        for (int num : this.numeri) {
            sum += num;
        }
        return sum;
    }

    /**
     * Getter per ottenere la somma calcolata
     *
     * @return valore della somma
     */
    public int getSomma() {
        return this.somma;
    }

    /**
     * Getter per ottenere l'array di numeri
     *
     * @return array di numeri
     */
    public int[] getNumeri() {
        return this.numeri;
    }

    /**
     * Rappresentazione testuale dell'oggetto
     *
     * @return stringa formattata contenente array e somma
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " {\n" +
                "\tArray: " + ArrayMethods.printArray(this.numeri) + "\n" +
                "\tSomma: " + this.somma + "\n" +
                "}";
    }

    /**
     * Metodo principale per testare la classe
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Calcolo Somma Array ===\n");

        // Creazione oggetto e calcolo automatico della somma
        SommaArray sa = new SommaArray(sc);

        // Visualizzazione risultati
        System.out.println("\n" + sa);
        System.out.println("La somma degli elementi è: " + sa.getSomma());

        sc.close();
    }
}
