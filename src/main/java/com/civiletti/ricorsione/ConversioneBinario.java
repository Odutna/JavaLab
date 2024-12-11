package com.civiletti.ricorsione;

import java.util.Scanner;

// Conversione di un numero intero decimale in binario tramite ricorsione
public class ConversioneBinario {

    static int inserisci(Scanner sc){
        System.out.print("Numero decimale da convertire: ");
        return sc.nextInt();
    }

    // Metodo ricorsivo per convertire un numero decimale in binario
    public static void binario(int numero) {

        if (numero > 0) {                   // Condizione di terminazione della ricorsione
            binario(numero / 2);    // Chiamata ricorsiva diviso 2
            System.out.print(numero % 2);   // Stampa il resto della divisione per 2 (bit)
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================");
        System.out.println("=   Conversione in binario    =");
        System.out.println("===============================");

        do {
            binario(inserisci(sc));
            System.out.println("\nContinuare? (s/n)");
        }while(sc.next().charAt(0) != 'n');

        System.out.println("Arrivederci!");
    }


}
