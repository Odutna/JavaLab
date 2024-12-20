package com.civiletti.veicolo.v1;

// Classe principale per rappresentare un veicolo
public class Veicolo {

    // Attributi base del veicolo
    private String marca;
    private String modello;
    private String targa;
    private String colore;
    private int annoImmatricolazione;

    // Stato del veicolo
    private boolean acceso;
    private int velocita;
    private int marcia;
    private double chilometri;
    private double carburante;
    private int livelloBatteria;
    private int livelloOlio;
    private int livelloTergicristalli;

    // Stato delle frecce
    private enum StatoFrecce {
        SPENTE, SINISTRA, DESTRA, EMERGENZA
    }
    private StatoFrecce statiFrecce = StatoFrecce.SPENTE;

    // Costruttore
    public Veicolo(String marca, String modello, String targa, String colore, int annoImmatricolazione) {
        setMarca(marca);
        setModello(modello);
        setTarga(targa);
        setColore(colore);
        setAnnoImmatricolazione(annoImmatricolazione);

        // Valori iniziali
        this.acceso = false;
        this.velocita = 0;
        this.marcia = 1;
        this.chilometri = 0;
        this.carburante = 50; // Litri
        this.livelloBatteria = 100;
        this.livelloOlio = 100;
        this.livelloTergicristalli = 100;
        this.statiFrecce = StatoFrecce.SPENTE;
    }

    // Metodi getter e setter
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModello() { return modello; }
    public void setModello(String modello) { this.modello = modello; }

    public String getTarga() { return targa; }
    public void setTarga(String targa) { this.targa = targa; }

    public String getColore() { return colore; }
    public void setColore(String colore) { this.colore = colore; }

    public int getAnnoImmatricolazione() { return annoImmatricolazione; }
    public void setAnnoImmatricolazione(int annoImmatricolazione) { this.annoImmatricolazione = annoImmatricolazione; }


    public int getVelocita() {
        return this.velocita;
    }

    // Getter per lo stato delle frecce (opzionale ma utile)
    public StatoFrecce getStatoFrecce() {
        return statiFrecce;
    }

    // Metodo per spegnere forzatamente le frecce se necessario
    public void spegniFrecce() {
        statiFrecce = StatoFrecce.SPENTE;
        System.out.println("Tutte le frecce disattivate");
    }


    // Metodi di controllo veicolo
    public void accendi() {
        if (!acceso && verificaStatoVeicolo()) {
            acceso = true;
            System.out.println("Veicolo acceso!");
        } else {
            System.out.println("Impossibile accendere il veicolo.");
        }
    }

    public void spegni() {
        if (acceso && velocita == 0) {
            acceso = false;
            System.out.println("Veicolo spento.");
        } else {
            System.out.println("Impossibile spegnere. Fermare prima il veicolo.");
        }
    }

    public void avanza(int velocitaImpostata) {
        if (acceso && marcia > 0) {
            velocita = velocitaImpostata;
            chilometri += velocita * 0.1; // Incremento chilometri
            carburante -= velocita * 0.01; // Consumo carburante
            System.out.println("Veicolo in movimento a " + velocita + " km/h");
        } else {
            System.out.println("Impossibile avanzare.");
        }
    }

    public void accelera() {
        if (acceso && marcia > 0 && velocita < 180) {
            velocita += 10;
            chilometri += velocita * 0.1;
            carburante -= velocita * 0.02;
            System.out.println("Accelerazione. Velocità attuale: " + velocita + " km/h");
        }
    }

    public void frena() {
        if (velocita > 0) {
            velocita = Math.max(0, velocita - 10);
            System.out.println("Frenata. Velocità attuale: " + velocita + " km/h");
        }
    }

    public void cambiaMarcia(boolean superiore) {
        if (acceso) {
            if (superiore && marcia < 6) {
                marcia++;
                System.out.println("Cambiata marcia in avanti. Marcia: " + marcia);
            } else if (!superiore && marcia > 0) {
                marcia--;
                System.out.println("Scalata marcia. Marcia: " + marcia);
            }
        }
    }

    public void retromarcia() {
        if (acceso && velocita == 0) {
            marcia = -1;
            System.out.println("Inserita retromarcia");
        }
    }

    // Metodi per le frecce
    public void attivaFreccia(String direzione) {
        switch (direzione.toLowerCase()) {
            case "sinistra":
                if (statiFrecce == StatoFrecce.SINISTRA) {
                    // Se già attive a sinistra, le spegne
                    statiFrecce = StatoFrecce.SPENTE;
                    System.out.println("Frecce sinistra disattivate");
                } else {
                    // Attiva freccia sinistra
                    statiFrecce = StatoFrecce.SINISTRA;
                    System.out.println("Freccia sinistra attiva");
                }
                break;

            case "destra":
                if (statiFrecce == StatoFrecce.DESTRA) {
                    // Se già attive a destra, le spegne
                    statiFrecce = StatoFrecce.SPENTE;
                    System.out.println("Frecce destra disattivate");
                } else {
                    // Attiva freccia destra
                    statiFrecce = StatoFrecce.DESTRA;
                    System.out.println("Freccia destra attiva");
                }
                break;

            case "emergenza":
                if (statiFrecce == StatoFrecce.EMERGENZA) {
                    // Se già in emergenza, le spegne
                    statiFrecce = StatoFrecce.SPENTE;
                    System.out.println("Frecce di emergenza disattivate");
                } else {
                    // Attiva frecce di emergenza
                    statiFrecce = StatoFrecce.EMERGENZA;
                    System.out.println("Frecce di emergenza attive");
                }
                break;

            default:
                statiFrecce = StatoFrecce.SPENTE;
                System.out.println("Frecce spente");
        }
    }

    // Metodi per i tergicristalli
    public void attivaTogliTergicristalli() {
        if (livelloTergicristalli > 0) {
            System.out.println("Tergicristalli attivati");
        } else {
            System.out.println("Liquido tergicristalli esaurito");
        }
    }

    // Verifica stato veicolo
    private boolean verificaStatoVeicolo() {
        return carburante > 0 &&
                livelloBatteria > 20 &&
                livelloOlio > 20 &&
                livelloTergicristalli > 0;
    }

    // Visualizza quadro strumenti
    public void mostraQuadroStrumenti() {
        System.out.println();
        System.out.println("=== \033[32m  QUADRO INDICATORI  \033[0m ===");
        System.out.println(" Velocità: " + velocita + " km/h");
        System.out.println(" MArcia: " + marcia );
        System.out.println(" Chilometri percorsi: " + String.format("%.2f", chilometri) + " km");
        System.out.println(" Carburante: " + String.format("%.2f", carburante) + " litri");
        System.out.println(" Batteria: " + livelloBatteria + "%");
        System.out.println(" Olio: " + livelloOlio + "%");
        System.out.println(" Liquido tergicristalli: " + livelloTergicristalli + "%");
        System.out.println(" Stato frecce: " + statiFrecce);
        System.out.println("==============================");
    }

    public String toString(){

        return  // getClass().getSimpleName() + "{\n" +
                "\t " +getMarca() + " " + getModello() + "\n" +
                "\t Targa: " + getTarga()
                ;
//               + "}";
    }
}



// Classe di test per il veicolo
//class TestVeicolo {
//    public static void main(String[] args) {
//        Veicolo mioVeicolo = new Veicolo("Fiat", "Panda", "MI123CD", "Bianco", 2018);
//
//        System.out.println("========================================");
//        System.out.println(" " + mioVeicolo );
//        System.out.println("========================================");
//        System.out.println("Accensione veicolo? (s/n)");
//        boolean spento = false;
//        while (new Scanner(System.in).nextLine().charAt(0) == 's') {
//            if(spento) {
//                mioVeicolo.accendi();
//                spento = true;
//            }
//            System.out.println("[1] Cambia Marcia [2] Scala marcia [3] Accelera [4] Frena [5] Stop [6] Spegni veicolo ");
//            mioVeicolo.cambiaMarcia(true); // Prima marcia
//            mioVeicolo.avanza(50);
//            mioVeicolo.attivaFreccia("destra");
//            mioVeicolo.mostraQuadroStrumenti();
//
//            mioVeicolo.accelera();
//            mioVeicolo.frena();
//
//            mioVeicolo.spegni();
//        }
//    }
//}
