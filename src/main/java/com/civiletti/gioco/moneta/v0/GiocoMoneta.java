package com.civiletti.gioco.moneta.v0;

import java.util.Random;
import java.util.Scanner;

/**
 * Classe che rappresenta una moneta con due facce: TESTA o CROCE.
 */
class Moneta {
    public static final int TESTA = 1;
    public static final int CROCE = 0;
    private int faccia;
    private static Random random = new Random();

    // Costruttore: lancia subito la moneta
    public Moneta() {
        lancia();
    }

    // Lancia la moneta e genera casualmente 0 o 1
    public void lancia() {
        faccia = random.nextInt(2);
    }

    // Ritorna true se è Testa
    public boolean isTesta() {
        return faccia == TESTA;
    }

    // Ritorna "Testa" o "Croce"
    @Override
    public String toString() {
        return isTesta() ? "Testa" : "Croce";
    }
}

/**
 * Classe principale del gioco
 */
public class GiocoMoneta {
    private static final Scanner input = new Scanner(System.in);

    // Determina e stampa il vincitore in base alla scelta e ai risultati
    public static void determinaVincitore(int scelta, int testa, int croce) {
        boolean giocatoreVince = (scelta == Moneta.TESTA && testa >= 3) ||
                (scelta == Moneta.CROCE && croce >= 3);

        if (giocatoreVince) {
            System.out.println("> Hai vinto!");
            System.out.println("> Hai indovinato " + (scelta == Moneta.TESTA ? testa : croce) + " volte!");
        } else {
            System.out.println("> Ha vinto il PC!");
            System.out.println("> Il PC ha ottenuto " + (scelta == Moneta.TESTA ? croce : testa) + " risultati opposti ai tuoi.");
        }
    }

    public static void main(String[] args) {
        String continua;

        System.out.println("Benvenuto nel Gioco del Lancio della Moneta!");

        do {
            int testa = 0, croce = 0;

            System.out.print("Scegli Testa (1) o Croce (0): ");
            int scelta = input.nextInt();

            Moneta moneta = new Moneta();

            // 5 lanci
            for (int i = 1; i <= 5; i++) {
                moneta.lancia();
                System.out.println("Lancio " + i + ": " + moneta);
                if (moneta.isTesta()) testa++;
                else croce++;
            }

            determinaVincitore(scelta, testa, croce);

            System.out.print("Vuoi continuare a giocare? [s/n]: ");
            continua = input.next();
            System.out.println();

        } while (continua.equalsIgnoreCase("s"));

        System.out.println("Grazie per aver giocato!");
        input.close();
    }
}

