package com.civiletti.intro;

/**
 * Dimostrazione dell'utilizzo dei metodi costruttore
 * variabili di istanza e metodi.
 * Lo scopo di questo lab. è di mostrare come ogni
 * oggetto, in questa implementazione, abbia una
 * propria area di memoria.
 */

public class Territorio2 {
    //Variabili
    double superficie; //valore in Kmq
    int abitanti;

    //Costruttore
    Territorio2(double s, int a ){
        superficie = s;
        abitanti = a;
    }

    //Metodo densita
    double densita(){
        return superficie/abitanti;
    }

    public static void main(String args[]){

        Territorio2 t = new Territorio2( 257.3, 12250);
        System.out.println("+--------------------------+");
        System.out.println("Oggetto t " + t);
        System.out.println("Superficie: " + t.superficie);
        System.out.println("Abitanti: " + t.abitanti);
        System.out.println("Densita: " + t.densita());
        System.out.println("+--------------------------+");

        Territorio2 t2 = new Territorio2( 475.98, 98750);

        System.out.println("Oggetto t2 " + t2);
        System.out.println("Superficie: " + t2.superficie);
        System.out.println("Abitanti: " + t2.abitanti);
        System.out.println("Densita: " + t2.densita());

        // Stampo nuovamente i dati relativi all'oggetto t
        System.out.println("+--------------------------+");
        System.out.println("Oggetto t " + t);
        System.out.println("Superficie: " + t.superficie);
        System.out.println("Abitanti: " + t.abitanti);
        System.out.println("Densita: " + t.densita());
        System.out.println("+--------------------------+");

    }
}

