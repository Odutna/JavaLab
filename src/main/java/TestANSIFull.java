public class TestANSIFull {

    // Mostra tutti i codici ANSI da 0 a 99
    public static void ansiAllCodes() {
        System.out.println("ANSI Codes (0-99):");
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                int n = i * 10 + j;
                if (n > 99) break;
                System.out.print("\033[" + n + "m " + n + " \033[0m");
            }
            System.out.println();
        }
    }

    // Combinazioni di effetti, foreground e background
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
        int[] foregroundColors = { 30, 31, 32, 33, 34, 35, 36, 37 }; // Colori del testo
        int[] backgroundColors = { 40, 41, 42, 43, 44, 45, 46, 47 }; // Colori di sfondo

        for (String effect : effects) {
            for (int fg : foregroundColors) {
                for (int bg : backgroundColors) {
                    System.out.print("\033[" + effect + ";" + fg + ";" + bg + "m "
                            + "E:" + effect + " FG:" + fg + " BG:" + bg + " \033[0m");
                }
                System.out.println();
            }
        }
    }

    // Test avanzato con combinazioni estese (incluso da 10 a 99)
    public static void ansiExtendedTest() {
        System.out.println("\nExtended ANSI Test (10-99):");
        for (int i = 10; i <= 99; i++) {
            System.out.print("\033[" + i + "m " + i + " \033[0m");
            if (i % 10 == 9) System.out.println();
        }
    }

    public static void main(String[] args) {
        ansiAllCodes();         // Mostra i codici base 0-99
        ansiCombinations();     // Mostra combinazioni di effetti e colori
        ansiExtendedTest();     // Mostra tutti i codici da 10 a 99
    }
}
