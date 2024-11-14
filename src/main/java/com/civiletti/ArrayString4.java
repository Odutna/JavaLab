package com.civiletti;

/**
 * In questa versione, si vuole mostrare come implementare il *method chaining*,
 * restituendo l'istanza corrente dell'oggetto all'interno dei metodi setter.
 * Questo permette di concatenare più chiamate di metodo in una singola istruzione,
 * migliorando la leggibilità e la fluidità del codice.
 *
 * Funzionalità principali:
 * - Inserimento di una stringa da parte dell'utente
 * - Conteggio degli spazi nella stringa
 * - Memorizzazione dei dati in variabili private
 * - Accesso ai dati tramite metodi getter/setter
 *
 * Per un ulteriore esemppio vedere anche la classe Persona.
 *
 * @author Ing. Civiletti
 * @version 4.0
 *
 */


import java.util.Scanner;

public class ArrayString4 {

    private String stringaInserita;
    private int contaSpazi;

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
    public ArrayString4 setStringaInserita(String stringaInserita) {
        this.stringaInserita = stringaInserita;
        return this;  // Restituisce l'istanza corrente per consentire chiamate concatenate
    }

    /**
     * Restituisce il numero di spazi contati nella stringa.
     * @return Il numero di spazi
     */
    public int getContaSpazi() {
        return contaSpazi;
    }
    // Fine metodi getter e setter

    /**
     * Imposta il numero di spazi contati.
     * @param contaSpazi Il numero di spazi da memorizzare
     */
    public ArrayString4 setContaSpazi(int contaSpazi) {
        this.contaSpazi = contaSpazi;
        return this;  // Restituisce l'istanza corrente per consentire chiamate concatenate
    }

    /**
     * Metodo per acquisire una stringa dall'utente tramite Scanner.
     * Utilizza nextLine() per leggere l'intera riga, inclusi gli spazi,
     * invece di next() che si fermerebbe al primo spazio.
     *
     * @param sc Scanner per la lettura dell'input
     * @return La stringa inserita dall'utente
     */
    public ArrayString4 inserisciStringa(Scanner sc) {
        System.out.println("Inserisci una stringa:");
        String s = sc.nextLine();  // Legge l'intera riga di input
        return setStringaInserita(s);  // Imposta la stringa inserita e restituisce l'istanza
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
    public ArrayString4 contaSpazi() {
        int conta = 0;
        String[] arrayS = stringaInserita.split("");
        for (String s1 : arrayS) {
            if (s1.equals(" ")) {  // Usare equals per confrontare le stringhe
                conta++;
            }
        }
        return setContaSpazi(conta);  // Imposta il numero di spazi e restituisce l'istanza
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
        ArrayString4 as = new ArrayString4();

        // Esempio di utilizzo concatenato
        as.inserisciStringa(sc).contaSpazi();

        // Visualizzazione dell'oggetto utilizzando toString()
        System.out.println(as);
    }
}
