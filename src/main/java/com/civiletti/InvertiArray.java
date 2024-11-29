package com.civiletti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

import java.util.Scanner;

/**
 * Questa classe implementa diverse metodologie per invertire un array di interi.
 * Fornisce funzionalità per:
 * - Inserimento dell'array da tastiera
 * - Inversione dell'array usando un approccio base
 * - Visualizzazione dell'array originale e invertito
 *
 * @author civiletti
 * @version 1.0
 */
public class InvertiArray {
    int dim;
    int[] numeri;
    int[] arrayInvertito;

    /**
     * Costruttore che inizializza l'array e lo inverte
     * @param sc Scanner per l'input da tastiera
     */
    InvertiArray(Scanner sc) {
        this.numeri = inserisciArray(sc);
        this.arrayInvertito = invertiArrayBase(this.numeri);
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
     * Metodo base per invertire l'array usando un ciclo for
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
        InvertiArray ia = new InvertiArray(scanner);

        // Test
        System.out.println("Inversione con metodo base:");
        //ia.arrayInvertito = ia.invertiArrayBase(ia.numeri);
        System.out.println(ia);

        scanner.close();
    }
}