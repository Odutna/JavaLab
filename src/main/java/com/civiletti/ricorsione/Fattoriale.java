package com.civiletti.ricorsione;

import java.util.Scanner;

public class Fattoriale {

    /**
     * Calcolo del fattoriale
     *
     * Il fattoriale di un numero intero positivo 'n', indicato come 'n!', è il prodotto di tutti i numeri interi
     * da 1 fino a 'n'. È definito come:
     * - '0! = 1' (per definizione)
     * - 'n! = n * (n-1) * (n-2) * ... * 3 * 2 * 1', per 'n > 0'.
     *
     * Utilità del fattoriale:
     * - Compare in molte aree della matematica, come combinatoria, probabilità, e algebra.
     * - Serve per calcolare il coefficiente binomiale \(C(n, k)\), usato nel Triangolo di Tartaglia.
     * - È alla base di formule matematiche per permutazioni e combinazioni.
     *
     * In questo programma, il fattoriale viene calcolato iterativamente tramite un ciclo 'for'.
     *
     * @param numero il numero di cui calcolare il fattoriale.
     * @return il fattoriale del numero dato.
     */
    int fattoriale(int numero) {
        int factorial = 1;
        for (int n = 1; n <= numero; n++) { // Partiamo da 1
            factorial *= n; // Moltiplichiamo direttamente
        }
        return factorial;
    }

    public static void main(String[] args) {

        Fattoriale f = new Fattoriale();
        Scanner sc = new Scanner(System.in);
        System.out.println("Calcolare il fattoriale di: ");
        System.out.println(f.fattoriale(sc.nextInt()));
    }
}
