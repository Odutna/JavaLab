package com.civiletti;

/**
 * Es. 6
 *
 * Determinazione del giorno della settimana (con costruttore e metodo)
 *
 * Crea una classe chiamata GiornoSettimana che accetta un numero (1-7)
 * nel costruttore.
 * Aggiungi un metodo chiamato determinazioneGiorno che restituisce il
 * nome del giorno della settimana.
 */

import java.util.Scanner;

public class GiornoSettimana {
    int numero;

    // Costruttore
    public GiornoSettimana(int numero) {
        this.numero = numero;
    }

    // Metodo per determinare il giorno della settimana
    public void determinazioneGiorno() {
        switch(numero) {
            case 1:
                System.out.println("Lunedì");
                break;
            case 2:
                System.out.println("Martedì");
                break;
            case 3:
                System.out.println("Mercoledì");
                break;
            case 4:
                System.out.println("Giovedì");
                break;
            case 5:
                System.out.println("Venerdì");
                break;
            case 6:
                System.out.println("Sabato");
                break;
            case 7:
                System.out.println("Domenica");
                break;
            default:
                System.out.println("Numero non valido.");
        }
    }
}

class TestGiornoSettimana {
    public static void main(String[] args) {

        System.out.println("Insersci il numero di un giorno della settimana: ");

        Scanner sc = new Scanner(System.in);
        int numero = sc.nextInt();

        GiornoSettimana giorno = new GiornoSettimana(numero);
        giorno.determinazioneGiorno();
    }
}

