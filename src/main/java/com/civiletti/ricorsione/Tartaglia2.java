package com.civiletti.ricorsione;

/**
 *  Triangolo di Tartaglia (o Triangolo di Pascal)
 *
 *  Il triangolo di Tartaglia è una rappresentazione matematica di forma triangolare,
 *  composta da numeri naturali. Ogni numero all'interno del triangolo rappresenta un
 *  coefficiente binomiale, calcolato come combinazione di n elementi presi k alla volta.
 *
 *  Struttura del triangolo:
 *  - Ogni riga inizia e termina con il valore 1.
 *  - Ogni numero interno è la somma dei due numeri direttamente sovrastanti.
 *
 *  Applicazioni principali:
 *  1. **Sviluppo del binomio**: Gli elementi della riga n-esima del triangolo (n ≥ 0)
 *     corrispondono ai coefficienti dello sviluppo della potenza di un binomio.
 *  2. **Combinatoria**: I valori C(n, k) rappresentano il numero di modi in cui è possibile
 *     scegliere k elementi da un insieme di n elementi.
 *  3. **Geometria e Algebra**: Utilizzato per risolvere problemi legati a permutazioni,
 *     disposizioni e coefficienti in polinomi.
 *
 *  Definizione del coefficiente binomiale:
 *      ======================================================
 *      =   C(n, k) = n! / [k! * (n − k)!]   con 0 ≤ k ≤ n   =
 *      ======================================================
 *  Dove:
 *  - C(n, k) rappresenta il valore nella riga n e colonna k del triangolo.
 *  - n è l'indice della riga (partendo da 0).
 *  - k è l'indice della posizione nella riga (partendo da 0).
 *
 *  Formula ricorsiva del coefficiente binomiale:
 *      C(n, k+1) = C(n, k) ⋅ (n − k) / (k + 1)
 *  Questa formula è utile per calcolare rapidamente il valore di C(n, k) a partire
 *  dal valore precedente nella stessa riga, evitando il calcolo esplicito dei fattoriali.
 *
 *  Limitazioni ed efficienza:
 *  - Il calcolo ripetitivo dei fattoriali può essere inefficiente per grandi valori di n.
 *    L'uso della formula ricorsiva migliora significativamente le prestazioni.
 *
 *  Implementazione:
 *  - È possibile costruire il triangolo di Tartaglia riga per riga usando iterazioni
 *    o formule ricorsive.
 *  - I risultati possono essere stampati a video o salvati in strutture dati per ulteriori
 *    elaborazioni (ad esempio, matrici o liste nidificate).
 *
 *  Esempio di triangolo (prime 5 righe):
 *      1
 *      1   1
 *      1   2   1
 *      1   3   3   1
 *      1   4   6   4   1
 *
 *  Utilizzo:
 *  - Questo programma genera le prime 'n' righe del triangolo di Tartaglia.
 *  - Modificare il numero di righe per espandere la profondità del calcolo.
 *
 */


public class Tartaglia2 {

    public static void main(String[] args) {
        int tartaglia;
        int righe = 10;

        for (int n = 0; n < righe; n++) {
            int n_factorial = 1; // Reset per ogni nuovo 'n'

            // Calcolo del fattoriale di n
            for (int i = 1; i <= n; i++) {
                n_factorial *= i;
            }

            for (int k = 0; k <= n; k++) {
                int k_factorial = 1; // Reset per ogni nuovo 'k'
                int n_k_factorial = 1; // Reset per ogni nuovo 'n-k'

                // Calcolo del fattoriale di k
                for (int i = 1; i <= k; i++) {
                    k_factorial *= i;
                }

                // Calcolo del fattoriale di (n-k)
                for (int i = 1; i <= (n - k); i++) {
                    n_k_factorial *= i;
                }

                // Formula: n! / (k! * (n-k)!)
                tartaglia = n_factorial / (k_factorial * n_k_factorial);
                System.out.print(tartaglia + " ");
            }
            System.out.println(); // Nuova riga per il livello successivo
        }
    }
}
