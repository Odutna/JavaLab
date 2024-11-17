package com.civiletti;

/**
 * Questa classe dimostra i concetti fondamentali del casting in Java:
 * 1. Casting implicito (widening): conversione automatica da un tipo più piccolo a uno più grande
 *    byte -> short -> int -> long -> float -> double
 * 2. Casting esplicito (narrowing): conversione esplicita da un tipo più grande a uno più piccolo
 *    richiede cast esplicito e può comportare perdita di dati
 * 3. Promozione numerica: le operazioni aritmetiche promuovono automaticamente i tipi
 *    più piccoli di int a int
 *
 * @author civiletti
 * @version 1.0
 */
public class CastingTipi {
    short a, b;

    /**
     * Costruttore che accetta byte. Dimostra il casting implicito da byte a short
     * poiché byte (8 bit) può essere contenuto in short (16 bit) senza perdita di dati
     * @param a primo numero
     * @param b secondo numero
     */
    CastingTipi (byte a, byte b) {
        this.a = a;  // casting implicito da byte a short
        this.b = b;  // casting implicito da byte a short
    }

    /**
     * Costruttore che accetta short. Non richiede casting poiché i tipi coincidono
     * @param a primo numero
     * @param b secondo numero
     */
    CastingTipi (short a, short b) {
        this.a = a;
        this.b = b;
    }

    /* Questo costruttore non compila perché richiede un casting esplicito:
    CastingTipi (int a, int b) {
        this.a = a;  // Errore: possibile perdita di dati da int (32 bit) a short (16 bit)
        this.b = b;
    }
    */

    /* Questo costruttore non compila per lo stesso motivo:
    CastingTipi (long a, long b) {
        this.a = a;  // Errore: possibile perdita di dati da long (64 bit) a short (16 bit)
        this.b = b;
    }
    */
}

class CastTest {
    public static void main(String[] args) {
        // Visualizzazione delle dimensioni in bit dei tipi primitivi
        System.out.println("Dimensioni dei tipi primitivi in bit:");
        System.out.println("byte: " + Byte.SIZE + " - short: " + Short.SIZE  +
                " - int: " + Integer.SIZE + " - long: " + Long.SIZE +
                " - float: " + Float.SIZE + " - double: " + Double.SIZE);

        // Esempio 1: Casting con costruttore
        CastingTipi ct = new CastingTipi((short)5, (short)2);

        // Esempio 2: Dimostrazione della promozione numerica nelle operazioni
        long c = (byte)(ct.a + ct.b);  // Il risultato di (a + b) è int, poi cast a byte, poi a long
        System.out.println("Cast a byte poi promozione a long: " + c);

        c = (short)(ct.a + ct.b);      // Il risultato di (a + b) è int, poi cast a short, poi a long
        System.out.println("Cast a short poi promozione a long: " + c);

        // Casting implicito: il risultato di (a + b) è già int, viene promosso implicitamente a long
        c = (ct.a + ct.b);
        System.out.println("Promozione implicita a long: " + c);

        // Esempio 3: Dimostrazione di perdita di dati nel casting
        System.out.println("\nDimostrazione di possibile perdita di dati:");
        int grandeNumero = 32768;  // 2^15, troppo grande per short
        short numeroRidotto = (short)grandeNumero;
        System.out.println("Originale (int): " + grandeNumero);
        System.out.println("Dopo cast a short: " + numeroRidotto);  // Mostra overflow

        // Esempio 4: Casting con numeri decimali
        System.out.println("\nCasting con numeri decimali:");
        double d = 3.14159;
        float f = (float)d;    // Richiede cast esplicito
        int i = (int)d;        // Tronca la parte decimale
        System.out.println("Double: " + d);
        System.out.println("Cast a float: " + f);
        System.out.println("Cast a int: " + i);

        // Esempio 5: Casting con byte
        CastingTipi ct1 = new CastingTipi((byte)1, (byte)2);
        byte risultatoByte = (byte)(ct1.a + ct1.b);
        System.out.println("\nOperazioni con byte:");
        System.out.println("Somma cast a byte: " + risultatoByte);
    }
}