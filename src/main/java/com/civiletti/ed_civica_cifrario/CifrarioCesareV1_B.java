package com.civiletti.ed_civica_cifrario;



import java.util.*;

public class CifrarioCesareV1_B {
    private static final int MIN_SHIFT = 6;
    private static final int MAX_SHIFT = 15;

    // Versione Base migliorata che gestisce tutti i caratteri
    public static String cifraBase(String testo, int shift) {
        StringBuilder risultato = new StringBuilder();
        for (char c : testo.toCharArray()) {
            // Convertiamo direttamente il carattere usando il codice ASCII
            int codiceAscii = (int) c;
            // Applichiamo lo shift ciclico per mantenere i caratteri nel range valido
            int codificaCifra = (codiceAscii + shift) % 65536; // 65536 è il numero totale di caratteri Unicode
            risultato.append((char) codificaCifra);
        }
        return risultato.toString();
    }

    public static String decifraBase(String testoCifrato, int shift) {
        StringBuilder risultato = new StringBuilder();
        for (char c : testoCifrato.toCharArray()) {
            int codiceAscii = (int) c;
            // Per decifrare, sottraiamo lo shift e gestiamo i valori negativi
            int decodificaCifra = codiceAscii - shift;
            if (decodificaCifra < 0) {
                decodificaCifra += 65536; // Aggiungiamo il range totale per gestire i valori negativi
            }
            risultato.append((char) decodificaCifra);
        }
        return risultato.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Test Cifrario di Cesare - Versione Base ===");
        System.out.println("Inserisci il testo da cifrare (può contenere caratteri speciali):");
        String testo = scanner.nextLine();

        // Generiamo un numero casuale per lo shift
        int shift = MIN_SHIFT + new Random().nextInt(MAX_SHIFT - MIN_SHIFT + 1);
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
