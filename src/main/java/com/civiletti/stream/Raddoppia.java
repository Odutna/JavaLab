package com.civiletti.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;  // per leggere interi da un file binario
import java.io.ObjectOutputStream; // per scrivere interi in un file binario
import java.io.EOFException;       // Usata come meccanismo per terminare il ciclo while
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Sono richieste le classi:
 *      • FileBinarioInputTest per la lettura del file .dat
 *      • FileBinarioOutputTest per la scrittura del file .dat
 *
 * Programma che svolge delle semplici elaborazioni di dati.
 *
 * Il programma richiede all’utente i nomi di due file, legge dei numeri dal primo file,
 * li raddoppia e scrive i risultati nel secondo file.
 *
 * Le operazioni da svolgere sono semplici, ma il programma mostra l’utilizzo di varie
 * tecniche di uso comune nella gestione dell’I/O con file.
 *
 * In particolare, si noti che le variabili che referenziano gli oggetti di tipo stream
 * connessi ai file sono variabili di istanza, e che le operazioni da svolgere sono
 * suddivise tra più metodi.
 *
 * Funzionamento:
 *
 *      1. Richiede all'utente di inserire il nome di un file di input e uno di output
 *      2. Legge numeri interi dal file di input usando ObjectInputStream
 *      3. Raddoppia ciascun numero
 *      4. Scrive i numeri raddoppiati nel file di output usando ObjectOutputStream
 *      5. Chiude entrambi i file
 *
 * Il programma è progettato per lavorare solo quando il file di input esiste, poiché il suo scopo è leggere
 * dati da un file esistente, elaborarli e scrivere i risultati.
 *
 * Se volessimo che il programma creasse comunque il file di output anche quando il file di input non esiste,
 * occorre:
 *
 *      • Rimuovere la chiamata a System.exit(0) dal blocco catch
 *      • Modificare il flusso del programma per gestire il caso in cui il file di input non esista
 *
 * Vale la pena notare che ObjectInputStream e ObjectOutputStream sono progettati per la serializzazione di
 * oggetti Java, e in questo caso il programma utilizza il metodo readInt() e writeInt() per leggere/scrivere
 * numeri interi primitivi.RiprovaClaude non ha ancora la capacità di eseguire il codice che genera.
 */

public class Raddoppia {

    private ObjectInputStream inputStream = null;
    private ObjectOutputStream outputStream = null;

    /**
     * Raddoppia gli interi in un file e scrive il risultato in un altro file.
     */

    public static void main(String[] args) {

        Raddoppia moltiplicatore = new Raddoppia();
        moltiplicatore.collegaFileDiInput();  // Apre il file di input
        moltiplicatore.collegaFileDiOutput(); // Apre il file di output
        moltiplicatore.moltiplicaPerDue();    // Legge, raddoppia e scrive i numeri
        moltiplicatore.chiudiFile();          // Chiude entrambi i file
        System.out.println("Numeri letti da un file di input");
        System.out.println("raddoppiati e copiati in un file di output.");
        String nomeFile = moltiplicatore.leggiNomeFile("Inserisci il nome del file di input:");
        try {
            FileBinarioInputTest.LeggiInteri(nomeFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void collegaFileDiInput() {  // Leggere il file
        String nomeFileDiInput =
                leggiNomeFile("Inserisci il nome del file di input:");
        try {
            inputStream = new ObjectInputStream(new
                    FileInputStream(nomeFileDiInput));
        } catch (FileNotFoundException e) {
            System.out.println("File " + nomeFileDiInput + " non trovato.");

            try {
                FileBinarioOutputTest.ScriviInteri(nomeFileDiInput);
                // Riapri il file appena creato
                inputStream = new ObjectInputStream(new FileInputStream(nomeFileDiInput));
            } catch (IOException ex) {
                System.out.println("Errore nella creazione o riapertura del file.");
                System.out.println(ex.getMessage());
                System.exit(0);
            }
        } catch (IOException e) {
            System.out.println("Errore nell'apertura del file di input " +
                    nomeFileDiInput);
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    private String leggiNomeFile(String messaggio) {
        String nomeFile = null;
        System.out.println(messaggio);
        Scanner tastiera = new Scanner(System.in);
        nomeFile = tastiera.next();
        return nomeFile;
    }

    public void collegaFileDiOutput() {
        String nomeFileDiOutput =
                leggiNomeFile("Inserisci il nome del file di output:"); // Ottiene un nome di file dall'utente
        try {
            outputStream = new ObjectOutputStream(new
                    FileOutputStream(nomeFileDiOutput));
        } catch (IOException e) {
            System.out.println("Errore nell'apertura del file di output " +
                    nomeFileDiOutput);
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
/**
    Un programma utile in un caso reale trasformerebbe
    probabilmente i dati in modo più complicato prima
    di scriverli nel file di output e avrebbe quindi,
    probabilmente, dei metodi aggiuntivi per farlo.
*/
    public void moltiplicaPerDue() {

        try {
            while (true) {
                int prossimo = inputStream.readInt();
                outputStream.writeInt(2 * prossimo);
            }
        } catch (EOFException e) {
            // Non fa niente, serve solo per terminare il ciclo.
        }catch (IOException e) {
            System.out.println("Errore nella lettura o nella scrittura dei file.");
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }

    public void chiudiFile() {

        try {
            inputStream.close();
            outputStream.close();
        } catch (IOException e) {
            System.out.println("Errore nella chiusura dei file.");
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
}