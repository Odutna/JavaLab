package com.civiletti.intro.visibilita.static_keyword;

public class CStatic5 {

    static int valoreStatico;
    int valoreIstanza;

    // Blocco statico: eseguito una sola volta al caricamento della classe
    static {
        valoreStatico = 100;
        System.out.println("Blocco statico eseguito!");
    }

    // Costruttore: eseguito a ogni nuova istanza
    public CStatic5() {
        valoreIstanza = 10;
        System.out.println("Costruttore eseguito!");
    }
}

class TestCStatic5 {

    public static void main(String[] args) {

        System.out.println("Main avviato");
        CStatic5 a = new CStatic5();
        CStatic5 b = new CStatic5();
    }
}