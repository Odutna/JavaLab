package com.civiletti.stream;

import java.io.*;

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
     *
     * @param directory Directory where to save the file
     * @param fileName  Name of the file to create
     * @param content   Content to write in the file
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

    /**
     * Reads a file and prints its content.
     * Works on both Windows and Unix-based systems (Linux, macOS).
     */
    public static void readFile() {
        // Use user home directory and File.separator for cross-platform compatibility
        String userHome = System.getProperty("user.home");
        String fileName = "prova4.txt";
        String path = userHome + File.separator + fileName;

        char[] in = new char[50];
        int size = 0;

        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            size = fr.read(in);

            System.out.println("File letto da: " + path);
            System.out.println("Caratteri presenti: " + size);
            System.out.println("Il contenuto del file è il seguente:");

            for (int i = 0; i < size; i++) {
                System.out.print(in[i]);
            }
            System.out.println(); // Add a newline after printing

            fr.close();
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    public static void readFile2() {
        // Use user home directory and File.separator for cross-platform compatibility
        String userHome = System.getProperty("user.home");
        String fileName = "prova4.txt";
        String path = userHome + File.separator + fileName;
        BufferedReader reader;
        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            reader = new BufferedReader(fr);

            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);
                line = reader.readLine();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * Advanced file reading method that allows specifying file location and returns content as a string.
     * Works on both Windows and Unix-based systems (Linux, macOS).
     */
    public static String readFileFromPath(String directory, String fileName) {
        String path = directory + File.separator + fileName;
        StringBuilder content = new StringBuilder();

        try {
            File file = new File(path);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }

            br.close();
            fr.close();

            System.out.println("File letto con successo da: " + path);
            return content.toString();
        } catch (IOException e) {
            System.err.println("Errore durante la lettura del file: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Creates a file with test content that can be used for testing the read methods.
     */
    public static void createTestFile() {
        String userHome = System.getProperty("user.home");
        String fileName = "prova4.txt";
        String path = userHome + File.separator + fileName;
        String content = "Questo è un file di test.\nSto testando la lettura di file.\nFunziona su tutti i sistemi operativi!";

        try {
            File file = new File(path);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(content);
            bw.flush();
            bw.close();

            System.out.println("File di test creato con successo in: " + path);
        } catch (IOException e) {
            System.err.println("Errore durante la creazione del file di test: " + e.getMessage());
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

        // Create a test file first
        createTestFile();

        // Read the file using the basic method
        readFile();


        // Read the file using the advanced method
        String userHome = System.getProperty("user.home");
        String content = readFileFromPath(userHome, "prova4.txt");

        if (content != null) {
            System.out.println("\nContenuto letto con il metodo avanzato:");
            System.out.println(content);
        }
    }
}

