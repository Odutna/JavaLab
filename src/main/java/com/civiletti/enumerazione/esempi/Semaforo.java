package com.civiletti.enumerazione.esempi;

public class Semaforo {
    public String stato;
    public enum Colore {
        VERDE, ROSSO, GIALLO, NERO;
    }

    public void cambiaColore(Colore colore) {
        stato= switch(colore) {
            case VERDE -> "La luce è verde!";
            case GIALLO -> "La luce è gialla!";
            case ROSSO -> "La luce è rossa!";
            default -> {
                System.out.println("Gestione di un caso non previsto...");
                yield "Caso non previsto!";
            }
        };
    }

    public void stampaStato() {
        System.out.println(this.stato);
    }
}

class TestSemaforo{
    public static void main(String[] args) {
        Semaforo semaforo = new Semaforo();
        semaforo.cambiaColore(Semaforo.Colore.ROSSO);
        semaforo.stampaStato();
        semaforo.cambiaColore(Semaforo.Colore.VERDE);
        semaforo.stampaStato();
        semaforo.cambiaColore(Semaforo.Colore.GIALLO);
        semaforo.stampaStato();
        semaforo.cambiaColore(Semaforo.Colore.NERO);
        semaforo.stampaStato();
    }
}
