package com.civiletti.exception;

public class GestioneEccezioniAnnidate {
    public static void main(String[] args) {
        try { //1
            try { //2
                int risultato = 10 / 0;
            } catch (ArithmeticException e) {
                System.out.println("Errore interno: Divisione per zero.");
                throw e;
            }//Fine 2
        } catch (ArithmeticException e) {
            System.out.println("Errore esterno: " + e.getMessage());
        }//Fine 1
    }
}

