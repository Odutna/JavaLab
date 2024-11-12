package com.civiletti;

import java.util.Scanner;

public class ArrayString2 {



    public String inserisciStringa(Scanner sc) {
        System.out.println("Inserisci una stringa:");
        return sc.nextLine();  // Legge l'intera riga di input mentre next() si ferma al primo spazio " "
    }

    public int contaSpazi(String s) {
        int conta = 0;
        //String[] arrayS = s.split("");
        for(int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                conta++;
            }
        }
        return conta;
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayString2 as = new ArrayString2();

        String s = as.inserisciStringa(sc);


        System.out.println("Stringa inserita: " + s);
        int i = as.contaSpazi(s);
        System.out.println("Numero di spazi: " + i);


        //System.out.println(as);
    }
}
