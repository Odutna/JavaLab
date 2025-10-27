package com.civiletti;

/**
 * Esercizio 3.2 - Confronto di numeri
 * <p>
 * La classe ConfrontoNumeri_v2 consente di individuare il valore massimo
 * tra una serie di numeri inseriti dall’utente.
 * <p>
 * Funzionalità:
 * - Chiede all’utente quanti numeri inserire.
 * - Memorizza i valori.
 * - Determina e restituisce il numero più grande con il metodo trovaMassimo().
 *
 * @author Civiletti
 * @version 1.3
 */

import java.util.*;

public class ConfrontoNumeri_v2 {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int n, max;
        char continua;
        do {
            System.out.println("Quanti numeri vuoi inserire?");
            n = input.nextInt();
            int a;

            max = 0;
            while (n > 0) {
                System.out.println("Inserisci un valore intero");
                a = input.nextInt();
                if (a > max) {
                    max = a;
                }
                n = n - 1;
            }
            System.out.println("Il numero più grande che è stato inserito è: " + max);
            System.out.println("Continuare? [s/n]");
            continua = input.next().toLowerCase().charAt(0);
        } while (continua == 's');
        System.out.printf("Grazie per aver utilizzato il mio software!");
    }
}
