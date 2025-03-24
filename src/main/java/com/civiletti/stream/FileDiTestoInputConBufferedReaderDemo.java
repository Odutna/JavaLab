package com.civiletti.stream;

import java.io.BufferedReader; // Importo la classe BufferedReader per la lettura efficiente del file.
import java.io.FileReader; // Importo la classe FileReader per leggere il file riga per riga.
import java.io.FileNotFoundException; // Importo la classe per gestire l'eccezione file non trovato.
import java.io.IOException; // Importo la classe per gestire le eccezioni di input/output.

public class FileDiTestoInputConBufferedReaderDemo {

    public static void main(String[] args) {

        String nomeFile = "originale.txt"; // Nome del file da leggere

        // Dichiarazione dell'oggetto BufferedReader per la lettura del file
        BufferedReader inputStream = null;

        System.out.println("Il file " + nomeFile + "\ncontiene le righe seguenti:\n");

        try { // Blocco try per l'apertura del file
            inputStream = new BufferedReader(new FileReader(nomeFile)); // Apertura del file
        } catch (FileNotFoundException e) { // Eccezione se il file non viene trovato
            System.out.println("Problema nell’apertura del file.");
        }

        try { // Blocco try per la lettura del file riga per riga
            String riga = inputStream.readLine(); // Legge la prima riga del file

            // Loop per leggere tutte le righe fino a che non ci sono più dati
            while (riga != null) {
                System.out.println(riga);
                riga = inputStream.readLine(); // Legge la riga successiva
            }
            inputStream.close(); // Chiusura dello stream di lettura

        } catch (IOException e) { // Gestione dell'errore in caso di problemi di lettura
            System.out.println("Errore nella lettura da " + nomeFile);
        }
    }
}
