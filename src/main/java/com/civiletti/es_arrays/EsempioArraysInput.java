package com.civiletti.es_arrays;

import java.util.Scanner;
import java.util.Arrays;
import java.util.stream.Collectors;

/***
 * • Arrays.stream(userInfo)
 *
 *    Arrays.stream() crea uno stream dagli elementi dell'array userInfo.
 *    Se userInfo è un array di stringhe, otteniamo uno stream di stringhe.
 *
 *    Ti permette di evitare i cicli for e scrivere codice più leggibile.
 *    Puoi usare metodi come filter(), map(), collect() direttamente sugli
 *    elementi.
 *
 *    [Uno Stream in Java è una sequenza di dati su cui puoi applicare
 *    operazioni funzionali come filtrare, trasformare e raccogliere gli
 *    elementi.]
 *
 *    Non modifica i dati originali e viene spesso usato per lavorare con
 *    array, liste e collezioni in modo efficiente.
 *
 * • .collect(Collectors.joining("\n"))
 *
 *    collect() è un metodo degli Stream che raccoglie i dati in una struttura
 *    finale, come una Lista, Set o Stringa.
 *
 * •  Collectors.joining("\n") combina tutti gli elementi dello stream in
 *    un’unica stringa, separandoli con il carattere \n (a capo).
 *
 *    Collectors è una classe utility che fornisce metodi per raccogliere
 *    i dati di uno stream.
 *
 **/

public class EsempioArraysInput {

    public static void main(String[] args) {

        // Creare un array per raccogliere informazioni dall'utente

        String[] userInfo = new String[4];
        String[] prompts = {"Nome", "Cognome", "Età", "Città"};

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < userInfo.length; i++) {
            System.out.print("Inserisci il tuo " + prompts[i] + ": ");
            userInfo[i] = prompts[i] + ": " + scanner.nextLine();
        }

        // Costruire una stringa dalle informazioni utilizzando la classe Arrays
        String result = Arrays.stream(userInfo)
                .collect(Collectors.joining("\n"));

        System.out.println("\nRiepilogo dei tuoi dati:");
        System.out.println(result);

        // System.out.println(Arrays.toString(prompts));

        scanner.close();
    }
}


