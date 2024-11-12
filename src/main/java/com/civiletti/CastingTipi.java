package com.civiletti;


public class CastingTipi {
    short a, b;

    CastingTipi (byte a, byte b) {
        this.a = a;
        this.b = b;
    }

    CastingTipi (short a, short b) {
        this.a = a;
        this.b = b;
    }

    /* Che conclusioni trai?
    CastingTipi (int a, int b) {
        this.a = a;
        this.b = b;
    }
    */

    /* Che conclusioni trai?
    CastingTipi (long a, long b) {
        this.a = a;
        this.b = b;
    }
     */

}

class Main{

    public static void main(String[] args) {

        System.out.println("byte: " + Byte.SIZE + " - short: " + Short.SIZE  + " - int: " + Integer.SIZE + "- long: " + Long.SIZE + "- float: " + Float.SIZE + "- double: " + Double.SIZE);
//        short a = 5;
//        short b = 2;  // Command SHIFT 7

        CastingTipi ct = new CastingTipi((short)5, (short)2);

        long c = (byte)(ct.a + ct.b);

        System.out.println(c);

        c = (short) (ct.a + ct.b);
        System.out.println(c);

        c = (int) (ct.a + ct.b);  // Conversione implicita
        c = (ct.a + ct.b);
        System.out.println(c);

        c  = (long) (ct.a + ct.b); // Conversione implicita
        c  = (ct.a + ct.b);
        System.out.println(c);

        System.out.println("+-----+");
        System.out.println("   " + (byte) c);
        System.out.println("   " + (short) c);
        System.out.println("   " + (int) c);
        System.out.println("+-----+");

        CastingTipi ct1 = new CastingTipi((byte) 1, (byte) 2);
        int d = (byte)(ct1.a + ct1.b);
        System.out.println(d);

        short e = (byte)(ct1.a + ct1.b);
        System.out.println(e);


    }
}