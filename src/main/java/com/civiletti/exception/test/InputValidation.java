package com.civiletti.exception.test;

// Test 2

import java.util.InputMismatchException;
import java.util.Scanner;

// Eccezione personalizzata per gestire numeri non validi
class InputSbagliatoEx extends Exception {
    public InputSbagliatoEx(String messaggio) {
        super(messaggio);
    }
}

public class InputValidation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = 0;
        boolean inputValido = false;

        while (!inputValido) { // Ciclo finchè non inserisco un numero valido
            try {
                System.out.print("Inserisci un numero positivo: ");

                // Controllo prima se è un intero, diversamente lancio l'exception
                if (!scanner.hasNextInt()) {
                    scanner.nextLine(); // consumo l'input generato da scanner.hasNextInt()
                    throw new InputSbagliatoEx("Valore non valido. Inserisci un numero intero.");
                }
                
                numero = scanner.nextInt();
//                scanner.nextLine(); // Consumo l'input

                // Valido il numero
                verificaNumero(numero);
                inputValido = true; // Se è valido, esco dal ciclo
                System.out.println("Numero valido: " + numero);

            } catch (InputMismatchException e) {
                System.out.println("Errore: Devi inserire un numero intero.");
                scanner.nextLine(); // consumo l'iput
            } catch (InputSbagliatoEx e) { // Catturo la mia exception
                System.out.println("Erroresss: " + e.getMessage());
//                e.printStackTrace();
            }
        }
        scanner.close();
    }

    // Metodo che lancia l'eccezione personalizzata se il numero è <= 0
    public static void verificaNumero(int numero) throws InputSbagliatoEx {
        if (numero <= 0) {
            throw new InputSbagliatoEx("Il numero deve essere positivo.");
        }
    }
}

