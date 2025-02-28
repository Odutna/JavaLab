package com.civiletti.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ValidazioneInput {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero positivo: ");


        try {
            int numero = scanner.nextInt();
            validaNumero(numero);
            System.out.println("Numero valido: " + numero);

        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public static void validaNumero(int numero) {
        if (numero <= 0) {
            throw new IllegalArgumentException("Il numero deve essere positivo.");
        }
    }
}
