package com.civiletti;

import java.util.Scanner;

/**
 * Classe che simula diversi modi di implementare il metodo length() di String
 * @author civiletti
 * @version 1.0
 */

public class ContaCaratteri2 {
    int conta;

    /**
     * Implementazione che usa charAt() e gestisce l'eccezione
     * @param s stringa in input
     * @return lunghezza della stringa
     */
    public int lengthStringa1(String s) {
        this.conta = 0;
        try {
            while (true) {
                s.charAt(this.conta);
                this.conta++;
            }
        } catch (IndexOutOfBoundsException e) {
            // Esce dal ciclo quando si raggiunge la fine della stringa
        }
        return this.conta;
    }

    /**
     * Implementazione che usa toCharArray()
     * @param s stringa in input
     * @return lunghezza della stringa
     */
    public int lengthStringa2(String s) {
        this.conta = 0;
        for (char c : s.toCharArray())
            this.conta++;
        return this.conta;
    }

    /**
     * Implementazione che usa direttamente length()
     * @param s stringa in input
     * @return lunghezza della stringa
     */
    public int lengthStringa3(String s) {
        return s.length();
    }

    public static void main(String[] args) {

        ContaCaratteri2 cc = new ContaCaratteri2();
        Scanner sc = new Scanner(System.in);

        int metodo = 0;

        do {

            System.out.println("Inserisci una stringa: ");

            String s = sc.nextLine();

            switch (metodo) {
                case 0:
                    System.out.print("lengthStringa1(): \n...lunghezza stringa " + cc.lengthStringa1(s) + "\n");
                    metodo++;
                    break;
                case 1:
                    System.out.print("lengthStringa2(): \n...lunghezza stringa " + cc.lengthStringa2(s) + "\n");
                    metodo++;
                    break;
                case 2:
                    System.out.print("lengthStringa3() \n...lunghezza stringa " + cc.lengthStringa3(s) + "\n");
                    metodo=0;
                    break;
            }

            System.out.println("Continuare? (s/n)");

        } while( sc.nextLine().charAt(0) != 'n');

        System.out.println("Arrivederci!");

        sc.close();
    }
}