package com.civiletti.ricorsione;

import java.util.Scanner;

public class MoltiplicazioneRicorsiva {

    /**
     * Metodo per il calcolo di una potenza utilizzando la ricorsione.
     *
     * La ricorsione viene utilizzata per calcolare la potenza di una base elevata
     * a un esponente intero non negativo, seguendo queste regole:
     *
     * - **Caso base 1**: 0 per qualsiasi numero restituisce 0
     * - **Caso base 2**: 1 per qualsiasi numero restituisce il numero stesso - RIDONDANTE
     * - **Passo ricorsivo**: Per moltiplicandi ≥ 1.
     *
     * @param n moltiplicando
     * @param m moltiplicatore
     * @return Il risultato della moltiplicazione.
     */
    public double moltiplicazione(int n, int m) {
        if(n==0) return 0; // Caso base 1
//        else if(n==1) return m; // Caso base 2
        else return m + moltiplicazione(n-1, m); // Step ricorsivo
    }

    public static void main(String[] args) {

        MoltiplicazioneRicorsiva mf = new MoltiplicazioneRicorsiva();

        System.out.println("===============================");
        System.out.println("=  Moltiplicazione Ricorsiva  =");
        System.out.println("===============================");

        do {
            System.out.println("Inserisci due numeri: ");
            System.out.println(mf.moltiplicazione(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));
            System.out.print("Continuare? (s/n)");
        }while(new Scanner(System.in).nextLine().charAt(0) != 'n');
    }
}
