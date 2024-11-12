package com.civiletti;

/**
 * Programma che chiede all'utente di inserire una stringa e conta quante consonanti
 * contiene.
 *
 */

import java.util.Scanner;

public class ContaConsonanti {

    // Funzione per verificare se un carattere è una consonante
    public static boolean isConsonant(char c) {

        c = Character.toLowerCase(c); // Converti il carattere in minuscolo

        return (c >= 'a' && c <= 'z' && c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u');

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input della stringa
        System.out.print("Inserisci una stringa: ");
        String str = scanner.nextLine();

        int consonantCount = 0;

        // Conta le consonanti
        for (int i = 0; i < str.length(); i++) {

            char currentChar = str.charAt(i);

            if (isConsonant(currentChar)) {
                consonantCount++;
            }
        }

        // Output del risultato
        System.out.println("Il numero di consonanti nella stringa è: " + consonantCount);

        scanner.close();
    }
}