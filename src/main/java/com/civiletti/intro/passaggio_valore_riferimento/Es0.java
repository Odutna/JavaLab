package com.civiletti.intro.passaggio_valore_riferimento;

public class Es0 {
    public static void incrementa(int numero) {
        numero++; // Modifica solo la copia locale
    }

    public static void main(String[] args) {
        int numero = 10;
        incrementa(numero);
        System.out.println(numero); // Stampa 10
    }
}
