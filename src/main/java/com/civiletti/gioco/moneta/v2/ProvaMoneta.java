package com.civiletti.gioco.moneta.v2;

import javax.swing.*;
import java.util.Scanner;

public class ProvaMoneta{
    private int vincita = 0;
    private int cont = 0;
    // Funzione per determinare il vincitore
    public static boolean determinaVincitore(int sceltaGiocatore, int lanciTesta) {
        // Determina il vincitore in base alla scelta del giocatore e ai lanci di testa
        boolean giocatoreVince = (sceltaGiocatore == Moneta.TESTA && lanciTesta >= 3) ||
                                 (sceltaGiocatore == Moneta.CROCE && (5 - lanciTesta) >= 3); // (5 - lanciTesta) = numero di croce

        System.out.println( giocatoreVince ? "> Hai vinto!" : "> Ha vinto il PC!" );
        return giocatoreVince;
    }

    private int punta(Scanner sc) {
        while(true) {
            System.out.println("LA PUNTATA MINIMA È 5€ - PUNTATE ACCETTATE: 5€ | 7€ | 10€. QUANTO PUNTI?");
            int punta = sc.nextInt();
            switch (punta) {
                case 5, 7, 10:
                    return punta;
                default:
                    System.out.println("Puntata non ammessa");
            }
        }
    }


    public static void main(String[] args)throws Exception{

        Scanner in = new Scanner(System.in);
        int sceltaGiocatore;
        ProvaMoneta gioco = new ProvaMoneta();
        String continua;
        do {
            int lanciTesta = 0;
            System.out.println("\nGioco del testa o croce - 5 lanci");
            int puntata = gioco.punta(in);
            System.out.print("Scegli testa (0) oppure croce (1): ");

            sceltaGiocatore = in.nextInt();

            Moneta miaMoneta = new Moneta();

            // Effettua i lanci della moneta
            for (int x = 0; x < 5; x++) {
                miaMoneta.lancia();
                System.out.println("Lancio (" + (x+1) + "): " + miaMoneta);
                if (miaMoneta.isTesta()) lanciTesta++; // Incrementa lanciTesta se è uscito Testa
            }

            // Determina il vincitore e incrementa il portafogli
            if (determinaVincitore(sceltaGiocatore, lanciTesta))
                gioco.vincita += puntata;
            else
                gioco.vincita -= puntata;

            System.out.println("Guadagni: " + gioco.vincita + "€");
            System.out.println("Vuoi tentare nuovamente la fortuna? [s, n]");
            continua = in.next().toLowerCase().charAt(0) == 's' ? "s" : "n";
            gioco.cont++;
        }while (continua.equals("s"));   // Attenzione! continua == "s" controlla i riferimenti, String è un oggetto.

        System.out.println("Hai giocato " + gioco.cont + " volte!");

        if(gioco.vincita > 0) System.out.println("Hai barato, ha vinto: " + gioco.vincita + "€, ti spaccheremo le ossa!");
        else if(gioco.vincita < 0) System.out.println("Grazie per averci regalato i tuoi soldi! Hai perso: " + (- gioco.vincita) + "€" );
        else System.out.println("Non hai vinto e non hai perso. Riprovaci potrai diventare ricco! Bilancio: " + gioco.vincita + "€");
    }
}
