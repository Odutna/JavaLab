package com.civiletti;

import java.util.Scanner;

public class OrdinaArrayCrescente {

    int[] numeri;
    int num;

//    OrdinaArrayCrescente(Scanner sc){
//        chiediDati(sc);
//    }

    int chiediDati(Scanner sc) {
        System.out.println("Inserisci un numero: ");
        this.num = sc.nextInt();
        return this.num;
    }

    int[] ordinaArrayCrescente(Scanner sc) {

        System.out.println("Inserisci la dimensione dell'array: ");
        final int MAX = sc.nextInt();
        this.numeri = new int[MAX];

        int i = this.numeri.length;

        while (i > 0) { // Inserisco i dati a partire dall'ultimo elemento
            OrdinaArrayCrescente oac = new OrdinaArrayCrescente();
            this.numeri[i - 1] = oac.chiediDati(sc);
            i--;
        }

        // Ordina i numeri in ordine crescente - Bubble Sort

        /**
         * Il ciclo esterno esegue un numero di iterazioni pari alla lunghezza dell'array meno 1.
         * Questo perché l'array sarà completamente ordinato dopo numeri.length - 1 passaggi.
         *
         * Il ciclo interno confronta ogni elemento dell'array a partire dalla posizione z + 1
         * fino alla fine dell'array. Lo scopo è confrontare ogni elemento con tutti quelli che
         * lo seguono nell'array.
         *
         * Se durante il confronto viene trovato un elemento in ordine sbagliato (cioè numeri[z]
         * è maggiore di numeri[k]), i due elementi vengono scambiati utilizzando una variabile
         * temporanea tmp.
         *
         * Questo processo di confronto e scambio (se necessario) viene ripetuto finché l'intero
         * array non è completamente ordinato in ordine crescente.
         *
         * Complessità temporale è O(n^2), cioèe il tempo di esecuzione cresce in modo quadratico
         * rispetto alla dimensione dell'array.
         *
         */
        for (int z = 0; z < numeri.length - 1; z++) {
            for (int k = z + 1; k < numeri.length; k++) { //k = z + 1
                if (numeri[z] > numeri[k]) { // Scambia i numeri se sono in ordine sbagliato
                    int tmp = numeri[z];
                    numeri[z] = numeri[k];
                    numeri[k] = tmp;
                }
            }
        }

        return numeri;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        OrdinaArrayCrescente oac = new OrdinaArrayCrescente();

        int[] Arrayinvertito = oac.ordinaArrayCrescente(sc);

        // Stampa i numeri ordinati
        System.out.println("Numeri ordinati in ordine crescente:");
        System.out.print("ArrayInvertito = [ ");
        int i = 1;
        for (int elemento : Arrayinvertito) {
            if( i != Arrayinvertito.length)
                System.out.print(elemento + ", ");
            else System.out.print(elemento + " ]");
            i++;
        }

    }
}
