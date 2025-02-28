package com.civiletti.enumerazione.orari.v2;

import java.util.Scanner;

// Enum per i giorni della settimana e festivi
enum GiornoSettimana {
    LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA, NATALE, ANNO_NUOVO, EPIFANIA, CARNEVALE, PASQUA;

    public boolean isFestivo() {
        return this == NATALE || this == ANNO_NUOVO || this == EPIFANIA || this == CARNEVALE || this == PASQUA;
    }

    public boolean isFineSettimana() {
        return this == SABATO || this == DOMENICA;
    }
}

// Classe per gestire gli orari della palestra
public class OrariPalestra {
    public static final String ORARIO_STANDARD = "07:00-22:00";
    public static final String ORARIO_FINE_SETTIMANA = "09:00-20:00";
    public static final String ORARIO_FESTIVO = "Chiuso";

    public String getOrario(GiornoSettimana giorno) {
        if (giorno.isFestivo()) {
            return ORARIO_FESTIVO;
        } else if (giorno.isFineSettimana()) {
            return ORARIO_FINE_SETTIMANA;
        } else {
            return ORARIO_STANDARD;
        }
    }
}

class TestOrariPalestra {
    public static void main(String[] args) {
        OrariPalestra palestra = new OrariPalestra();
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================================================");
        System.out.println("===                      Orari Palestra                     ===");
        System.out.println("===============================================================");
        System.out.println("= Valori validi:                                              =");
        System.out.println("= LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI,               =");
        System.out.println("= SABATO, DOMENICA,                                           =");
        System.out.println("= NATALE, ANNO_NUOVO, EPIFANIA, CARNEVALE, PASQUA             =");
        System.out.println("===============================================================");


        boolean run = true;

        while (run) {
            try {
                System.out.println("\nInserisci un giorno:");
                String input = sc.nextLine().trim().toUpperCase();
                GiornoSettimana giorno = GiornoSettimana.valueOf(input); //

                String orario = palestra.getOrario(giorno);
                System.out.println("Orario di " + giorno + ": " + orario);

            } catch (IllegalArgumentException e) {
                System.out.println("Errore: giorno non valido. Riprova.");
                e.printStackTrace();
            }

            System.out.println("Vuoi continuare? (s/n):");
            String risposta = sc.nextLine().trim().toLowerCase();
            if (!risposta.equals("s")) {
                run = false;
            }
        }

        sc.close();
        System.out.println("Programma terminato.");
    }
}
