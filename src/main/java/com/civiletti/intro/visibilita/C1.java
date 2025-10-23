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
 * Il metodo m2() è protected, quindi dovrebbe essere accessibile anche in altri package.
 * Tuttavia, il metodo m3() con visibilità package-private (default) espone indirettamente m2().
 *
 */


public class C1 {

    public int m1() {
        return 1;
    }
    protected int m2() {
        return 2;
    }
    int m3() {
        return 3;
    }

    public String toString(){
        return "C1";
    }
}

class TestC1{
    public static void main(String[] args) {
        C1 c = new C1();
        System.out.println(c.m1());
        System.out.println(c.m2()); // i membri protected hanno visibilità in altri package solo tramite ereditarietà vedi classe C4
        System.out.println(c.m3());
    }
}