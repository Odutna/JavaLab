package com.civiletti.exception;

public class RilancioEccezione {

    public static void main(String[] args) {
        try {
            metodo1();
        } catch (ArithmeticException e) {
            System.out.println("Errore catturato nel main: " + e.getMessage());
        }
    }

    public static void metodo1() {
        try {
            int risultato = 10 / 0;
        } catch (ArithmeticException e) {
            System.out.println("Errore nel metodo1: " + e.getMessage());
            throw e;  // Rilancia l'eccezione
        }
    }
}
