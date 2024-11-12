package com.civiletti;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class PersonaChaining {

    private String nome;
    private String cognome;
    private String dataNascita;
    private int eta;

    // Metodi getter e setter

    public int getEta() {
        return eta;
    }

    public PersonaChaining setEta(int eta) {
        this.eta = eta;
        return this;
    }


    public String getDataNascita() {
        return dataNascita;
    }

    public PersonaChaining setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
        calcolaEta(dataNascita);
        return this; // Restituisce l'istanza corrente
    }

    public PersonaChaining setNome(String nome) {
        this.nome = nome;
        return this;  // Restituisce l'istanza corrente
    }

    public String getNome() {
        return nome;
    }

    public PersonaChaining setCognome(String cognome) {
        this.cognome = cognome;
        return this;  // Restituisce l'istanza corrente
    }

    public String getCognome() {
        return cognome;
    }

    // Fine metodi getter e setter

    public PersonaChaining calcolaEta(String data) {
        // Definire il formato della data in gg/mm/aaaa
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        int etaYears = 0;
        try {
            // Convertire la stringa in un oggetto LocalDate
            LocalDate dataNascita = LocalDate.parse(data, formatter);
            LocalDate dataAttuale = LocalDate.now();

            // Calcolare l'età
            Period eta = Period.between(dataNascita, dataAttuale);
            //System.out.println("L'età calcolata è: " + eta.getYears() + " anni");
            etaYears = eta.getYears();

        } catch (DateTimeParseException e) {
            System.out.println("Formato della data non valido. Assicurati di usare il formato gg/mm/aaaa.");
        }
        return setEta(etaYears);
    }

    public String toString() {
        return getClass().getSimpleName() + "{\n" +
               "\tNome: " + getNome() + "\n" +
               "\tCognome: " + getCognome() + "\n" +
                "\tNato il: " + getDataNascita() + "\n" +
                "\tEtà: " + getEta() + "\n" +
               "}";
    }

    public static void main(String[] args) {
        PersonaChaining chain = new PersonaChaining();

        chain.setNome("Mario").setCognome("Rossi").setDataNascita("11/11/2000");

        System.out.println(chain);
    }
}
