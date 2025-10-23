package com.civiletti.intro.visibilita.static_keyword;

public class CStatic2 {
    static int contatore = 0;  // condiviso tra tutte le istanze
    int id;                    // specifico per ogni oggetto

    public CStatic2() {
        contatore++;
        id = contatore;
    }

    public void visualizza() {
        System.out.println("ID oggetto: " + id + " | contatore totale: " + contatore);
    }
}

class TestCStatic2 {
    public static void main(String[] args) {
        CStatic2 a = new CStatic2();
        CStatic2 b = new CStatic2();
        CStatic2 c = new CStatic2();

        a.visualizza();
        b.visualizza();
        c.visualizza();
    }
}

