package com.civiletti.cifrariocesare;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.util.Scanner;

/**
 * Questo esempio rappresenta un'introduzione al cifrario di Cesare.
 *
 * Il modulo (%), utilizzato nel calcolo della codifica, è essenziale per garantire
 * una ciclazione circolare. Ciò significa che, se si supera il limite massimo
 * rappresentabile per un carattere (es. nel set Unicode), si riparte dal minimo.
 * Questo evita errori o risultati fuori dall'intervallo dei caratteri validi.
 *
 * # Ciclazione con il Modulo (%)
 *
 * La tabella mostra il comportamento del modulo ('%') per numeri da 0 a 15 con divisore 5:
 *
 * | Numero | Divisione Intera (÷) | Resto | Risultato Modulo (%) |
 * |--------|----------------------|-------|----------------------|
 * | 0      | 0 ÷ 5 = 0            | 0     | 0 % 5 = 0            |
 * | 1      | 1 ÷ 5 = 0            | 1     | 1 % 5 = 1            |
 * | 2      | 2 ÷ 5 = 0            | 2     | 2 % 5 = 2            |
 * | 3      | 3 ÷ 5 = 0            | 3     | 3 % 5 = 3            |
 * | 4      | 4 ÷ 5 = 0            | 4     | 4 % 5 = 4            |
 * | 5      | 5 ÷ 5 = 1            | 0     | 5 % 5 = 0            |
 * | 6      | 6 ÷ 5 = 1            | 1     | 6 % 5 = 1            |
 * | 7      | 7 ÷ 5 = 1            | 2     | 7 % 5 = 2            |
 * | 8      | 8 ÷ 5 = 1            | 3     | 8 % 5 = 3            |
 * | 9      | 9 ÷ 5 = 1            | 4     | 9 % 5 = 4            |
 * | 10     | 10 ÷ 5 = 2           | 0     | 10 % 5 = 0           |
 * | 11     | 11 ÷ 5 = 2           | 1     | 11 % 5 = 1           |
 * | 12     | 12 ÷ 5 = 2           | 2     | 12 % 5 = 2           |
 * | 13     | 13 ÷ 5 = 2           | 3     | 13 % 5 = 3           |
 * | 14     | 14 ÷ 5 = 2           | 4     | 14 % 5 = 4           |
 * | 15     | 15 ÷ 5 = 3           | 0     | 15 % 5 = 0           |
 *
 * 1. Il modulo è "circolare": quando il numero raggiunge un multiplo del divisore, torna a '0'.
 * 2. I valori del modulo sono sempre compresi tra '0' e il divisore.
 *
 */
public class CodificaDecodificaCaratteri2 {

    private char lettera;
    private int shift;
    private char letteraCodificata;
    private char letteraDecodificata;
    private boolean codifica;


    public char codificaCaratteri(char carattere, int shift) {
        this.lettera = carattere; // Salva il carattere originale
        this.shift = shift;       // Salva lo shift

        // In Java il tipo char è limitato a 16 bit => 2^16 = 65536
        // System.out.println("<Codifica>");

        int codiceAscii = carattere;  // Converte il carattere nel valore ASCII (122) - il casting è ridondante

        // Applica lo shift con ciclazione grazie al modulo
        int codificaCifra = (codiceAscii + shift) % 65536; // 124
        this.codifica = true;
        this.letteraCodificata = (char) codificaCifra;
        return this.letteraCodificata;  // Converte il nuovo codice ASCII in carattere
    }

    public char decodificaCaratteri(char carattereCodificato, int shift) {
        this.lettera = carattereCodificato; // Salva il carattere codificato
        this.shift = shift;                 // Salva lo shift
//        System.out.println("<Decodifica>");
        int codiceAscii = carattereCodificato;  // Converte in ASCII (124) - il casting è ridondante

        // Decodifica applicando l'inverso dello shift
        // Nota: qui il modulo non è usato perché non si verifica un underflow
        int decodificaCifra = (codiceAscii - shift + 65536) % 65536; // 122
        this.letteraDecodificata = (char) decodificaCifra;
        this.codifica = false;
        return this.letteraDecodificata;  // Riconverte in carattere originale

    }

    public String toString(){
        if (this.codifica) {
            return getClass().getSimpleName() + "{\n" +
                    "\tLettera da codificare: " + lettera + "\n" +
                    "\tShift: " + shift + "\n" +
//                    "\tCodifica: " + codificaCaratteri(this.lettera, this.shift) + "\n" +
                    "\tCodifica: " + letteraCodificata + "\n" +
                    "}\n";
        } else{
            return getClass().getSimpleName() + "{\n" +
                    "\tLettera da codificare: " + lettera + "\n" +
                    "\tShift: " + shift + "\n" +
                    "\tDecodifica: " + letteraDecodificata + "\n" +
//                    "\tDecodifica: " + decodificaCaratteri(this.lettera, this.shift) + "\n" +
                    "}\n";
        }
    }

    public static char inserisciCarattere(Scanner sc) {
        System.out.println("Inserisci il carattere da codificare: ");

        return sc.next().charAt(0);
    }

    public static int inserisciShift(Scanner sc) {
        System.out.println("Inserisci il valore di traslazione: ");

        return sc.nextInt();
    }

    public static void main(String[] args) {

        Charset charset = Charset.defaultCharset();
        CharsetDecoder decoder = charset.newDecoder();
        System.out.println("Il formato di codifica utilizzato per la stringa è: " + decoder.charset()); // UTF-8

        System.out.println("=========================================");
        System.out.println("= Codifica e Decodifica di un carattere =");
        System.out.println("=========================================");

        Scanner sc = new Scanner(System.in);
        CodificaDecodificaCaratteri2 cdc = new CodificaDecodificaCaratteri2();

//        System.out.println("Premi 's' per iniziare");
        char scelta;

        do  {
            System.out.println("[1] Codificare [0] Decodificare [n] Esci");
            scelta = sc.next().charAt(0);
            switch (scelta){
               case '1':
                    System.out.println("===================================");
                    cdc.codificaCaratteri(inserisciCarattere(sc), inserisciShift(sc));
                    System.out.printf(cdc.toString());
                    break;

                case '0':
                    System.out.println("===================================");
                    cdc.decodificaCaratteri(inserisciCarattere(sc), inserisciShift(sc));
                    System.out.printf(cdc.toString());
                    break;
                default:
                    System.out.println("Arrivederci!");
                    break;
            }

        } while (scelta != 'n');
        sc.close();

    }
}

