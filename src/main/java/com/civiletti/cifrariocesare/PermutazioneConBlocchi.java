package com.civiletti.cifrariocesare;



public class PermutazioneConBlocchi {

    private static final int[] PERMUTAZIONE = {3, 1, 4, 0, 2}; // Permutazione predefinita
    private static final int BLOCCO_DIMENSIONE = 5;            // Lunghezza dei blocchi

    public static String cifraConBlocchi(String testo) {
        StringBuilder risultato = new StringBuilder();

        // Itera sui blocchi
        for (int i = 0; i < testo.length(); i += BLOCCO_DIMENSIONE) {
            // Estrai il blocco corrente
            String blocco = testo.substring(i, Math.min(i + BLOCCO_DIMENSIONE, testo.length()));

            // Aggiungi padding se il blocco è troppo corto
            while (blocco.length() < BLOCCO_DIMENSIONE) {
                blocco += 'X';
            }

            // Applica la permutazione al blocco
            risultato.append(permutazione(blocco.toCharArray(), PERMUTAZIONE));
        }

        return risultato.toString();
    }

    public static String decifraConBlocchi(String testo) {
        StringBuilder risultato = new StringBuilder();

        // Calcola la permutazione inversa
        int[] permutazioneInversa = new int[PERMUTAZIONE.length];
        for (int i = 0; i < PERMUTAZIONE.length; i++) {
            permutazioneInversa[PERMUTAZIONE[i]] = i;
        }

        // Itera sui blocchi
        for (int i = 0; i < testo.length(); i += BLOCCO_DIMENSIONE) {
            // Estrai il blocco corrente
            String blocco = testo.substring(i, Math.min(i + BLOCCO_DIMENSIONE, testo.length()));

            // Applica la permutazione inversa al blocco
            risultato.append(permutazione(blocco.toCharArray(), permutazioneInversa));
        }

        return risultato.toString();
    }

    // Metodo per applicare una permutazione
    private static char[] permutazione(char[] blocco, int[] permutazione) {
        char[] risultato = new char[blocco.length];
        for (int i = 0; i < blocco.length; i++) {
            risultato[permutazione[i]] = blocco[i];
        }
        return risultato;
    }

    public static void main(String[] args) {
        String testoOriginale = "Questo è un test Questo è un test Questo è un test Questo è un test Questo è un test Questo è un test Questo è un test Questo è un test Questo è un test\n";

        // Cifra il testo
        String cifrato = cifraConBlocchi(testoOriginale);
        System.out.println("Testo cifrato: " + cifrato);

        // Decifra il testo
        String decifrato = decifraConBlocchi(cifrato);
        System.out.println("Testo decifrato: " + decifrato);



    }
}

