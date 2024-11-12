package com.civiletti;

public class Studente {
    private String nome;
    private int eta;

    // Costruttore con parametri
    public Studente(String nome, int eta) {
        this.nome = nome; // 'this.nome' si riferisce alla variabile di istanza, 'nome' al parametro
        this.eta = eta;
    }

    // Metodo che mostra l'uso di 'this' come restituzione dell'istanza corrente
    public Studente setNome(String nome) {
        this.nome = nome;
        return this; // Restituisce l'istanza corrente
    }

    // Metodo per stampare i dettagli dello studente
    public void mostraDettagli() {
        System.out.println("Nome: " + this.nome + ", Età: " + this.eta);
    }
}

class Test {
    public static void main(String[] args) {

        Studente s = new Studente("Mario", 20);
        s.setNome("Luca").mostraDettagli(); // return this; permette al metodo setNome di restituire l’istanza corrente
                                            // della classe 'Studente', consentendo un concatenamento di metodi.

    }
}