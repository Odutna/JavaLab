package com.civiletti;

/**
 * Generare tabelle di moltiplicazione di diverse dimensioni
 *
 * Scrivere un programma Java che generi e visualizzi tabelle di moltiplicazione di
 * dimensioni diverse. Il programma dovrebbe consentire all'utente di specificare la
 * dimensione delle tabelle da generare e quindi visualizzare le tabelle di
 * moltiplicazione corrispondenti.
 */

public class TabellinaDoWhile {
    private int dim;

    public TabellinaDoWhile(int d) {
        dim = d;
    }

    public void show() {
        int i = 1;
        String separation = "";

        do {
            int j = 1;
            do {
                System.out.print(i*j);
                System.out.print("\t");
                j++;
            } while(j <= dim);
            System.out.println();
            i++;
            String tab = "---";
            if(i <= dim )
                separation += "-" + tab;
        } while(i <= dim);
        System.out.println(separation);
    }

    public static void main(String[] args) {
        TabellinaDoWhile x = new TabellinaDoWhile(5);
        TabellinaDoWhile y = new TabellinaDoWhile(10);
        TabellinaDoWhile z = new TabellinaDoWhile(12);
        x.show();y.show();z.show();
    }

}