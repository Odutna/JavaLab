package com.civiletti.intro.valore_nullo;

public class EsempioNull {
    // Variabili di istanza - inizializzate automaticamente a null
    private String nome;        // null (automatico)
    private Integer numero;     // null (automatico)
    private int[] array;        // null (automatico)

    public void metodo() {
        // Variabili locali - DEVONO essere inizializzate esplicitamente
        String cognome = null;  // Inizializzazione esplicita

        // ERRORE: variabile locale non inizializzata
        // String citta;
        // System.out.println(citta);  // Errore di compilazione!

        // Controllo null prima dell'uso
        if (nome != null) {
            System.out.println(nome.toUpperCase());
        }

        // Inizializzazione condizionale
        String risultato = (nome != null) ? nome : "Sconosciuto";
        System.out.println(risultato);
    }

    public static void main(String[] args){
        EsempioNull en = new EsempioNull();

        en.metodo();
    }
}
