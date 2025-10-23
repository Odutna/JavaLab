package com.civiletti.intro.visibilita;

/**
 *
 *     private: visibilità solo all'interno della stessa classe
 *     default (package-private): visibilità solo all'interno dello stesso package
 *     protected: visibilità nello stesso package E nelle sottoclassi (anche in altri package)
 *     public: visibilità ovunque
 *
 *     Modificatore   Stessa classe    Stesso package    Sottoclasse (altro package)    Qualsiasi classe
 *     private          ✅ Sì            ❌ No                ❌ No                        ❌ No
 *     default          ✅ Sì            ✅ Sì                ❌ No                        ❌ No
 *     protected        ✅ Sì            ✅ Sì                ✅ Sì (solo Ereditarietà)    ❌ No
 *     public           ✅ Sì            ✅ Sì                ✅ Sì                        ✅ Sì
 *
 * Il metodo m2() è private, quindi dovrebbe essere accessibile solo internamente alla classe C.
 * Tuttavia, il metodo m3() con visibilità package-private (default) espone indirettamente m2().
 *
 */

public class C {

    public int m1() {
        return 1;
    }
    private int m2() {
        return 2;
    }
    int m3() {
        return m2();
    }
}

class TestC{
    public static void main(String[] args) {
        C c = new C();
        System.out.println(c.m1());
//        System.out.println(c.m2()); // Gli attributi privati hanno visibilità solo all'interno della stessa classe
        System.out.println(c.m3());   // La visibilità dei metodi va pensata attentamente!
    }
}