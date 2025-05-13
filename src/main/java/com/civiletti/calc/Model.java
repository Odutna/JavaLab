/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.civiletti.calc;

/**
 *
 * @author S.Civiletti
 */
public class Model {

    public double calcolatrice(double operando1, double operando2, String operatore) {
        System.out.println("");

        switch (operatore) {
            case "+" -> {
                return operando1 + operando2;
            }
            case "-" -> {
                return operando1 - operando2;
            }
            case "x" -> {
                return operando1 * operando2;
            }
            case "÷" -> {
                if (operando2 != 0) {
//                    System.out.println("/ -> " + (double) (operando1 / operando2));
                    return operando1 / operando2;
                } else {
                    return 0;
                }
            }
//            case "AC" -> {
//                System.out.println("AC");
//                return 0;
//            }
//            case "±" -> {
//                return -1;
//            }
            default -> {
                return 0;
            }
        }

    }

}
