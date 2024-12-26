package com.civiletti.veicolo.v3;

import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.InfoCmp;

/**
 * Applicazione sviluppata sulla base dell'idea e dell'implementazione (perfettamente funzionante)
 * realizzate dalla studentessa N. Premovic della classe 4A INF - Dicembre 2024.
 *
 * Le modifiche apportate sono esclusivamente frutto di scelte didattiche.
 *
 */

public class TestMovimento {

    public static void clearScreen(Terminal terminal) {
        try {
            terminal.puts(InfoCmp.Capability.clear_screen); // Usa il terminale per pulire lo schermo
            terminal.flush();
        } catch (Exception e) {
            System.out.println("\n".repeat(50)); // Metodo alternativo per sistemi che non supportano il terminale
        }
    }

    public static void main(String[] args) throws IOException {



        // Configura il terminale
        Terminal terminal = TerminalBuilder.builder()
                .system(true) // Usa il terminale di sistema
                .build();

        // Configura modalità raw
        terminal.enterRawMode();


        // Crea una mappa 10x10
        Mappa mappa = new Mappa(10, 10);

        // Creazione del veicolo
        Veicolo mioVeicolo = new Veicolo("Fiat", "Panda", "MI123CD", "Bianco", 2018);

        // Flag per controllare lo stato del veicolo
        boolean inEsecuzione = true;
        boolean veicoloAcceso = false;

        InfoVeicolo.info(mioVeicolo);

        while (inEsecuzione) {
            InfoVeicolo.menu();

//            int terminal = System.in.read(); // Legge il tasto premuto immediatamente e lo conserva in una variabile "c"
//            System.out.println("Tasto premuto: "+terminal);

            // Mostra opzioni di base
            if (!veicoloAcceso) {
                System.out.println("\033[93m[R]\033[0m Accendi veicolo");
            }

            // Legge l'input senza aspettare [Invio]
            int input = terminal.reader().read();
            char scelta = Character.toUpperCase((char) input);

//            clearScreen(terminal);
            TestVeicolo.clearScreen();
//            char scelta = Character.toUpperCase((char) (terminal));

            // Gestione delle scelte
            switch (scelta) {
                case 'E':
                    inEsecuzione = false;
                    System.out.println("Programma terminato.");
                    break;

                case 'R':
                    if (!veicoloAcceso) {
                        mioVeicolo.accendi();
                        veicoloAcceso = true;
                    }
                    break;

                case 'S':
                    mioVeicolo.retromarcia();
                    mappa.aggiornaPosizioneVeicolo(mioVeicolo, "indietro");
                    mappa.stampaMappa();
                    break;

                case 'W':
                    mioVeicolo.avanza(5);
                    mappa.aggiornaPosizioneVeicolo(mioVeicolo, "avanti");
                    mappa.stampaMappa();
                    break;

                case 'A':
                    mioVeicolo.attivaFreccia("sinistra");
                    mappa.aggiornaPosizioneVeicolo(mioVeicolo, "sinistra");
                    mappa.stampaMappa();
                    break;

                case 'D':
                    mioVeicolo.attivaFreccia("destra");
                    mappa.aggiornaPosizioneVeicolo(mioVeicolo, "destra");
                    mappa.stampaMappa();
                    break;

                case 'H':
                    InfoVeicolo.help();
                    break;

                case 'Q':
                    InfoVeicolo.quadro(mioVeicolo);
                    break;

                case 'M':
                    mappa.stampaMappa();
                    break;

                default:
                    System.out.println("Scelta non valida. Riprova.");
            }
        }

        terminal.close();  //
    }
}
