package com.civiletti.exception;


public class Divisione {
    public static void main(String[] args) {
        try {
            int risultato = 10 / 0;
            System.out.println("Risultato: " + risultato);
        } catch (ArithmeticException e) {
            System.out.println("Errore: Divisione per zero non permessa.");
        }
    }
}
