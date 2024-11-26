package com.civiletti;

/**
 * Questo esempio rappresenta un'introduzione al cifrario di Cesare.
 *
 * Il modulo (%), utilizzato nel calcolo della codifica, è essenziale per garantire
 * una ciclazione circolare. Ciò significa che, se si supera il limite massimo
 * rappresentabile per un carattere (es. nel set Unicode), si riparte dal minimo.
 * Questo evita errori o risultati fuori dall'intervallo dei caratteri validi.
 *
 * # Ciclazione con il Modulo (%)
 *
 * La tabella mostra il comportamento del modulo ('%') per numeri da 0 a 15 con divisore 5:
 *
 * | Numero | Divisione Intera (÷) | Resto | Risultato Modulo (%) |
 * |--------|----------------------|-------|----------------------|
 * | 0      | 0 ÷ 5 = 0            | 0     | 0 % 5 = 0            |
 * | 1      | 1 ÷ 5 = 0            | 1     | 1 % 5 = 1            |
 * | 2      | 2 ÷ 5 = 0            | 2     | 2 % 5 = 2            |
 * | 3      | 3 ÷ 5 = 0            | 3     | 3 % 5 = 3            |
 * | 4      | 4 ÷ 5 = 0            | 4     | 4 % 5 = 4            |
 * | 5      | 5 ÷ 5 = 1            | 0     | 5 % 5 = 0            |
 * | 6      | 6 ÷ 5 = 1            | 1     | 6 % 5 = 1            |
 * | 7      | 7 ÷ 5 = 1            | 2     | 7 % 5 = 2            |
 * | 8      | 8 ÷ 5 = 1            | 3     | 8 % 5 = 3            |
 * | 9      | 9 ÷ 5 = 1            | 4     | 9 % 5 = 4            |
 * | 10     | 10 ÷ 5 = 2           | 0     | 10 % 5 = 0           |
 * | 11     | 11 ÷ 5 = 2           | 1     | 11 % 5 = 1           |
 * | 12     | 12 ÷ 5 = 2           | 2     | 12 % 5 = 2           |
 * | 13     | 13 ÷ 5 = 2           | 3     | 13 % 5 = 3           |
 * | 14     | 14 ÷ 5 = 2           | 4     | 14 % 5 = 4           |
 * | 15     | 15 ÷ 5 = 3           | 0     | 15 % 5 = 0           |
 *
 * 1. Il modulo è "circolare": quando il numero raggiunge un multiplo del divisore, torna a '0'.
 * 2. I valori del modulo sono sempre compresi tra '0' e il divisore.
 * 
 */
public class CodificaDecodificaCaratteri {

    public static void main(String[] args) {
        System.out.println("<Codifica>");
        // Codifica
        char lettera = 'z';  // codice ASCII 122
        int shift = 2;  // Numero di posizioni da spostare
        int codiceAscii = (int) lettera;  // Converte il carattere nel valore ASCII (122)

        // Applica lo shift con ciclazione grazie al modulo
        int codificaCifra = (codiceAscii + shift) % 65536; // 124
        char risultato = (char) codificaCifra;  // Converte il nuovo codice ASCII in carattere ('|')

        System.out.printf(" Lettera: " + lettera + "\n" +
                " Shift: " + shift + "\n" +
                " Codifica Cifra: " + codificaCifra + "\n" +
                " Codifica: " + risultato + "\n\n");

        System.out.println("<Decodifica>");
        // Decodifica
        char letteraCifrata = '|';  // codice ASCII 124
        codiceAscii = (int) letteraCifrata;  // Converte in ASCII (124)

        // Decodifica applicando l'inverso dello shift
        // Nota: qui il modulo non è usato perché non si verifica un underflow
        int decodificaCifra = codiceAscii - shift; // 122
        risultato = (char) decodificaCifra;  // Riconverte in carattere originale ('z')

        System.out.printf(" Lettera Cifrata: " + letteraCifrata + "\n" +
                " Shift: " + shift + "\n" +
                " Decodifica Cifra: " + decodificaCifra + "\n" +
                " Decodifica: " + risultato + "\n\n");

        System.out.println("<Decodifica Circolare>");
        // Decodifica Circolare
        letteraCifrata = '|';  // codice ASCII 124
        codiceAscii = (int) letteraCifrata;  // Converte in ASCII (124)

        // Decodifica con modulo per ciclazione
        decodificaCifra = (codiceAscii - shift + 65536) % 65536; // Evita valori negativi
        risultato = (char) decodificaCifra;  // Riconverte in carattere originale ('z')

        System.out.printf(" Lettera Cifrata: " + letteraCifrata + "\n" +
                " Shift: " + shift + "\n" +
                " Decodifica Cifra: " + decodificaCifra + "\n" +
                " Decodifica: " + risultato + "\n");
    }
}
