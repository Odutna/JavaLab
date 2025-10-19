package com.civiletti.intro.visibilita.test_protected;

import com.civiletti.intro.visibilita.C1;

public class C3 {

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
        return "C3";
    }
}

class TestC3{
    public static void main(String[] args) {

        C3 c2 = new C3();

        System.out.println(c2.m1() + " " + c2);

        // Decommenta le seguenti righe per verificare:
        // - protected: accessibile da altro package solo tramite ereditarietà (vedi C4)
        // - default: accessibile solo nello stesso package

        C1 c1 = new C1(); // abbiamo dovuto importarlo perché in altro package
//        System.out.println(c1.m2() + " " + c1); // gli attributi protected hanno visibilità in altri package solo tramite ereditarietà vedi classe C4
//        System.out.println(c1.m3() + " " + c1); // gli attributi default hanno visibilità solo all'interno dello stesso package
    }
}