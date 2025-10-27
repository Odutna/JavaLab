package com.civiletti;

/**
 * Es. 1
 *
 * Verifica del numero positivo, negativo o zero (con costruttore e metodo)
 * Crea una classe chiamata Numero con un costruttore che accetta un intero.
 * Aggiungi un metodo chiamato verificaSegno che determina se il numero è positivo,
 * negativo o uguale a zero.
 */

import java.util.Scanner;

public class NumeroPari {
    int valore;

    // Costruttore
    public NumeroPari(int valore) {
        this.valore = valore;
    }

    // Metodo per verificare il segno
    public void verificaPari() {
        if (valore % 2 == 0) System.out.println("Il numero è pari.");
        else System.out.println("Il numero è dispari.");
    }
}

class TestNumeroPari {
    public static void main(String[] args) {
        char c;
        do {
            System.out.println("Inserisci un numero: ");
            Scanner sc = new Scanner(System.in);
            int numero = sc.nextInt();

            NumeroPari num = new NumeroPari(numero);
            num.verificaPari();
            System.out.println("Continuare? (s/n)");
            c = sc.next().toLowerCase().charAt(0);
        } while ( c == 's');
    }
}