package com.civiletti.libreria.vers1;

//import com.civiletti.libreria.vers3.Libreria;
//import com.civiletti.libreria.vers3.Libro;

import com.civiletti.libreria.vers2.Libro;
import com.civiletti.libreria.vers2.Mensola;

public class TestLibreria {
    public static void main(String[] args) {
com.civiletti.libreria.vers2.Mensola mensola = new Mensola();

        // Creazione di alcuni libri
        Libro libro1 = new Libro("Un destino ridicolo", "De Andrè", 205);
        Libro libro2 = new Libro("Il lupo della steppa", "Hermann Hesse", 305);
        Libro libro3 = new Libro("Il richiamo della foresta", "Jack London", 225);

        // Inserimento dei libri nella mensola
        mensola.setVolume(libro1, 0);
        mensola.setVolume(libro2, 1);
        mensola.setVolume(libro3, 2);

        // Ricerca di libri
        int posizioneLibro = mensola.cercaLibroPerTitolo("Un destino ridicolo");
        System.out.println("Posizione del libro: " + posizioneLibro);

        // Ricerca libri per autore
        com.civiletti.libreria.vers2.Libro[] libriDeAndre = mensola.cercaLibriPerAutore("De Andrè");
        System.out.println("Libri di De Andrè:");
        for (com.civiletti.libreria.vers2.Libro libro : libriDeAndre) {
            System.out.println(libro.getTitolo());
        }

        // Ottenere tutti i libri
        com.civiletti.libreria.vers2.Libro[] tuttiLibri = mensola.getTuttiILibri();
        System.out.println("Tutti i libri nella mensola:");
        for (Libro libro : tuttiLibri) {
            System.out.println(libro.getTitolo() + " - " + libro.getAutore());
        }
    }
}
