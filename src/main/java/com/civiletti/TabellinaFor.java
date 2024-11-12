package com.civiletti;

/**
 * Generare tabelle di moltiplicazione di diverse dimensioni
 *
 * Scrivere un programma Java che generi e visualizzi tabelle di moltiplicazione di
 * dimensioni diverse. Il programma dovrebbe consentire all'utente di specificare la
 * dimensione delle tabelle da generare e quindi visualizzare le tabelle di
 * moltiplicazione corrispondenti.
 */

import java.util.Scanner;

public class TabellinaFor {
    private int dim;

    //Costruttore
    public TabellinaFor(int d) {
        dim = d;
    }

    //Metodo per mostrare l'output utilizzando due cicli for annidati
    public void show() {
        String separation = "";
        //Scansione delle righe
        for(int i = 1; i <= dim; i++) { // RIGHE
            //Scansione delle colonne
            for(int j = 1; j <= dim; j++) { // COLONNE
                System.out.print(i * j);
                System.out.print("\t");

            }
            String tab = "---";
            if(i <= dim )
                separation += "-" + tab;
            System.out.println();
        }
        System.out.println(separation);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.println("Inserire la dimensione della matrice:  [0 per uscire]");

            int dim = scanner.nextInt();
            TabellinaFor x = new TabellinaFor(dim);
            System.out.println("Matrice [" + dim + "X" + dim + "]: ");
            x.show();

            if(dim == 0){
                scanner.close();
                System.out.printf("Grazie per aver utilizzato il software!\n");
                break;
            }
        }


//        TabellinaFor y = new TabellinaFor(10);
//        TabellinaFor z = new TabellinaFor(12);
//        x.show();
//        y.show();
//        z.show();
    }
}
