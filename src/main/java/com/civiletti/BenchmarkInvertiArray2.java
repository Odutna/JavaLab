package com.civiletti;

import java.util.Arrays;

/**
 * Il passaggio di InvertiArray2 nel costruttore è necessario perché questa classe deve accedere
 * ai metodi di inversione dell'array definiti in InvertiArray2. Non si possono invocarli direttamente
 * senza un'istanza.
 *
 *  1. Uso di clone() – Si crea sempre una copia dell'array originale per ogni test perché:
 *
 *       Evita che l'array originale venga modificato
 *       Assicura che ogni test parta dalle stesse condizioni iniziali
 *
 *  2. Warm-up della JVM – Fondamentale per benchmark accurati perché:
 *
 *       La JVM ottimizza il codice durante l'esecuzione
 *       Le prime esecuzioni sono tipicamente più lente
 *       Il warm-up permette alla JVM di stabilizzarsi
 *
 *  3. Esclusione outlier – Si esclude il 10% dei valori più alti e più bassi per:
 *
 *       Eliminare misurazioni anomale
 *       Ottenere statistiche più rappresentative delle prestazioni reali
 *
 */

public class BenchmarkInvertiArray2 {
    private InvertiArray2 invertiArray; // istanza
    private int iterazioni;

    // Costruttore che richiede un'istanza di InvertiArray2
    // (necessario per accedere ai metodi di inversione)
    public BenchmarkInvertiArray2(InvertiArray2 invertiArray, int iterazioni) {
        this.invertiArray = invertiArray;
        this.iterazioni = iterazioni;
    }

    public void eseguiBenchmark() {
        System.out.println("\nEsecuzione benchmark con " + iterazioni + " iterazioni per metodo");

        // ARRAY per memorizzare i tempi di esecuzione di ogni metodo
        long[] tempiOttimizzato = new long[iterazioni];
        long[] tempiCopia = new long[iterazioni];
        long[] tempiDoppiaCopia = new long[iterazioni];
        long[] tempiCollection = new long[iterazioni];
        long[] tempiStringBuilder = new long[iterazioni];

        // Warm-up della JVM per ottenere misurazioni più accurate
        // Si eseguono i metodi 1000 volte senza misurare i tempi
        System.out.println("Warm-up JVM in corso...");
        for(int i = 0; i < 1000; i++) {
            invertiArray.invertiArrayOttimizzato(invertiArray.numeri.clone());
            invertiArray.invertiArrayCopia(invertiArray.numeri.clone());
            invertiArray.invertiArrayDoppiaCopia(invertiArray.numeri.clone());
            invertiArray.invertiArrayCollection(invertiArray.numeri.clone());
            invertiArray.invertiArrayStringBuilder(invertiArray.numeri.clone());
        }

        // Test effettivo: misura il tempo di ogni metodo per il numero di iterazioni specificato
        for(int i = 0; i < iterazioni; i++) {
            // Test invertiArrayOttimizzato
            long startTime = System.nanoTime();
            invertiArray.invertiArrayOttimizzato(invertiArray.numeri.clone());
            tempiOttimizzato[i] = System.nanoTime() - startTime;

            // Test invertiArrayCopia
            startTime = System.nanoTime();
            invertiArray.invertiArrayCopia(invertiArray.numeri.clone());
            tempiCopia[i] = System.nanoTime() - startTime;

            // Test invertiArrayDoppiaCopia
            startTime = System.nanoTime();
            invertiArray.invertiArrayDoppiaCopia(invertiArray.numeri.clone());
            tempiDoppiaCopia[i] = System.nanoTime() - startTime;

            // Test invertiArrayCollection
            startTime = System.nanoTime();
            invertiArray.invertiArrayCollection(invertiArray.numeri.clone());
            tempiCollection[i] = System.nanoTime() - startTime;

            // Test invertiArrayStringBuilder
            startTime = System.nanoTime();
            invertiArray.invertiArrayStringBuilder(invertiArray.numeri.clone());
            tempiStringBuilder[i] = System.nanoTime() - startTime;
        }

        // Calcola e mostra le statistiche
        mostraStatisticheBenchmark("Copia", tempiCopia);
        mostraStatisticheBenchmark("Doppia Copia", tempiDoppiaCopia);
        mostraStatisticheBenchmark("Ottimizzato", tempiOttimizzato);
        mostraStatisticheBenchmark("Collection", tempiCollection);
        mostraStatisticheBenchmark("StringBuilder", tempiStringBuilder);
    }

    private void mostraStatisticheBenchmark(String metodo, long[] tempi) {
        Arrays.sort(tempi); // Per calcolare la mediana e rimuovere outlier

        // Calcola statistiche escludendo il 10% dei valori più alti e più bassi
        int start = (int)(tempi.length * 0.1);
        int end = (int)(tempi.length * 0.9);

        double media = 0;
        for(int i = start; i < end; i++) {
            media += tempi[i];
        }
        media /= (end - start);

        double mediana = tempi[tempi.length/2];

        System.out.printf("\nMetodo %s:\n", metodo);
        System.out.printf("Media (80%% centrali): %.2f ns\n", media);
        System.out.printf("Mediana: %.2f ns\n", mediana);
        System.out.printf("Minimo: %d ns\n", tempi[start]);
        System.out.printf("Massimo: %d ns\n", tempi[end-1]);
    }
}