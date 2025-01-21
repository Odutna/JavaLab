package com.civiletti.rubrica;


public class ContattoPersonale extends Contatto {
    private String email;
    private String dataNascita;

    public ContattoPersonale(String nome, String cognome, String telefono, String email, String dataNascita) {
        super(nome, cognome, telefono);
        setEmail(email);
        setDataNascita(dataNascita);
    }

    // Getter e Setter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email.contains("@")) { // Validazione semplice
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email non valida.");
        }
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    @Override
    public void visualizzaDettagli() {
        super.visualizzaDettagli();
        System.out.println("Email: " + getEmail());
        System.out.println("Data di Nascita: " + getDataNascita());
    }
}

class TestContattoPersonale {

    public static String miaClasse(){
        return TestContattoPersonale.class.getSimpleName();
    }

    public static void main(String[] args) {

        System.out.println("=====================");
        System.out.println(  miaClasse() );
        System.out.println("=====================");

        ContattoPersonale mario = new ContattoPersonale("Mario", "Rossi", "1234567890", "mario@example.com", "01/01/1990");

        System.out.println("Dettagli Mario:");
        mario.visualizzaDettagli();

        // Modifica i dati
        mario.setTelefono("9876543210");
        mario.setEmail("mario.rossi@example.com");

        System.out.println("\nDettagli Mario (aggiornati):");
        mario.visualizzaDettagli();
    }
}
