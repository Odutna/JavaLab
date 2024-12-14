package com.civiletti.contacaratteri.methodchaining.regularexpression;

import java.util.Scanner;

/**
 * Questa classe implementa un programma avanzato per l'analisi di stringhe, che include
 * il conteggio di spazi, consonanti e vocali. Utilizza il pattern del method chaining
 * per permettere chiamate concatenate dei metodi. Rispetto alle versioni precedenti,
 * aggiunge funzionalità per l'analisi dei caratteri e include un costruttore aggiuntivo.
 *
 * Funzionalità principali:
 * - Inserimento di una stringa da parte dell'utente o tramite costruttore
 * - Conteggio degli spazi nella stringa
 * - Conteggio delle consonanti nella stringa – tramite Regular Expression (methodchaining)
 * - Conteggio delle vocali nella stringa – tramite Regular Expression (methodchaining)
 * - Memorizzazione dei dati in variabili private
 * - Accesso ai dati tramite metodi getter/setter con method chaining
 *
 * @author Ing. Civiletti
 * @version 1.5
 */
public class ArrayString5 {

    private String stringaInserita;
    private int contaSpazi;
    private int contaConsonanti;
    private int contaVocali;

    /**
     * Costruttore vuoto per inizializzare l'oggetto senza parametri.
     */
    ArrayString5() {
    }

    /**
     * Costruttore che accetta una stringa come parametro iniziale.
     * @param stringa La stringa da analizzare
     */
    ArrayString5(String stringa) {
        this.stringaInserita = stringa;
    }

    // Metodi getter e setter
    /**
     * Restituisce la stringa memorizzata.
     * @return La stringa inserita
     */
    public String getStringaInserita() {
        return stringaInserita;
    }

    /**
     * Imposta la stringa da analizzare.
     * @param stringaInserita La stringa da memorizzare
     * @return L'istanza corrente per il method chaining
     */
    public ArrayString5 setStringaInserita(String stringaInserita) {
        this.stringaInserita = stringaInserita;
        return this;
    }

    /**
     * Restituisce il numero di spazi contati.
     * @return Il numero di spazi
     */
    public int getContaSpazi() {
        return contaSpazi;
    }

    /**
     * Imposta il numero di spazi contati.
     * @param contaSpazi Il numero di spazi da memorizzare
     * @return L'istanza corrente per il method chaining
     */
    public ArrayString5 setContaSpazi(int contaSpazi) {
        this.contaSpazi = contaSpazi;
        return this;
    }

    /**
     * Restituisce il numero di consonanti contate.
     * @return Il numero di consonanti
     */
    public int getContaConsonanti() {
        return contaConsonanti;
    }

    /**
     * Imposta il numero di vocali contate.
     * @param contaVocali Il numero di vocali da memorizzare
     * @return L'istanza corrente per il method chaining
     */
    public ArrayString5 setContaVocali(int contaVocali) {
        this.contaVocali = contaVocali;
        return this;
    }

    /**
     * Restituisce il numero di vocali contate.
     * @return Il numero di vocali
     */
    public int getContaVocali() {
        return contaVocali;
    }

    /**
     * Imposta il numero di consonanti contate.
     * @param contaConsonanti Il numero di consonanti da memorizzare
     * @return L'istanza corrente per il method chaining
     */
    public ArrayString5 setContaConsonanti(int contaConsonanti) {
        this.contaConsonanti = contaConsonanti;
        return this;
    }

    /**
     * Metodo per acquisire una stringa dall'utente tramite Scanner.
     * @param sc Scanner per la lettura dell'input
     * @return L'istanza corrente per il method chaining
     */
    public ArrayString5 inserisciStringa(Scanner sc) {
        System.out.println("Inserisci una stringa:");
        String s = sc.nextLine();  // Legge l'intera riga di input
        return setStringaInserita(s);
    }

    /**
     * Conta il numero di spazi nella stringa memorizzata.
     * @return L'istanza corrente per il method chaining
     */
    public ArrayString5 contaSpazi() {
        int conta = 0;
        String[] arrayS = stringaInserita.split("");
        for (String s1 : arrayS) {
            if (s1.equals(" ")) {  // Usare equals per confrontare le stringhe
                conta++;
            }
        }
        return setContaSpazi(conta);
    }

    /**
     * Conta il numero di consonanti nella stringa memorizzata.
     * Utilizza una regular expression per identificare i caratteri
     * che non sono vocali.
     * @return L'istanza corrente per il method chaining - Modificato in fase di implementazione nel metodo setter
     */
    public ArrayString5 contaConsonanti() {
        int conta = 0;
        String[] arrayS = stringaInserita.toLowerCase().split("");
        for (String s1 : arrayS) {
            if (s1.matches("[^aeiouAEIOU]")) {  // Verifica se s1 è una consonante
                conta++;
            }
        }
        return setContaConsonanti(conta);
    }

    /**
     * Conta il numero di vocali nella stringa memorizzata.
     * Utilizza una regular expression per identificare le vocali.
     * @return L'istanza corrente per il method chaining
     */
    public ArrayString5 contaVocali() {
        int conta = 0;
        String[] arrayS = stringaInserita.toLowerCase().split("");
        for (String s1 : arrayS) {
            if (s1.matches("[aeiouAEIOU]")) {  // Verifica se s1 è una vocale
                conta++;
            }
        }
        return setContaVocali(conta);
    }

    /**
     * Fornisce una rappresentazione testuale dell'oggetto.
     * @return Una stringa formattata con tutti i dati dell'oggetto
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{\n" +
                "\tStringa inserita: " + getStringaInserita() + "\n" +
                "\tNumero di spazi: " + getContaSpazi() + "\n" +
                "\tNumero di consonanti: " + getContaConsonanti() + "\n" +
                "\tNumero di vocali: " + getContaVocali() + "\n" +
                "}";
    }

    /**
     * Metodo principale che dimostra l'utilizzo della classe.
     * Mostra due esempi:
     * 1. Utilizzo con input da utente
     * 2. Utilizzo con stringa predefinita passata al costruttore
     *
     * @param args Argomenti da riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayString5 as = new ArrayString5();

        String testStringa = "Questo è un semplice test per contare gli spazi le vocali e le consonanti con concatenamento ";

        // Esempio di utilizzo concatenato con input da utente
        as.inserisciStringa(sc).contaSpazi().contaConsonanti().contaVocali();
        System.out.println(as);

        // Esempio di utilizzo concatenato con stringa predefinita
        ArrayString5 as1 = new ArrayString5(testStringa);
        as1.contaSpazi().contaConsonanti().contaVocali();
        System.out.println(as1);
    }
}