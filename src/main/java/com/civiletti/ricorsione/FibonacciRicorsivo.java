package com.civiletti.ricorsione;

import java.util.Scanner;

/**
 * Programma per il calcolo della serie di Fibonacci utilizzando la ricorsione.
 *
 * La **serie di Fibonacci** è una sequenza matematica in cui ogni numero
 * è la somma dei due numeri precedenti, a partire dai valori iniziali 0 e 1.
 *
 * Serie: 0, 1, 1, 2, 3, 5, 8, 13, 21, ...
 * - F(0) = 0 (caso base)
 * - F(1) = 1 (caso base)
 * - F(n) = F(n-1) + F(n-2) (passo ricorsivo)
 *
 * Applicazioni:
 * - Algoritmi di ricerca (es. ricerca Fibonacci).
 * - Modelli naturali (ad es. crescita di popolazioni o strutture frattali).
 * - Problemi di ottimizzazione (es. programmazione dinamica).
 *
 * Questo programma utilizza la ricorsione per calcolare il valore
 * di Fibonacci per un dato numero 'n'.
 *
 */

public class FibonacciRicorsivo {

    /**
     * Metodo per calcolare il valore di Fibonacci di un numero 'n' utilizzando la ricorsione.
     *
     * Casi base:
     * - Se 'n <= 1', restituisce direttamente il valore di 'n' (F(0) = 0, F(1) = 1).
     * Passo ricorsivo:
     * - Altrimenti, restituisce la somma dei due numeri precedenti: F(n-1) + F(n-2).
     *
     * Complessità:
     * - La complessità è **esponenziale** O(2^n) a causa della ripetizione dei calcoli
     *   per gli stessi valori. Una versione ottimizzata può utilizzare la **memoization**.
     *
     * @param n Il numero per cui calcolare il valore di Fibonacci.
     * @return Il valore corrispondente della serie di Fibonacci.
     */
    public int fibonacci(int n) {

        if (n <= 1) return n; // Casi base

        return fibonacci(n-1) + fibonacci(n-2); // Passo ricorsivo
    }

    public static void main(String[] args) {
        FibonacciRicorsivo fibonacci = new FibonacciRicorsivo();
        do {
            System.out.println("Inserire un numero: ");
            System.out.println(fibonacci.fibonacci(new Scanner(System.in).nextInt()));
            System.out.println("Continuare? (s/n)");
        } while (new Scanner(System.in).nextLine().charAt(0) != 'n');
    }
}
