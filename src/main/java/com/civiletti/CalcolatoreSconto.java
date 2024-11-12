package com.civiletti;


/**
 * Es. 5
 *
 * Calcolatore di sconto (con costruttore e metodo)
 *
 * Crea una classe chiamata CalcolatoreSconto che accetta l'importo dell'acquisto
 * nel costruttore. Aggiungi un metodo chiamato calcolaSconto per determinare lo
 * sconto in base all'importo.
 */

import java.util.Scanner;

public class CalcolatoreSconto {

    private double importo;
    private double sconto;
    // Costruttore
    public CalcolatoreSconto(double importo) {
        this.importo = importo;
    }

    // Metodo per calcolare lo sconto
    public double calcolaSconto() {

        if (importo < 50) {
            sconto = 0;
        } else if (importo <= 100) {
            sconto = 0.05 * importo;
        } else if (importo <= 200) {
            sconto = 0.10 * importo;
        } else {
            sconto = 0.20 * importo;
        }
        return sconto;
    }

    public double prezzoTot(){
        return  (importo -sconto);
    }

    public String toString(){
        return "Importo: " + importo + "\n" +
               "Sconto: " + calcolaSconto() + "\n" +
               "Totale: " + prezzoTot();
    }
}

class TestCalcolatoreSconto {
    public static void main(String[] args) {

        System.out.printf("Inserisci importo: ");

        Scanner sc = new Scanner(System.in);
        double prezzo = sc.nextDouble();

        CalcolatoreSconto calcolatore = new CalcolatoreSconto(prezzo);
        //calcolatore.calcolaSconto();
        //calcolatore.prezzoTot();
        System.out.println(calcolatore);
    }
}
