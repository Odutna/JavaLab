package com.civiletti.enumerazione.orari.v1;

import java.util.Scanner;

// 1. Enum semplice per i giorni della settimana
enum GiornoSettimana {
    LUNEDI, MARTEDI, MERCOLEDI, GIOVEDI, VENERDI, SABATO, DOMENICA
}
// 1. Esempio GiornoSettimana - Gestione orari palestra
class OrariPalestra {

    public String getOrario(GiornoSettimana giorno) {
        return switch (giorno) {
            case LUNEDI, MERCOLEDI, VENERDI -> "07:00-22:00";
            case MARTEDI, GIOVEDI -> "08:00-22:00";
            case SABATO -> "09:00-18:00";
            case DOMENICA -> "09:00-13:00";
        };
    }

    public static void main(String[] args) {
        OrariPalestra palestra = new OrariPalestra();
        GiornoSettimana oggi = GiornoSettimana.LUNEDI;
        System.out.println("Orario di oggi (" + oggi + "): " + palestra.getOrario(oggi));
        boolean run = true;
        Scanner sc = new Scanner(System.in);
        do {

            System.out.println("Inserisci un giorno: ");
            final String giorno = sc.nextLine().toUpperCase();
            try {
                GiornoSettimana giornoEnum = GiornoSettimana.valueOf(giorno);
                System.out.println(giornoEnum);
                System.out.println("Orario di " + giorno + ": " + palestra.getOrario(giornoEnum));
            }catch (IllegalArgumentException e) {
                System.out.println("***");
                System.out.println("Tentativo di accedere a una costante di un enumerazione (enum) che non esiste:\n" + e);
                System.out.println("***");
            }
            System.out.println("Continua? (s/n)");
        }while (sc.nextLine().charAt(0) != 'n');
    }
}
