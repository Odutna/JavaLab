package com.civiletti;

/**
 * Generare tabelle di moltiplicazione di diverse dimensioni
 *
 * Scrivere un programma Java che generi e visualizzi tabelle di moltiplicazione di
 * dimensioni diverse. Il programma dovrebbe consentire all'utente di specificare la
 * dimensione delle tabelle da generare e quindi visualizzare le tabelle di
 * moltiplicazione corrispondenti.
 */


public class TabellinaWhile {
    private int dim;

    public TabellinaWhile(int d) {
        dim = d;
    }

    public void show() {

        int i = 1;
        String separation = "";

        while(i <= dim) {
            int j = 1;
            while(j <= dim) {
                System.out.print(i*j);
                System.out.print("\t");
                j++;
            }
            System.out.println();
            i++;

            String tab = "---";
            if(i <= dim )
                separation += "-" + tab;
        }
        System.out.println(separation);
    }

    public static void main(String[] args) {
        TabellinaWhile x = new TabellinaWhile(5);
        TabellinaWhile y = new TabellinaWhile(10);
        TabellinaWhile z = new TabellinaWhile(12);
        x.show();y.show();z.show();
    }

}