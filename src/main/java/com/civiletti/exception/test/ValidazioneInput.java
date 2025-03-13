package com.civiletti.exception.test;

// Test 1

import java.util.InputMismatchException;
import java.util.Scanner;

class InputSbagliatoException extends Exception {
    public InputSbagliatoException(String messaggio) {
        super(messaggio);
    }
}

public class ValidazioneInput {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;

        try {
            System.out.print("Inserisci un numero positivo: ");
            numero = scanner.nextInt();
            verificaNumero(numero);
            System.out.println("Numero valido: " + numero);

        } catch (InputMismatchException e) { // valore non numerico
            System.out.println("Errore: Devi inserire un numero intero.");
        } catch (InputSbagliatoException e) { // Il numero è negativo o zero
            System.out.println("Errore: " + e.getMessage());
        } finally {
            scanner.close(); // Chiusura dello scanner per evitare memory leak
        }

    }

    public static void verificaNumero(int numero) throws InputSbagliatoException {
        if (numero <= 0) {
            throw new InputSbagliatoException("Il numero deve essere positivo.");
        }
    }
}
