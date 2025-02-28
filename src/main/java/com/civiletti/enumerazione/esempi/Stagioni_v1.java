package com.civiletti.enumerazione.esempi;

public class Stagioni_v1 {

    public static void main(String[] args) {
        String mese = "Marzo";
        String stagione;

        switch (mese) {
            case "Dicembre", "Gennaio", "Febbraio":
                stagione = "Inverno";
                break;
            case "Marzo", "Aprile", "Maggio":
                stagione = "Primavera";
                break;
            case "Giugno", "Luglio", "Agosto":
                stagione = "Estate";
                break;
            case "Settembre", "Ottobre", "Novembre":
                stagione = "Autunno";
                break;
            default:
                stagione = "Mese non valido";
        }

        System.out.println("Il mese di " + mese + " appartiene alla stagione: " + stagione);
    }
}

