package com.civiletti;

import java.util.Scanner;

public class GestioneInventario {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int prodottiDisponibili = 5; // numero iniziale di prodotti in inventario
        int venditeEffettuate = 0;   // contatore per il numero di vendite effettuate

        // Ciclo per simulare le vendite
        for (int i = 0; i < 3; i++) {
            System.out.println("Prodotti disponibili prima della vendita: " + prodottiDisponibili);

            System.out.println("Domanda: Qual è il valore di venditeEffettuate dopo venditeEffettuate++?");
            int risposta = sc.nextInt();

            System.out.println("Risposta corretta: venditeEffettuate = " + venditeEffettuate++);
            if (risposta == venditeEffettuate) {
                System.out.println("Risposta corretta!");
            } else {
                System.out.println("Risposta errata. Il valore attuale di venditeEffettuate è " + venditeEffettuate);
            }

            // Decrementa prodotti disponibili e incrementa vendite effettuate
            System.out.println("Domanda: Qual è il valore di venditeEffettuate dopo ++venditeEffettuate?");
            risposta = sc.nextInt();

            System.out.println("Risposta corretta: venditeEffettuate = " + ++venditeEffettuate);
            if (risposta == venditeEffettuate) {
                System.out.println("Risposta corretta!");
            } else {
                System.out.println("Risposta errata. Il valore attuale di venditeEffettuate è " + venditeEffettuate);
            }

            // Aggiorna l'inventario
            prodottiDisponibili--;
            System.out.println("Prodotti disponibili dopo la vendita: " + prodottiDisponibili);
            System.out.println("-------------------------------");
        }

        System.out.println("Vendite totali effettuate: " + venditeEffettuate);
        System.out.println("Prodotti rimasti in inventario: " + prodottiDisponibili);
    }
}
