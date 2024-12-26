package com.civiletti.ansi.v2;

import java.util.Scanner;

public class ANSICodeGenerator {

    private enum Effect {
        BOLD("1", "Grassetto"),
        DIM("2", "Luminosità ridotta"),
        ITALIC("3", "Italico"),
        UNDERLINE("4", "Sottolineato"),
        BLINK_SLOW("5", "Lampeggiante lento"),
        NEGATIVE("7", "Negativo"),
        HIDDEN("8", "Nascosto"),
        STRIKETHROUGH("9", "Barrato");

        private final String code;
        private final String description;

        Effect(String code, String description) {
            this.code = code;
            this.description = description;
        }
    }

    private enum Color {
        BLACK(40, 90, "Nero"),
        RED(41, 91, "Rosso"),
        GREEN(42, 92, "Verde"),
        YELLOW(43, 93, "Giallo"),
        BLUE(44, 94, "Blu"),
        PURPLE(45, 95, "Viola"),
        CYAN(46, 96, "Ciano"),
        WHITE(47, 97, "Bianco");

        private final int fgCode;
        private final int bgCode;
        private final String description;

        Color(int fgCode, int bgCode, String description) {
            this.fgCode = fgCode;
            this.bgCode = bgCode;
            this.description = description;
        }
    }

    private static void displayColors() {
        for (Color color : Color.values()) {
            System.out.printf("\033[%dm%s (%d/%d)\033[0m ",
                    color.fgCode,
                    color.description,
                    color.fgCode,
                    color.bgCode);
        }
        System.out.println();
    }

    private static Color getColorChoice(Scanner scanner) {
        while (true) {
            System.out.print("Inserisci codice colore: ");
            int code = scanner.nextInt();
            scanner.nextLine(); // consume newline

            for (Color color : Color.values()) {
                if (color.fgCode == code || color.bgCode == code) {
                    return color;
                }
            }
            System.out.println("Codice non valido.");
        }
    }

    private static boolean askYesNo(Scanner scanner, String question, String ansiEffect) {
        System.out.print("\033[" + ansiEffect + "m" + question + " \033[0m(y/n) ");
        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            StringBuilder ansiCode = new StringBuilder("\033[");
            System.out.println("=== Crea stringa ANSI ===");

            // Handle effects
            for (Effect effect : Effect.values()) {
                if (askYesNo(scanner, effect.description + "?", effect.code)) {
                    ansiCode.append(effect.code).append(";");
                }
            }

            // Handle colors
            if (askYesNo(scanner, "Colore testo?", "1")) {
                displayColors();
                Color color = getColorChoice(scanner);
                System.out.printf("Esempio colore testo: \033[%dm%s\033[0m\n",
                        color.fgCode, "Testo di esempio");
                ansiCode.append(color.fgCode).append(";");
            }

            if (askYesNo(scanner, "Colore sfondo?", "1")) {
                displayColors();
                Color color = getColorChoice(scanner);
                System.out.printf("Esempio colore sfondo: \033[%dm%s\033[0m\n",
                        color.bgCode, "Testo di esempio con sfondo");
                ansiCode.append(color.bgCode).append(";");
            }

            // Finalize code
            String finalCode = ansiCode.toString().replaceAll(";$", "m");
            System.out.println("\nCodice: \\" + finalCode.replaceAll("\033", "\\033"));
            System.out.println("Esempio: " + finalCode + " Testo d'esempio \033[0m");

        } while (askYesNo(scanner, "\nContinuare?", "1"));
    }
}
