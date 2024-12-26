package com.civiletti.ansi;

import java.util.Scanner;

public class TestANSI {

    public static void ansiBase(){
        int n;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 10; j++) {
                n = 10 * i + j;
                if (n > 108) break;
                System.out.print("\033[" + n + "m " + n +"\033[m");
            }
            System.out.println();
        }
    }

    public static void ansiCombinations() {
        System.out.println("\nCombinazioni ANSI (Effetti e Colori):");

        String[] effects = {
                "1",  // Grassetto
                "2",  // Luminosità ridotta
                "3",  // Italico
                "4",  // Sottolineato
                "5",  // Lampeggiante lento
                "6",  // Lampeggiante veloce - non supportato dalla maggior parte dei terminali moderni (iTerm2, GNOME Terminal, macOS Terminal, Windows PowerShell)
                "7",  // Negativo - inverte i colori di primo piano e sfondo
                "8",  // Nascosto - nasconde il testo mantenendolo presente nel buffer e può essere rivelato con ANSI 28 (Show)
                "9"   // Barrato
        };

        int cont = 9; // Contatore per andare a capo ogni 10 combinazioni

        for (String effect : effects) {
            for (int color = 0; color <= 99; color++) { // Codici colore da 0 a 99
                String ansiCode = "\033[" + effect + ";" + color + "m";
                String resetCode = "\033[0m";

                // Stampa l'effetto con codice ANSI e visualizza il codice
                System.out.print(ansiCode
                        + "Efx:" + effect + " Color:" + color + " "
                        + resetCode);

                // Stampa il codice ANSI per copia/incolla
//                System.out.print(" [Code: " + ansiCode.replace("\033", "\\033") + resetCode + "] ");
                System.out.println(" => " + ansiCode + " \"" + ansiCode.replace("\033", "\\033") + resetCode + "\" ");

                // Vai a capo ogni 10 combinazioni
                if (cont == 0) {
                    System.out.println();
                    cont = 10;
                }
                cont--;
            }
            System.out.println();
        }
    }

    // Combinazioni di effetti, foreground e background
    public static void ansiEfxFgBg() {
        System.out.println("\nCombinazioni ANSI (Effetti e Colori):");

        String[] effects = {
                "1",  // Grassetto
                "2",  // Luminosità ridotta
                "3",  // Italico
                "4",  // Sottolineato
                "5",  // Lampeggiante lento
                "6",  // Lampeggiante veloce - non supportato dalla maggior parte dei terminali moderni (iTerm2, GNOME Terminal, macOS Terminal, Windows PowerShell)
                "7",  // Negativo - inverte i colori di primo piano e sfondo
                "8",  // Nascosto - nasconde il testo mantenendolo presente nel buffer e può essere rivelato con ANSI 28 (Show)
                "9"   // Barrato
        };
        int[] foregroundColors = { 30, 31, 32, 33, 34, 35, 36, 37 }; // Colori del testo
        int[] backgroundColors = { 40, 41, 42, 43, 44, 45, 46, 47 }; // Colori di sfondo

        for (String effect : effects) {

            for (int fg=1; fg<99; fg++) {
                if(fg == 1 ) System.out.print("\t\t ");
                for (int bg=1; bg<99; bg++) {
                    if(bg == 1 ) System.out.print("\t\t ");
                    System.out.print("\033[" + effect + ";" + fg + ";" + bg + "m "
                            + "E:" + effect + " FG:" + fg + " BG:" + bg + " \033[0m");
                    if((bg+1) % 9 == 0) System.out.println();
                }
                System.out.println();
            }
        }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("[1] ANSI BASE, [2] ANSI COMBINATIONS, [3] ANSI EFFECTS + Foregroung and Background Colors [Q]uit");
            char selection = scanner.nextLine().charAt(0);
            switch (selection) {
                case '1':
                    ansiBase();
                    break;
                case '2':
                    ansiCombinations();
                    break;
                case '3':
                    ansiEfxFgBg();
                    break;
                default:
                    System.out.printf("Value non permitted!");
            }
            if(selection == 'Q') break;
            else System.out.printf("[C]continue [Q]uit\n");
        }while(scanner.nextLine().charAt(0) != 'Q');

        // Testo invisibile (stesso colore dello sfondo)
        System.out.println("\033[30;40mQuesto è invisibile su sfondo nero\033[0m");

        // Testo nascosto (ANSI 8)
        System.out.println("\033[8mQuesto è nascosto\033[0m");
        // Per rivelarlo: non disponibile in molti termila (si utilizzano tecniche avanzate)
        System.out.println("\033[28mOra il testo nascosto è visibile\033[0m");

        // Testo invertito (ANSI 7)
        System.out.println("\033[7mQuesto testo è invertito\033[0m");

        System.out.println("\033[1;3;9;33;40mQuesto è un test con lo sfondo NERO");
    }
}
