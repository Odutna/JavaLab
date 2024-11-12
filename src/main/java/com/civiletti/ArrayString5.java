package com.civiletti;

import java.util.Scanner;

public class ArrayString5 {

    private String stringaInserita;
    private int contaSpazi;
    private int contaConsonanti;
    private int contaVocali;

    ArrayString5() {

    }

    ArrayString5(String stringa) {
        this.stringaInserita = stringa;
    }

    // Metodi getter e setter
    public String getStringaInserita() {
        return stringaInserita;
    }

    public ArrayString5 setStringaInserita(String stringaInserita) {
        this.stringaInserita = stringaInserita;
        return this;  // Restituisce l'istanza corrente per consentire chiamate concatenate
    }

    public int getContaSpazi() {
        return contaSpazi;
    }

    public ArrayString5 setContaSpazi(int contaSpazi) {
        this.contaSpazi = contaSpazi;
        return this;  // Restituisce l'istanza corrente per consentire chiamate concatenate
    }

    public int getContaConsonanti() {
        return contaConsonanti;
    }

    public ArrayString5 setContaVocali(int contaVocali) {
        this.contaVocali = contaVocali;
        return this;
    }

    public int getContaVocali() {
        return contaVocali;
    }

    public ArrayString5 setContaConsonanti(int contaConsonanti) {
        this.contaConsonanti = contaConsonanti;
        return this;
    }

    // Fine metodi getter e setter

    public ArrayString5 inserisciStringa(Scanner sc) {
        System.out.println("Inserisci una stringa:");
        String s = sc.nextLine();  // Legge l'intera riga di input
        return setStringaInserita(s);  // Imposta la stringa inserita e restituisce l'istanza
    }

    public ArrayString5 contaSpazi() {
        int conta = 0;
        String[] arrayS = stringaInserita.split("");
        for (String s1 : arrayS) {
            if (s1.equals(" ")) {  // Usare equals per confrontare le stringhe
                conta++;
            }
        }
        return setContaSpazi(conta);  // Imposta il numero di spazi e restituisce l'istanza
    }

    // Metodo per contare le consonanti in una stringa
    public ArrayString5 contaConsonanti() {
        int conta = 0;
        String[] arrayS = stringaInserita.toLowerCase().split("");
        for (String s1 : arrayS) {
            if (s1.matches("[^aeiouAEIOU]")) {  // Verifica se s1 è una consonante
                conta++;
            }
        }
        return setContaConsonanti(conta);
    }

    // Metodo per contare le consonanti in una stringa
    public ArrayString5 contaVocali() {
        int conta = 0;
        String[] arrayS = stringaInserita.toLowerCase().split("");
        for (String s1 : arrayS) {
            if (s1.matches("[aeiouAEIOU]")) {  // Verifica se s1 è una consonante
                conta++;
            }
        }
        return setContaVocali(conta);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "{\n" +
                "\tStringa inserita: " + getStringaInserita() + "\n" +
                "\tNumero di spazi: " + getContaSpazi() + "\n" +
                "\tNumero di consonanti: " + getContaConsonanti() + "\n" +
                "\tNumero di vocai: " + getContaVocali() + "\n" +
                "}";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayString5 as = new ArrayString5();

        String testStringa = "Questo è un semplice test per contare gli spazi le vocali e leconsonanti con concatenamento ";

        // Esempio di utilizzo concatenato
        as.inserisciStringa(sc).contaSpazi().contaConsonanti().contaVocali();
        System.out.println(as);

        ArrayString5 as1 = new ArrayString5(testStringa);

        as1.contaSpazi().contaConsonanti().contaVocali();
        System.out.println(as1);
    }
}
