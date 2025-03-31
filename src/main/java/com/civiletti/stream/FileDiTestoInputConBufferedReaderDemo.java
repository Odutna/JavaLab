package com.civiletti.stream;

import java.io.BufferedReader;        // classe BufferedReader per la lettura efficiente del file.
import java.io.FileReader;            // classe FileReader per leggere il file riga per riga.
import java.io.FileNotFoundException; // classe per gestire l'eccezione file non trovato.
import java.io.IOException;           // classe per gestire le eccezioni di input/output.

public class FileDiTestoInputConBufferedReaderDemo {

    public static void main(String[] args) {

        String nomeFile = "originale.txt"; // Nome del file da leggere
        BufferedReader inputStream = null; // Dichiaro l'oggetto BufferedReader per la lettura del file
        System.out.println("Il file " + nomeFile + "\ncontiene le righe seguenti:\n");

        try {
            inputStream = new BufferedReader(new FileReader(nomeFile)); // Apertura del file
        } catch (FileNotFoundException e) {
            System.out.println("Problema nell’apertura del file.");
        }

        try {
            String riga = inputStream.readLine(); // Leggo la prima riga del file

            while (riga != null) { // Ciclo per leggere tutte le righe finché non ci sono più dati
                System.out.println(riga);
                riga = inputStream.readLine(); // Leggo la riga successiva
            }
            inputStream.close(); // Chiusura dello stream di lettura

        } catch (IOException e) {
            System.out.println("Errore nella lettura da " + nomeFile);
        }
    }
}
