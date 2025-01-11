package com.civiletti.clona;


class AltraPersona {
    String nome;
    int[] dati;

    // Costruttore normale
    public AltraPersona(String nome, int[] dati) {
        this.nome = nome;
        this.dati = dati; // Condivide il riferimento
    }

    // Costruttore di copia
    public AltraPersona(AltraPersona altraPersona) {
        this.nome = altraPersona.nome; // Copia il valore semplice

        // Clona l'array per evitare il problema dei riferimenti
        this.dati = altraPersona.dati.clone();
    }
}

public class TestFixRiferimenti {

    public static void main(String[] args) {
        int[] dati = {1, 2, 3};
        AltraPersona persona1 = new AltraPersona("Mario", dati);
        AltraPersona persona2 = new AltraPersona(persona1); // Usa il costruttore di copia

        // Modifichiamo il dato nell'array
        persona2.dati[0] = 99;

        System.out.println(persona1.dati[0]); // Rimane 1 (indipendente)
        System.out.println(persona2.dati[0]); // È 99

    }
}