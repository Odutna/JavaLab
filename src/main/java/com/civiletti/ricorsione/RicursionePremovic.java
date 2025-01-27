package com.civiletti.ricorsione;

/**
 * Studente: Niko Premovic
 * Classe: 4A INF
 * Data: 12/12/2024
 * Descrizione: Classe per calcolare fattoriale in maniera ricursiva;
 *              Fibonacci in maniera non ricursiva
 *              numero decimale -> binario (ricursivo e non)
 */

public class RicursionePremovic {

    static int moltiplicazione(int fattore1, int fattore2)
    {
        return (fattore2 == 0) ? 0 : fattore1 + moltiplicazione(fattore1, fattore2-1);
    }

    static long fattoriale(int numero)
    {
        return (numero == 0) ? 1 : numero * fattoriale(numero -1);
    }

    static long fibonacci(int numero)
    {
        long counter = numero, z = 0, y = 1, x = 0;
        while (counter > 0)
        {
            z = x + y;
            x = y;
            y = z;
            counter--;
        }
        return x;
    }

    static long fibonacciRicursivo(int n)
    {
        return (n <= 1) ? n : fibonacci(n-1) + fibonacci(n-2);
    }
    //Decimale --> Binario (Numeri Positivi)
    static int conversioneDecBin1(int numeroDecimale) {

        int n = numeroDecimale, divisore;
        int numeroBinarioCiclo, numeroBinario = 0;

        while (n > 0)
        {
            numeroBinarioCiclo = 1;
            divisore = 2;

            while (divisore <= n) {
                numeroBinarioCiclo *= 10;
                divisore *= 2;
            }

            numeroBinario += numeroBinarioCiclo;
            divisore /= 2;
            n -= divisore;
        }

        //System.out.println(n);
        //numeroBinario += (n == 1) ? 1 : 0;

        return numeroBinario;
    }
    //Decimale --> Binario (Numeri Positivi) (versione migliore)
    static int conversioneDecBin2(int numeroDecimale) {

        int n = numeroDecimale, divisore;
        int numeroBinarioCiclo, numeroBinario = 0;

        while (n > 0)
        {
            numeroBinarioCiclo = 1;
            divisore = 1;

            while (divisore*2 <= n) {
                divisore *= 2;
                numeroBinarioCiclo *= 10;
            }

            numeroBinario += numeroBinarioCiclo;
            n -= divisore;
        }
        return numeroBinario;
    }

    //Decimale --> Binario  (Numeri Positivi)
    static int conversioneDecBinRicursiva(int numeroDecimale) {

        int n = numeroDecimale, divisore = 1;
        int numeroBinarioCiclo = 1;

            while (divisore*2 <= n) {
                divisore *= 2;
                numeroBinarioCiclo *= 10;
            }

        return (numeroDecimale == 0) ? 0 : numeroBinarioCiclo + conversioneDecBinRicursiva(numeroDecimale-divisore);
    }

    public static void main(String[] args)
    {
        for (int i = 1; i < 20; i++) {
            System.out.println(fibonacciRicursivo(i) + "|" + fibonacci(i));
//            System.out.println(moltiplicazione((i), 5));
//            System.out.println(fattoriale((i)));
//            System.out.println(conversioneDecBin2(i) + "|" + conversioneDecBinRicursiva(i));
        }

    }
}


//Decimale --> Binario
/*    static int conversioneDecBin(int numeroDecimale) {
        int n = numeroDecimale, divisore = 2, numeroBinario = 0;
        int counter = 0;
        int numeroBinarioCiclo = 10;

        while (n > 1)
        {
            n -= divisore;
            numeroBinarioCiclo = 1;
            divisore = 2;

            while (divisore <= n) {
                numeroBinarioCiclo *= 10;
                divisore *= 2;
            }

            numeroBinario += numeroBinarioCiclo;
        }
        //System.out.println(n);
        numeroBinario += (n == 1) ? 1 : 0;

        return numeroBinario;
    }
*/