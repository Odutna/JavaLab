package com.civiletti.intro.visibilita;

public class C2 {

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
        return "C2";
    }
}

class TestC2{
    public static void main(String[] args) {
        C1 c1 = new C1();
        C2 c2 = new C2();

        System.out.println(c2.m1() + " " + c2);
        System.out.println(c1.m2() + " " + c1); // i membri protected hanno visibilità in altri package solo tramite ereditarietà vedi classe C4
        System.out.println(c1.m3() + " " + c1); // i membri default hanno visibilità solo all'interno dello stesso package
    }
}