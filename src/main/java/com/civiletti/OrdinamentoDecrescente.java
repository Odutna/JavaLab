package com.civiletti;

import java.util.Scanner;

/**
 * Classe OrdinamentoDecrescente
 *
 * Questa classe consente di inserire tre numeri interi e visualizzarli
 * in ordine decrescente, senza l’utilizzo di array.
 *
 * <p><b>Funzionalità principali:</b></p>
 * <ul>
 *   <li>Richiede all’utente tre valori numerici.</li>
 *   <li>Applica confronti multipli per ordinarli in ordine decrescente.</li>
 *   <li>Visualizza il risultato a video.</li>
 *   <li>Consente di ripetere l’operazione finché l’utente lo desidera.</li>
 * </ul>
 *
 * <p><b>Autore:</b> Civiletti</p>
 * <p><b>Data:</b> Ottobre 2007</p>
 */
public class OrdinamentoDecrescente {

    /**
     * Metodo principale del programma.
     * Gestisce l’acquisizione dei dati, l’ordinamento e il controllo
     * del ciclo di ripetizione.
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char scelta;

        do {
            System.out.println("=== ORDINAMENTO DECRESCENTE DI TRE NUMERI ===");

            // Inserimento dei tre valori numerici
            System.out.print("Inserisci il primo numero: ");
            int a = input.nextInt();

            System.out.print("Inserisci il secondo numero: ");
            int b = input.nextInt();

            System.out.print("Inserisci il terzo numero: ");
            int c = input.nextInt();

            // ===== ORDINAMENTO CON ALGORITMO BUBBLE SORT SEMPLIFICATO =====
            // L'idea è fare "galleggiare" i valori più grandi verso destra

            // Es. a= -1 b=3 c=5
            // Passo 1: Assicura che a ≥ b (ordina i primi due)
            if (a < b) { // Primo swap se necessario => -1 < 3 => inverto
                int temp = a;
                a = b;
                b = temp;
            } // a= 3 b=-1 c=5

            // Passo 2: Assicura che b ≥ c (ordina gli ultimi due)
            // ATTENZIONE: questo può "rompere" l'ordine di a e b!
            if (b < c) { // Secondo swap se necessario, potrebbe contraddire il primo swap quindi serve il passo 3 => -1 < 5 => inverto
                int temp = b;
                b = c;
                c = temp;
            } // a=3 b=5 c=-1 => adesso perà violo la condizione dello step 1 quindi devo ripeterlo

            // Passo 3: Ricontrolla a ≥ b (necessario dopo il passo 2)
            // Se al passo 2 b è diventato più piccolo, ora va prima di a
            if (a < b) { // Terzo swap per prevenire problemi che possono insorgere al passo 2 => 3 < 5
                int temp = a;
                a = b;
                b = temp;
            } // a=5 b=3 c=-1
            // A questo punto: a ≤ b ≤ c garantito!

            // Visualizzazione dei valori in ordine crescente
            System.out.println("\nValori in ordine decrescente:");
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
