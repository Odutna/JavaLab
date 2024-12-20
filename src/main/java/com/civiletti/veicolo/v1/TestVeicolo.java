package com.civiletti.veicolo.v1;

import java.util.Scanner;

public class TestVeicolo {

//    public static void clearScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }

//    public static void clearScreen() {
//        System.out.println("\n".repeat(30));
//        // Sposta il cursore all'inizio
//        System.out.print("\033[H");
//    }

    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            System.out.println("\n".repeat(50));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creazione del veicolo
        Veicolo mioVeicolo = new Veicolo("Fiat", "Panda", "MI123CD", "Bianco", 2018);

        // Flag per controllare lo stato del veicolo
        boolean inEsecuzione = true;
        boolean veicololAcceso = false;

        while (inEsecuzione) {
            clearScreen();
            System.out.println();
            System.out.println("==============================");
            System.out.println("= \033[32m      INFO VEICOLO        \033[0m =");
            System.out.println("==============================");

            // Mostra stato corrente
            System.out.println(mioVeicolo);
//            System.out.println("Veicolo: " + mioVeicolo.getMarca() + " " + mioVeicolo.getModello());
            mioVeicolo.mostraQuadroStrumenti();

            // Menu delle opzioni
            System.out.println("\nScegli un'operazione:");
            System.out.println("[0] Esci");

            // Opzioni di base
            if (!veicololAcceso) {
                System.out.println("[1] Accendi veicolo");
            } else {
                System.out.println("[2] Cambia marcia su \t\t [5] Avanza \t\t [9] Freccia sinistra");
                System.out.println("[3] Scala marcia \t\t [6] Accelera \t\t [10] Freccia destra");
                System.out.println("[4] Retromarcia \t\t [7] Frena \t\t [11] 4 Frecce");
                System.out.println("[8] Stop (semaforo/incrocio)");
                System.out.println("[12] Spegni veicolo");
            }

            int scelta = scanner.nextInt();

            // Gestione delle scelte
            switch (scelta) {
                case 0:
                    // Esci dal programma
                    inEsecuzione = false;
                    System.out.println("Programma terminato.");
                    break;

                case 1:
                    // Accendi veicolo
                    if (!veicololAcceso) {
                        mioVeicolo.accendi();
                        veicololAcceso = true;
                    }
                    break;

                case 2:
                    // Cambia marcia su
                    mioVeicolo.cambiaMarcia(true);
                    break;

                case 3:
                    // Scala marcia
                    mioVeicolo.cambiaMarcia(false);
                    break;
                case 4:
                    // Retromarcia
                    mioVeicolo.retromarcia();
                    break;
                case 5:
                    // Avanza a velocità costante
                    mioVeicolo.avanza(5);
                    break;
                case 6:
                    // Accelera
                    mioVeicolo.accelera();
                    break;

                case 7:
                    // Frena
                    mioVeicolo.frena();
                    break;

                case 8:
                    // Stop (simula una fermata al semaforo o all'incrocio)
                    if (mioVeicolo.getVelocita() > 0) {
                        System.out.println("Fermata al semaforo/incrocio.");
//                        int vel = mioVeicolo.getVelocita();
                        while(mioVeicolo.getVelocita() > 0) {
                            mioVeicolo.frena();
//                            vel--;
                        }
                        System.out.println("Veicolo completamente fermo.");
                    } else {
                        System.out.println("Il veicolo è già fermo.");
                    }
                    break;

                case 9:
                    // Freccia sinistra
                    mioVeicolo.attivaFreccia("sinistra");
                    break;

                case 10:
                    // Freccia destra
                    mioVeicolo.attivaFreccia("destra");
                    break;

                case 11:
                    // Frecce di emergenza
                    mioVeicolo.attivaFreccia("emergenza");
                    break;

                case 12:
                    // Spegni veicolo
                    if (mioVeicolo.getVelocita() == 0) {
                        mioVeicolo.spegni();
                        veicololAcceso = false;
                    } else {
                        System.out.println("Impossibile spegnere. Fermare prima il veicolo.");
                    }
                    break;


                default:
                    System.out.println("Scelta non valida. Riprova.");
            }

            // Pausa per leggibilità
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                System.out.println("Interruzione del thread.");
//            }
        }

        scanner.close();
    }
}
