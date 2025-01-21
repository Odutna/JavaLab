package com.civiletti.rubrica;

public class ContattoProfessionale extends Contatto {
    private String azienda;
    private String ruolo;

    public ContattoProfessionale(String nome, String cognome, String telefono, String azienda, String ruolo) {
        super(nome, cognome, telefono);
        setAzienda(azienda);
        setRuolo(ruolo);
    }

    // Getter e Setter
    public String getAzienda() {
        return azienda;
    }

    public void setAzienda(String azienda) {
        this.azienda = azienda;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    @Override
    public void visualizzaDettagli() {
        super.visualizzaDettagli();
        System.out.println("Azienda: " + getAzienda());
        System.out.println("Ruolo: " + getRuolo());
    }
}

class TestContattoProfessionale {

    public static String miaClasse(){
        return TestContattoProfessionale.class.getSimpleName();
    }

    public static void main(String[] args) {

        System.out.println("=====================");
        System.out.println(  miaClasse() );
        System.out.println("=====================");

        ContattoProfessionale luigi = new ContattoProfessionale("Luigi", "Verdi", "0987654321", "TechCorp", "Developer");

        System.out.println("Dettagli Luigi:");
        luigi.visualizzaDettagli();

        // Modifica i dati
        luigi.setAzienda("InnovaTech");
        luigi.setRuolo("Senior Developer");

        System.out.println("\nDettagli Luigi (aggiornati):");
        luigi.visualizzaDettagli();
    }
}
