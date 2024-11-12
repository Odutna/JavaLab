package com.civiletti;



import java.lang.reflect.Array;
import java.util.ArrayList;

public class ScatolaGenerica<T> {


    private T contenuto;

    public void setContenuto(T contenuto) {
        this.contenuto = contenuto;
    }

    public T getContenuto() {
        return contenuto;
    }


    public <T> void printArray( T[] array) {
        String separazione = " - ";
        for (T elemento : array) {
            System.out.print(elemento +separazione);
        }
        System.out.println();
    }

    public static void main(String[] args) {

        System.out.println("Tipi Generics\n");

        ScatolaGenerica<String> scatolaString = new ScatolaGenerica<>();
        scatolaString.setContenuto("Ciao sono un tipo String!");
        System.out.println("Contenuto: " + scatolaString.getContenuto());

        ScatolaGenerica<Integer> scatolaInt = new ScatolaGenerica<>();
        scatolaInt.setContenuto(123);
        System.out.println("Contenuto: " + scatolaInt.getContenuto());

        ScatolaGenerica<Boolean> scatolaBoolean = new ScatolaGenerica<>();
        scatolaBoolean.setContenuto(true);
        System.out.println("Contenuto: " + scatolaBoolean.getContenuto());

        ScatolaGenerica<Array> scatolaArray = new ScatolaGenerica<>();
        String[] words = {"I", "tipi", "generici", "sono", "molto", "utili"};
        Integer[] numbers = {1, 2, 3, 4, 5};
        scatolaArray.printArray(words);
        scatolaArray.printArray(numbers);

        //printArray(words);
        //printArray(numbers);
    }
}


