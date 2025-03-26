package com.civiletti.stream;

import java.io.*;
import java.util.Scanner;

public class GestioneTransazioni {
    public static void main(String[] args) {
        String nomeFile = "Transazioni.css";
        File file = new File(nomeFile);
        boolean fileEsiste = file.exists();

        try (PrintWriter writer = new PrintWriter(new FileWriter(file, true));
             Scanner scanner = new Scanner(System.in)) {

            // Se il file non esiste o è vuoto, scriviamo l'intestazione
            if (!fileEsiste || file.length() == 0) {
                writer.println("Codice,Quantità,Prezzo,Descrizione");
            }
            boolean run = true;
            // Chiediamo all'utente di inserire i dati della transazione
            while (run) {
                System.out.println("Inserisci i dati della nuova transazione.");
                System.out.print("Codice: ");
                String codice = scanner.nextLine();

                System.out.print("Quantità: ");
                int quantita = Integer.parseInt(scanner.nextLine());

                System.out.print("Prezzo: ");
                double prezzo = Double.parseDouble(scanner.nextLine());
                System.out.println(prezzo);
                System.out.print("Descrizione: ");
                String descrizione = scanner.nextLine();

                // Scriviamo la nuova riga nel file
//            writer.printf("%s,%d,%.4f,%s%n", codice, quantita, prezzo, descrizione);

                writer.println(codice + "," + quantita + "," + prezzo + "," + descrizione);

                System.out.println("Transazione aggiunta con successo!");
                System.out.printf("\nContinuare (s/n)");
                if (scanner.nextLine().equals("n")) {
                    run = false;
                    break;
                }

            }
        } catch (IOException e) {
            System.out.println("Errore nella gestione del file: " + e.getMessage());
        }
    }
}

