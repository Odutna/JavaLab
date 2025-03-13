package com.civiletti.exception.esercitazione;

// Classe Utente
class Utente {
    private String nome;
    private String cognome;
    private int codice;

    public Utente(String nome, String cognome, int codice) {
        this.nome = nome;
        this.cognome = cognome;
        this.codice = codice;
    }

    public int getCodice() {
        return codice;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String toString() {
        return "Utente: " + nome + " " + cognome + " (Codice: " + codice + ")";
    }
}

// Classe Libro
class Libro {
    private String titolo;
    private String autore;
    private String isbn;
    private int copieDisponibili;

    public Libro(String titolo, String autore, String isbn, int copieDisponibili) {
        this.titolo = titolo;
        this.autore = autore;
        this.isbn = isbn;
        this.copieDisponibili = copieDisponibili;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getCopieDisponibili() {
        return copieDisponibili;
    }

    public void prestaLibro() throws LibroNonDisponibileException {
        if (copieDisponibili > 0) {
            copieDisponibili--;
        } else {
            throw new LibroNonDisponibileException("Libro non disponibile per il prestito.");
        }
    }

    public void restituisciLibro() {
        copieDisponibili++;
    }

    public void modificaLibro(String nuovoTitolo, String nuovoAutore) {
        this.titolo = nuovoTitolo;
        this.autore = nuovoAutore;
    }

    public String toString() {
        return "Libro: " + titolo + " di " + autore + " (ISBN: " + isbn + ") - Copie disponibili: " + copieDisponibili;
    }
}

// Classe Biblioteca
class Biblioteca {
    private Libro[] libri;
    private Utente[] utenti;
    private int numLibri;
    private int numUtenti;
    private final int MAX_LIBRI = 30;
    private final int MAX_UTENTI = 50;

    public Biblioteca() {
        libri = new Libro[MAX_LIBRI];
        utenti = new Utente[MAX_UTENTI];
        numLibri = 0;
        numUtenti = 0;
    }

    public void aggiungiLibro(Libro libro) throws BibliotecaPienaException {
        if (numLibri < MAX_LIBRI) {
            libri[numLibri++] = libro;
        } else {
            throw new BibliotecaPienaException("Capacità massima di libri raggiunta.");
        }
    }

    public void rimuoviLibro(String isbn) {
        for (int i = 0; i < numLibri; i++) {
            if (libri[i].getIsbn().equals(isbn)) {
                libri[i] = libri[numLibri - 1];
                numLibri--;
                break;
            }
        }
    }

    public void modificaLibro(String isbn, String nuovoTitolo, String nuovoAutore) {
        for (int i = 0; i < numLibri; i++) {
            if (libri[i].getIsbn().equals(isbn)) {
                libri[i].modificaLibro(nuovoTitolo, nuovoAutore);
                break;
            }
        }
    }

    public void visualizzaLibri() {
        for (int i = 0; i < numLibri; i++) {
            System.out.println(libri[i]);
        }
    }

    public void prestaLibro(String isbn) throws LibroNonDisponibileException {
        for (int i = 0; i < numLibri; i++) {
            if (libri[i].getIsbn().equals(isbn)) {
                libri[i].prestaLibro();
                break;
            }
        }
    }

    public void restituisciLibro(String isbn) {
        for (int i = 0; i < numLibri; i++) {
            if (libri[i].getIsbn().equals(isbn)) {
                libri[i].restituisciLibro();
                break;
            }
        }
    }

    public void registraUtente(Utente utente) {
        if (numUtenti < MAX_UTENTI) {
            utenti[numUtenti++] = utente;
        }
    }

    public void rimuoviUtente(int codiceUtente) {
        for (int i = 0; i < numUtenti; i++) {
            if (utenti[i].getCodice() == codiceUtente) {
                utenti[i] = utenti[numUtenti - 1];
                numUtenti--;
                break;
            }
        }
    }

    public void modificaUtente(int codiceUtente, String nuovoNome, String nuovoCognome) {
        for (int i = 0; i < numUtenti; i++) {
            if (utenti[i].getCodice() == codiceUtente) {
                utenti[i].setNome(nuovoNome);
                utenti[i].setCognome(nuovoCognome);
                break;
            }
        }
    }

    public void visualizzaUtenti() {
        for (int i = 0; i < numUtenti; i++) {
            System.out.println(utenti[i]);
        }
    }
}

// Eccezioni personalizzate
class LibroNonDisponibileException extends Exception {
    public LibroNonDisponibileException(String messaggio) {
        super(messaggio);
    }
}

class BibliotecaPienaException extends Exception {
    public BibliotecaPienaException(String messaggio) {
        super(messaggio);
    }
}

// Classe di test
public class TestBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        try {
            biblioteca.aggiungiLibro(new Libro("Il Nome della Rosa", "Umberto Eco", "1234567890", 5));
            biblioteca.aggiungiLibro(new Libro("1984", "George Orwell", "0987654321", 3));
            biblioteca.visualizzaLibri();

            biblioteca.prestaLibro("1234567890");
            biblioteca.visualizzaLibri();

            biblioteca.restituisciLibro("1234567890");
            biblioteca.visualizzaLibri();

            biblioteca.registraUtente(new Utente("Mario", "Rossi", 1));
            biblioteca.visualizzaUtenti();
        } catch (BibliotecaPienaException | LibroNonDisponibileException e) {
            System.out.println(e.getMessage());
        }
    }
}