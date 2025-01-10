package com.civiletti.emailvalidator;

import java.util.regex.Pattern;

public class EmailValidatorRegex {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Espressione regolare per la validazione
        String emailRegex = "^[a-zA-Z][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Verifica della stringa con il pattern
        return Pattern.matches(emailRegex, email);
    }

    public static void main(String[] args) {
        String email1 = "esempio@test.com";
        String email2 = "1nonvalida@test.com";
        String email3 = "non.valida.@com";

        System.out.println(email1 + " è valida? " + isValidEmail(email1)); // true
        System.out.println(email2 + " è valida? " + isValidEmail(email2)); // false
        System.out.println(email3 + " è valida? " + isValidEmail(email3)); // false
    }
}

