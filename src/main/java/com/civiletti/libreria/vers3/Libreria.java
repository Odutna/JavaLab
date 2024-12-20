package com.civiletti.libreria.vers3;

public class Libreria {
    private static final int MAX_MENSOLE = 10; // Numero massimo di mensole
    private Mensola[] mensole;
    private int numeroMensole;

    /**
     * Costruttore che crea una nuova lib vuota.
     */
    public Libreria() {
        mensole = new Mensola[MAX_MENSOLE];
        numeroMensole = 0;
    }

    /**
     * Aggiunge una nuova mensola alla lib.
     *
     * @return l'indice della nuova mensola, o -1 se la lib è piena
     */
    public int aggiungiMensola() {
        if (numeroMensole < MAX_MENSOLE) {
            mensole[numeroMensole] = new Mensola();
            return numeroMensole++;
        }
        return -1;
    }

    /**
     * Trova un libro per titolo in tutte le mensole.
     *
     * @param titolo il titolo del libro da cercare
     * @return un oggetto Posizione che contiene l'indice della mensola e la posizione del libro,
     *         o null se il libro non è stato trovato
     */
    public Posizione cercaLibroPerTitolo(String titolo) {
        for (int indiceMensola = 0; indiceMensola < numeroMensole; indiceMensola++) {
            int posizioneSuMensola = mensole[indiceMensola].cercaLibroPerTitolo(titolo);
            if (posizioneSuMensola != -1) {
                return new Posizione(indiceMensola, posizioneSuMensola);
            }
        }
        return null;
    }

    /**
     * Trova tutti i libri di un determinato autore in tutte le mensole.
     *
     * @param autore il nome dell'autore da cercare
     * @return un array di oggetti LibroInPosizione contenenti i libri trovati
     */
    public LibroInPosizione[] cercaLibriPerAutore(String autore) {
        // Prima passata per contare i libri
        int contaLibri = 0;
        for (int i = 0; i < numeroMensole; i++) {
            contaLibri += mensole[i].cercaLibriPerAutore(autore).length;
        }

        // Seconda passata per creare l'array dei libri
        LibroInPosizione[] libriTrovati = new LibroInPosizione[contaLibri];
        int indice = 0;

        for (int indiceMensola = 0; indiceMensola < numeroMensole; indiceMensola++) {
            Libro[] libriAutore = mensole[indiceMensola].cercaLibriPerAutore(autore);
            for (Libro libro : libriAutore) {
                int posizioneSuMensola = mensole[indiceMensola].cercaLibroPerTitolo(libro.getTitolo());
                libriTrovati[indice++] = new LibroInPosizione(libro, indiceMensola, posizioneSuMensola);
            }
        }

        return libriTrovati;
    }

    /**
     * Inserisce un libro in una mensola specifica.
     *
     * @param libro il libro da inserire
     * @param indiceMensola l'indice della mensola
     * @return la posizione in cui il libro è stato inserito, o -1 se l'inserimento non è riuscito
     */
    public int inserisciLibro(Libro libro, int indiceMensola) {
        if (indiceMensola < 0 || indiceMensola >= numeroMensole) {
            return -1;
        }

        // Cerca la prima posizione libera nella mensola specificata
        for (int posizione = 0; posizione < mensole[indiceMensola].getNumMaxVolumi(); posizione++) {
            int risultato = mensole[indiceMensola].setVolume(libro, posizione);
            if (risultato != -1 && risultato != -2) {
                return posizione;
            }
        }

        return -1;
    }

    /**
     * Ottiene il numero di mensole nella lib.
     *
     * @return il numero di mensole
     */
    public int getNumeroMensole() {
        return numeroMensole;
    }

    /**
     * Classe interna per rappresentare la posizione di un libro.
     */
    public static class Posizione {
        public final int indiceMensola;
        public final int posizioneSuMensola;

        public Posizione(int indiceMensola, int posizioneSuMensola) {
            this.indiceMensola = indiceMensola;
            this.posizioneSuMensola = posizioneSuMensola;
        }
    }

    /**
     * Classe interna per rappresentare un libro con la sua posizione.
     */
    public static class LibroInPosizione {
        public final Libro libro;
        public final int indiceMensola;
        public final int posizioneSuMensola;

        public LibroInPosizione(Libro libro, int indiceMensola, int posizioneSuMensola) {
            this.libro = libro;
            this.indiceMensola = indiceMensola;
            this.posizioneSuMensola = posizioneSuMensola;
        }
    }
}