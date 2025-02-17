package com.civiletti.es_arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class IPValidator_v3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Richiesta input
        String[] datiInseriti = richiediInput(scanner);
        String ip = datiInseriti[0];
        String subnet = datiInseriti[1];

        // Regex per validazione sintattica
        String ipv4Regex = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
        String subnetRegex = "^(255|254|252|248|240|224|192|128|0)\\.((255|254|252|248|240|224|192|128|0)\\.){2}(255|254|252|248|240|224|192|128|0)$";

        Pattern ipv4Pattern = Pattern.compile(ipv4Regex);
        Pattern subnetPattern = Pattern.compile(subnetRegex);

        // Verifica sintattica con regex
        boolean ipCorretto = ipv4Pattern.matcher(ip).matches();
        boolean subnetCorretta = subnetPattern.matcher(subnet).matches();

        // Verifica logica aggiuntiva
        boolean ipValido = ipCorretto && isValidIPv4(ip);
        boolean subnetValida = subnetCorretta && isValidSubnetMask(subnet);

        // Risultato della validazione
        if (ipValido && subnetValida) {
            System.out.println("🛜 Indirizzo IP e Subnet validi!");

            // Formattazione dell'IP con separatore " - "
            String ipArrayString = String.join(" - ", ip.split("\\."));
            System.out.println("IP scomposto: " + ipArrayString);

            // Uso di StringBuilder per la subnet
            StringBuilder subnetBuilder = new StringBuilder();
            subnetBuilder.append("Subnet: ").append(subnet);
            System.out.println(subnetBuilder.toString());
        } else {
            System.out.println("⁉️ Indirizzo IP o Subnet non validi!");
        }

        scanner.close();
    }

    /**
     * Metodo per richiedere input utente
     */
    public static String[] richiediInput(Scanner scanner) {
        System.out.print("Inserisci un indirizzo IPv4: ");
        String ip = scanner.nextLine();

        System.out.print("Inserisci una subnet mask: ");
        String subnet = scanner.nextLine();

        return new String[]{ip, subnet};
    }

    /**
     * Controllo logico per un indirizzo IPv4 valido
     */
    public static boolean isValidIPv4(String ip) {
        String[] parts = ip.split("\\.");
        int firstOctet = Integer.parseInt(parts[0]);

        // Controlla se il primo ottetto è 0 o 255 (non valido per un host)
        if (firstOctet == 0 || firstOctet == 255) {
            return false;
        }

        // Controlla se è un IP riservato (loopback, broadcast, multicast)
        if (ip.equals("0.0.0.0") || ip.equals("255.255.255.255") || firstOctet >= 224) {
            return false;
        }

        return true;
    }

    /**
     * Controllo logico per una subnet valida
     */
    public static boolean isValidSubnetMask(String subnet) {
        String[] parts = subnet.split("\\.");
        int[] values = Arrays.stream(parts).mapToInt(Integer::parseInt).toArray();

        // Lista delle subnet valide
        int[] subnetValidValues = {255, 254, 252, 248, 240, 224, 192, 128, 0};

        // Controlla che la subnet sia decrescente senza "salti"
        boolean trovatoZero = false;
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 0) {
                trovatoZero = true;
            } else if (trovatoZero) {
                return false; // Se troviamo un valore non zero dopo uno zero → ERRORE
            }

            // Verifica che ogni valore sia tra quelli validi
            int finalI = i;
            boolean valoreValido = Arrays.stream(subnetValidValues).anyMatch(v -> v == values[finalI]);
            if (!valoreValido) {
                return false;
            }
        }

        return true;
    }
}

