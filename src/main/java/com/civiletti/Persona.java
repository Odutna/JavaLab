package com.civiletti;

/**
 * Es. 2
 *
 * Classificazione dell'età (con costruttore e metodo)
 *
 * Crea una classe chiamata Persona con un costruttore che accetta l'età.
 * Aggiungi un metodo chiamato classificaEta che determina la categoria
 * in base all'età:
 *
 *  - bambino 0-12 anni
 *  - adolescente 13-17 anni
 *  - adulto 18-64 anni
 *  - anziano >= 65 anni
 *
 */

import java.util.Scanner;

public class Persona {
    int eta;

    // Costruttore
    public Persona(int eta) {
        this.eta = eta;
    }

    // Metodo per classificare l'età
    public String classificaEta() {
        if (eta >= 0 && eta <= 12) return"Sei un bambino.";
        else if (eta >= 13 && eta <= 17) return "Sei un adolescente.";
        else if (eta >= 18 && eta <= 64) return"Sei un adulto.";
        else if (eta >= 65) return "Sei un anziano.";
        else return "Età non valida.";

    }

    //@Override
    public String toString(){

        return "\n" + getClass().getSimpleName() + "{ \n" +
                "\t\t La tua età è: " + eta + "\n" +
                "\t\t Quindi: " + classificaEta() +
                "\n\t\t}";
    }

}

class TestPersona {
    public static void main(String[] args) {

        boolean run = true;
        while(run) {
            System.out.println("Inserisci un'eta': ");
            Scanner sc = new Scanner(System.in);
            int eta = sc.nextInt();

            Persona persona = new Persona(eta);
            //persona.classificaEta();

            System.out.println(persona);

            System.out.println("Continuare? (s/n)");
            String s = sc.next();
            if (s.equals("n")) {
                run = false;
                sc.close();
                System.out.printf("Grazie!");
            }
        }
    }
}