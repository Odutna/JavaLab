package com.civiletti;

/**
 * Dimostrazione dell'utilizzo dei metodi costruttore
 * variabili di istanza e metodi
 */

public class Territorio1 {
    //Variabili
    double superficie; //valore in Kmq
    int abitanti;

    //Costruttore
    Territorio1( double s, int a ){
        superficie = s;
        abitanti = a;
    }

    //Metodo densita
    double densita(){
        return superficie/abitanti;
    }

    public static void main(String args[]){

        Territorio5 t = new Territorio5( 257.3, 12250);

        System.out.println("Superficie: " + t.superficie);
        System.out.println("Abitanti: " + t.abitanti);
        System.out.println("Densita: " + t.densita());
    }
}
