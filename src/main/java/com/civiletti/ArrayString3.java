package com.civiletti;

import java.util.Scanner;

/**
 * Questa classe implementa un programma per l'analisi di stringhe, in particolare per contare
 * il numero di spazi presenti. A differenza delle versioni precedenti (ArrayString1 e ArrayString2),
 * questa implementazione utilizza l'incapsulamento dei dati attraverso variabili private e metodi
 * getter/setter.
 *
 * Funzionalità principali:
 * - Inserimento di una stringa da parte dell'utente
 * - Conteggio degli spazi nella stringa
 * - Memorizzazione dei dati in variabili private
 * - Accesso ai dati tramite metodi getter/setter
 *
 * @author Ing. Civiletti
 * @version 3.0
 */
public class ArrayString3 {

    // Variabili di istanza private per l'incapsulamento dei dati
    private String stringaInserita;  // Memorizza la stringa inserita dall'utente
    private int contaSpazi;          // Memorizza il numero di spazi contati

    // Metodi getter e setter
    /**
     * Restituisce la stringa inserita dall'utente.
     * @return La stringa memorizzata
     */
    public String getStringaInserita() {
        return stringaInserita;
    }

    /**
     * Imposta la stringa da analizzare.
     * @param stringaInserita La stringa da memorizzare
     */
    public void setStringaInserita(String stringaInserita) {
        this.stringaInserita = stringaInserita;
    }

    /**
     * Restituisce il numero di spazi contati nella stringa.
     * @return Il numero di spazi
     */
    public int getContaSpazi() {
        return contaSpazi;
    }

    /**
     * Imposta il numero di spazi contati.
     * @param contaSpazi Il numero di spazi da memorizzare
     */
    public void setContaSpazi(int contaSpazi) {
        this.contaSpazi = contaSpazi;
    }

    /**
     * Metodo per acquisire una stringa dall'utente tramite Scanner.
     * Utilizza nextLine() per leggere l'intera riga, inclusi gli spazi,
     * invece di next() che si fermerebbe al primo spazio.
     *
     * @param sc Scanner per la lettura dell'input
     * @return La stringa inserita dall'utente
     */
    public String inserisciStringa(Scanner sc) {
        System.out.println("Inserisci una stringa:");
        return sc.nextLine();
    }

    /**
     * Conta il numero di spazi in una stringa utilizzando il metodo split.
     * La stringa viene divisa in un array di singoli caratteri e viene
     * utilizzato un ciclo for-each per contare gli spazi.
     * Il risultato viene anche memorizzato nella variabile di istanza
     * tramite setContaSpazi().
     *
     * @param s La stringa da analizzare
     * @return Il numero di spazi trovati nella stringa
     */
    public int contaSpazi(String s) {
        int conta = 0;
        String[] arrayS = s.split("");  // Divide la stringa in singoli caratteri
        for (String s1 : arrayS) {
            if (s1.equals(" ")) {  // Usa equals per confrontare le stringhe
                conta++;
            }
        }
        setContaSpazi(conta);  // Memorizza il risultato nella variabile di istanza
        return conta;
    }

    /**
     * Override del metodo toString() per fornire una rappresentazione leggibile
     * dell'oggetto ArrayString3, includendo la stringa inserita e il numero
     * di spazi contati.
     *
     * @return Una stringa formattata con i dati dell'oggetto
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{\n" +
                "\tStringa inserita: " + getStringaInserita() + "\n" +
                "\tNumero di spazi: " + getContaSpazi() + "\n" +
                "}";
    }

    /**
     * Metodo principale che esegue il programma.
     * Crea un oggetto Scanner per l'input, un'istanza della classe,
     * acquisisce una stringa dall'utente, conta gli spazi e visualizza i risultati.
     *
     * @param args Argomenti da riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayString3 as = new ArrayString3();

        // Acquisizione e memorizzazione della stringa
        String s = as.inserisciStringa(sc);
        as.setStringaInserita(s);

        // Visualizzazione della stringa e conteggio degli spazi
        System.out.println("Stringa inserita: " + as.getStringaInserita());
        as.contaSpazi(s);
        System.out.println("Numero di spazi: " + as.getContaSpazi());

        // Visualizzazione dell'oggetto utilizzando toString()
        System.out.println(as);
    }
}