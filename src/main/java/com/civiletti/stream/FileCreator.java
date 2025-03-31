package com.civiletti.stream;

import java.io.File;
import java.io.IOException;

public class FileCreator {

    public static void newFile() {
        // Determina il percorso in base al sistema operativo
        String path;
        System.out.println(System.getProperty("os.name"));
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            path = "C:\\html.txt"; // Percorso per Windows
        } else {
            path = "/tmp/html.txt"; // Percorso per Unix-based (Linux/macOS)
        }

        try {
            File file = new File(path);

            if (file.exists()) {
                System.out.println("Il file " + path + " esiste già.");
            } else if (file.createNewFile()) {
                System.out.println("Il file " + path + " è stato creato con successo.");
            } else {
                System.out.println("Il file " + path + " non può essere creato.");
            }
        } catch (IOException e) {
            System.err.println("Errore durante la creazione del file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        newFile();
    }
}

