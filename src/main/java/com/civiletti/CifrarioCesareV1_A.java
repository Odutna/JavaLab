package com.civiletti;

import java.util.Random;
import java.util.Scanner;

public class CifrarioCesareV1_A {
    private static final int MIN_SHIFT = 6;
    private static final int MAX_SHIFT = 15;

    // Versione Base semplificata
    public static String cifraBase(String testo, int shift) {
        String risultato = "";
        // Usando length() e charAt() invece di toCharArray()
        for (int i = 0; i < testo.length(); i++) {
            char carattere = testo.charAt(i);
            // Convertiamo il carattere usando il codice ASCII
            int codiceAscii = (int) carattere;
            // Applichiamo lo shift – il modulo lo usiamo per la circolarità
            int codificaCifra = (codiceAscii + shift) % 65536; // 65536 (2^16) è il numero totale di caratteri Unicode possibili
            // Convertiamo il codice ASCII in carattere e lo aggiungiamo alla stringa
            risultato = risultato + (char)codificaCifra;
        }
        return risultato;
    }

    public static String decifraBase(String testoCifrato, int shift) {
        String risultato = "";
        for (int i = 0; i < testoCifrato.length(); i++) {
            char carattere = testoCifrato.charAt(i);
            int codiceAscii = (int) carattere;
            // Per decifrare sottraiamo lo shift
            int decodificaCifra = codiceAscii - shift;
            if (decodificaCifra < 0) {
                decodificaCifra += 65536; // 65536 (2^16) è il numero totale di caratteri Unicode possibili
            }
            risultato = risultato + (char)decodificaCifra;
        }
        return risultato;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Test Cifrario di Cesare - Versione Base ===");
        System.out.println("Inserisci il testo da cifrare:");
        String testo = scanner.nextLine();

        // Generiamo un numero casuale per lo shift
        Random random = new Random();
        // random.nextInt(n) genera un numero casuale da 0 fino a n-1
        int shift = MIN_SHIFT + random.nextInt(MAX_SHIFT - MIN_SHIFT + 1); // L'offset serve per evitare che lo shift sia 0
        System.out.println("Shift utilizzato: " + shift);

        // Cifriamo il testo
        String testoCifrato = cifraBase(testo, shift);
        System.out.println("Testo cifrato: " + testoCifrato);

        // Decifriamo il testo
        String testoDecifrato = decifraBase(testoCifrato, shift);
        System.out.println("Testo decifrato: " + testoDecifrato);

        scanner.close();
    }
}