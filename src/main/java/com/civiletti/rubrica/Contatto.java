package com.civiletti.rubrica;

public class Contatto {
    private String nome;
    private String cognome;
    private String telefono;

    public Contatto(String nome, String cognome, String telefono) {
        setNome(nome);
        setCognome(cognome);
        setTelefono(telefono);
    }

    // Getter e Setter
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        // Controllo per numeri validi (opzionale)
        if (telefono.matches("\\d+")) { // Solo cifre
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("Il numero di telefono deve contenere solo cifre.");
        }
    }

    public void visualizzaDettagli() {
        System.out.println("Nome: " + getNome());
        System.out.println("Cognome: " + getCognome());
        System.out.println("Telefono: " + getTelefono());
    }
}


class TestContatto {

    public static String miaClasse(){
        return TestContatto.class.getSimpleName();
    }

    public static void main(String[] args) {

        System.out.println("=====================");
        System.out.println("\t" + miaClasse());
        System.out.println("=====================");

        Contatto mario = new Contatto("Mario", "Rossi", "1234567890");

        System.out.println("Dettagli Mario:");
        mario.visualizzaDettagli();

        // Modifica i dati
        mario.setTelefono("9876543210");

        System.out.println("\nDettagli Mario (aggiornati):");
        mario.visualizzaDettagli();
    }
}


