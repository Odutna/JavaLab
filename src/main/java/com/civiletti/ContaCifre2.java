package com.civiletti;

import java.util.Scanner;

public class ContaCifre2 {


    // Metodo per calcolare il numero di cifre
    public static int contaCifre2(int numero) {

        //counter cifre
        int counter = 0;

        if (numero == 0) return 1; // Caso

        //ciclo for per calcolare il numero di cifre; != rende funzionale sia per numeri negativi che positivi
        for (; numero != 0; numero/=10) {
            counter++;
        }
        return counter;
    }

    public static void main(String[] cmd) {

        Scanner sc = new Scanner(System.in); // Creo un oggetto Scanner per leggere l'input utente

        do {
            System.out.print("Inserisci un numero: ");
            int n1 = sc.nextInt(); // Leggo il numero intero inserito

            // Stampo il numero di cifre del numero usando il metodo contaCifre2
            System.out.print("Il numero di cifre è: " + contaCifre2(n1));

            System.out.print("\nContinuare? (s/n) ");

        } while(sc.next().charAt(0) != 'n');

        System.out.println("Grazie per aver usato il mio programma!");

    }
}
