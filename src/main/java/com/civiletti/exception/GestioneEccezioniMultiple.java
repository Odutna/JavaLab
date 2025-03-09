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

        // Primo blocco try per l'accesso all'array
        try {
            int[] array = new int[5];
            System.out.println(array[10]); // Potenziale ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Errore indice array: " + e.getMessage());
        }

        // Secondo blocco try per la divisione
        try {
            int risultato = 10 / 0; // Potenziale ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Errore divisione: " + e.getMessage());
        }

    }
}
