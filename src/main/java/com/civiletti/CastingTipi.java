package com.civiletti;

/**
 * Questa classe illustra i concetti fondamentali del casting in Java, con esempi dettagliati e spiegazioni:
 *
 * 1. **Casting implicito (widening)**: avviene automaticamente quando si converte un tipo di dati più piccolo 
 *    in uno più grande. Questo tipo di conversione è sicuro e non comporta perdita di precisione o dati.
 *    Esempio:
 *    
 *    int numeroInt = 100;
 *    double numeroDouble = numeroInt; // Conversione implicita da int a double
 *   
 *    Ordine di conversione: 'byte -> short -> int -> long -> float -> double'
 *
 * 2. **Casting esplicito (narrowing)**: richiede un cast esplicito per convertire un tipo di dati più grande 
 *    in uno più piccolo. Questa conversione può comportare perdita di dati o precisione.
 *
 *    Esempio:
 *    
 *    double numeroDouble = 123.456;
 *    int numeroInt = (int) numeroDouble; // Conversione esplicita, la parte decimale viene troncata
 *    
 *    Nota: è importante prestare attenzione per evitare comportamenti imprevisti come truncamento dei valori
 *          o perdita di segno.
 *
 * 3. **Promozione numerica**: in operazioni aritmetiche, i tipi di dati più piccoli di 'int' (come 'byte' e 'short')
 *    vengono automaticamente promossi a 'int'.
 *    Esempio:
 *    
 *    byte a = 10;
 *    byte b = 20;
 *    int risultato = a + b; // 'a' e 'b' sono promossi a 'int' per l'operazione
 *
 * **Eccezioni legate al casting**:
 * - In Java, il cast esplicito non genera eccezioni di runtime per il semplice cast tra tipi primitivi; tuttavia, 
 *   ci possono essere problemi di compatibilità o perdita di dati non prevista.
 * - *Operazioni aritmetiche con tipi minori di 'int'*: durante le operazioni con 'byte', 'short' e 'char',
 *    il risultato viene automaticamente promosso a 'int'.
 *   Esempio problematico:

 *   byte x = 7;
 *   byte y = 6;
 *   byte z = (byte) (x + y); // Necessario il cast esplicito per evitare l'errore di tipo

 *   Senza il cast esplicito, il compilatore genererà un errore:
 *
 *             **********************************************
 *             *"possible lossy conversion from int to byte"*.
 *             **********************************************
 *
 * - *Eccezioni durante il casting di tipi non compatibili*: se si tenta di castare tipi di riferimento non
 *    compatibili, si otterrà una 'ClassCastException'.
 *
 *   Esempio:
 *
 *   Object obj = "Test";
 *   Integer num = (Integer) obj; // Lancia ClassCastException a runtime
 *
 * **Nota sui problemi comuni**:
 * - *Perdita di precisione*: la conversione da 'float' o 'double' a 'int' tronca la parte decimale.
 *   Esempio: 'int valore = (int) 7.89; // Risultato: 7'
 * - *Overflow e underflow*: possono verificarsi durante il cast esplicito quando il valore supera il range del tipo.
 *   Esempio: 'byte valore = (byte) 130; // Risultato: -126 (overflow)'
 * - *Compatibilità dei tipi*: il cast tra tipi non numerici (es. 'char' e 'int') può produrre risultati non intuitivi.
 *   Esempio: 'char c = 'A'; int valoreInt = (int) c; // Risultato: 65 (valore ASCII)'
 * - *Eccezioni non gestite*: se il cast non è valido o è applicato in modo improprio, potrebbe generare un errore.
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

        byte x = 7;
        byte y = 6;
        byte z = (byte) (x + y);
    }
}


