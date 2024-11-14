package com.civiletti;

import java.util.Scanner;

public class ContaCifre {

    // Metodo statico che conta il numero di cifre di un numero intero positivo
    static int contaCifre(int numero) {

        int cont = 1; // Inizializzo il contatore delle cifre a 1

        // Ciclo infinito che continua finché il numero non è inferiore a 10
        while (true) {
            // Se il numero diviso per 10 è diverso da zero, ha ancora cifre rimanenti
            if (numero / 10 != 0) {
                numero /= 10; // Riduco il numero eliminando l'ultima cifra
                cont++;       // Incremento il contatore delle cifre
            } else break;     // Se il numero è minore di 10, usciamo dal ciclo
        }
        return cont; // Restituisco il numero totale di cifre calcolato
    }

    public static void main(String[] cmd) {
        Scanner sc = new Scanner(System.in); // Creo un oggetto Scanner per leggere l'input utente

        boolean run = true;
        while(run) {
            System.out.print("Inserisci un numero: ");
            int n1 = sc.nextInt(); // Leggo il numero intero inserito

            // Stampo il numero di cifre del numero usando il metodo contaCifre
            System.out.print("Il numero di cifre è: " + contaCifre(n1));

            System.out.print("\nContinuare? (s/n) ");
            char op = sc.next().charAt(0);
            if (op == 'n') {
                run = false;
                System.out.println("Grazie per aver usato il mio programma!");
            }
        }
    }
}
