package com.civiletti.exception;

public class GestioneEccezioniMultiple {
    public static void main(String[] args) {
        try {
            int[] array = new int[5];
            System.out.println(array[10]);  // Genera ArrayIndexOutOfBoundsException
            int risultato = 10 / 0;  // Genera ArithmeticException
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Errore: " + e.getMessage());
        } //catch (ArithmeticException e) {
//            System.out.println("Errore: " + e.getMessage());
//        }
    }
}
