package com.civiletti.contacaratteri;


/**
 * Questo programma consente all'utente di inserire una stringa e calcola il numero di spazi presenti al suo interno.
 * Utilizza un metodo per l'inserimento della stringa e un altro metodo per contare gli spazi.
 * Sfrutta la funzione 'split()' per convertire la stringa in un array di singoli caratteri e un ciclo 'for-each'
 * per iterare su di essi e contarne gli spazi.
 *
 * @author Ing. Civiletti
 * @version 1.0
 */

import java.util.Scanner;

public class ArrayString1 {

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
     *
     * • Confronto con ==
     *
     *     - Confronta i riferimenti in memoria (l'indirizzo degli oggetti)
     *     - Per le stringhe, controlla se sono lo stesso oggetto
     *     - Non confronta il contenuto effettivo
     *
     * • Confronto con equals()
     *
     *     - Confronta il contenuto effettivo delle stringhe
     *     - Metodo definito nella classe Object
     *     - Per la classe String, è stato sovrascritto per confrontare il contenuto testuale
     *
     * @param s La stringa su cui eseguire il conteggio
     * @return Il numero di spazi nella stringa
     */
    public int contaSpazi(String s) {
        int conta = 0; // Contatore per gli spazi

        String[] arrayS = s.split(""); // Array di stringhe, "" splitta ogni singolo carattere

        for (String s1 : arrayS)
            if (s1.equals(" ")) // !!! Usare equals per confrontare le stringhe !!!
                conta++;

            // System.out.print(" " +s1); // Test
        //System.out.println(arrayS.length); // Test
        return conta;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayString1 as = new ArrayString1();

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
