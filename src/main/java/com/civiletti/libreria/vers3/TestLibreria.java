package com.civiletti.libreria.vers3;

public class TestLibreria {
    public static void main(String[] args) {
        Libreria libreria = new Libreria();

        // Aggiungi alcune mensole
        int mensola1 = libreria.aggiungiMensola();
        int mensola2 = libreria.aggiungiMensola();

        // Crea alcuni libri
        Libro libro1 = new Libro("Un destino ridicolo", "De Andrè", 205);
        Libro libro2 = new Libro("Il lupo della steppa", "Hermann Hesse", 305);
        Libro libro3 = new Libro("Il richiamo della foresta", "Jack London", 225);

        // Inserisci libri nelle mensole
        libreria.inserisciLibro(libro1, mensola1);
        libreria.inserisciLibro(libro2, mensola1);
        libreria.inserisciLibro(libro3, mensola2);

        // Cerca un libro per titolo
        Libreria.Posizione posizione = libreria.cercaLibroPerTitolo("Il lupo della steppa");
        if (posizione != null) {
            System.out.println("Libro trovato nella mensola " + posizione.indiceMensola +
                    " alla posizione " + posizione.posizioneSuMensola);
        }

        // Cerca libri per autore
        Libreria.LibroInPosizione[] libriDeAndre = libreria.cercaLibriPerAutore("De Andrè");
        System.out.println("Libri di De Andrè:");
        for (Libreria.LibroInPosizione libroPos : libriDeAndre) {
            System.out.println(libroPos.libro.getTitolo() + " - Mensola: " +
                    libroPos.indiceMensola + ", Posizione: " + libroPos.posizioneSuMensola);
        }
    }
}
