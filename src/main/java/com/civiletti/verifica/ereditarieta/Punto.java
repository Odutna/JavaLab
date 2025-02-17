package com.civiletti.verifica.ereditarieta;

// Classe Punto - aggiornata con ulteriori metodi utility
public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Costruttore di copia
    public Punto(Punto p) {
        this.x = p.getX();
        this.y = p.getY();
    }

    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }

    public double distanza(Punto p1, Punto p2) {
        double dx = p1.getX() - p2.getX();
        double dy = p1.getY() - p2.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    public boolean equals(Punto p) {
        return (x == p.getX() && y == p.getY());
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}

