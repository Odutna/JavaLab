package com.civiletti.exception;

// Exception personalizzata
class SaldoInsufficienteException extends Exception {
    public SaldoInsufficienteException(String messaggio) {
        super(messaggio);
    }
}

// Classe che rappresenta un conto bancario
public class ContoBancario {
    private String titolare;
    private double saldo;

    // Costruttore
    public ContoBancario(String titolare, double saldoIniziale) {
        this.titolare = titolare;
        this.saldo = saldoIniziale;
    }

    // Metodo per prelevare denaro
    public void preleva(double importo) throws SaldoInsufficienteException {
        if (importo > saldo) {
            throw new SaldoInsufficienteException("Saldo insufficiente per prelevare " + importo + " euro.");
        }
        saldo -= importo;
        System.out.println("Prelievo effettuato: " + importo + " euro. Saldo rimanente: " + saldo + " euro.");
    }

    // Metodo per depositare denaro
    public void deposita(double importo) {
        saldo += importo;
        System.out.println("Deposito effettuato: " + importo + " euro. Saldo attuale: " + saldo + " euro.");
    }

    // Metodo per ottenere il saldo
    public double getSaldo() {
        return saldo;
    }
}

class TestEccezioniPersonalizzate {
    public static void main(String[] args) {
        ContoBancario conto = new ContoBancario("Mario Rossi", 100.0);

        try {
            // Prova a prelevare un importo che supera il saldo
            conto.preleva(150.0);
        } catch (SaldoInsufficienteException e) {
            System.err.println("Errore: " + e.getMessage());
        }

        // Effettua un deposito
        conto.deposita(50.0);

        try {
            // Prova un prelievo che dovrebbe funzionare
            conto.preleva(50.0);
        } catch (SaldoInsufficienteException e) {
            System.err.println("Errore: " + e.getMessage());
        }
    }
}

