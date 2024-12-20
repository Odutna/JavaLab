package com.civiletti.libreria.vers1;

/**
 *
 * La classe Mensola rappresenta una mensola per libri con un numero massimo di volumi pari a 15.
 * Fornisce metodi per inserire, ottenere e rimuovere libri dalla mensola.
 *
 * Classe Mensola:
 *
 * • Ci sono due costruttori:
 *
 *      uno che crea una nuova mensola vuota, e uno che crea una copia di una mensola esistente.
 *
 * • Il metodo setVolume() permette di inserire un libro in una determinata posizione sulla mensola,
 *   se la posizione è libera.
 *
 * • Il metodo getVolume() permette di ottenere una copia del libro in una determinata posizione sulla
 *   mensola.
 *
 * • Il metodo rimuoviVolume() permette di rimuovere un libro da una determinata posizione sulla mensola.
 *
 * • I metodi getNumMaxVolumi() e getNumVolumi() permettono di ottenere, rispettivamente, il numero massimo
 *   di volumi sulla mensola e il numero di volumi attualmente presenti.
 *
 */


public class Mensola {
    // Attributi
    private static final int MAX_NUM_VOLUMI = 15;
    private Libro[] volumi;

    /**
     * Costruttore che crea una nuova mensola vuota.
     */
    public Mensola() {
        volumi = new Libro[MAX_NUM_VOLUMI];
    }

    /**
     * Costruttore di copia che crea una nuova mensola
     * copiando i libri da un'altra mensola esistente.
     *
     * @param mensola la mensola da cui copiare i libri
     */
    public Mensola(Mensola mensola) {
        volumi = new Libro[MAX_NUM_VOLUMI];
        for (int i = 0; i < MAX_NUM_VOLUMI; i++) {
            if (mensola.getVolume(i) != null) {
                volumi[i] = new Libro(mensola.getVolume(i));
            }
        }
    }

    /**
     * Inserisce un libro in una determinata posizione sulla mensola.
     * Se la posizione è valida e libera, il libro viene inserito.
     *
     * @param libro     il libro da inserire
     * @param posizione la posizione in cui inserire il libro
     * @return la posizione in cui il libro è stato inserito, o -1 se la posizione non è valida, o -2 se la posizione è già occupata
     */
    public int setVolume(Libro libro, int posizione) {
        if (posizione < 0 || posizione >= MAX_NUM_VOLUMI) {
            return -1; // Posizione non valida
        }
        if (volumi[posizione] != null) {
            return -2; // Posizione già occupata
        }
        volumi[posizione] = new Libro(libro);
        return posizione;
    }

    /**
     * Restituisce una copia del libro nella posizione specificata sulla mensola.
     * Se la posizione non è valida o è vuota, restituisce null.
     *
     * @param posizione la posizione del libro da ottenere
     * @return una copia del libro nella posizione specificata, o null se la posizione non è valida o è vuota
     */
    public Libro getVolume(int posizione) {
        if (posizione < 0 || posizione >= MAX_NUM_VOLUMI) {
            return null; // Posizione non valida
        }
        if (volumi[posizione] == null) {
            return null; // Posizione vuota
        }
        return new Libro(volumi[posizione]);
    }

    /**
     * Rimuove il libro dalla posizione specificata sulla mensola.
     * Se la posizione non è valida o è vuota, restituisce un valore di errore.
     *
     * @param posizione la posizione del libro da rimuovere
     * @return la posizione da cui il libro è stato rimosso, o -1 se la posizione non è valida, o -2 se la posizione è vuota
     */
    public int rimuoviVolume(int posizione) {
        if (posizione < 0 || posizione >= MAX_NUM_VOLUMI) {
            return -1; // Posizione non valida
        }
        if (volumi[posizione] == null) {
            return -2; // Posizione vuota
        }
        volumi[posizione] = null;
        return posizione;
    }

    /**
     * Restituisce il numero massimo di volumi che la mensola può contenere.
     *
     * @return il numero massimo di volumi
     */
    public int getNumMaxVolumi() {
        return MAX_NUM_VOLUMI;
    }

    /**
     * Restituisce il numero di volumi attualmente presenti sulla mensola.
     *
     * @return il numero di volumi presenti sulla mensola
     */
    public int getNumVolumi() {
        int count = 0;
        for (Libro volume : volumi) {
            if (volume != null) {
                count++;
            }
        }
        return count;
    }
}