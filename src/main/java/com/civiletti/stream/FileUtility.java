package com.civiletti.stream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Utility class for file operations that work consistently across different operating systems.
 */
public class FileUtility {

    /**
     * Writes a string to a file in the user's home directory.
     * Works on both Windows and Unix-based systems (Linux, macOS).
     */
    public static void writeFile(String fileName, String content) {
        // Get user's home directory
        String userHome = System.getProperty("user.home");
        String path = userHome + File.separator + fileName;

        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.flush();
            bw.close();

            System.out.println("File creato con successo in: " + path);
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * Overloaded method that corresponds to the original writeFile2 method.
     * Writes a fixed message to html.txt in user's home directory.
     */
    public static void writeFile2() {
        writeFile("html.txt", "Questo è il nostro primo file");
    }

    /**
     * Example of usage with custom directory.
     * @param directory Directory where to save the file
     * @param fileName Name of the file to create
     * @param content Content to write in the file
     */
    public static void writeFileToDirectory(String directory, String fileName, String content) {
        String path = directory + File.separator + fileName;

        try {
            // Create directories if they don't exist
            File dir = new File(directory);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.flush();
            bw.close();

            System.out.println("File creato con successo in: " + path);
        } catch (IOException e) {
            System.err.println("Errore durante la scrittura del file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Example main method to demonstrate usage
    public static void main(String[] args) {
        // Using the original method
        writeFile2();

        // Using the more flexible method
        writeFile("example.txt", "Questo è un esempio di contenuto personalizzato");

        // Using the method with custom directory
        String projectDir = System.getProperty("user.dir");
        String dataDir = projectDir + File.separator + "data";
        writeFileToDirectory(dataDir, "data.txt", "Questi sono dati importanti");
    }
}

