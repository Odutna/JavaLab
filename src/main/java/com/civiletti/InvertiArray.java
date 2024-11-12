package com.civiletti;

import java.util.Scanner;


public class InvertiArray {

    int dim;
    int[] numeri;
    int[] arrayInvertito;

    InvertiArray(Scanner sc) {
        this.numeri = inserisciArray(sc);
        this.arrayInvertito = invertiArray(this.numeri);
    }

    public int[] inserisciArray(Scanner sc){

        System.out.print("Quanti numeri vuoi inserire? ");
        this.dim = sc.nextInt();
        this.numeri = new int[dim];

        // Inserimento dei numeri
        System.out.println("Inserisci " + this.dim + " numeri:");

        for (int i = 0; i < this.dim; i++) {
            System.out.print("Numero (" + (i + 1) + "): ");
            this.numeri[i] = sc.nextInt();
        }
        return this.numeri;
    }

    public int[] invertiArray(int[] numeri) {
        this.arrayInvertito = new int[numeri.length];
        // Inversione dell'array
        for (int i = numeri.length - 1; i >= 0; i--) {
            this.arrayInvertito[numeri.length -1 - i] = this.numeri[i];
        }
        return this.arrayInvertito;
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

        return InvertiArray.class.getSimpleName() +"{\n" +
               "\t  array inserito:"  + printArray(this.numeri) + "\n" +
               "\t array invertito:" + printArray(this.arrayInvertito) +"\n" +
               "}";
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InvertiArray ia = new InvertiArray(scanner);
        scanner.close();
        System.out.println(ia);
    }
}
