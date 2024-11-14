package com.civiletti;

/**
 * Questa dimostrazione mostra come dichiarare, allocare memoria e inizializzare array in Java.
 * Viene anche illustrato come iterare sugli elementi, oltre a eseguire operazioni di inserimento 
 * e lettura dei singoli elementi tramite l'indice.
 *
 * In Java, gli array sono considerati oggetti e possono essere dichiarati e inizializzati in vari modi,
 * con o senza l'uso dell'operatore 'new'.
 *
 * @author Ing. Civiletti
 * @version 0.0
 */
public class ArrayDichiarazione {

    public static void main(String[] args) {

        // Dichiarazione e allocazione di memoria
        int[] arrayInt = new int[5];  // Array di interi con lunghezza 5
        double[] arrayDouble = new double[10];  // Array di double con lunghezza 10

        // Dichiarazione separata e successiva allocazione di memoria
        float[] arrayFloat;        // Dichiarazione dell'array
        arrayFloat = new float[5]; // Allocazione di un array di float con lunghezza 5

        // Dichiarazione e inizializzazione separata
        Character[] arrayCharacter;  // Dichiarazione dell'array
        arrayCharacter = new Character[]{'P', 'r', 'o', 'g', 'r', 'a', 'm', 'm', 'a'};  // Inizializzazione

        // Trasformare una stringa in un array di stringhe utilizzando 'split()'
        String miaStringa = "Se. ti. piace. l'informatica";
        String[] arrayString = miaStringa.split("\\.");  // [.] // Divisione della stringa in base al punto [.]

        // Dichiarazione e inizializzazione diretta di un array
        int[] numeri = {1, 2, 3, 4, 5};  // Inizializzazione inline

        // Inizializzazione con 'new'
        int[] numeri2 = new int[]{1, 2, 3, 4, 5};  // Analoga alla precedente

        // Stampa di tutti gli elementi dell'array 'numeri' utilizzando un ciclo for tradizionale
        for (int index = 0; index < numeri.length; index++) {
            System.out.println("Elemento in 'numeri' indice (" + index + "): " + numeri[index]);
        }

        // Stampa degli elementi di 'numeri2' utilizzando un ciclo for-each con contatore manuale
        int indice = 0;
        for (int elemento : numeri2) {
            System.out.println("Elemento in 'numeri2' indice (" + indice + "): " + elemento);
            indice++;
        }

        // Stampa degli elementi dell'array 'arrayString' utilizzando un ciclo for-each
        System.out.print("Elementi di arrayString: ");
        for (String elementoStringa : arrayString) {
            System.out.print(elementoStringa + "_");
        }
        System.out.println();

        // Stampa degli elementi dell'array 'arrayCharacter' utilizzando un ciclo for-each
        System.out.print("Elementi di arrayCharacter: ");
        for (char c : arrayCharacter) {
            System.out.print(c + "°");
        }
        System.out.println();

        // Esempio di inserimento e lettura di elementi in un array tramite indice
        int[] arrayInserimento = new int[3];  // Dichiarazione e allocazione
        arrayInserimento[0] = 10;  // Inserimento al primo indice
        arrayInserimento[1] = 20;  // Inserimento al secondo indice
        arrayInserimento[2] = 30;  // Inserimento al terzo indice

        // Lettura e stampa degli elementi tramite indice
        System.out.println("Elementi di arrayInserimento:");
        for (int i = 0; i < arrayInserimento.length; i++) {
            System.out.println("Indice " + i + ": " + arrayInserimento[i]);
        }
    }
}
