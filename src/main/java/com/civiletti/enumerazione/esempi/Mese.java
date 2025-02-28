package com.civiletti.enumerazione.esempi;

public enum Mese {
    GENNAIO(31), FEBBRAIO(28), MARZO(31), APRILE(30),
    MAGGIO(31), GIUGNO(30), LUGLIO(31), AGOSTO(31),
    SETTEMBRE(30), OTTOBRE(31), NOVEMBRE(30), DICEMBRE(31);;

    private final int giorni; // Variabile associata

    // Costruttore
    Mese(int giorni) {
        this.giorni = giorni;
    }

    // Metodo per ottenere il valore associato
    public int getGiorni() {
        return giorni;
    }
    // Metodo getter per il numero di giorni
    public int getGiorni(boolean bisestile) {
        // Ritorna 29 giorni per febbraio se è un anno bisestile
        if (this == FEBBRAIO && bisestile) {
            return 29;
        }
        return giorni;
    }

    // Metodo per determinare se un anno è bisestile
    public static boolean isBisestile(int anno) {
        return (anno % 400 == 0 || (anno % 4 == 0 && anno % 100 != 0));
    }
}

//class TestEnum {
//    public static void main(String[] args) {
//        for (Mese mese : Mese.values()) {
//            System.out.println(mese + " ha " + mese.getGiorni() + " giorni.");
//        }
//    }
//}

class TestEnumMetodi {

    public static void main(String[] args) {
        // Stampa tutte le costanti usando values()
        System.out.println("Elenco dei giorni:");
        for (Mese mese : Mese.values()) {
            System.out.println("- " + mese);
        }

        // Converte una stringa in un valore enum
        String input = "MAGGIO";  // prova con MERCOLEDI
        Mese giornoSpecifico = Mese.valueOf(input);
        System.out.println("\nIl giorno specifico è: " + giornoSpecifico);

        // Ottieni la posizione (ordinal) e il nome (name) del giorno
        System.out.println("Ordinal di " + giornoSpecifico + ": " + giornoSpecifico.ordinal());
        System.out.println("Nome di " + giornoSpecifico + ": " + giornoSpecifico.name());
    }
}

