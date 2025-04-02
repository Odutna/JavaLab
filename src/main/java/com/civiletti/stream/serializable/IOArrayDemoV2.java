package com.civiletti.stream.serializable;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *  L'ArrayList<Specie> permette l'inserimento di un numero illimitato di elementi.
 *
 */
public class IOArrayDemoV2 {

    public static void main(String[] args) {
        ArrayList<Specie> listaSpecie = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Input interattivo
        boolean continua = true;
        while(continua) {
            System.out.println("\nInserisci i dati della specie:");

            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            System.out.print("Popolazione: ");
            int popolazione = Integer.parseInt(scanner.nextLine());

            System.out.print("Tasso di crescita: ");
            double tasso = Double.parseDouble(scanner.nextLine());

            listaSpecie.add(new Specie(nome, popolazione, tasso));

            System.out.print("\nVuoi inserire un'altra specie? (s/n) ");
            String risposta = scanner.nextLine();
            continua = risposta.equalsIgnoreCase("s");
        }

        String nomeFile = "specie.dat";

        // Scrittura su file
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nomeFile))) {
            outputStream.writeObject(listaSpecie);
            System.out.println("\nDati salvati correttamente nel file " + nomeFile);
        } catch (IOException e) {
            System.out.println("Errore di scrittura: " + e.getMessage());
            System.exit(1);
        }

        // Lettura da file
        ArrayList<Specie> specieCaricate = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nomeFile))) {
            @SuppressWarnings("unchecked")
            ArrayList<Specie> temp = (ArrayList<Specie>) inputStream.readObject();
            specieCaricate = temp;
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Errore di lettura: " + e.getMessage());
            System.exit(1);
        }

        // Stampa risultati
        System.out.println("\nSpecie caricate dal file:");
        for(Specie s : specieCaricate) {
            System.out.println(s);
            System.out.println("----------------------");
        }
    }
}
