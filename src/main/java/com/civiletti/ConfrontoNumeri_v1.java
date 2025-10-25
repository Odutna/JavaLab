package com.civiletti;

/**
 * Es. 3
 *
 * Numero più grande tra tre numeri (con costruttore e metodo)
 *
 * Crea una classe chiamata ConfrontoNumeri che accetta tre numeri nel costruttore.
 * Aggiungi un metodo chiamato trovaMassimo che restituisce il numero più grande.
 */

import java.util.Scanner;

public class ConfrontoNumeri_v1 {
    int num1, num2, num3;

    // Costruttore
    public ConfrontoNumeri_v1(int num1, int num2, int num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }

    // Metodo per trovare il numero massimo
    public int trovaMassimo() {
        return (num1 >= num2 && num1 >= num3) ? num1 :
               (num2 >= num1 && num2 >= num3) ? num2 :
                       num3;
    }
}

class TestConfrontoNumeri_v1 {
    public static void main(String[] args) {

        int num1, num2, num3;
        boolean run = true;
        while (run) {
            System.out.println("Inserisci 3 numeri: ");

            Scanner sc = new Scanner(System.in);
            num1 = sc.nextInt();
            num2 = sc.nextInt();
            num3 = sc.nextInt();

            ConfrontoNumeri_v1 numeri = new ConfrontoNumeri_v1(num1, num2, num3);

            System.out.println("Il numero più grande è: " + numeri.trovaMassimo());

            System.out.println("Continuare? (s/n)");
            String s = sc.next();
            if (s.equalsIgnoreCase("n")) {
                System.out.println("Grazie per aver utilizzao il mo software!");
                run = false;
            }

        }
    }
}
