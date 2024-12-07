package com.civiletti.ricorsione;

/**
 *  Triangolo di Tartaglia
 *
 *  Il triangolo di Tartaglia è una famosa rappresentazione dei coefficienti binomiali che si
 *  ottengono dallo sviluppo del binomio di Newton (a+b)^n, dove n è una riga del triangolo...
 *
 *  Si tratta di una tabella di forma triangolare composta da numeri naturali, dove ogni numero
 *  è un particolare coefficiente binomiale. Tale tabella ha infiniti elementi, e ciascuna riga
 *  si ottiene dalla precedente disponendo 1 agli estremi e sommando le coppie di termini della
 *  riga sovrastante.
 *
 *  La principale applicazione del triangolo di Tartaglia riguarda lo sviluppo di una qualsiasi
 *  potenza di binomio, infatti gli elementi dell'n-esima riga del triangolo, con 'n' numero
 *  naturale maggiore o uguale ad 1, corrispondono ai coefficienti dello sviluppo della potenza
 *  di binomio.
 *
 *          Cofficiente binomiale:
 *          =============================================
 *          =   C(n,k)= n!/k!(n−k)!   con k > n, n−k    =
 *          =============================================
 *
 *      • C(n,k) è il valore nella riga n e colonna k del triangolo.
 *      • n è l'indice della riga (partendo da 0).
 *      • k è l'indice della posizione nella riga (partendo da 0).
 *
 *  Calcolare il fattoriale ripetutamente è inefficiente. Un approccio migliore utilizza la formula
 *  ricorsiva del coefficiente binomiale:
 *
 *  C(n,k+1)=C(n,k)⋅ (k+1) / (n−k)
 *
 *
 */

public class Tartaglia {


    // Funzione per calcolare il coefficiente binomiale C(n, k)
    private static int coefficienteBinomiale(int n, int k) {
        return factoriale(n) / (factoriale(k) * factoriale(n - k));
    }

    // Funzione per calcolare il fattoriale di un numero
    private static int factoriale(int num) {
        if (num == 0 || num == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 2; i <= num; i++) {
            result *= i;
        }
        return result;
    }

    public static void main(String[] args) {

        int rows = 10; // Numero di righe del triangolo

        for (int n = 0; n < rows; n++) { // Per ogni riga
            for (int k = 0; k <= n; k++) { // Calcola i valori da 0 a n
                System.out.print(coefficienteBinomiale(n, k) + " ");
            }
            System.out.println(); // Nuova riga dopo ogni riga completata
        }
    }


}
