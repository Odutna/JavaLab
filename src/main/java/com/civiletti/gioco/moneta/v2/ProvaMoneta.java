package com.civiletti.gioco.moneta.v2;

import java.util.Scanner;

public class ProvaMoneta{

    // Funzione per determinare il vincitore
    public static void determinaVincitore(int sceltaGiocatore, int lanciTesta) {
        // Determina il vincitore in base alla scelta del giocatore e ai lanci di testa
        boolean check = (sceltaGiocatore == 0 && lanciTesta > 2) || (sceltaGiocatore == 1 && lanciTesta <= 2);

        String vincitore = check ? "> Hai vinto!" : "> Ha vinto il PC!";

        System.out.println( vincitore );

    }


    public static void main(String[] args)throws Exception{

        Scanner in = new Scanner(System.in);
        int sceltaGiocatore;
        int lanciTesta = 0;

        System.out.println("\nGioco del testa o croce - 5 lanci");
        System.out.print("Scegli testa (0) oppure croce (1): ");

        sceltaGiocatore = in.nextInt();

        Moneta miaMoneta = new Moneta();

        // Effettua i lanci della moneta
        for (int x = 0; x < 5; x++){
            miaMoneta.lancia();
            System.out.println(miaMoneta.toString());

            // Incrementa lanciTesta se è uscito Testa
            if (miaMoneta.isTesta()) lanciTesta++;
        }

    /*
    if((sceltaGiocatore == 0 && lanciTesta > 2) || (sceltaGiocatore == 1 && lanciTesta <= 2))
        System.out.println("> Hai vinto!");
    else
        System.out.println("> Ha vinto il PC!");
    */

        determinaVincitore(sceltaGiocatore, lanciTesta);

    }
}
