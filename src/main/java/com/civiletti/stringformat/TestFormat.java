package com.civiletti.stringformat;

public class TestFormat {
    public static void main(String[] args) {
        // Dichiarazione di una stringa
        String string;

        // Esempio con formato stringa e carattere
        String s = "mondo";
        char c = '!';
        string = String.format("Ciao %s%c", s, c);
        System.out.println(string); // Output: Ciao mondo!

        // Esempio con formato intero
        int i = 42;
        string = String.format("Il valore è %d", i);
        System.out.println(string); // Output: Il valore è 42

        // Esempio con formato esadecimale
        string = String.format("Il valore è %x", i);
        System.out.println(string); // Output: Il valore è 2a (42 in esadecimale)

        // Esempio con formato decimale a virgola mobile
        double d = Math.PI; // Pi greco
        string = String.format("Il valore è %f", d);
        System.out.println(string); // Output: Il valore è 3.141593

        // Esempio con notazione scientifica
        d = 6.02214076E23; // Numero di Avogadro
        string = String.format("Il valore è %e", d);
        System.out.println(string); // Output: Il valore è 6.022141e+23

        // Esempio con formato booleano
        boolean b = (i % 2 == 0); // Controllo se i è pari
        string = String.format("%d è pari: %b", i, b);
        System.out.println(string); // Output: 42 è pari: true
    }
}

