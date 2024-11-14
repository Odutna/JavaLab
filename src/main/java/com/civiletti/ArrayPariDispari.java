package com.civiletti;

import java.util.Scanner;

class Dati{
    int dim;
    static int[] numeri;
    static int pari, dispari;
}

public class ArrayPariDispari {


    Dati d = new Dati();


    ArrayPariDispari(Scanner sc) {

        d.numeri = inserisciArray(sc);

        //this.arrayInvertito = invertiArray(this.numeri);
    }

    public int[] inserisciArray(Scanner sc){

        System.out.print("Quanti numeri vuoi inserire? ");
        d.dim = sc.nextInt();
        d.numeri = new int[d.dim];

        // Inserimento dei numeri
        System.out.println("Inserisci " + d.dim + " numeri:");

        for (int i = 0; i < d.dim; i++) {
            System.out.print("Numero (" + (i + 1) + "): ");
            d.numeri[i] = sc.nextInt();
        }
        return d.numeri;
    }

    public Dati conraPari(int[] numeri) {
        d.pari = 0;
        d.dispari = 0;
        // Inversione dell'array
        for (int i = numeri.length - 1; i >= 0; i--) {
            if(numeri[i] %2 == 0){
                d.pari++;
            } else d.dispari++;
        }
        return this.d;
    }

    public static String printArray(int[] array) {
        // Stampa dei numeri inseriti
        String arrayString = " [ ";
        int index = 0;
        for (int num : array) { // for-each
            if(index != array.length - 1) {
                arrayString += num + ", ";
            } else arrayString += num + " ]";
            index++;
        }
        return arrayString;
    }

    @Override
    public String toString() {

        return InvertiArray2.class.getSimpleName() +"{\n" +
                "\t array inserito:"  + printArray(d.numeri) + "\n" +
                "\t elementi pari: " + d.pari +"\n" +
                "\t elementi dispari : " + d.dispari +"\n" +
                "}";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayPariDispari apd = new ArrayPariDispari(scanner);
        scanner.close();
        Dati d = new Dati();
        apd.conraPari(d.numeri);
        System.out.println(apd);
    }
}

