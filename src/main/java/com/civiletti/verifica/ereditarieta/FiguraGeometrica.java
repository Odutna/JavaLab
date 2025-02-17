package com.civiletti.verifica.ereditarieta;

// Classe base per tutte le figure geometriche
public class FiguraGeometrica {
    protected Punto[] vertici;

    public FiguraGeometrica(Punto[] punti) {
        // Uso del costruttore di copia per ogni punto
        vertici = new Punto[punti.length]; // crea una copia indipendente di ogni punto, proteggendo i dati della figura da modifiche esterne
        for (int i = 0; i < punti.length; i++) {
            vertici[i] = new Punto(punti[i]); // Qui usiamo il costruttore di copia!
        }
    }

    // Metodo generico per calcolare l'area di qualsiasi poligono
    public double calcolaArea() {
        // Formula dell'area di un poligono irregolare usando le coordinate dei vertici
        // A = 1/2 * |x1(y2 - yn) + x2(y3 - y1) + x3(y4 - y2) + ... + xn(y1 - yn-1)|
        double area = 0;
        for (int i = 0; i < vertici.length; i++) {
            int j = (i + 1) % vertici.length;
            area += vertici[i].getX() * vertici[j].getY();
            area -= vertici[i].getY() * vertici[j].getX();
        }
        return Math.abs(area) / 2;
    }

    public double calcolaPerimetro() {
        Punto p = new Punto(vertici[0].getX(), vertici[0].getY());
        double perimetro = 0;
        for (int i = 0; i < vertici.length; i++) {
            int j = (i + 1) % vertici.length; // uso circolare dell'array
            perimetro += p.distanza(vertici[i], vertici[j]);
        }
        return perimetro;
    }
}

// Classe specifica per i triangoli
class Triangolo extends FiguraGeometrica {
    public Triangolo(Punto p1, Punto p2, Punto p3) {
        super(new Punto[]{p1, p2, p3});
    }

    // Override opzionale per usare la formula di Erone per triangoli
    @Override
    public double calcolaArea() {
        Punto p = new Punto(0, 0); // punto qualsiasi per chiamare distanza
        double a = p.distanza(vertici[0], vertici[1]);
        double b = p.distanza(vertici[1], vertici[2]);
        double c = p.distanza(vertici[2], vertici[0]);
        double s = (a + b + c) / 2;  // semiperimetro
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

}

// Classe per i rettangoli
class Rettangolo extends FiguraGeometrica {
    public Rettangolo(Punto p1, Punto p2, Punto p3, Punto p4) {
        super(new Punto[]{p1, p2, p3, p4});
    }

    @Override
    public double calcolaArea() {
        // Per un rettangolo possiamo usare base * altezza
        Punto p = new Punto(0, 0);
        double base = p.distanza(vertici[0], vertici[1]);
        double altezza = p.distanza(vertici[1], vertici[2]);
        return base * altezza;
    }
}

// Classe per i quadrati (caso speciale di rettangolo)
class Quadrato extends Rettangolo {
    public Quadrato(Punto p1, Punto p2, Punto p3, Punto p4) {
        super(p1, p2, p3, p4);
        // Potremmo aggiungere una verifica che sia effettivamente un quadrato
    }

    @Override
    public double calcolaArea() {
        // Per un quadrato possiamo usare lato * lato
        Punto p = new Punto(0, 0);
        double lato = p.distanza(vertici[0], vertici[1]);
        return lato * lato;
    }
}

// Classe di test
class TestFiguraGeometrica {
    public static void main(String[] args) {
        // Test delle figure
        Punto p1 = new Punto(0, 0);
        Punto p2 = new Punto(3, 0);
        Punto p3 = new Punto(3, 4);
        Punto p4 = new Punto(0, 4);

        // Uso del costruttore di copia
        Punto p1Copia = new Punto(p1);

        Triangolo triangolo = new Triangolo(p1, p2, p3);
        System.out.println("Area triangolo: " + triangolo.calcolaArea());
        System.out.println("Perimetro triangolo: " + triangolo.calcolaPerimetro());

        // Test rettangolo
        Rettangolo rettangolo = new Rettangolo(p1, p2, p3, p4);
        System.out.println("Area rettangolo: " + rettangolo.calcolaArea());
        System.out.println("Perimetro rettangolo: " + rettangolo.calcolaPerimetro());

        // Test quadrato
        Punto q1 = new Punto(0, 0);
        Punto q2 = new Punto(2, 0);
        Punto q3 = new Punto(2, 2);
        Punto q4 = new Punto(0, 2);
        Quadrato quadrato = new Quadrato(q1, q2, q3, q4);
        System.out.println("Area quadrato: " + quadrato.calcolaArea());
        System.out.println("Perimetro quadrato: " + quadrato.calcolaPerimetro());


        // Test con poligono irregolare a 5 lati
        Punto[] verticiPentagono = {
                new Punto(0, 0),
                new Punto(2, 1),
                new Punto(3, 3),
                new Punto(1, 4),
                new Punto(-1, 2)
        };
        FiguraGeometrica pentagono = new FiguraGeometrica(verticiPentagono);
        System.out.println("Area pentagono: " + pentagono.calcolaArea());
    }
}

