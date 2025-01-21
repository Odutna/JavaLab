package com.civiletti.esercitazione;

/**
 * Calcolo dell'età dell'utente, dalla data di nascita,
 * e i giorni mancanti al prossimo compleanno utilizzndo:
 *
 *   ChronoUnit.DAYS.between(date1, date2);
 *
 *   del package: java.time.temporal.ChronoUnit;
 */

import java.time.LocalDate;
//import java.time.Month;

import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class CalcoloEtaV2 {

    public static void main(String[] args) {

        // Creazione di un oggetto Scanner per l'input da tastiera
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la data di nascita (GG-MM-AAAA): ");

        String input = scanner.nextLine(); // Leggo la stringa nel formato indicato

        String gg = input.substring(0,2); // Estraggo le sotto stringhe
        String mm = input.substring(3,5);
        String aaaa = input.substring(6,10);

        String inputReformatted = aaaa + "-" + mm + "-" + gg;  // Ricostruisco la stringa secondo il formato accettato da LocalDate

        // Parsing della data di nascita in un oggetto LocalDate
        LocalDate dataNascita = LocalDate.parse(inputReformatted);  // Data di nascita passata nel formato richiesto
/*
        // Riformattazione della data di nascita nel formato GG-MM-AAAA
        String nuovaDataNascita = dataNascita.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
*/
        // Calcolo dell'età attuale
        LocalDate oggi = LocalDate.now(); // Leggo la data attuale
        long anni = ChronoUnit.YEARS.between(dataNascita, oggi); // Calcolo degli anni trascorsi

        // Calcolo dei giorni mancanti al prossimo compleanno
        LocalDate prossimoCompleanno = dataNascita.plusYears(anni + 1);
        long giorniMancanti = ChronoUnit.DAYS.between(oggi, prossimoCompleanno);

        System.out.println("Hai " + anni + " anni e fra " + giorniMancanti + " giorni avrai " + (anni + 1) + " anni.");

        scanner.close();
    }

}
