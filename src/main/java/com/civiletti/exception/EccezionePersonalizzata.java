package com.civiletti.exception;

class MiaEccezione extends Exception {
    public MiaEccezione(String messaggio) {
        super(messaggio);
    }
}

public class EccezionePersonalizzata {
    public static void main(String[] args) {
        try {
            lanciaEccezione();
        } catch (MiaEccezione e) {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public static void lanciaEccezione() throws MiaEccezione {
        throw new MiaEccezione("Questa è un'eccezione personalizzata.");
    }
}
