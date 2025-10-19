package com.civiletti.ordinamento_array;


import java.util.Scanner;

public class OrdinaArrayStringBubbleSort {

    String[] nomi;

    public OrdinaArrayStringBubbleSort(String[] nomi) {
        this.nomi = nomi;
    }

    static String[] inserisci(Scanner sc){
        System.out.println("Quanti nomi vuoi inserire?");
        int n = sc.nextInt();
        String[] nomi = new String[n];

        for (int i = 0; i < n; i++) {
            nomi[i] = sc.next();
        }
        return nomi;
    }

    public static void main(String[] args) {

        // String[] nomi = {"Luca", "Anna", "Marco", "Giulia", "Paolo", "Annamaria"};  // Test

        String[] nomi = inserisci(new Scanner(System.in));

        System.out.println("===============================");

        // Ordinamento crescente
        for (int i = 0; i < nomi.length - 1; i++) {
            for (int j = 0; j < nomi.length - 1 - i; j++) {
                if (nomi[j].compareTo(nomi[j + 1]) > 0) { // Scambia se non sono in ordine
                    String temp = nomi[j];
                    nomi[j] = nomi[j + 1];
                    nomi[j + 1] = temp;
                }
            }
        }

        // Stampa il risultato
        System.out.println("Ordinamento crescente:");
        for (String nome : nomi) {
            System.out.print(nome + " ");
        }

        System.out.println("\n===============================");

        // Ordinamento decrescente
        for (int i = 0; i < nomi.length - 1; i++) {
            for (int j = 0; j < nomi.length - 1 - i; j++) {
                if (nomi[j].compareTo(nomi[j + 1]) < 0) { // Scambia se non sono in ordine
                    String temp = nomi[j];
                    nomi[j] = nomi[j + 1];
                    nomi[j + 1] = temp;
                }
            }
        }

        // Stampa il risultato
        System.out.println("Ordinamento decrescente:");
        for (String nome : nomi) {
            System.out.print(nome + " ");
        }
        System.out.println("\n===============================");

    }
}
