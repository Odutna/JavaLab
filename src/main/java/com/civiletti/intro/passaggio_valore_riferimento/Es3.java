package com.civiletti.intro.passaggio_valore_riferimento;

class Container {
    int valore;
}

public class Es3 {
    public static void modifica(Container c) {
        c = new Container();
        c.valore = 99; // Modifica il contenuto dell'oggetto
    }

    public static void main(String[] args) {
        Container c = new Container();
        c.valore = 10;
        modifica(c);
        System.out.println(c.valore); // Stampa 99
    }
}

