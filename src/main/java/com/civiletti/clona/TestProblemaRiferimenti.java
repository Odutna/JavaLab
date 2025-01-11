package com.civiletti.clona;

class Persona {
    String nome;
    int[] dati; // Attributo che è un riferimento ad un array

    // Costruttore
    public Persona(String nome, int[] dati) {
        this.nome = nome;
        this.dati = dati; // Condivide il riferimento
    }
}

public class TestProblemaRiferimenti{
    public static void main(String[] args) {

        int[] dati = {1, 2, 3};

        // Modifichiamo il dato nell'array
        persona2.dati[0] = 99;

        System.out.println(persona2.dati[0]); // Stampa 99!
    }
}
