package com.civiletti.libreria;

import com.civiletti.libreria.vers2.Libro;

public class TestLibreria {
    public static void main(String[] args) {
        // Creazione di un'istanza della classe Libro2 per gestire la lib
        Libro libreria = new Libro("Libreria Principale", "Biblioteca", 0);

        // Creazione di alcuni libri
        Libro libro1 = new Libro("Un destino ridicolo", "De Andrè", 205);
        Libro libro2 = new Libro("Il lupo della steppa", "Hermann Hesse", 305);
        Libro libro3 = new Libro("Il richiamo della foresta", "Jack London", 225);

        // Aggiunta dei libri alla lib
        libreria.aggiungiLibro(libro1);
        libreria.aggiungiLibro(libro2);
        libreria.aggiungiLibro(libro3);

        // Test del metodo getTitoliLibriAutore
        String[] titoli = libreria.getTitoliLibriAutore("De Andrè");

        // Stampa dei risultati
        System.out.println("Titoli dei libri di De Andrè:");
        for (String titolo : titoli) {
            System.out.println(titolo);
        }
    }
}