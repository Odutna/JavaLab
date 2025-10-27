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

public class SegnoNumero {
    int valore;

    // Costruttore
    public SegnoNumero(int valore) {
        this.valore = valore;
    }

    // Metodo per verificare il segno
    public void verificaSegno() {

        if (valore > 0) System.out.println("Il numero è positivo.");
        else if (valore < 0) System.out.println("Il numero è negativo.");
        else System.out.println("Il numero è zero.");

    }
}

class TestSegnoNumero {
    public static void main(String[] args) {

        System.out.println("Inserisci un numero: ");
        Scanner sc = new Scanner(System.in);
        int numero =  sc.nextInt();

        NumeroPari num = new NumeroPari(numero);
        num.verificaPari();
    }
}