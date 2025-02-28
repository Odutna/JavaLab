package com.civiletti.enumerazione.creditcard;


import java.util.regex.Pattern;

enum TipoCard {

    /*
    ^4[0-9]{12}(?:[0-9]{3})?$
                ^: Indica che il pattern deve iniziare dall'inizio della stringa.
                4: La carta VISA inizia sempre con il numero 4.
        [0-9]{12}: Dopo il 4, ci devono essere esattamente 12 cifre (qualsiasi cifra da 0 a 9).
    (?:[0-9]{3})?: Questo gruppo opzionale (?: evita di catturare il gruppo) specifica
                   che possono esserci 3 cifre aggiuntive, rendendo la lunghezza totale
                   della carta 16 cifre (opzionali rispetto alle 13 minime).
                $: Indica che il pattern deve terminare alla fine della stringa.
     */
    VISA("Visa", "^4[0-9]{12}(?:[0-9]{3})?$"),  // Inizia con 4, lunghezza 13 o 16
    MASTERCARD("Mastercard", "^5[1-5][0-9]{14}$"),  // Inizia con 51..55, lunghezza 16
    AMEX("American Express", "^3[47][0-9]{13}$");  // Inizia con 34 o 37, lunghezza 15

    private final String nome;
    private final String regexPrefisso;

    TipoCard(String nome, String regexPrefisso) {
        this.nome = nome;

        this.regexPrefisso = regexPrefisso;
    }

    public String getNome() { return nome; }
//    public String getPrefissoNumero() { return prefissoNumero; }
    public Pattern getPattern() {
        return Pattern.compile(regexPrefisso);
    }
}


// Esempio TipoCard - Validazione carta di credito
class ValidatoreCarta {

//    public boolean validaCarta(String numeroCarta, TipoCard tipo) {
//        if (!numeroCarta.startsWith(tipo.getPrefissoNumero())) {
//            System.out.println("Carta " + tipo.getNome() + " deve iniziare con " + tipo.getPrefissoNumero());
//            return false;
//        }
//        return true;
//    }

    public boolean validaCarta(String numeroCarta, TipoCard tipo) {
        if (!tipo.getPattern().matcher(numeroCarta).matches()) {
            System.out.println("La carta " + tipo.getNome() + " non rispetta il formato corretto.");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        ValidatoreCarta validatore = new ValidatoreCarta();
        String numeroCarta = "4111111111111111";
        TipoCard tipo = TipoCard.VISA;
        boolean isValida = validatore.validaCarta(numeroCarta, tipo);
        System.out.println("La carta è valida? " + isValida);

        numeroCarta = "5500000000000004";
        tipo = TipoCard.MASTERCARD;
        isValida = validatore.validaCarta(numeroCarta, tipo);
        System.out.println("La carta è valida? " + isValida);
    }
}

