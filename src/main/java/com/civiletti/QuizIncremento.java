package com.civiletti;

import java.util.Scanner;

public class QuizIncremento {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Scanner per input da tastiera

        int score = 0; // Variabile per conteggiare il punteggio delle risposte corrette
        int i = 0; // Variabile che verrà modificata con i++ e ++i

        // Ciclo for che ripete due volte il quiz
        for (int j = 0; j < 2; j++) {
            System.out.println("j = (" + j + ") i = " + i);

            System.out.println("Qual'è il valore di i dopo la System.out.println( i++ )");

            int risposta = sc.nextInt(); // Acquisisce la risposta dell'utente

            System.out.println("Risposta corretta: i = " + i++);
            // Confronta la risposta utente con il valore di i aggiornato (i è incrementato dopo il confronto)
            int tmp = i;
            tmp--;
            if(risposta == tmp) {
                score++;
                System.out.println("SCORE!");
            }

            System.out.println("Qual'è il valore di i dopo la System.out.println( ++i )");

            risposta = sc.nextInt(); // Acquisisce la risposta dell'utente

            System.out.println("Risposta corretta: i = " + ++i);

            // Confronta la risposta dell'utente con il valore attuale di i e aggiorna il punteggio
            if(risposta == i) {
                score++;
                System.out.println("SCORE!");
            }
        }

        System.out.println("Qual è il valore finale di i dopo il ciclo?");
        int risposta = sc.nextInt();

        System.out.println("Risposta finale: i = " + i);

        if(risposta == i) {
            score++;
            System.out.println("SCORE!");
        }

        // Stampa il punteggio finale dell'utente
        System.out.println("Il tuo punteggio è: " + score);
    }
}

