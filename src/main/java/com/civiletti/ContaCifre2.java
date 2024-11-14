package com.civiletti;

import java.util.Scanner;

public class ContaCifre2 {


    // Metodo per calcolare il numero di cifre
    public static int contaCifre2(int numero) {

        //counter cifre
        int cont = 0;

        if (numero == 0) return 1; // Caso base

        //ciclo for per calcolare il numero di cifre
        for (; numero != 0; numero/=10) {
            cont++;
        }
        return cont;
    }

    public static void main(String[] cmd) {

        Scanner sc = new Scanner(System.in); // Creo un oggetto Scanner per leggere l'input utente

        do {
            System.out.print("Inserisci un numero: ");
            int n = sc.nextInt(); // Leggo il numero intero inserito

            // Stampo il numero di cifre del numero usando il metodo contaCifre2
            System.out.print("Il numero di cifre è: " + contaCifre2(n));

            System.out.print("\nContinuare? (s/n) ");

        } while(sc.next().charAt(0) != 'n');

        System.out.println("Grazie per aver usato il mio programma!");

    }
}
