package com.civiletti;
import javax.sql.rowset.serial.SerialStruct;
import java.util.Scanner;

public class ArrayInserireValori {

    // Dichiarazione di un array di lunghezza 5
    int[] numeri;

    public int[] inserireValori(Scanner sc) {

        // Inserire la dimensione dell'array
        System.out.println("Quanti numeri vuoi inserire?");
        int dim = sc.nextInt();
        this.numeri = new int[dim];

        // Ciclo per leggere i numeri e inserirli nell'array
        for (int index = 0; index < numeri.length; index++) {
            System.out.print("Elemento (" + (index + 1) + "): "); // Solo visualizzazione
            numeri[index] = sc.nextInt();
        }
        return numeri;
    }

    public static String printArray(int[] array) {
        // Stampa dei numeri inseriti
        String arrayString = "Array: [ ";
        int index = 0;
        for (int num : array) { // for-each
            if(index != array.length - 1) {
                arrayString += num + ", ";
            } else arrayString += num + " ]";
            index++;
        }
        return arrayString;
    }

    public static void main(String[] args) {

        // Creazione di un oggetto ArrayInserireValori per utilizzare i suoi metodi
        ArrayInserireValori aiv = new ArrayInserireValori();

        // Creazione di un oggetto Scanner per leggere l'input dell'utente
        Scanner scanner = new Scanner(System.in);

        int[] nuovoArray = aiv.inserireValori(scanner);

        // Chiusura dello scanner
        scanner.close();

        aiv.printArray(nuovoArray);
        System.out.println(printArray(nuovoArray));
    }
}





