package com.civiletti.gioco.moneta.v1;

/**
 * Realizzare un'applicazione in linguaggio Java che emuli il lancio di una moneta.
 * All'inizio, il giocatore effettua una scelta: Testa (0) o Croce (1).
 * Durante ogni lancio, il programma mostra il risultato parziale.
 *
 * Al termine di 5 lanci, il vincitore sarà determinato in base al punteggio più alto,
 * sia del giocatore che del PC."
 *
 * Suggerimento: Utilizzare la classe Random del package java.util.Random
 *
 * Esempio di output:
 *
 * Benvenuto nel gioco del lancio della moneta! Scegli Testa (0) o Croce (1)
 *  0
 * Lancio 1: Testa
 * Lancio 2: Testa
 * Lancio 3: Croce
 * Lancio 4: Croce
 * Lancio 5: Croce
 * Il PC ha vinto con 3 Croce!
 */

//Versione 4
import java.util.Random;
import java.util.Scanner;

public class GiocoMoneta {

    final static String testa = "Testa";
    final static String croce = "Croce";
    private String sceltaGiocatore, sceltaPC;
    private int scelta; // solo i metodi getter e setter potranno accedervi

    public int getScelta(){
        return scelta;
    }

    public void setScelta(int s){
        this.scelta = s;
    }

    public String getSceltaGiocatore(){
        return sceltaGiocatore;
    }

    public String getSceltaPC(){
        return sceltaPC;
    }

    /* Non servono per questo esercizio

    void setSceltaG(String sg){
        this.sceltaG = sg;
    }

    void setSceltaPC(String spc){
        this.sceltaPC = spc;
    }
    */

    // Inizializzazione di default
    GiocoMoneta(){
        this.sceltaGiocatore = testa;
        this.sceltaPC = croce;
    }

    // Costruttore che inizializza in base la scelta effettuata dal giocatore
    GiocoMoneta(int scelta){
        setScelta(scelta); // invoco il metodo setter per impostare la scelta effettuata dal giocatore

        if( scelta == 0){
            sceltaGiocatore = testa;
            sceltaPC = croce;
        } else{
            sceltaGiocatore = croce;
            sceltaPC = testa;
        }
    }

    public void lanci(){
        int lanciTestaGiocatore = 0, lanciTestaPC = 0;
        Random random = new Random(); // oggetto per la generazione di numeri casuali

        int sceltaGiocatore = getScelta();

        // Simulazione di 5 lanci della moneta
        for (int i = 0; i < 5; i++) {

            int lancio = random.nextInt(2); // Genera un numero casuale (0 o 1)

            // Visualizza il risultato del lancio
            if (lancio == 0) {

                System.out.println("Lancio " + (i + 1) + ": Testa");

                if (sceltaGiocatore == 0) {
                    lanciTestaGiocatore++; // Incremento il punteggio del giocatore
                } else {
                    lanciTestaPC++; // Incremento il punteggio del PC
                }

            } else {

                System.out.println("Lancio " + (i + 1) + ": Croce");
                if (sceltaGiocatore == 1) {
                    lanciTestaGiocatore++; // Incremento il punteggio del giocatore
                } else {
                    lanciTestaPC++; // Incremento il punteggio del PC
                }
            }
        }

        // Determina il vincitore in base al punteggio più alto
        if (lanciTestaGiocatore > lanciTestaPC) {
            System.out.println("Hai vinto con " + lanciTestaGiocatore + " " + getSceltaGiocatore());
        } else if (lanciTestaGiocatore < lanciTestaPC) {
            System.out.println("Il PC ha vinto con " + lanciTestaPC + " " + getSceltaPC());
        } else {
            System.out.println("Pareggio!"); // Su 5 lanci non può mai avvenire
        }

    }

    static void menu(int i){

        if(i==0){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("+ Benvenuto nel gioco del lancio della moneta! +");
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
        } else if(i==1) {
            System.out.println("################################");
            System.out.println("# Scegli Testa (0) o Croce (1) #");
            System.out.println("################################");
        } else if(i==2) {
            System.out.println();
            System.out.println("###################################");
            System.out.println(" Continuare con altri lanci? [s/n]");
            System.out.println("###################################");
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int sceltaGiocatore;

        menu(0);
        menu(1);

        boolean run = true;
        while(run){

            // Scelta del giocatore (Testa o Croce)
            sceltaGiocatore = scanner.nextInt();

            GiocoMoneta gm = new GiocoMoneta(sceltaGiocatore);

            gm.lanci();
            menu(2);
            scanner = new Scanner(System.in);
            String continua = scanner.nextLine().toLowerCase();

            if(continua.charAt(0) == 's'){
                menu(1);
            } else {
                run = false;
                System.out.println("Grazie per aver giocato al lancio delle monete!");
            }
        }
        scanner.close();
    }
}
