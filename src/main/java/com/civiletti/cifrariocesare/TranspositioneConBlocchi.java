package com.civiletti.cifrariocesare;

import java.io.*;
import java.util.Scanner;

public class TranspositioneConBlocchi {
    String originale = "";
    public String inserisciStringa(Scanner sc){
        System.out.println("Inserisci la stringa:");

        return sc.nextLine();
    }

    // Metodo per cifrare un file
    public static void cifraFile(String inputFile, String outputFile, int[] shift) throws IOException {
        try (
                FileReader fr = new FileReader(inputFile);
                FileWriter fw = new FileWriter(outputFile)
        ) {
            char[] buffer = new char[1024]; // Blocchi di 1024 caratteri
            int charsRead;

            CodDecodChar cdc = new CodDecodChar();

            // Leggi il file a blocchi
            while ((charsRead = fr.read(buffer)) != -1) {
                // Crea un array della dimensione effettiva dei caratteri letti
                char[] blocco = new char[charsRead];
                System.arraycopy(buffer, 0, blocco, 0, charsRead);

                // Cifra il blocco
                char[] bloccoCifrato = cifratura(blocco, shift, cdc);

                // Scrive il blocco cifrato nel file di output
                fw.write(bloccoCifrato);
            }
        }
    }

    // Metodo per decifrare un file
    public static void decifraFile(String inputFile, String outputFile, int[] shift) throws IOException {
        try (
                FileReader fr = new FileReader(inputFile);
                FileWriter fw = new FileWriter(outputFile)
        ) {
            char[] buffer = new char[1024]; // Blocchi di 1024 caratteri
            int charsRead;

            CodDecodChar cdc = new CodDecodChar();

            // Leggi il file a blocchi
            while ((charsRead = fr.read(buffer)) != -1) {
                // Crea un array della dimensione effettiva dei caratteri letti
                char[] blocco = new char[charsRead];
                System.arraycopy(buffer, 0, blocco, 0, charsRead);

                // Decifra il blocco
                char[] bloccoDecifrato = decifratura(blocco, shift, cdc);

                // Scrivi il blocco decifrato nel file di output
                fw.write(bloccoDecifrato);
            }
        }
    }

    // Metodo per cifrare un blocco
    public static char[] cifratura(char[] blocco, int[] shift, CodDecodChar cdc) {
        char[] risultato = new char[blocco.length];
        for (int i = 0; i < blocco.length; i++) {
            int shiftIndex = i % shift.length; // Cicla lo shift
            risultato[i] = cdc.codificaCaratteri(blocco[i], shift[shiftIndex]);
        }
        return risultato;
    }

    // Metodo per decifrare un blocco
    public static char[] decifratura(char[] blocco, int[] shift, CodDecodChar cdc) {
        char[] risultato = new char[blocco.length];
        for (int i = 0; i < blocco.length; i++) {
            int shiftIndex = i % shift.length; // Cicla lo shift
            risultato[i] = cdc.decodificaCaratteri(blocco[i], shift[shiftIndex]);
        }
        return risultato;
    }

    public static void processaStringa(String input, int blockSize, int[] shift, boolean cifrare) {
        CodDecodChar cdc = new CodDecodChar();

        int length = input.length();
        StringBuilder risultato = new StringBuilder(); // Per salvare l'output completo

        // Processa ogni blocco
        for (int i = 0; i < length; i += blockSize) {
            int end = Math.min(i + blockSize, length);
            String blocco = input.substring(i, end);

            // Cifra o decifra il blocco
            char[] bloccoElaborato = cifrare
                    ? cifratura(blocco.toCharArray(), shift, cdc)
                    : decifratura(blocco.toCharArray(), shift, cdc);

            risultato.append(bloccoElaborato);
        }

        // Mostra l'output completo
        System.out.println("Risultato: " + risultato.toString());
    }

    public static void main(String[] args) {
        TranspositioneConBlocchi tcb = new TranspositioneConBlocchi();
        Scanner sc = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("=   Cifrario di Cesare con Blocchi      =");
        System.out.println("=========================================");
        // Gestione cifratura/decifratura di file
//        System.out.println("Inserisci il nome del file di input:");
//        String inputFile = sc.nextLine();
//
//        System.out.println("Inserisci il nome del file di output:");
//        String outputFile = sc.nextLine();

//        System.out.println("[0] Cifra [1] Decifra");

        char scelta;
        int[] traslazione = {2, 3, 4, 5, 6, 7, 2, 4, 6, 8, 9, 1, 2, 1, 2, 6, 12, 2, 7, 4, 3, 3, 1, 2, 2, 1};
        do {
            System.out.println("\t[0] Cifra [1] Decifra [n] Esci");
            scelta = sc.nextLine().charAt(0);
//        try {
            switch (scelta) {
                case '0':
//                    cifraFile(inputFile, outputFile, traslazione); // Cifratura di file
                    processaStringa(tcb.inserisciStringa(sc), 5, traslazione,true);
                    System.out.println("File cifrato con successo!");
                    break;
                case '1':
                    //decifraFile(inputFile, outputFile, traslazione); // Decifratura di file
                    processaStringa(tcb.inserisciStringa(sc), 5, traslazione, false);
                    System.out.println("File decifrato con successo!");
                    break;
                case 'n':
                    System.out.println("Bye, bye!");
                default:
                    System.out.println("Scelta non valida.");
                    break;
//            }
//        } catch (IOException e) {
//            System.err.println("Errore durante la lettura o scrittura del file: " + e.getMessage());
            }
        }while(scelta != 'n');

        sc.close();
    }
}

