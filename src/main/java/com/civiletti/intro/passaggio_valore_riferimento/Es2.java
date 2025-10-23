package com.civiletti.intro.passaggio_valore_riferimento;

class Contenitore {
    int valore;
}

public class Es2 {
    public static void modifica(Contenitore c) {
        c.valore = 99; // Modifica il contenuto dell'oggetto
    }

    public static void main(String[] args) {
        Contenitore obj = new Contenitore();
        obj.valore = 10;
        modifica(obj);
        System.out.println(obj.valore); // Stampa 99
    }
}

