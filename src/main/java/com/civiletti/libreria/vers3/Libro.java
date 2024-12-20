package com.civiletti.libreria.vers3;

/**
 * La classe Libro rappresenta un libro con le seguenti proprietà:
 * - titolo: il titolo del libro
 * - autore: l'autore del libro
 * - numeroPagine: il numero di pagine del libro
 * - costoPagina: il costo per pagina, impostato come variabile statica
 * - COSTO_FISSO: il costo fisso aggiuntivo per ogni libro
 *
 * La classe fornisce metodi per accedere e modificare le proprietà del libro,
 * nonché per calcolare il prezzo totale del libro in base al numero di pagine
 * e al costo fisso e variabile.
 */

public class Libro {
    private String titolo;
    private String autore;
    private int numeroPagine;
    private static double costoPagina = 0.05;
    private final double COSTO_FISSO = 5.5;

    private static final int MAX_NUM_VOLUMI = 100; // Numero massimo di libri nella mensola
    private Libro[] volumi = new Libro[MAX_NUM_VOLUMI]; // Array di libri nella lib
    private int indiceVolumi;

    /**
     * Costruttore di copia che crea una nuova istanza di Libro
     * copiando le proprietà da un oggetto Libro esistente.
     *
     * @param libro l'oggetto Libro da copiare
     */
    public Libro(Libro libro) {
        this.titolo = libro.getTitolo();
        this.autore = libro.getAutore();
        this.numeroPagine = libro.getNumeroPagine();
        this.volumi = new Libro[MAX_NUM_VOLUMI];
        this.indiceVolumi = 0;     // per tenere traccia dell'indice corrente

    }

    /**
     * Costruttore che crea una nuova istanza di Libro
     * impostando direttamente le proprietà.
     *
     * @param titolo        il titolo del libro
     * @param autore        l'autore del libro
     * @param numeroPagine  il numero di pagine del libro
     */
    public Libro(String titolo, String autore, int numeroPagine) {
        this.titolo = titolo;
        this.autore = autore;
        this.numeroPagine = numeroPagine;
    }

    /**
     * Restituisce il titolo del libro.
     *
     * @return il titolo del libro
     */
    public String getTitolo() {
        return titolo;
    }

    /**
     * Imposta il titolo del libro.
     *
     * @param titolo il nuovo titolo del libro
     */
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    /**
     * Restituisce l'autore del libro.
     *
     * @return l'autore del libro
     */
    public String getAutore() {
        return autore;
    }

    /**
     * Imposta l'autore del libro.
     *
     * @param autore il nuovo autore del libro
     */
    public void setAutore(String autore) {
        this.autore = autore;
    }

    /**
     * Restituisce il numero di pagine del libro.
     *
     * @return il numero di pagine del libro
     */
    public int getNumeroPagine() {
        return numeroPagine;
    }

    /**
     * Imposta il numero di pagine del libro.
     *
     * @param numeroPagine il nuovo numero di pagine del libro
     */
    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    /**
     * Calcola il prezzo totale del libro in base al costo fisso e al costo per pagina.
     *
     * @return il prezzo totale del libro
     */
    public double prezzo() {
        return COSTO_FISSO + numeroPagine * costoPagina;
    }

    /**
     * Imposta il costo per pagina, da utilizzare nel calcolo del prezzo.
     *
     * @param costo il nuovo costo per pagina
     */
    public static void setCostoPagina(double costo) {
        costoPagina = costo;
    }




    // Metodo per aggiungere un libro all'array
    public void aggiungiLibro(Libro libro) {
        if (indiceVolumi < MAX_NUM_VOLUMI) {
            volumi[indiceVolumi] = libro;
            indiceVolumi++;
        } else {
            System.out.println("La lib è piena. Impossibile aggiungere altri libri.");
        }
    }

    /**
     * Metodo per ottenere i titoli dei libri di un determinato autore.
     *
     * @param autore Il nome dell'autore.
     * @return Un array di stringhe contenente i titoli dei libri dell'autore.
     */
    public String[] getTitoliLibriAutore(String autore) {
        int libriAutore = 0;

        // Prima passata: conta i libri dell'autore
        for (int posizione = 0; posizione < indiceVolumi; posizione++) {
            if (volumi[posizione] != null &&
                    volumi[posizione].getAutore().equalsIgnoreCase(autore)) {
                libriAutore++;
            }
        }

        // Se non ci sono libri dell'autore, restituisce un array vuoto
        if (libriAutore == 0) {
            return new String[0];
        }

        // Seconda passata: crea l'elenco dei titoli
        String[] elencoLibri = new String[libriAutore];
        int indice = 0;

        for (int posizione = 0; posizione < indiceVolumi; posizione++) {
            if (volumi[posizione] != null &&
                    volumi[posizione].getAutore().equalsIgnoreCase(autore)) {
                elencoLibri[indice] = volumi[posizione].getTitolo();
                indice++;
            }
        }

        return elencoLibri;
    }


    public static void main(String[] args){
        Libro libro = new Libro("Un destino ridicolo", "De Andrè", 205);
        Libro libro2 = new Libro("Pinocchio", "Collodi", 150);

        System.out.println(libro.getTitolo() + ", " + libro.getAutore() + ", " + libro.getNumeroPagine() + ", " + libro.prezzo());
        System.out.println(libro2.getTitolo() + ", " + libro2.getAutore() + ", " + libro2.getNumeroPagine() + ", " + libro.prezzo());

        libro.setCostoPagina(0.1);

        System.out.println(libro.getTitolo() + ", " + libro.getAutore() + ", " + libro.getNumeroPagine() + ", " + libro.prezzo());
        System.out.println(libro2.getTitolo() + ", " + libro2.getAutore() + ", " + libro2.getNumeroPagine() + ", " + libro.prezzo());
    }
}
