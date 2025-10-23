package com.civiletti.intro.visibilita.static_keyword;

public class CStatic1 {

    public static void metodoStatico() {
        System.out.println("Sono un metodo statico!");
        // metodoIstanza(); // Errore: non posso chiamare metodi di istanza da un contesto statico
    }

    public void metodoIstanza() {
        System.out.println("Sono un metodo di istanza!");
        metodoStatico(); // Posso chiamare metodi statici dentro metodi non statici
    }
}

class TestCStatic1 {

    public static void main(String[] args) {
        CStatic1.metodoStatico();   // Invocazione diretta senza oggetto in un altra classe

        CStatic1 cs = new CStatic1();
        cs.metodoIstanza();        // Serve un’istanza per metodi non statici
    }
}

