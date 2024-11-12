package com.civiletti;

/**
 * In Java gli array sono considerati oggetti e possono essere dichiarati in diversi modi,
 * con o senza l'uso dell'operatore new.
 */

public class ArrayDichiarazione {

    public static void main(String[] args) {

        // Sintassi:
        // Tipo[] nomeArray = new Tipo[dimensione];
        
        // Dichiarazione con Allocazione Esplicita di Memoria
        int[] arrayInt = new int[5];  // Array di interi di lunghezza 5
        double[] arrayDouble = new double[10];  // Array di double di lunghezza 10

        // Dichiarazione e Allocazione separata
        float[] arrayFloat;        // Dichiarazione dell'array
        arrayFloat = new float[5]; // Array di float di lunghezza 5

        // Dichiarazione e Allocazione separata e inizializzazione
        Character[] arrayCharacter;        // Dichiarazione dell'array
        arrayCharacter = new Character[]{'P','r','o','g','r','a','m','m','a'}; // Inizializzazione dell'array

        String miaStringa = "Se. ti. piace. l'informatica";
        //miaStringa = "192.168.1.1";
        String[] arrayString = miaStringa.split("[.]"); // trasformo una stringa in un array di stringhe

        // Dichiarazione e inizializzazione di un array di interi
        int[] numeri = {1, 2, 3, 4, 5};   // 

        int[] numeri2 = new int[]{1, 2, 3, 4, 5};   // Analoga alla precedente


        // Stampa di tutti gli elementi dell'array
        for (int index = 0; index < numeri.length; index++) { // Utilizzo del costrutto for-each
            System.out.println("Elemento in 'numeri' indice (" + index + "): " + numeri[index]);
        }

        int indice = 0;
        for(int elemento : numeri2) {
            System.out.println("Elemento in 'numeri2' indice (" + indice + "): " + elemento);
            indice++;
        }

        // Utilizzo del costrutto for-each

        for(String elementoStringa : arrayString){
            System.out.print(elementoStringa + "_");
        }

        System.out.printf(" ");

        for(char c : arrayCharacter){
            System.out.print(c + "°");
        }

    }
}
