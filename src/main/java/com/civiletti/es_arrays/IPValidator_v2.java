package com.civiletti.es_arrays;

import java.util.Scanner;
import java.util.regex.Pattern;

public class IPValidator_v2 {


    /**
     * Metodo per richiedere l'input all'utente.
     * @param scanner Scanner per l'input utente
     * @return Array con [IP, Subnet Mask]
     */
    public static String[] richiediInput(Scanner scanner) {
        System.out.print("Inserisci un indirizzo IPv4: ");
        String ip = scanner.nextLine();

        System.out.print("Inserisci una subnet mask: ");
        String subnet = scanner.nextLine();

        return new String[]{ip, subnet}; // Restituiamo entrambi i valori in un array
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Richiesta dati all'utente
        String[] datiInseriti = richiediInput(scanner);
        String ip = datiInseriti[0];
        String subnet = datiInseriti[1];

        // Regex per validare IPv4 e subnet
        String ipv4Regex = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";
        String subnetRegex = "^(255|254|252|248|240|224|192|128|0)\\.((255|254|252|248|240|224|192|128|0)\\.){2}(255|254|252|248|240|224|192|128|0)$";

        // Creazione dei pattern regex
        Pattern ipv4Pattern = Pattern.compile(ipv4Regex);
        Pattern subnetPattern = Pattern.compile(subnetRegex);

        // Validazione IP e Subnet
        boolean ipValido = ipv4Pattern.matcher(ip).matches();
        boolean subnetValida = subnetPattern.matcher(subnet).matches();

        // Output della validazione
        if (ipValido && subnetValida) {
            System.out.println("🛜 Indirizzo IP e Subnet validi!");

            // Formattazione dell'IP con separatore " - "
            String[] ipParts = ip.split("\\.");
            String ipArrayString = String.join(" - ", ipParts);  // Alternativa più semplice agli Streams

            System.out.println("IP scomposto: " + ipArrayString);

            // Uso di StringBuilder per costruire il messaggio della subnet
            StringBuilder subnetBuilder = new StringBuilder();
            subnetBuilder.append("Subnet: ").append(subnet);

            System.out.println(subnetBuilder.toString());
        } else {
            System.out.println("⁉️ Indirizzo IP o Subnet non validi!");
        }

        scanner.close();
    }


}
