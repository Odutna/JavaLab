package com.civiletti.enumerazione.esempi;

public class Stagioni_v3 {

    public static void main(String[] args) {
        String mese = "Paleolitico";
        String stagione = switch (mese) {
            case "Dicembre", "Gennaio", "Febbraio" -> {yield "Inverno";}
            case "Marzo", "Aprile", "Maggio" -> {yield "Primavera";}
            case "Giugno", "Luglio", "Agosto" -> {yield "Estate";}
            case "Settembre", "Ottobre", "Novembre" -> {yield "Autunno";}
            default ->{yield "Mese non valido";}
        };

        System.out.println("Il mese di " + mese + " appartiene alla stagione: " + stagione);
    }
}




