package com.civiletti.intro;

/**
 * Dimostrazione dell'utilizzo dei metodi costruttore
 * variabili di istanza e metodi
 */

public class Territorio1 {
    //Variabili
    double superficie; //valore in Kmq
    int abitanti;
    private String nome;

    //Costruttore
    Territorio1( String nome, double s, int a ){
        this.nome = nome;
        superficie = s;
        abitanti = a;
    }

    Territorio1( double s ){
        nome = "";
        superficie = s;
        abitanti = 100000; // default - 100.000 abitanti
    }

    Territorio1( int a ){
        nome = "";
        superficie = 100000; // default - 20.000 Km^2
        abitanti = a;
    }

    Territorio1(){
        nome = "";
        superficie = 100000; // default - 20.000 Km^2
        abitanti = 100000; // default - 100.000 abitanti
    }

    //Metodo densita
    double densita(){
        System.out.println(this.nome);
        return superficie/abitanti;
    }

    public static void main(String args[]){

        Territorio1 t1 = new Territorio1("Sicilia", 25711.34, 4800000);
        System.out.println("+-------------------------------------+\n Oggetto: " + t1);
        System.out.println("Superficie: " + t1.superficie);
        System.out.println("Abitanti: " + t1.abitanti);
        System.out.println("Densita: " + t1.densita());

        Territorio1 t2 = new Territorio1(257.3 );
        System.out.println("+-------------------------------------+\n Oggetto: " + t2);
        System.out.println("Superficie: " + t2.superficie);
        System.out.println("Abitanti: " + t2.abitanti);
        System.out.println("Densita: " + t2.densita());


        Territorio1 t3 = new Territorio1(12000 );
        System.out.println("+-------------------------------------+\n Oggetto: " + t3);
        System.out.println("Superficie: " + t3.superficie);
        System.out.println("Abitanti: " + t3.abitanti);
        System.out.println("Densita: " + t3.densita());


        Territorio1 t4 = new Territorio1();
        System.out.println("+-------------------------------------+\n Oggetto: " + t4);
        System.out.println("Superficie: " + t4.superficie);
        System.out.println("Abitanti: " + t4.abitanti);
        System.out.println("Densita: " + t4.densita());


        Territorio1 t5 = new Territorio1("Lombardia", 23863, 10050000);
        Territorio1 t6 = new Territorio1("Sardegna", 24090, 1580000);
        Territorio1 t7 = new Territorio1("Lazio", 17242, 5720000);

        System.out.println("+-------------------------------------+");
        System.out.println(t5);
        System.out.println(t6);
        System.out.println(t7);

    }
}
