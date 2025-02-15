package com.civiletti.es_arrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 *
 *
 * Regex per l'indirizzo IP:
 *
 * ^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$
 *
 * ===============================================================================================================
 * Simbolo	Significato	                           Esempio nella regex
 * ===============================================================================================================
 * ^	    Indica l'inizio della stringa	       L'IP deve iniziare all'inizio della stringa
 * $	    Indica la fine della stringa	       L'IP deve terminare esattamente lì, senza caratteri extra
 * (...)	Gruppo di espressioni	               Raggruppa i pattern per ripetizioni o alternative
 *  |		Operatore OR (alternativa)             'pipe'
 * {3}	    Ripetizione esatta di un elemento	   `(25[0-5]
 * \.	    Carattere punto (.) letterale	       Separa gli ottetti, come in 192.168.1.1
 * [...]	Classe di caratteri	[0-9]              indica qualsiasi cifra da 0 a 9
 * ?	    Rende un carattere opzionale	       1?[0-9][0-9]? permette numeri a 1, 2 o 3 cifre
 *
 * ===============================================================================================================
 *    Parte della regex	    Spiegazione	               Esempi validi	    Esempi non validi
 * ===============================================================================================================
 *    ^	                    Inizio della stringa	   192.168.1.1	        test 192.168.1.1 ❌
 *    (25[0-5]	        Cattura numeri da 250 a 255	   250, 255	            260 ❌
 *                      2[0-4][0-9]      	          Cattura numeri 	    200, 225, 249
 *                                                    da 200 a 249
 *                      1?[0-9][0-9]?   	          Cattura numeri    	0, 99, 150, 199
 *                                                    da 0 a 199
 *    )	                Chiude il gruppo del numero	       -	                 -
 *    \.	            Punto obbligatorio dopo il   	192.	            192 ❌ (manca il punto)
 *                      numero
 *    {3}	            Ripete il gruppo 3 volte 	  192.168.1.	        192.168. ❌ (manca un numero)
 *                      per catturare 3 ottetti
 *    (25[0-5]	        2[0-4][0-9]	                  1?[0-9][0-9]?)`	    Ultimo numero (senza il punto)
 *    $	                Fine della stringa	          192.168.1.1	        192.168.1.1 extra ❌
 *
 *
 *  250-255 → 25[0-5]
 *  200-249 → 2[0-4][0-9]
 *  0-199 → 1?[0-9][0-9]?
 *
 * Regex per la Subnet Mask:
 * ^(255|254|252|248|240|224|192|128|0)\.((255|254|252|248|240|224|192|128|0)\.){2}(255|254|252|248|240|224|192|128|0)$
 *
 * ==========================================================================================
 * Parte della regex	Spiegazione	            Esempi validi	   Esempi non validi
 * ==========================================================================================
 * ^	                Inizio della stringa	255.255.255.0	   abc 255.255.255.0 ❌
 * (255	                254	                    252	               248
 * \.	                Punto separatore	    255.	           255 ❌ (manca il punto)
 * ((255	            254	                    252	               248
 * (255	                254	                    252	               248
 * $	                Fine della stringa	    255.255.255.0	   255.255.255.0 extra ❌
 *
 */


public class IPValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Regex per IPv4 valida (0-255.0-255.0-255.0-255)
        String ipv4Regex = "^((25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\.){3}(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)$";

        // Regex per Subnet valida (255.255.255.0, 255.0.0.0, ecc.)
        String subnetRegex = "^(255|254|252|248|240|224|192|128|0)\\.((255|254|252|248|240|224|192|128|0)\\.){2}(255|254|252|248|240|224|192|128|0)$";

        Pattern ipv4Pattern = Pattern.compile(ipv4Regex);
        Pattern subnetPattern = Pattern.compile(subnetRegex);

        System.out.print("Inserisci un indirizzo IPv4: ");
        String ip = scanner.nextLine();

        System.out.print("Inserisci una subnet mask: ");
        String subnet = scanner.nextLine();

        // Validazione IP e subnet
        boolean ipValido = ipv4Pattern.matcher(ip).matches();
        boolean subnetValida = subnetPattern.matcher(subnet).matches();

        if (ipValido && subnetValida) {
            System.out.println("✅ Indirizzo IP e Subnet validi!");

            // Uso di Arrays per suddividere l'IP
            String[] ipParts = ip.split("\\.");

            // esempio di utilizzo di stream e collectors
            String ipArrayString = Arrays.stream(ipParts).collect(Collectors.joining(" - "));

            /**
             * Scrittura equivalente:
             *
             * String ipArrayString = "";
             * for (int i = 0; i < ipParts.length; i++) {
             *     ipArrayString += ipParts[i];
             *     if (i < ipParts.length - 1) {
             *         ipArrayString += " - ";
             *     }
             * }
             *
             */

            System.out.println("IP scomposto: " + ipArrayString);

            // Uso di StringBuilder per costruire la subnet con prefisso
            StringBuilder subnetBuilder = new StringBuilder();
            subnetBuilder.append("Subnet: ").append(subnet);

            System.out.println(subnetBuilder.toString());
        } else {
            System.out.println("❌ Indirizzo IP o Subnet non validi!");
        }

        scanner.close();
    }
}

