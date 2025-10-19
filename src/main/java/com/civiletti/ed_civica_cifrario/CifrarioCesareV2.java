package com.civiletti.ed_civica_cifrario;


import java.io.*;
import java.util.*;

public class CifrarioCesareV2 {
    // Per rendere più difficile la comprensione si scegli un range per lo shift delle lettere
    private static final int MIN_SHIFT = 6;
    private static final int MAX_SHIFT = 15;
    private static final int ALPHABET_SIZE = 26;  // Numero di lettere nell'afabeto anglosassone

    // Versione Base
    public static String cifraBase(String testo, int shift) {
        StringBuilder risultato = new StringBuilder();
        for (char c : testo.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                risultato.append((char) (((c - base + shift) % 26) + base));
            } else {
                risultato.append(c);
            }
        }
        return risultato.toString();
    }

    public static String decifraBase(String testoCifrato, int shift) {
        return cifraBase(testoCifrato, 26 - shift);
    }

    // Versione Intermedia
    static class CifraIntermedia {
        private int[] shiftArray;

        public CifraIntermedia(int[] shifts) {
            if (shifts.length != ALPHABET_SIZE) {
                throw new IllegalArgumentException("Servono 26 valori di shift!");
            }
            this.shiftArray = shifts.clone();
        }

        public String cifra(String testo) {
            StringBuilder risultato = new StringBuilder();
            for (char c : testo.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int pos = c - base;
                    risultato.append((char) (((pos + shiftArray[pos]) % 26) + base));
                } else {
                    risultato.append(c);
                }
            }
            return risultato.toString();
        }

        public String decifra(String testoCifrato) {
            StringBuilder risultato = new StringBuilder();
            for (char c : testoCifrato.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int pos = c - base;
                    // Trova la posizione originale
                    for (int i = 0; i < ALPHABET_SIZE; i++) {
                        if ((i + shiftArray[i]) % 26 == pos) {
                            risultato.append((char) (i + base));
                            break;
                        }
                    }
                } else {
                    risultato.append(c);
                }
            }
            return risultato.toString();
        }
    }

    // Versione Migliorata
    static class CifraMigliorata {
        private int[] permutazione;
        private static final String FILENAME = "permutazione.dat";

        public CifraMigliorata() {
            this.permutazione = generaPermutazioneCasuale();
            salvaPermutazione();
        }

        public CifraMigliorata(boolean caricaDaFile) {
            if (caricaDaFile) {
                this.permutazione = caricaPermutazione();
            } else {
                this.permutazione = generaPermutazioneCasuale();
                salvaPermutazione();
            }
        }

        private int[] generaPermutazioneCasuale() {
            int[] perm = new int[ALPHABET_SIZE];
            List<Integer> numeri = new ArrayList<>();
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                numeri.add(i);
            }
            Random rand = new Random();
            for (int i = 0; i < ALPHABET_SIZE; i++) {
                int indice = rand.nextInt(numeri.size());
                perm[i] = numeri.remove(indice);
            }
            return perm;
        }

        private void salvaPermutazione() {
            try (ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream(FILENAME))) {
                oos.writeObject(permutazione);
            } catch (IOException e) {
                System.err.println("Errore nel salvare la permutazione: " + e.getMessage());
            }
        }

        private int[] caricaPermutazione() {
            try (ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream(FILENAME))) {
                return (int[]) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Errore nel caricare la permutazione: " + e.getMessage());
                return generaPermutazioneCasuale();
            }
        }

        public String cifra(String testo) {
            StringBuilder risultato = new StringBuilder();
            for (char c : testo.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int pos = c - base;
                    risultato.append((char) (permutazione[pos] + base));
                } else {
                    risultato.append(c);
                }
            }
            return risultato.toString();
        }

        public String decifra(String testoCifrato) {
            StringBuilder risultato = new StringBuilder();
            for (char c : testoCifrato.toCharArray()) {
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int pos = c - base;
                    // Trova la posizione originale nella permutazione
                    for (int i = 0; i < ALPHABET_SIZE; i++) {
                        if (permutazione[i] == pos) {
                            risultato.append((char) (i + base));
                            break;
                        }
                    }
                } else {
                    risultato.append(c);
                }
            }
            return risultato.toString();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Test Versione Base
        System.out.println("=== Test Versione Base ===");
        System.out.println("Inserisci il testo da cifrare:");
        String testo = scanner.nextLine();
        int shift = MIN_SHIFT + new Random().nextInt(MAX_SHIFT - MIN_SHIFT + 1);
        String testoCifrato = cifraBase(testo, shift);
        System.out.println("Testo cifrato: " + testoCifrato);
        System.out.println("Testo decifrato: " + decifraBase(testoCifrato, shift));

        // Test Versione Intermedia
        System.out.println("\n=== Test Versione Intermedia ===");
        int[] shifts = new int[ALPHABET_SIZE];
        System.out.println("Inserisci 26 valori di shift (uno per ogni lettera):");
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            shifts[i] = scanner.nextInt();
        }
        scanner.nextLine(); // Consuma il newline
        CifraIntermedia cifraInt = new CifraIntermedia(shifts);
        System.out.println("Inserisci il testo da cifrare:");
        testo = scanner.nextLine();
        testoCifrato = cifraInt.cifra(testo);
        System.out.println("Testo cifrato: " + testoCifrato);
        System.out.println("Testo decifrato: " + cifraInt.decifra(testoCifrato));

        // Test Versione Migliorata
        System.out.println("\n=== Test Versione Migliorata ===");
        CifraMigliorata cifraMig = new CifraMigliorata();
        System.out.println("Inserisci il testo da cifrare:");
        testo = scanner.nextLine();
        testoCifrato = cifraMig.cifra(testo);
        System.out.println("Testo cifrato: " + testoCifrato);
        System.out.println("Testo decifrato: " + cifraMig.decifra(testoCifrato));

        scanner.close();
    }
}