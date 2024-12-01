package com.civiletti.ricorsione;

import java.sql.SQLOutput;
import java.util.Scanner;

/**
 * Numeri Primi: Storia, Implicazioni e Problemi Aperti
 *
 * I numeri primi sono quei numeri interi maggiori di 1 divisibili solo per 1 e per sé stessi.
 * Esempi: 2, 3, 5, 7, 11, 13, 17, ...
 *
 * **Storia:**
 * - I numeri primi furono studiati già nell'antichità. Il matematico greco **Eratostene**
 *   ideò un algoritmo chiamato *crivello di Eratostene* per trovare i numeri primi eliminando
 *   iterativamente i multipli di ciascun numero.
 * - **Euclide** dimostrò nel III secolo a.C. che i numeri primi sono infiniti, un risultato
 *   fondamentale nella teoria dei numeri.
 * - Nel XIX secolo, **Bernhard Riemann** introdusse la funzione zeta di Riemann, che collega
 *   i numeri primi alla distribuzione degli zeri di una funzione complessa. Il suo lavoro
 *   ha portato al famoso **Ipotesi di Riemann**, ancora irrisolta, che riguarda la posizione
 *   degli zeri della funzione zeta e la distribuzione dei numeri primi.
 *
 * **Implicazioni nella Crittografia:**
 * - I numeri primi sono al centro di algoritmi crittografici moderni, come **RSA**, che si basano
 *   sulla difficoltà di fattorizzare numeri molto grandi in fattori primi.
 * - La sicurezza della maggior parte delle comunicazioni digitali (ad esempio HTTPS) dipende
 *   dall'uso di numeri primi.
 *
 * **Problemi Aperti:**
 * - L'*Ipotesi di Riemann* è considerata uno dei problemi più importanti della matematica. La sua
 *   risoluzione potrebbe cambiare il modo in cui comprendiamo la distribuzione dei numeri primi.
 * - Esistono infiniti numeri primi gemelli (due numeri primi separati da 2)? Questa domanda, nota
 *   come **congettura dei primi gemelli**, è ancora irrisolta.
 *
 * **Descrizione del Programma:**
 * - Questo programma utilizza un algoritmo ricorsivo per determinare se un numero è primo.
 * - Dato un numero intero positivo 'n', verifica se è divisibile solo per 1 e sé stesso.
 * - La ricorsione controlla progressivamente tutti i divisori di 'n' a partire da 'n-1'.
 *
 * **Limiti della Ricorsione:**
 * - La complessità è lineare O(n), ma può essere ottimizzata verificando i divisori solo
 *   fino alla radice quadrata di 'n'.
 *
 * **Esempio di Input/Output:**
 * - Inserire un numero: 7  
 *   Risultato: true (7 è primo)
 * - Inserire un numero: 10  
 *   Risultato: false (10 non è primo)
 *
 * **Estensioni Future:**
 * - Migliorare l'efficienza utilizzando metodi iterativi o algoritmi come il crivello di Eratostene.
 * - Integrare la verifica per grandi numeri primi utilizzando approcci probabilistici (ad esempio, test
 *   di primalità di Miller-Rabin).
 */


public class NumeriPrimiRicorsivo {

    /**
     * Metodo ricorsivo per determinare se un numero è un numero primo.
     *
     * Un numero è **primo** se è maggiore di 1 e divisibile solo per 1 e se stesso.
     * Esempi: 2, 3, 5, 7, 11, 13, ...
     *
     * Strategia:
     * - La ricorsione controlla se il numero 'n' è divisibile per i numeri compresi 
     *   tra 'divisore' e 2.
     * - Se si trova un divisore diverso da 1 o 'n', il numero non è primo.
     *
     * Casi base:
     * - Se 'n <= 1', il numero non è primo (ritorna 'false').
     * - Se 'divisore == 1', il numero è primo (ritorna 'true').
     *
     * Passo ricorsivo:
     * - Controlla se 'n' è divisibile per il 'divisore' corrente.
     * - Se non lo è, richiama il metodo con 'divisore - 1'.
     *
     * Complessità:
     * - La complessità è **lineare** O(n) poiché verifica tutti i numeri da 'divisore' a 2.
     * - Una versione ottimizzata potrebbe verificare solo fino alla radice quadrata di 'n'.
     *
     * @param n        Il numero da controllare.
     * @param divisore Il divisore corrente (inizialmente 'n-1').
     * @return 'true' se il numero è primo, altrimenti 'false'.
     */
    public boolean isPrimo(int n, int divisore) {
        // Caso base: numeri <= 1 non sono primi
        if (n <= 1) return false;

        // Caso base: se siamo arrivati al divisore 1, 'n' è primo
        if (divisore == 1) return true;

        // Se 'n' è divisibile per il divisore, non è primo
        if (n % divisore == 0) return false;

        // Passo ricorsivo: controlla con il divisore decrementato
        return isPrimo(n, divisore - 1);
    }


    /**
     * Metodo ricorsivo ottimizzato per verificare se un numero è primo.
     *
     * Un numero è **primo** se è maggiore di 1 e divisibile solo per 1 e se stesso.
     * Questo metodo segue una logica ricorsiva migliorata per evitare calcoli inutili.
     *
     * Strategia:
     * - Controlla i divisori a partire da 'divisore' e scendendo fino a 2.
     * - Se si trova un divisore, il numero non è primo.
     * - Se si raggiunge un valore del divisore inferiore a 2, il numero è primo.
     *
     * Casi base:
     * - Se 'n <= 1', il numero non è primo (ritorna 'false').
     * - Se 'divisore < 2', significa che non sono stati trovati divisori, quindi il numero è primo (ritorna 'true').
     * - Se 'n % divisore == 0', il numero è divisibile per 'divisore' e non è primo (ritorna 'false').
     *
     * Passo ricorsivo:
     * - Richiama il metodo con 'divisore - 1', continuando a cercare divisori.
     *
     * Complessità:
     * - La complessità è **O(n)** nel caso peggiore, ma può essere migliorata limitando la ricerca alla radice quadrata di 'n'.
     *
     * @param n        Il numero da verificare.
     * @param divisore Il divisore corrente (inizialmente 'n-1').
     * @return 'true' se il numero è primo, altrimenti 'false'.
     */
    public boolean isPrimoOttimizzato(int n, int divisore) {
        // Caso base: numeri <= 1 non sono primi
        if (n <= 1) return false;

        // Caso base: se divisore < 2, il numero è primo
        if (divisore < 2) return true;

        // Se 'n' è divisibile per 'divisore', non è primo
        if (n % divisore == 0) return false;

        // Passo ricorsivo: verifica con il divisore decrementato
        return isPrimoOttimizzato(n, divisore - 1);
    }



    public static void main(String[] args) {

        NumeriPrimiRicorsivo primi = new NumeriPrimiRicorsivo();

        System.out.println("=========================================");
        System.out.println("=     Verifica se un numero è primo     =");
        System.out.println("=========================================");
        int count = 0;
        do {
            System.out.println("Inserire un numero: ");
            int numero = Integer.parseInt((new Scanner(System.in)).nextLine());
            // Richiamo alternativamente i due metodi
            if(count==0) {
                System.out.println("Metodo Ricorsivo Base");
                System.out.println(primi.isPrimo(numero, numero - 1));
                count++;
            } else {
                System.out.println("Metodo Ricorsivo Ottimizzato");
                System.out.println(primi.isPrimoOttimizzato(numero, (int)Math.sqrt(numero - 1)));
                count = 0;
            }
            System.out.println("Continuare? (s/n)");
        } while (new Scanner(System.in).nextLine().charAt(0) != 'n');

        System.out.println("Arrivederci!");
    }
}
