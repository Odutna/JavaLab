package com.civiletti.esercitazione;

/**
 * Definire una classe Punto per impostare le coordinate del punto, il calcolo della distanza e
 * sovrascivere il metodo toString in modo che consena di visualizzare il punto come es. P1(1,7.8)
 *
 * Inoltre definire una classe TestPunto che prevede un metodo per l'inserimento delle coordinate
 * dei punti e poi visualizzi i risultati. Devono essere rispettati i principi dell'incapsulamento
 * dei dati
 *
 * La formula per calcolare la distanza  d tra due punti P1(x1, y1) e P2(x2, y2) è:
 *
 *       d = √ (x2 - x1)^2 + (y2 - y1)^2
 *  nel piano cartesiano è data da:
 */


public class Punto {
    private double x;
    private double y;

    // Costruttore principale
    public Punto(double x, double y) {
        setX(x);
        setY(y);
    }

    // Costruttore di copia - l'uso di this è ridondante, in questo caso non ci sono ambiguità, quindi può essere omesso
    public Punto(Punto p) {
        x = p.getX();
        y = p.getY();
    }

    // Metodi setter
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Metodi getter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Calcolo della distanza tra due punti
    public static double distanza(Punto p1, Punto p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt((dx * dx) + (dy * dy));
    }

    // Metodo equals per confrontare due punti
    public boolean equals(Punto p) {
        return ((x == p.x) && (y == p.y));
    }

    // Metodo toString per rappresentare il punto come stringa
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    // Metodo main per testare la classe
    public static void main(String[] args) {
        Punto p1 = new Punto(1.0, 1.0);
        Punto p2 = new Punto(2.0, 2.0);
        Punto p3 = new Punto(p1);

        System.out.println("P1" + p1.toString());
        System.out.println("P2" + p2.toString());
        System.out.println("P3" + p3.toString());

        System.out.println("Distanza P1-P2: " + distanza(p1, p2));
        System.out.println("Distanza P1-P3: " + distanza(p1, p3));

        if (p1.equals(p3)) {
            System.out.println("P1 e P3 coincidono");
        } else {
            System.out.println("P1 e P3 non coincidono");
        }
    }
}
