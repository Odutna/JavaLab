package com.civiletti.exception;

public class CheckedUnchecked {

    public static void main(String[] args) {

        // Eccezione non verificata (unchecked)
        try {
            int risultato = 10 / 0;
            System.out.println("TEST");
        } catch (ArithmeticException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        // Eccezione verificata (checked)
        try {
            throw new Exception("Eccezione verificata (checked).");
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }

    }
}
