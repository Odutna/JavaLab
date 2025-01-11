package com.civiletti.clona;

public class ClonaPersona implements Cloneable {
    String nome;

    public ClonaPersona(String nome) {
        this.nome = nome;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public class Main {
        public static void main(String[] args) {
            int[] arrayOriginale = {1, 2, 3, 4};
            int[] arrayClone = arrayOriginale.clone();

            // Modifica del clone
            arrayClone[0] = 99;

            System.out.println("Array Originale: " + arrayOriginale[0]); // Rimane 1
            System.out.println("Array Clone: " + arrayClone[0]); // Diventa 99
        }
    }
}

class TestClonaPersona {
    public static void main(String[] args) throws CloneNotSupportedException {
        ClonaPersona persona1 = new ClonaPersona("Mario");
        ClonaPersona persona2 = (ClonaPersona) persona1.clone();

        System.out.println("Originale: " + persona1.nome);
        System.out.println("Clone: " + persona2.nome);

        // Modifica del clone
        persona2.nome = "Luigi";
        System.out.println("Originale (dopo modifica): " + persona1.nome); // Rimane invariato
    }
}






