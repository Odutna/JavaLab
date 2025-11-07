package com.civiletti.operatori;

public class AssegnazioneBitWise {

    public static void main(String[] args) {

        int x = 10;
        System.out.println("x = " + x + "\t" + Integer.toBinaryString(x));

        System.out.println("=== SHIFT POSITIVO ===");
        x >>>= 1;
        System.out.println("x = " + x + "\t" + Integer.toBinaryString(x));
        x >>= 1;
        System.out.println("x = " + x + "\t" + Integer.toBinaryString(x));

        int m = 5, n = 3;
        int risultato;

        // --- Operazioni bitwise ---
        System.out.println("\n=== OPERAZIONI BITWISE ===");
        risultato = m & n; // risultato diventa 1 (0101 & 0011 = 0001) - And bit a bit
        System.out.println("risultato = " + risultato + "\t" + Integer.toBinaryString(risultato));
        risultato = m | n; // risultato diventa 7 (0101 | 0011 = 0111) - Or bit a bit
        System.out.println("risultato = " + risultato + "\t" + Integer.toBinaryString(risultato));
        risultato = m ^ n; // risultato diventa 6 (0101 ^ 0011 = 0110) - XOR
        System.out.println("risultato = " + risultato + "\t" + Integer.toBinaryString(risultato));
        risultato = ~m; // risultato diventa -6 (complemento a uno di 0101) - Not, o complemento a 1
        System.out.println("risultato = " + risultato + "\t" + Integer.toBinaryString(risultato));

        // --- SHIFT su un valore negativo ---
        System.out.println("\n=== SHIFT SU NEGATIVO ===");
        risultato >>= 1; // risultato diventa -6 (complemento a uno di 0101)
        System.out.println("risultato = " + risultato + "\t" + Integer.toBinaryString(risultato));
        risultato <<= 10; // risultato diventa -6 (complemento a uno di 0101)
        System.out.println("risultato = " + risultato + "\t" + Integer.toBinaryString(risultato));
    }
}
