package com.civiletti;

import java.util.Scanner;

/**
 * Classe OrdinamentoCrescente
 *
 * Questa classe consente di inserire tre numeri interi e visualizzarli
 * in ordine crescente, senza l’utilizzo di array.
 *
 * <p><b>Funzionalità principali:</b></p>
 * <ul>
 *   <li>Richiede all’utente tre valori numerici.</li>
 *   <li>Applica confronti multipli per ordinarli in ordine crescente.</li>
 *   <li>Visualizza il risultato a video.</li>
 *   <li>Consente di ripetere l’operazione finché l’utente lo desidera.</li>
 * </ul>
 *
 * <p><b>Autore:</b> Civiletti</p>
 * <p><b>Data:</b> Ottobre 2007</p>
 */
public class OrdinamentoCrescente {

    /**
     * Metodo principale del programma.
     * Gestisce l’acquisizione dei dati, l’ordinamento e il controllo
     * del ciclo di ripetizione.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char scelta;

        do {
            System.out.println("=== ORDINAMENTO CRESCENTE DI TRE NUMERI ===");

            // Inserimento dei tre valori numerici
            System.out.print("Inserisci il primo numero: ");
            int a = input.nextInt();

            System.out.print("Inserisci il secondo numero: ");
            int b = input.nextInt();

            System.out.print("Inserisci il terzo numero: ");
            int c = input.nextInt();

            // ===== ORDINAMENTO CON ALGORITMO BUBBLE SORT SEMPLIFICATO =====
            // L'idea è fare "galleggiare" i valori più grandi verso destra

            // Passo 1: Assicura che a ≤ b (ordina i primi due)
            if (a > b) { // Primo swap se necessario
                int temp = a;
                a = b;
                b = temp;
            }

            // Passo 2: Assicura che b ≤ c (ordina gli ultimi due)
            // ATTENZIONE: questo può "rompere" l'ordine di a e b!
            if (b > c) { // Secondo swap se necessario, potrebbe contraddire il primo swap quindi serve il passo 3
                int temp = b;
                b = c;
                c = temp;
            }

            // Passo 3: Ricontrolla a ≤ b (necessario dopo il passo 2)
            // Se al passo 2 b è diventato più piccolo, ora va prima di a
            if (a > b) { // Terzo swap per prevenire problemi che possono insorgere al passo 2
                int temp = a;
                a = b;
                b = temp;
            }
            // A questo punto: a ≤ b ≤ c garantito!

            // Visualizzazione dei valori in ordine crescente
            System.out.println("\nValori in ordine crescente:");
            System.out.println(a + " " + b + " " + c);

            // Richiesta per continuare o terminare
            System.out.print("\nVuoi ordinare altri numeri? (s/n): ");
            scelta = input.next().toLowerCase().charAt(0);

            System.out.println("-------------------------------------------\n");

        } while (scelta == 's');

        System.out.println("Programma terminato. Arrivederci!");
        input.close();
    }
}
