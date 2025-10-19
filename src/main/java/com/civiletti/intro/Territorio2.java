package com.civiletti.intro;

/**
 * Dimostrazione dell'utilizzo dei metodi costruttore
 * variabili di istanza e metodi.
 * Lo scopo di questo lab. è di mostrare come ogni
 * oggetto, in questa implementazione, abbia una
 * propria area di memoria.
 *
 * Come possiamo stampare l'oggetto in modo che abbia
 * una rappresentazione leggibile e significativa che
 * ci consenta di capire cosa contiene?
 */

public class Territorio2 {
    //Variabili
    double superficie; //valore in Kmq
    int abitanti;
    private String nome;

    //Costruttore
    Territorio2( String nome, double s, int a ){
        this.nome = nome;
        superficie = s;
        abitanti = a;
    }

    Territorio2( double s ){
        nome = "Paese o regione";
        superficie = s;
        abitanti = 100000; // default - 100.000 abitanti
    }

    Territorio2( int a ){
        nome = "Paese o regione";
        superficie = 100000; // default - 20.000 Km^2
        abitanti = a;
    }

    Territorio2(){
        nome = "Paese o regione";
        superficie = 100000; // default - 20.000 Km^2
        abitanti = 100000; // default - 100.000 abitanti
    }

    //Metodo densita
    double densita(){
        System.out.println(this.nome);
        return superficie/abitanti;
    }

    public String toString(){
        return "\n" + getClass().getSimpleName() + "{ \n" +
                "   nome: " + nome + ",\n" +
                "   superficie: " + superficie + " km², \n" +
                "   abitanti: " + abitanti + ", \n" +
                "   densita: " + densita() + " ab/km²\n" +
                "}";
    }

    public static void main(String args[]){

        Territorio2 t1 = new Territorio2("Sicilia", 25711.34, 4800000);
        System.out.println("+-------------------------------------+\n\t~~~\nOggetto t1: " + t1 + "\n\t ~~~");
        System.out.println("Superficie: " + t1.superficie);
        System.out.println("Abitanti: " + t1.abitanti);
        System.out.println("Densita: " + t1.densita());

        Territorio2 t2 = new Territorio2(257.3 );
        System.out.println("+-------------------------------------+\n\t~~~\nOggetto t2: " + t2 + "\n\t ~~~");
        System.out.println("Superficie: " + t2.superficie);
        System.out.println("Abitanti: " + t2.abitanti);
        System.out.println("Densita: " + t2.densita());


        Territorio2 t3 = new Territorio2(12000 );
        System.out.println("+-------------------------------------+\n\t~~~\nOggetto t3: " + t3 + "\n\t ~~~");
        System.out.println("Superficie: " + t3.superficie);
        System.out.println("Abitanti: " + t3.abitanti);
        System.out.println("Densita: " + t3.densita());


        Territorio2 t4 = new Territorio2();
        System.out.println("+-------------------------------------+\n\t~~~\nOggetto t4: " + t4 + "\n\t ~~~");
        System.out.println("Superficie: " + t4.superficie);
        System.out.println("Abitanti: " + t4.abitanti);
        System.out.println("Densita: " + t4.densita());


        Territorio2 t5 = new Territorio2("Lombardia", 23863, 10050000);
        Territorio2 t6 = new Territorio2("Sardegna", 24090, 1580000);
        Territorio2 t7 = new Territorio2("Lazio", 17242, 5720000);

        System.out.println("+-------------------------------------+");
        System.out.println(t5);
        System.out.println(t6);
        System.out.println(t7);

    }
}


