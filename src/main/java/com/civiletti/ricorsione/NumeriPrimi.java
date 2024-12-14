package com.civiletti.ricorsione;

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

public class NumeriPrimi {

    /**
     * Metodo iterativo per determinare se un numero è un numero primo.
     *
     * Un numero è **primo** se è maggiore di 1 e divisibile solo per 1 e se stesso.
     * Strategia:
     * - Controlla se il numero è divisibile da 2 fino alla radice quadrata del numero stesso.
     * - Se si trova un divisore, il numero non è primo.
     *
     * Complessità:
     * - La complessità è **O(√n)** poiché verifica solo fino alla radice quadrata di 'n'.
     *
     * @param n Il numero da controllare.
     * @return 'true' se il numero è primo, altrimenti 'false'.
     */
    public boolean isPrimo(int n) {
        if (n <= 1) return false; // Numeri <= 1 non sono primi
        if (n == 2) return true;  // 2 è il primo numero primo

        // Controlla divisibilità per i numeri da 2 a √n - Non è necessario, infatti, testare tutti i divisori fino a n.
        // Questo è dovuto al fatto che i divisori si presentano in coppie simmetriche rispetto alla radice quadrata
        for (int i = 2; i <= Math.sqrt(n); i++)
            if (n % i == 0) return false; // Divisore trovato, non è un numero primo
        return true; // Nessun divisore trovato, è un numero primo
    }


    public static void main(String[] args) {
        NumeriPrimi primi = new NumeriPrimi();

        System.out.println("=========================================");
        System.out.println("=     Verifica se un numero è primo     =");
        System.out.println("=========================================");

        do {
            System.out.println("Inserire un numero: ");
            int numero = Integer.parseInt((new Scanner(System.in)).nextLine());

            System.out.println("Il numero " + numero + (primi.isPrimo(numero) ? " è primo!" : " non è primo."));

            System.out.println("Continuare? (s/n)");
        } while (new Scanner(System.in).nextLine().charAt(0) != 'n');
        System.out.println("Arrivederci!");
    }
}

