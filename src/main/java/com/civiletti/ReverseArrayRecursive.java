package com.civiletti;

import java.util.Arrays;

public class ReverseArrayRecursive {
    static int step = 1;
    /**
     * Inverte il contenuto del sottoarray data[low]...data[high], estremi compresi.
     */
    public static void reverseArrayRecursive(int[] data, int low, int high) {
        if (low < high) { // Se il sottoarray ha almeno due elementi
            int temp = data[low];        // Salva il valore di data[low]
            data[low] = data[high];      // Scambia data[low] con data[high]
            data[high] = temp;           // Assegna il valore salvato a data[high]

            System.out.println("step (" + step + ") -> " +Arrays.toString(data));
            step++;
            reverseArrayRecursive(data, low + 1, high - 1); // Ricorsione sulla parte restante
        }
    }

    public static void main(String[] args) {
        int[] data = { 4, 3, 6, 2, 7, 8, 9, 5};

        reverseArrayRecursive(data, 0, data.length - 1);

        System.out.println(Arrays.toString(data));

    }
}
