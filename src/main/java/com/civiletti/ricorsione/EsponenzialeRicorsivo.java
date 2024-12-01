package com.civiletti.ricorsione;

import java.util.Scanner;

public class EsponenzialeRicorsivo {

    /**
     * Metodo per il calcolo di una potenza utilizzando la ricorsione.
     *
     * La ricorsione viene utilizzata per calcolare la potenza di una base elevata
     * a un esponente intero non negativo, seguendo queste regole:
     *
     * - **Caso base 1**: Qualsiasi numero elevato a 0 restituisce 1 (base^0 = 1).
     * - **Caso base 2**: Un numero elevato a 1 restituisce sé stesso (base^1 = base).
     * - **Passo ricorsivo**: Per esponenti maggiori di 1, si utilizza la formula:
     *   'base^esponente = base * base^(esponente-1)'.
     *
     * @param base La base della potenza.
     * @param esponente L'esponente (>= 0).
     * @return Il risultato della base elevata all'esponente.
     */
    public double esponenziale(int base, int esponente) {
        if(esponente==0) return 1; // Caso base 1
        else if(esponente==1) return base; // Caso base 2
        else return base * esponenziale(base, esponente-1);
    }

    public static void main(String[] args) {

        EsponenzialeRicorsivo mf = new EsponenzialeRicorsivo();
        while(true) {
            System.out.println("Inserire i valori di base e esponente: ");
            System.out.println(mf.esponenziale(new Scanner(System.in).nextInt(), new Scanner(System.in).nextInt()));

            System.out.println("Continuare? (s/n)");
            if(new Scanner(System.in).nextLine().equalsIgnoreCase("n")) break;
        }
    }
}
