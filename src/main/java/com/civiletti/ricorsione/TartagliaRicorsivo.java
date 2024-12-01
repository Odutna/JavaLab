package com.civiletti.ricorsione;

import java.util.Scanner;

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
 *  Formula ricorsiva del coefficiente binomiale: (*)
 *      C(n, k+1) = C(n, k) ⋅ (n − k) / (k + 1)
 *
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
 * (*) DIMOSTRAZIONE:
 *  Immaginiamo di voler calcolare C(n,k). Per farlo, consideriamo un insieme di n elementi e
 *  analizziamo due scenari per uno specifico elemento (che chiameremo "elemento speciale"):
 *
 *  • L'elemento speciale è incluso:
 *    Se includiamo l'elemento speciale, dobbiamo scegliere gli altri k−1 elementi dal restante
 *    insieme di n−1 elementi.
 *
 *    Il numero di modi per farlo è C(n−1,k−1).
 *
 *  • L'elemento speciale è escluso:
 *    Se escludiamo l'elemento speciale, dobbiamo scegliere tutti i k elementi dal restante insieme
 *    di n−1 elementi.
 *
 *    Il numero di modi per farlo è C(n−1,k).
 *
 * • Combinazione dei due casi:
 *
 *   Poiché i due scenari sono mutualmente esclusivi e coprono tutte le possibilità, il numero totale
 *   di combinazioni è la somma dei due casi:
 *
 *              ================================
 *              =  C(n,k)=C(n−1,k−1)+C(n−1,k)  =
 *              ================================
 *
 *   Per garantire che la relazione ricorsiva funzioni, dobbiamo stabilire le condizioni di base:
 *
 *   1) Se k=0 (scelgo 0 elementi), c'è un solo modo di farlo (l'insieme vuoto):
 *
 *   • C(n,0)=1
 *
 *   2) Se k=n (scelgo tutti gli elementi), c'è un solo modo di farlo (l'intero insieme):
 *
 *   • C(n,n)=1
 */

public class TartagliaRicorsivo {

    /**
     * Metodo ricorsivo per calcolare il coefficiente binomiale C(n, k)
     *
     * Il coefficiente binomiale C(n,k) rappresenta il numero di modi per scegliere
     * k elementi da un insieme di n elementi
     *
     * Utilizza la relazione ricorsiva:
     *    C(n, k) = C(n-1, k-1) + C(n-1, k)
     * Con le condizioni di base:
     *    C(n, 0) = 1 e C(n, n) = 1
     *
     * @param n Indice della riga
     * @param k Indice della colonna
     * @return Coefficiente binomiale C(n, k)
     */
    public static int coefficienteBinomiale(int n, int k) {
        // Condizioni di base
        if (k == 0 || k == n) {
            return 1;
        }
        // Relazione ricorsiva
        return coefficienteBinomiale(n - 1, k - 1) + coefficienteBinomiale(n - 1, k);
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Numero di righe da calcolare: ");
        int righe = sc.nextInt();

        for (int n = 0; n < righe; n++) {
            for (int k = 0; k <= n; k++) {
                System.out.print(coefficienteBinomiale(n, k) + " ");
            }
            System.out.println();
        }
    }


}

