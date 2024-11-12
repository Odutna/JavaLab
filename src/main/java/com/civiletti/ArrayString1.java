package com.civiletti;

import java.util.Scanner;

public class ArrayString1 {

    public String inserisciStringa(Scanner sc) {
        System.out.println("Inserisci una stringa:");
        return sc.nextLine();  // Legge l'intera riga di input mentre next() si ferma al primo spazio " "
    }

    public int contaSpazi(String s) {
        int conta = 0; // Contatore per gli spazi

        String[] arrayS = s.split(""); // Array di stringhe

        for (String s1 : arrayS) {
            if (s1.equals(" ")) {  // !!! Usare equals per confrontare le stringhe !!!
                conta++;
            }
            System.out.print(" " +s1); // Test
        }
        System.out.println(arrayS.length);
        return conta;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayString1 as = new ArrayString1();

        String s = as.inserisciStringa(sc);

        System.out.println("Stringa inserita: " + s);

        int i = as.contaSpazi(s);
        System.out.println("Numero di spazi: " + i);

        System.out.println(as);
    }
}
