package com.civiletti.intro.visibilita.static_keyword;

public class CStatic3 {
    static int totaleVendite = 0;

    public void registraVendita(int valore) {
        totaleVendite += valore;
    }

    public static void mostraTotale() {
        System.out.println("Totale vendite complessivo: " + totaleVendite);
    }
}

class TestCStatic3 {

    public static void main(String[] args) {

        CStatic3 negozio1 = new CStatic3();
        CStatic3 negozio2 = new CStatic3();

        negozio1.registraVendita(100);
        negozio2.registraVendita(200);

        CStatic3.mostraTotale();  // Qual'è l'output?
    }
}

