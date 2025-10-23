package com.civiletti.intro.visibilita.static_keyword;

public class MathHelper {

    public static int quadrato(int x) {
        return x * x;
    }

    public static int somma(int a, int b) {
        return a + b;
    }
}

class TestMathHelper {

    public static void main(String[] args) {

        System.out.println(MathHelper.quadrato(5)); // ?
        System.out.println(MathHelper.somma(2, 3)); // ?
    }
}

