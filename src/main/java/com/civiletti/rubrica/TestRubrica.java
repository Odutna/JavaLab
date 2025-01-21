package com.civiletti.rubrica;

public class TestRubrica {

    public static void main(String[] args) {
        Rubrica rubrica = new Rubrica(100);

        ContattoPersonale mario = new ContattoPersonale("Mario", "Rossi", "1234567890", "mario@example.com", "01/01/1990");
        ContattoProfessionale luigi = new ContattoProfessionale("Luigi", "Verdi", "0987654321", "TechCorp", "Developer");

        rubrica.aggiungiContatto(mario);
        rubrica.aggiungiContatto(luigi);

        System.out.println("\nRubrica completa:");
        rubrica.visualizzaRubrica();

        System.out.println("\nCerca contatto 'Mario':");
        rubrica.cercaContatto("Mario");

        System.out.println("\nRimuovi contatto 'Luigi':");
        rubrica.rimuoviContatto("Luigi");

        System.out.println("\nRubrica aggiornata:");
        rubrica.visualizzaRubrica();
    }
}

