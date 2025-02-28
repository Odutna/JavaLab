package com.civiletti.enumerazione.calcolatrice;

import java.util.Scanner;

// Enum con metodo astratto
enum OperazioneMath {
    SOMMA {
        public double esegui(double x, double y) { return x + y; }
    },
    SOTTRAI {
        public double esegui(double x, double y) { return x - y; }
    },
    MOLTIPLICA {
        public double esegui(double x, double y) { return x * y; }
    },
    DIVIDI {
        public double esegui(double x, double y) { return x / y; }
    };

    public abstract double esegui(double x, double y);
}

// Esempio OperazioneMath - Calcolatrice
public class Calcolatrice {

    public void eseguiOperazione(double a, double b, OperazioneMath op) {
        double risultato = op.esegui(a, b);

        System.out.printf("\033[1;92;1;107m %.2f %s %.2f = %.2f \033[0m\n",
                a, op.toString(), b, risultato);

    }

    public static void main(String[] args) {
        Calcolatrice calc = new Calcolatrice();
//        calc.eseguiOperazione(10, 5, OperazioneMath.SOMMA);  // Test
//        calc.eseguiOperazione(10, 5, OperazioneMath.DIVIDI); // Test

        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("=== Calcolatrice ===");
            System.out.print("Numero: ");
            int n1 = sc.nextInt();
            System.out.println("+ - * /");
            String op = sc.next();
            System.out.println("Numero: ");
            int n2 = sc.nextInt();
            switch (op) {
                case "+":
                    calc.eseguiOperazione(n1, n2, OperazioneMath.SOMMA);
                    break;
                case "-":
                    calc.eseguiOperazione(n1, n2, OperazioneMath.SOTTRAI);
                    break;
                case "/":
                    calc.eseguiOperazione(n1, n2, OperazioneMath.DIVIDI);
                    break;
                case "*":
                    calc.eseguiOperazione(n1, n2, OperazioneMath.MOLTIPLICA);
                    break;
                default:
                    System.out.println("Operazione non valida");

            }

            System.out.println("Continuare? (s/n)");

        }while(sc.next().charAt(0) != 'n');
        sc.close();
    }
}