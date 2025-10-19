package com.civiletti.intro.visibilita.test_protected;

import com.civiletti.intro.visibilita.C1; // abbiamo dovuto importarlo perché in altro package

/**
 * Quando chiami m2() dentro C4, Java cerca il metodo nell'ordine:
 *
 * Prima in C4 stesso (non lo trova)
 * Poi nella classe padre C1 (lo trova qui!)
 */


public class C4 extends C1 {  // Ereditarietà!

    public void test() {
        // FUNZIONA - accedi tramite "this": this si riferisce sempre all'oggetto effettivo che è stato creato
        System.out.println(this.m2() + " " + this); // L'oggetto è uno solo: C4 (che ha ereditato m2()) - Esplicito
        System.out.println(m2() + " " + this); // Se C4 avesse fatto override di m2(), chiamerebbe la versione di C4 - Implicito
        System.out.println(super.m2() + " " + this); // Forza l'uso della versione di C1, anche se C4 avesse fatto override

        // NON FUNZIONA - accedi tramite istanza esterna
        C1 istanzaC1 = new C1();
        System.out.println("istanzaC1: " + istanzaC1); // Puoi vedere che è un'istanza DIVERSA
        // System.out.println(altraIstanza.m2()); // ERRORE! protected non accessibile da istanza esterna
    }

    @Override
    public String toString() {
//        return "C4[istanza=" + System.identityHashCode(this) + "]";
        return "C4";
    }
}

class TestC4{
    public static void main(String[] args) {

        C4 c4 = new C4();

        System.out.println("Inizio test..");
        System.out.println(c4.m1() + " " + c4);
        System.out.println("\nChiamo c4.test():");
        c4.test();

        // Decommenta le seguenti righe per verificare gli errori di compilazione:
        // - protected: accessibile da altro package solo tramite ereditarietà (vedi C4)
        // - default: accessibile solo nello stesso package

//        C1 c1 = new C1(); // Crea istanza per testare gli errori
//        System.out.println(c1.m2() + " " + c1); // ERRORE! protected non accessibile tramite istanza diretta da altro package
//        System.out.println(c1.m3() + " " + c1); // ERRORE! default non accessibile da altro package
    }
}