package com.civiletti;

public class WrapperTestCast {
    public static void main(String[] args) {
        int x = 10;
        Integer y = 10;       // Autoboxing → il valore 10 viene “impacchettato” in un oggetto Integer
        Integer z = new Integer(10); // Creazione esplicita di un nuovo oggetto (deprecata)

        System.out.println(x == y);  // true → y viene “unboxed” e confrontato come valore int
        System.out.println(y == z);  // false → sono due oggetti diversi in memoria
        System.out.println(y.equals(z)); // true → confronta il valore contenuto (10 == 10)
    }
}

