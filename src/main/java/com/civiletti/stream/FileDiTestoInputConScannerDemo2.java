package com.civiletti.stream;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class FileDiTestoInputConScannerDemo2 {

    public static void main(String[] args) {

        System.out.print("Inserire il nome di un file: ");
        Scanner tastiera = new Scanner(System.in);

        String nomeFile = tastiera.next();
        File file = new File(nomeFile);

        // Controllo se il file esiste, altrimenti lo creo
        if (!file.exists()) {
            try {
                if (file.createNewFile()) {
                    System.out.println("File creato: " + nomeFile);
                } else {
                    System.out.println("Impossibile creare il file.");
                }
            } catch (IOException e) { // Per esempio se non ho permessi di scrittura
                System.out.println("Errore nella creazione del file: " + e.getMessage());
                throw new RuntimeException(e);
//                System.exit(0);
            }
        }

        Scanner inputStream = null;

        System.out.println("Il file " + nomeFile + "\n" + "contiene le righe seguenti:\n");
        try {
            inputStream = new Scanner(new File(nomeFile)); // Leggo dal file specificato (non lo crea)
        } catch (FileNotFoundException e) {
            System.out.println("Errore nell'apertura del file " + nomeFile);
            System.exit(0);
        }
        while (inputStream.hasNextLine()) {
            String riga = inputStream.nextLine();
            System.out.println(riga);
        }
        inputStream.close();
    }
}
