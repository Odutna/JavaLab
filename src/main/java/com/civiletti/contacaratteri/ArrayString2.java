package com.civiletti.contacaratteri;

/**
 * Questo programma permette all'utente di inserire una stringa e conta il numero
 * di spazi presenti nella stringa. Utilizza il metodo 'charAt()' per iterare su 
 * ciascun carattere della stringa e controllare se è uno spazio.
 *
 * Rispetto alla versione precedente, che utilizzava 'split()' per trasformare 
 * la stringa in un array, questa implementazione con 'charAt()' è più diretta 
 * e leggera. Infatti, non richiede la creazione di un array temporaneo, quindi 
 * potrebbe risultare più efficiente in termini di memoria per stringhe di grandi
 * dimensioni.
 *
 * * @author Ing. Civiletti
 *  * @version 1.1
 */

import java.util.Scanner;

public class ArrayString2 {

    /**
     * Metodo per leggere una stringa inserita dall'utente.
     * @param sc Scanner per la lettura dell'input
     * @return La stringa inserita dall'utente
     */
    public String inserisciStringa(Scanner sc) {
        System.out.println("Inserisci una stringa:");
        return sc.nextLine();  // Legge l'intera riga di input mentre next() si ferma al primo spazio " "
    }

    /**
     * Metodo per contare il numero di spazi in una stringa.
     * @param s La stringa su cui eseguire il conteggio
     * @return Il numero di spazi nella stringa
     */
    public int contaSpazi(String s) {
        int conta = 0;
        //String[] arrayS = s.split("");
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                conta++;
            }
        }
        return conta;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Creo un oggetto scanner
        ArrayString2 as = new ArrayString2();

        // Inserimento della stringa da parte dell'utente
        String s = as.inserisciStringa(sc);

        // Visualizzazione della stringa inserita
        System.out.println("Stringa inserita: " + s);

        // Conteggio degli spazi e visualizzazione del risultato
        int i = as.contaSpazi(s);

        System.out.println("Numero di spazi: " + i);

        // Stampa dell'oggetto (usato qui in modo dimostrativo)
        //System.out.println(as);
    }
}
