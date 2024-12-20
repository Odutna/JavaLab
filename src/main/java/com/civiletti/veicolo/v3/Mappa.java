package com.civiletti.veicolo.v3;

import java.util.Arrays;

public class Mappa {
    private String[][] mappa;
    private int righe;
    private int colonne;
    private int posizioneAttualeX;
    private int posizioneAttualeY;
    private static final String PUNTO = "····";
    private static final String AUTO = "·🚗·";

    public Mappa(int righe, int colonne) {
        this.righe = righe;
        this.colonne = colonne;
        this.mappa = new String[righe][colonne];

        // Inizializza la mappa con i puntini
        for (int i = 0; i < righe; i++) {
            Arrays.fill(mappa[i], PUNTO);
        }

        // Posiziona l'auto al centro
        posizioneAttualeX = righe / 2;
        posizioneAttualeY = colonne / 2;
        mappa[posizioneAttualeX][posizioneAttualeY] = AUTO;
    }

    public void aggiornaPosizioneVeicolo(Veicolo veicolo, String direzione) {
        // Rimuovi l'auto dalla posizione corrente
        mappa[posizioneAttualeX][posizioneAttualeY] = PUNTO;

        // Calcola lo spostamento basato su velocità e marcia
        int spostamento = calcolaSpostamento(veicolo.getVelocita());

        switch (direzione) {
            case "avanti":
                muoviAvanti(spostamento);
                break;
            case "indietro":
                muoviIndietro(spostamento);
                break;
            case "destra":
                muoviDestra(spostamento);
                break;
            case "sinistra":
                muoviSinistra(spostamento);
                break;
        }

        // Posiziona l'auto nella nuova posizione
        mappa[posizioneAttualeX][posizioneAttualeY] = AUTO;
    }

    private int calcolaSpostamento(int velocita) {
        // Logica per calcolare lo spostamento basato sulla velocità
        if (velocita <= 10) return 1;
        if (velocita <= 30) return 2;
        if (velocita <= 50) return 3;
        if (velocita <= 70) return 4;
        return 5; // Massimo spostamento
    }

    private void muoviAvanti(int spostamento) {
        // Muovi verso l'alto (diminuendo X)
        posizioneAttualeX = Math.max(0,
                Math.min(righe - 1, posizioneAttualeX - spostamento));
    }

    private void muoviIndietro(int spostamento) {
        // Muovi verso il basso (aumentando X)
        posizioneAttualeX = Math.max(0,
                Math.min(righe - 1, posizioneAttualeX + spostamento));
    }

    private void muoviDestra(int spostamento) {
        // Muovi verso destra (aumentando Y)
        posizioneAttualeY = Math.max(0,
                Math.min(colonne - 1, posizioneAttualeY + spostamento));
    }

    private void muoviSinistra(int spostamento) {
        // Muovi verso sinistra (diminuendo Y)
        posizioneAttualeY = Math.max(0,
                Math.min(colonne - 1, posizioneAttualeY - spostamento));
    }

    public void stampaMappa() {
        System.out.println("\n--- MAPPA VEICOLO ---");
        System.out.println("=".repeat(righe*4));
        for (String[] riga : mappa) {
            for (String cella : riga) {
                System.out.print(cella + "");
            }
            System.out.println();
        }
        System.out.println("=".repeat(righe*4));
    }

    // Metodi getter per posizione
    public int getPosizioneX() {
        return posizioneAttualeX;
    }

    public int getPosizioneY() {
        return posizioneAttualeY;
    }
}