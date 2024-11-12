package com.civiletti;

import java.util.Scanner;

public class SommaArray {
    static int[] numeri;
    static int somma;

    static int sommaArray(int[] numeri){
        somma = 0;
        for(int num : numeri){
            somma += num;
        }
        return somma;
    }

    @Override
    public String toString(){
        return SommaArray.class.getSimpleName() + "{\n" +
               "\t" +ArrayInserireValori.printArray(numeri) + "\n" +
               "\tSomma: " + sommaArray(numeri) + "\n" +
                "}";
    }
    public static void main(String[] args) {

        ArrayInserireValori aiv = new ArrayInserireValori();

        Scanner sc = new Scanner(System.in);
        numeri = aiv.inserireValori(sc);


        System.out.println("La somma degli elementi dell'array è: " + sommaArray(numeri)); // Attenzione

        sc.close();

        SommaArray sa = new SommaArray();
        System.out.println(sa);

    }
}
