package com.civiletti.esercitazione;

/**
 * Azzera coppie di elementi consecutivi uguali all'interno di un vettore
 * Insieme di valori del vettore di test: {7, 3, 3, 4, 1, 8, 6, 6, 6, 5}
 *
 * Suggerimento:
 *
 * Il programma, denominato AzzeraCoppie, deve eseguire diverse operazioni
 * su un'array di numeri denominato ad esempio v[]:
 *
 * Inizializzazione e Copia:
 *
 * a) Inizializzare un array v[] con l'insieme di numeri interi.
 * b) Creare un nuovo array w[] della stessa lunghezza di v[].
 * c) Copia deivalori di v[] in w[].
 * Controllo delle Coppie adiacenti:
 *
 * Verifica se due numeri adiacenti (il precedente e il successivo) o l'elemento
 * stesso sono uguali in w[].
 *
 * Se l'elemento considerato è uguale a quello in esame nell'array w[] allora viene
 * impostato a 0.
 *
 * [Questo controllo deve essere effettuato escludendo i casi dei primi e ultimi
 * elementi dell'array, in quanto non hanno un predecessore o un successore adiacente.]
 *
 * Stampa dell'Array Risultante: Stampare l'array w[], dove i valori delle coppie
 * adiacenti uguali sono stati azzerati.
 *
 */

public class AzzeraCoppie {

    public static void main(String args[]) {

        int[] v = {7, 3, 3, 4, 1, 8, 6, 6, 6, 5};
        int n = v.length;
        int[] w = new int[n]; // Questo serve per non modificare l'array originale

        for (int i = 0; i < n; i++)
            w[i] = v[i];

        if (v[0] == v[1])  // Caso speciale - primo elemento uguale al secondo
            w[0] = 0;


        for (int i = 1; i < n - 1; i++) { //Controlla gli elementi dal secondo al penultimo
            if (v[i] == v[i - 1] || v[i] == v[i + 1]) // Controllo sul precedente elemento e il successivo
                w[i] = 0;
        }

        if (v[n - 1] == v[n - 2])  // Caso speciale - ultimo elemento uguale al penultimo
            w[n - 1] = 0;

        System.out.print("[");
        for (int i = 0; i < w.length; i++){
            if(i < w.length - 1){
                System.out.print(" " + w[i] + ", ");
            } else System.out.print(" " + w[i] + " ]");
        }
    }
}
