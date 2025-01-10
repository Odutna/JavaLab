package com.civiletti.emailvalidator;

public class EmailValidator {

    public static boolean isValidEmail(String email) {
        // Verifica che l'email non sia null o vuota
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Cerca l'indice dei caratteri '@' e punto '.'  (dell'ultimaparte nome.cognome@dominio.com)
        int atPosition = email.indexOf('@');
        int dotPosition = email.lastIndexOf('.');

        // Validazione basata sulle posizioni
        if (atPosition > 0 // '@' non è il primo carattere
            && dotPosition > atPosition + 1 // '.' segue '@'
            && dotPosition < email.length() - 1 // '.' non è l'ultimo carattere
        ) {
            // Estrai le sottostringhe principali
            String localPart = email.substring(0, atPosition);
            String domainPart = email.substring(atPosition + 1, dotPosition);
            String topLevelDomain = email.substring(dotPosition + 1);

            // Controlla che tutte le parti non siano vuote
            return !localPart.isEmpty() && !domainPart.isEmpty() && !topLevelDomain.isEmpty();
        }

        return false;
    }


    public static void main(String[] args) {
        String email1 = "esempio@test.com";
        String email2 = "nonvalida@com";
        String email3 = "@mancapartelocale.com";
        String email4 = "invalid..email@domain.com";
        String email5 = "valid.email@sub.domain.co.uk";

        System.out.println(email1 + " è valida? " + isValidEmail(email1)); // true
        System.out.println(email2 + " è valida? " + isValidEmail(email2)); // false
        System.out.println(email3 + " è valida? " + isValidEmail(email3)); // false
        System.out.println(email4 + " è valida? " + isValidEmail(email4)); // true
        System.out.println(email5 + " è valida? " + isValidEmail(email5)); // true
    }
}
