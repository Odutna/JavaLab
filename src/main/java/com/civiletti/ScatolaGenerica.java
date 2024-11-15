package com.civiletti;

//import java.lang.reflect.Array;  // Fornisce metodi per lavorare a basso livello con gli array come
                                   // la creazione dinamica di array, la modifica dei loro elementi e
                                   // l'accesso agli array attraverso la riflessione (iterare sugli
                                   // elementi di un array senza conoscerne il tipo in anticipo,
                                   // effettuare cast automatici degli elementi di un array, etc.
                                   // La riflessione è utile nei contesti di programmazione generica
                                   // o di analisi dinamica del codice, quando non si conoscono le
                                   // caratteristiche degli array.

import java.util.Arrays;           // Fornisce metodi statici per eseguire operazioni più comuni sugli
                                   // array, come ordinare, cercare, copiare e confrontare elementi.
                                   // Questa classe è più orientata alle operazioni di alto livello sui
                                   // dati di array.
//import java.util.ArrayList;

/**
 * Classe generica che implementa un contenitore per qualsiasi tipo di dato
 * @param <T> il tipo di dato che la scatola può contenere
 */
public class ScatolaGenerica<T> {

    // Il contenuto della scatola, di tipo generico T
    private T contenuto;

    /**
     * Imposta il contenuto della scatola
     * @param contenuto il valore da memorizzare nella scatola
     */
    public void setContenuto(T contenuto) {
        this.contenuto = contenuto;
    }

    /**
     * Recupera il contenuto della scatola
     * @return il valore memorizzato nella scatola
     */
    public T getContenuto() {
        return contenuto;
    }

    /**
     * Stampa gli elementi di un array generico
     * @param <T> il tipo degli elementi dell'array
     * @param array l'array da stampare
     */
    public <T> void printArray(T[] array) {
        String separazione = " - ";
        // Itera su ogni elemento dell'array e lo stampa seguito da un separatore
        for (T elemento : array) {
            System.out.print(elemento + separazione);
        }
        System.out.println();
    }

    /**
     * Metodo main per testare le funzionalità della classe
     * @param args argomenti da riga di comando (non utilizzati)
     */
    public static void main(String[] args) {
        System.out.println("Tipi Generics\n");

        // Test con tipo String
        ScatolaGenerica<String> scatolaString = new ScatolaGenerica<>();
        scatolaString.setContenuto("Ciao sono un tipo String!");
        System.out.println("Contenuto: " + scatolaString.getContenuto());

        // Test con tipo Integer
        ScatolaGenerica<Integer> scatolaInt = new ScatolaGenerica<>();
        scatolaInt.setContenuto(123);
        System.out.println("Contenuto: " + scatolaInt.getContenuto());

        // Test con tipo Boolean
        ScatolaGenerica<Boolean> scatolaBoolean = new ScatolaGenerica<>();
        scatolaBoolean.setContenuto(true);
        System.out.println("Contenuto: " + scatolaBoolean.getContenuto());

        // Test del metodo printArray con array di diversi tipi

        //ScatolaGenerica<Arrays> scatolaArray = new ScatolaGenerica<>();  // import java.lang.reflect.Array;

        ScatolaGenerica<Arrays> scatolaArray = new ScatolaGenerica<>();    // import java.util.Arrays
        String[] words = {"I", "tipi", "generici", "sono", "molto", "utili"};
        Integer[] numbers = {1, 2, 3, 4, 5};

        scatolaArray.printArray(words);
        scatolaArray.printArray(numbers);

        // TODO: Codice commentato per riferimento futuro
        //printArray(words);
        //printArray(numbers);
    }
}