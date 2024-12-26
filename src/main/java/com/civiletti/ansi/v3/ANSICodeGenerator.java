package com.civiletti.ansi.v3;

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
        BLACK("30", "40", "Nero"),
        RED("31", "41", "Rosso"),
        GREEN("92", "102", "Verde"),
        YELLOW("93", "103", "Giallo"),
        BLUE("94", "104", "Blu"),
        PURPLE("95", "105", "Viola"),
        CYAN("36", "46", "Ciano"),
        GRAY("37", "100", "Grigio"),
        WHITE("97", "107", "Bianco");

        private final String fgCode; // Codice colore per il testo
        private final String bgCode; // Codice colore per lo sfondo
        private final String description;

        Color(String fgCode, String bgCode, String description) {
            this.fgCode = fgCode;
            this.bgCode = bgCode;
            this.description = description;
        }

        public String getFgCode() {
            return fgCode;
        }

        public String getBgCode() {
            return bgCode;
        }

        public String getDescription() {
            return description;
        }
    }

    private static void displayColors(boolean isBackground) {
        for (Color color : Color.values()) {
            String code = isBackground ? color.getBgCode() : color.getFgCode();
            System.out.printf("\033[%sm%s (%s)\033[0m ", code, color.getDescription(), code);
        }
        System.out.println();
    }

    private static String getColorChoice(Scanner scanner, boolean isBackground) {
        while (true) {
            System.out.print("Inserisci codice colore: ");
            String code = scanner.nextLine().trim();

            for (Color color : Color.values()) {
                if ((isBackground && color.getBgCode().equals(code)) ||
                        (!isBackground && color.getFgCode().equals(code))) {
                    return code;
                }
            }
            System.out.println("Codice non valido. Riprova.");
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
            if (askYesNo(scanner, "Vuoi aggiungere un effetto?", "1")) {
                ansiCode.append("1;"); // Grassetto come esempio
            }

            // Handle text color
            if (askYesNo(scanner, "Vuoi aggiungere un colore al testo?", "1")) {
                displayColors(false); // Mostra i colori per il testo
                String fgCode = getColorChoice(scanner, false);
                ansiCode.append(fgCode).append(";");

                // Handle effects
                for (Effect effect : Effect.values()) {
                    if (askYesNo(scanner, effect.description + "?", effect.code)) {
                        ansiCode.append(effect.code).append(";");
                    }
                }
            }

            // Handle background color
            if (askYesNo(scanner, "Vuoi aggiungere un colore allo sfondo?", "1")) {
                displayColors(true); // Mostra i colori per lo sfondo
                String bgCode = getColorChoice(scanner, true);
                ansiCode.append(bgCode).append(";");
            }

            // Finalize code
            String finalCode = ansiCode.toString().replaceAll(";$", "m");
            System.out.println("\nCodice ANSI generato: \\" + finalCode.replaceAll("\033", "\\033"));
            System.out.println("Esempio: " + finalCode + " Testo d'esempio \033[0m");

        } while (askYesNo(scanner, "\nVuoi generare un altro codice?", "1"));
    }
}

