package com.civiletti;

/**
 * In questa versione, si vuole mostrare come implementare il *method chaining*,
 * restituendo l'istanza corrente dell'oggetto all'interno dei metodi setter.
 * Questo permette di concatenare più chiamate di metodo in una singola istruzione,
 * migliorando la leggibilità e la fluidità del codice.
 *
 * Per un ulteriore esemppio vedere anche la classe Persona.
 */


import java.util.Scanner;

public class ArrayString4 {

    private String stringaInserita;
    private int contaSpazi;

    // Metodi getter e setter
    public String getStringaInserita() {
        return stringaInserita;
    }

    public ArrayString4 setStringaInserita(String stringaInserita) {
        this.stringaInserita = stringaInserita;
        return this;  // Restituisce l'istanza corrente per consentire chiamate concatenate
    }

    public int getContaSpazi() {
        return contaSpazi;
    }
    // Fine metodi getter e setter


    public ArrayString4 setContaSpazi(int contaSpazi) {
        this.contaSpazi = contaSpazi;
        return this;  // Restituisce l'istanza corrente per consentire chiamate concatenate
    }

    public ArrayString4 inserisciStringa(Scanner sc) {
        System.out.println("Inserisci una stringa:");
        String s = sc.nextLine();  // Legge l'intera riga di input
        return setStringaInserita(s);  // Imposta la stringa inserita e restituisce l'istanza
    }

    public ArrayString4 contaSpazi() {
        int conta = 0;
        String[] arrayS = stringaInserita.split("");
        for (String s1 : arrayS) {
            if (s1.equals(" ")) {  // Usare equals per confrontare le stringhe
                conta++;
            }
        }
        return setContaSpazi(conta);  // Imposta il numero di spazi e restituisce l'istanza
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{\n" +
                "\tStringa inserita: " + getStringaInserita() + "\n" +
                "\tNumero di spazi: " + getContaSpazi() + "\n" +
                "}";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayString4 as = new ArrayString4();

        // Esempio di utilizzo concatenato
        as.inserisciStringa(sc).contaSpazi();
        System.out.println(as);
    }
}
