package com.civiletti.esercitazione;


/**
 * Utilizzo la classe GiorniTrascorsi per il calcolo dell'età esatta e
 * per stimare i giorni che mancano al compleanno.
 *
 * Calcolo dell'età:
 * • 1 anni = annoCorrente - annoNascita
 * • 2 devo verificare se il compleanno è già passato oppure no, cioè
 *     se giorniTrascorsiOggi < giorniTrascorsiNascita deve compierli!
 *   • 2 se il compleanno non è ancora passato sottraggo uno: anno -= 1
 *
 * Calcolo dei giorni trascorsi:
 * (anche in questo caso devo saper se il giorno del compleanno è già passato oppure no)
 *
 * • 1 Non ha compiuto gli anni nell'anno corrente:
 *     giorniMancanti = giorniTrascorsiNascita - giorniTrascorsiOggi;
 * • 2 Deve compiere gli anni, devo considerare l'anno successivo e dato
 *     che non so se è bisestile invoco nuvamente il metodo.
 *
 */

import java.time.LocalDate;
import java.util.Scanner;

public class CalcoloEta {

    public static void main(String[] args) {

        // Creazione di un oggetto Scanner per l'input da tastiera
        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci la data di nascita (GG-MM-AAAA): ");

        String input = scanner.nextLine(); // Leggo la stringa nel formato indicato

        String gg = input.substring(0, 2); // Estraggo le sotto stringhe
        String mm = input.substring(3, 5);
        String aaaa = input.substring(6, 10);

        String inputReformatted = aaaa + "-" + mm + "-" + gg; // Ricostruisco la stringa secondo il formato accettato da LocalDate

        // Parsing della data di nascita in un oggetto LocalDate
        LocalDate dataNascita = LocalDate.parse(inputReformatted); // Data di nascita passata nel formato richiesto

        // Calcolo dell'età attuale
        LocalDate oggi = LocalDate.now(); // Leggo la data attuale
        int annoCorrente = oggi.getYear();

        // Calcolo dei giorni trascorsi dall'inizio dell'anno per la data corrente
        int giorniTrascorsiOggi = GiorniTrascorsi.calcolaGiorniTrascorsi(oggi.getDayOfMonth(), oggi.getMonthValue(), annoCorrente, false);

        // Calcolo dei giorni trascorsi dall'inizio dell'anno per la data di nascita
        int giorniTrascorsiNascita = GiorniTrascorsi.calcolaGiorniTrascorsi(dataNascita.getDayOfMonth(), dataNascita.getMonthValue(), dataNascita.getYear(), false);

        // Calcolo degli anni
        long anni = annoCorrente - dataNascita.getYear();

        boolean anniCompiuti = giorniTrascorsiOggi < giorniTrascorsiNascita; // True se non ha ancora compiuto gli anni nell'anno corrente

        if (anniCompiuti) { // Verifica se non ha ancora compiuto gli anni
            anni -= 1;
        }

        // Calcolo dei giorni mancanti al prossimo compleanno
        int giorniMancanti;
        if (anniCompiuti) { // non ha ancora compiuto gli anni
            giorniMancanti = giorniTrascorsiNascita - giorniTrascorsiOggi;
        } else { // hagià compito gli anni devo considerare l'anno successivo

            giorniMancanti = GiorniTrascorsi.calcolaGiorniTrascorsi(dataNascita.getDayOfMonth(),
                                                                    dataNascita.getMonthValue(),
                                                              annoCorrente + 1,
                                                      false) - giorniTrascorsiOggi;
        }

        System.out.println("Hai " + anni + " anni e fra " + giorniMancanti + " giorni avrai " + (anni + 1) + " anni.");
        scanner.close();
    }

}

