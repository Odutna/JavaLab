package com.civiletti.enumerazione.ordine;

enum StatoOrdine {
    CREATO(false),
    IN_PROCESSAMENTO(false),
    SPEDITO(false),
    CONSEGNATO(true),
    ANNULLATO(true);

    private final boolean statoFinale;

    StatoOrdine(boolean statoFinale) {
        this.statoFinale = statoFinale;
    }

    public boolean isStatoFinale() { return statoFinale; }
}

class Ordine {
    private StatoOrdine stato;
    private final String numeroOrdine;

    public Ordine(String numeroOrdine) {
        this.numeroOrdine = numeroOrdine;
        this.stato = StatoOrdine.CREATO;
    }

    public void aggiornaStato(StatoOrdine nuovoStato) {
        if (stato.isStatoFinale()) {
            throw new IllegalStateException("Non puoi modificare un ordine in stato finale");
        }
        this.stato = nuovoStato;
    }

    public static void main(String[] args) {
        Ordine ordine = new Ordine("ORD-001");
        System.out.println("Stato iniziale: " + ordine.stato);

        ordine.aggiornaStato(StatoOrdine.IN_PROCESSAMENTO);
        System.out.println("Nuovo stato: " + ordine.stato);

        ordine.aggiornaStato(StatoOrdine.SPEDITO);
        System.out.println("Stato finale: " + ordine.stato);
    }
}
