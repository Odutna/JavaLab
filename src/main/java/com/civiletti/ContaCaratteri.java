package com.civiletti;

import java.util.Scanner;

public class ContaCaratteri {

    public static void main(String[] args) {

        boolean run = true;

        while(run) {
            System.out.println("Inserisci una stringa: ");

            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();

            int count = 0;

            //System.out.println(s.toString().charAt(count));

            for (char c : s.toCharArray()) count++;

            /* Provare - Attenzione non funziona come in C, non c'è un carattere di terminazione della stringa
            while(true){

                if(s.toString().charAt(count) == '\n') break;
                count++;
            }
            */

            System.out.println("La stringa è lunga: " + count + "\nContinuare? (s/n)");

            char c = sc.next().charAt(0);
            if (c == 'n') break;
        }
    }
}
