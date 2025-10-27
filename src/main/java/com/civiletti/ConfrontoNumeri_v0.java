package com.civiletti;

/**
 * Es. 3 - 0
 *
 * Numero più grande tra tre numeri (con costruttore e metodo)
 *
 * Crea una classe chiamata ConfrontoNumeri che accetta tre numeri nel costruttore.
 * Aggiungi un metodo chiamato trovaMassimo che restituisce il numero più grande.
 */

import java.util.Scanner;

public class ConfrontoNumeri_v0 {
    int num1, num2, num3;

    // Costruttore
    public ConfrontoNumeri_v0(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    // Metodo per trovare il numero massimo
    public int trovaMassimo() {
        if (num1 >= num2 && num1 >= num3)
            return num1;
        else if (num2 >= num1 && num2 >= num3)
            return num2;
        else
            return num3;
    }
}

class TestConfrontoNumeri_v0 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("Quanti numeri vuoi inserire?");
            int n = sc.nextInt();

            int[] valori = new int[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Inserisci valore [" + (i + 1) + "]: ");
                valori[i] = sc.nextInt();
            }

            // Uso del costruttore
            ConfrontoNumeri_v3 confronto = new ConfrontoNumeri_v3(valori);
            System.out.println("Il numero massimo è: " + confronto.trovaMassimo());

            System.out.println("Vuoi continuare? (s/n)");
            String risposta = sc.next();
            if (risposta.equalsIgnoreCase("n")) {
                continua = false;
                System.out.println("Arrivederci!");
            }
        }

        sc.close();
    }
}
