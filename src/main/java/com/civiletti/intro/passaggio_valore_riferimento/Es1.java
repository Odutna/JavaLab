package com.civiletti.intro.passaggio_valore_riferimento;

class Main {
    public static int modifica(int numero, StringBuilder sb) {
        numero = 42;
        sb.append(" Aggiunto");
        return numero;
    }

    public static void main(String[] args) {
        int numero = 10;
        StringBuilder testo = new StringBuilder("Originale");
        modifica(numero, testo);
        System.out.println(numero);     // ?
        System.out.println(testo); // ?
    }
}
