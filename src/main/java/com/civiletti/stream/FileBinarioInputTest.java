package com.civiletti.stream;

/**
 * Utilizzato dal programma Raddoppia.
 */

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileBinarioInputTest {

    public static void LeggiInteri(String nomeFile) throws IOException {

        ObjectInputStream inputStream = new ObjectInputStream(new
                FileInputStream(nomeFile));
        System.out.println("Lettura dei numeri non negativi nel file " + nomeFile);

        try {
            int unIntero;
            while (true) {
                unIntero = inputStream.readInt();
                if (unIntero < 0) break; // Esci dal ciclo se trovi un numero negativo
                System.out.println(unIntero);
            }
        } catch (EOFException e) { // Necessario per gestire il caso in cui il file contiene solo numeri non negativi.
            // Gestisce la fine del file normalmente
            System.out.println("Raggiunta la fine del file");
        } finally {
            System.out.println("Fine della lettura dal file.");
            inputStream.close();
        }
    }

    public static void main(String[] args) {

        String nomeFile = "numeri.dat";
        try {
            ObjectInputStream inputStream = new ObjectInputStream(new
                    FileInputStream(nomeFile));
            System.out.println("Lettura dei numeri non negativi nel file " + nomeFile);
            int unIntero = inputStream.readInt();
            while (unIntero >= 0) {
                System.out.println(unIntero);
                unIntero = inputStream.readInt();
            }
            System.out.println("Fine della lettura dal file.");
            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore nell'apertura del file " + nomeFile);
        } catch (EOFException e) {
            System.out.println("Errore nella lettura del file " + nomeFile);
            System.out.println("Raggiunta la fine del file. " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Errore nella lettura del file " + nomeFile);
        }
    }
}