package com.civiletti.rubrica;

public class Rubrica {
    private Contatto[] contatti;
    private int indiceCorrente;

    public Rubrica(int dimensione) {
        contatti = new Contatto[dimensione];
        indiceCorrente = 0;
    }

    public void aggiungiContatto(Contatto contatto) {
        if (indiceCorrente < contatti.length) {
            contatti[indiceCorrente++] = contatto;
            System.out.println("Contatto aggiunto!");
        } else {
            System.out.println("Rubrica piena, impossibile aggiungere altri contatti.");
        }
    }

    public void rimuoviContatto(String nome) {
        for (int i = 0; i < indiceCorrente; i++) {
            if (contatti[i] != null && contatti[i].getNome().equalsIgnoreCase(nome)) {
                // Spostamento degli elementi successivi
                for (int j = i; j < indiceCorrente - 1; j++) {
                    contatti[j] = contatti[j + 1];
                }
                contatti[--indiceCorrente] = null;
                System.out.println("Contatto rimosso!");
                return;
            }
        }
        System.out.println("Contatto non trovato.");
    }

    public void cercaContatto(String nome) {
        for (int i = 0; i < indiceCorrente; i++) {
            if (contatti[i] != null && contatti[i].getNome().equalsIgnoreCase(nome)) {
                contatti[i].visualizzaDettagli();
                return;
            }
        }
        System.out.println("Contatto non trovato.");
    }

    public void visualizzaRubrica() {
        if (indiceCorrente == 0) {
            System.out.println("La rubrica è vuota.");
            return;
        }
        for (int i = 0; i < indiceCorrente; i++) {
            contatti[i].visualizzaDettagli();
            System.out.println("=====================");
        }
    }
}

