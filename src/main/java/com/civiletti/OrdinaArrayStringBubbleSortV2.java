package com.civiletti;


import java.util.Scanner;

public class OrdinaArrayStringBubbleSortV2 {

    String[] nomi;

    public OrdinaArrayStringBubbleSortV2(String[] nomi) {
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

    public static String[] ordinaNomi(String[] nomi, boolean crescente) {

        boolean control;
        for (int i = 0; i < nomi.length - 1; i++) {
            for (int j = 0; j < nomi.length - 1 - i; j++) {
                if (crescente) control = nomi[j].compareTo(nomi[j + 1]) > 0; // crescente
                else control = nomi[j].compareTo(nomi[j + 1]) < 0; // decerescente
                if (control) {
                    String temp = nomi[j];
                    nomi[j] = nomi[j + 1];
                    nomi[j + 1] = temp;
                }
            }
        }
        return nomi; // Restituisce l'array ordinato
    }

    public static void stampaElementiArray(String[] nomi) {
        //System.out.println();
        System.out.println("===============================");
        for (String nome : nomi) {
            System.out.println(nome);
        }
    }

    public static void main(String[] args) {

        String[] nomi = {"Luca", "Anna", "Marco", "Giulia", "Paolo", "Annamaria"};  // Test

        //String[] nomi = inserisci(new Scanner(System.in));
        stampaElementiArray(nomi);

        // Ordina i nomi
        ordinaNomi(nomi,true); // Crescente
        stampaElementiArray(nomi);

        // Ordina i nomi
        ordinaNomi(nomi,false); // Decrescente
        stampaElementiArray(nomi);

    }
}
