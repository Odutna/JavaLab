package com.civiletti.intro.visibilita.static_keyword;

public class CStatic6 {
    static int valoreCondiviso = 0;

    public static void incrementa() {
        valoreCondiviso++;
    }
}

class TestCStatic6 {

    public static void main(String[] args) {

        CStatic6.incrementa();
        System.out.println(CStatic6.valoreCondiviso); // 1

        CStatic6.valoreCondiviso = -999; // accesso diretto: pericoloso!
        System.out.println(CStatic6.valoreCondiviso); // -999
    }
}


