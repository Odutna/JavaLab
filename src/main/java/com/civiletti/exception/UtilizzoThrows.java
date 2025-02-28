package com.civiletti.exception;

public class UtilizzoThrows {
    public static void main(String[] args) {
        try {
            metodoCheLanciaEccezione();
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public static void metodoCheLanciaEccezione() throws Exception {
        throw new Exception("Eccezione lanciata dal metodo.");
    }
}
