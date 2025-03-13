package com.civiletti.stream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {

    public static void writeFile() {
        // Determina il percorso in base al sistema operativo
        String path;
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            path = "C:'\'Prova'\'prova.txt"; // Percorso per Windows
        } else {
            path = "/tmp/prova.txt"; // Percorso per Unix-based (Linux/macOS)
        }

        try {
            File file = new File(path);

            // Assicura che la directory esista
            File parentDir = file.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                if (parentDir.mkdirs()) {
                    System.out.println("Cartella creata: " + parentDir.getAbsolutePath());
                } else {
                    System.err.println("Errore nella creazione della cartella.");
                    return;
                }
            }

            // Scrive nel file
            try (FileWriter fw = new FileWriter(file)) {
                fw.write("Questo è il nostro primo file");
                System.out.println("Scrittura completata in: " + path);
            }
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        writeFile();
    }
}


