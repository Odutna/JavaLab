package com.civiletti.ansi.v1;

import java.util.Scanner;

public class ANSICodeGenerator {

    private enum Effect {
        BOLD("1", "Grassetto"),
        DIM("2", "Luminosità ridotta"),
        ITALIC("3", "Italico"),
        UNDERLINE("4", "Sottolineato"),
        BLINK_SLOW("5", "Lampeggiante lento"),
//        BLINK_FAST("6", "Lampeggiante veloce"),
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
        BLACK(30, 40, "Nero"),
        RED(31, 41, "Rosso"),
        GREEN(32, 92, "Verde"),
        YELLOW(33, 43, "Giallo"),
        BLUE(34, 94, "Blu"),
        PURPLE(35, 95, "Viola"),
        CYAN(36, 46, "Ciano"),
        WHITE(37, 47, "Bianco");

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
            System.out.printf("%s (%d/%d) ", color.description, color.fgCode, color.bgCode);
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

    private static boolean askYesNo(Scanner scanner, String question) {
        System.out.print(question + " ");
        return scanner.nextLine().trim().equalsIgnoreCase("y");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            StringBuilder ansiCode = new StringBuilder("\033[");
            System.out.println("=== Crea stringa ANSI ===");

            // Handle effects
            for (Effect effect : Effect.values()) {
                if (askYesNo(scanner, effect.description + "? (y/n)")) {
                    ansiCode.append(effect.code).append(";");
                }
            }

            // Handle colors
            if (askYesNo(scanner, "Colore testo? (y/n)")) {
                displayColors();
                Color color = getColorChoice(scanner);
                ansiCode.append(color.fgCode).append(";");
            }

            if (askYesNo(scanner, "Colore sfondo? (y/n)")) {
                displayColors();
                Color color = getColorChoice(scanner);
                ansiCode.append(color.bgCode).append(";");
            }

            // Finalize code
            String finalCode = ansiCode.toString().replaceAll(";$", "m");
            System.out.println("\nCodice: \\" + finalCode.replaceAll("\033", "\\033"));
            System.out.println("Esempio: " + finalCode + "Testo di esempio\033[0m");

        } while (askYesNo(scanner, "\nContinuare? (y/n)"));
    }
}
