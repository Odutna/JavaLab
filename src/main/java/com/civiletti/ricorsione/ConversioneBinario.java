package com.civiletti.ricorsione;

import java.util.Scanner;

// Conversione di un numero intero decimale in binario tramite ricorsione
public class ConversioneBinario {

    static int inserisci(Scanner sc){
        System.out.print("Numero decimale da convertire: ");
        return sc.nextInt();
    }

    // Metodo ricorsivo per convertire un numero decimale in binario

    /**
     * Esempio
     *      binario(12) → chiamata binario(6)
     *      binario(6) → chiamata binario(3)
     *      binario(3) → chiamata binario(1)
     *      binario(1) → chiamata binario(0) <Termina la chiamata ricorsiva e passa alla stampa da binario(1)>
     * Stampa (ordine inverso):
     *      1 (da binario(1))
     *      1 (da binario(3))
     *      0 (da binario(6))
     *      0 (da binario(12))
     * @param numero
     */
    public static void binarioVoid(int numero) {

        if (numero > 0) {                   // Condizione di terminazione della ricorsione
            binarioVoid(numero / 2);    // Chiamata ricorsiva diviso 2
            System.out.print(numero % 2);   // Stampa il resto della divisione per 2 (bit)
        }
    }


    /**
     * Chiamata iniziale:
     *      binario(12) → return binario(6) + "0"
     * Seconda chiamata:
     *      binario(6) → return binario(3) + "0"
     * Terza chiamata:
     *      binario(3) → return binario(1) + "1"
     * Quarta chiamata:
     *      binario(1) → return binario(0) + "1"
     * Quinta chiamata (caso base):
     *      binario(0) → return "" (stringa vuota)
     *
     * Costruzione della stringa
     * Durante il ritorno della ricorsione, la stringa si costruisce concatenando i risultati:
     *
     * binario(0) → ""
     * binario(1) → "" + "1" → "1"
     * binario(3) → "1" + "1" → "11"
     * binario(6) → "11" + "0" → "110"
     * binario(12) → "110" + "0" → "1100"
     *
     * @param numero
     * @return
     */
    public static String binarioString(int numero) {
        if (numero == 0) return "0b"; // Caso base: stringa che indica la base di conversione
        return binarioString(numero / 2) + (numero % 2); // Ricorsione: calcola la parte superiore e aggiunge il resto come stringa
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===============================");
        System.out.println("=   Conversione in binario    =");
        System.out.println("===============================");

        int cont = 0;
        do {
            if( cont ==0 ) {
                System.out.println("[0]");
                binarioVoid(inserisci(sc));
                cont++;
            } else {
                System.out.println("[1]");
                System.out.println(binarioString(inserisci(sc)));
                cont = 0;
            }
            System.out.println("\nContinuare? (s/n)");
        }while(sc.next().charAt(0) != 'n');

        System.out.println("Arrivederci!");
    }


}
