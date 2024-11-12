package com.civiletti;

/**
 * Es.4
 *
 * Scambio di variabili con variabile temporanea
 *
 * Crea una classe Scambio con due variabili intere.
 * Aggiungi un metodo chiamato scambia che scambia i valori delle due variabili
 * utilizzando una variabile temporanea. Scrivere un metodo per visualizzare i
 * valori.
 */

import java.util.Scanner;

public class Scambio {
    int a, b;

    // Costruttore
    public Scambio(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // Metodo per scambiare le variabili
    public void scambia() {
        int temp = a;
        a = b;
        b = temp;
    }

    // Metodo per visualizzare i valori
    public void mostraValori() {
        System.out.println("a = " + a + ", b = " + b);
    }
}

class TestScambio {
    public static void main(String[] args) {
        int num1, num2;
        System.out.println("Inserisci 2 numeri: ");
        Scanner input = new Scanner(System.in);
        num1 = input.nextInt();
        num2 = input.nextInt();

        Scambio sc = new Scambio(num1, num2);
        sc.mostraValori();
        sc.scambia();
        sc.mostraValori();
    }
}