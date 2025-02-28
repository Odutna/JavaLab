package com.civiletti.enumerazione.hexcolor;

enum Colore {
    // Popola con altri colori
    NERO("#000000"),
    ROSSO("#FF0000"),
    VERDE("#00FF00"),
    BLU("#0000FF"),
    BIANCO("#FFFFFF");

    private final String codiceEsadecimale;

    Colore(String codice) {
        this.codiceEsadecimale = codice;
    }

    public String getCodiceEsadecimale() { return codiceEsadecimale; }

    /**
     * Se il codice non corrisponde a nessun colore, viene lanciata un'eccezione.
     * @param codice
     * @return  restituisce il colore corrispondente a un codice esadecimale.
     */
    public static Colore fromCodice(String codice) {
        for (Colore c : values()) {
            if (c.codiceEsadecimale.equalsIgnoreCase(codice)) {
                return c;
            }
        }
        throw new IllegalArgumentException("Codice colore non valido: " + codice);
    }
}


class EditorGrafico {
    private Colore coloreCorrente;

    public EditorGrafico() {
        this.coloreCorrente = Colore.NERO;
    }

    public void cambiaColore(String codiceEsadecimale) {
        try {
            this.coloreCorrente = Colore.fromCodice(codiceEsadecimale);
            System.out.println("Colore cambiato a: " + coloreCorrente);
        } catch (IllegalArgumentException e) {
            System.out.println("Colore non valido!");
        }
    }
}


class TestColor{

    public static void main(String[] args) {
        EditorGrafico editor = new EditorGrafico();
        editor.cambiaColore("#FF0000"); // Cambia a ROSSO
        editor.cambiaColore("#00FF00"); // Cambia a VERDE
        editor.cambiaColore("#XYZ123"); // Colore non valido


        // Stampare il codice esadecimale di ciascun colore
        for (Colore colore : Colore.values()) {
            System.out.println("Colore: " + colore + ", Codice esadecimale: " + colore.getCodiceEsadecimale());
        }

        // Ottenere e utilizzare il codice esadecimale
        Colore mioColore = Colore.VERDE;
        String codice = mioColore.getCodiceEsadecimale();
        System.out.println("Il codice esadecimale di " + mioColore + " è " + codice);

        // Confrontare i codici esadecimali
        if (codice.equals("#00FF00")) {
            System.out.println("Il colore è verde.");
        }
    }
}