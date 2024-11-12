package com.civiletti;

import java.util.Scanner;

public class ArrayString3 {

    private String stringaInserita;
    private int contaSpazi;

    // Metodi getter e setter
    public String getStringaInserita() {
        return stringaInserita;
    }

    public void setStringaInserita(String stringaInserita) {
        this.stringaInserita = stringaInserita;
    }

    public int getContaSpazi() {
        return contaSpazi;
    }

    public void setContaSpazi(int contaSpazi) {
        this.contaSpazi = contaSpazi;
    }

    // Fine metodi getter e setter

    public String inserisciStringa(Scanner sc) {
        System.out.println("Inserisci una stringa:");
        return sc.nextLine();  // Legge l'intera riga di input mentre next() si ferma al primo spazio " "
    }

    public int contaSpazi(String s) {
        int conta = 0;
        String[] arrayS = s.split("");
        for (String s1 : arrayS) {
            if (s1.equals(" ")) {  // !!! Usare equals per confrontare le stringhe !!!
                conta++;
            }
            //System.out.print(s1);
        }
        setContaSpazi(conta);
        return conta;
    }

    public String toString(){
        return getClass().getSimpleName() + "{\n" +
                "\tStringa inserita: " + getStringaInserita() + "\n" +
                "\tNumero di spazi: " + getContaSpazi() + "\n" +
                "}";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayString3 as = new ArrayString3();

        String s = as.inserisciStringa(sc);
        as.setStringaInserita(s);

        System.out.println("Stringa inserita: " + as.getStringaInserita());
        as.contaSpazi(s);
        System.out.println("Numero di spazi: " + as.getContaSpazi());

        System.out.println(as);
    }
}
