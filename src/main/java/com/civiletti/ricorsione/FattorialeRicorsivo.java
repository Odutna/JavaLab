package com.civiletti.ricorsione;

import java.util.Scanner;

/**
 * Calcolo del fattoriale con funzione ricorsiva
 *
 * La ricorsione è una tecnica di programmazione in cui una funzione richiama sé stessa
 * per risolvere un problema suddividendolo in sottoproblemi più semplici. La funzione
 * ricorsiva deve avere:
 *
 * 1. **Caso base**: La condizione in cui la funzione termina senza richiamarsi ulteriormente.
 *    - Nel caso del fattoriale, il caso base è 'n == 0' o 'n == 1', dove 'n! = 1'.
 *
 * 2. **Passo ricorsivo**: La regola con cui la funzione richiama sé stessa riducendo il problema.
 *    - Nel fattoriale, il passo ricorsivo è: 'n! = n * (n-1)!'.
 *
 * **Rischi della ricorsione**:
 * - **Overflow dello stack**: Se non si raggiunge mai il caso base, la ricorsione può andare in loop infinito e causare uno 'StackOverflowError'.
 * - **Efficienza**: Per problemi con un numero elevato di chiamate ricorsive, l'uso della ricorsione può essere meno efficiente rispetto a una soluzione iterativa, poiché consuma memoria per mantenere lo stato di ogni chiamata.
 *
 * Strategie per definire una funzione ricorsiva:
 * 1. Identificare il caso base per garantire la terminazione.
 * 2. Scrivere il passo ricorsivo per ridurre il problema.
 * 3. Verificare che la funzione si avvicini sempre al caso base.
 */


public class FattorialeRicorsivo {

    /**
     * Metodo per il calcolo del fattoriale utilizzando la ricorsione.
     *
     * La ricorsione è una tecnica che suddivide un problema complesso in sottoproblemi 
     * più semplici. In questo caso, il calcolo del fattoriale segue la formula:
     *
     * - **Caso base**: Se il numero è 0 o 1, il fattoriale è 1 (0! = 1! = 1).
     * - **Passo ricorsivo**: Per tutti gli altri valori, il fattoriale è dato da:
     *   'n! = n * (n-1)!'
     *
     * @param numero Il numero per cui calcolare il fattoriale (>= 0).
     * @return Il fattoriale calcolato.
     */
    int fattorialeRicorsione(int numero) {

        if(numero==0 || numero==1) return 1; // Caso base 0! = 1! = 1

        else return numero*fattorialeRicorsione(numero-1); // Step ricorsivo
    }

    public static void main(String[] args) {

        FattorialeRicorsivo f = new FattorialeRicorsivo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Calcolare il fattoriale di: ");
        int fattoriale = sc.nextInt();
        System.out.println(f.fattorialeRicorsione(fattoriale));


    }
}
