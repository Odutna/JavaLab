package com.civiletti.intro;

/**
 * Dimostrazione dell'utilizzo dei metodi costruttore variabili di istanza e metodi.
 * Lo scopo di questo lab. è, inoltre, quello di mostrare l'utilizzo del metodo
 * toString(), getClass().getName() e getclass().getSimpleName() e dell'operatore
 * istanceOf.
 *
 * In breve, possiamo così riassumere gli elementi introdotti:
 *
 * 1) metodo toString() della classe Object:
 *    è un metodo ereditato dalla classe Object in Java, utilizzato per ottenere una
 *    rappresentazione testuale di un oggetto.
 *
 *    Quando si stampa un oggetto direttamente, Java chiama automaticamente il metodo
 *    toString() su quell'oggetto per produrre una rappresentazione testuale.
 *
 * 2) l'operatore Java: istanceOf:
 *
 *    serve a verificare se un oggetto è un'istanza di una classe specifica o di
 *    una sua sottoclasse, e restituisce un valore booleano (true o false).
 *
 * 3) i metodi della classe Object: getClass(), getName() e getSimpleName():
 *
 *    • getClass() restituisce l'oggetto Class che rappresenta il tipo di runtime
 *      dell'oggetto su cui è chiamato.
 *
 *    • getName() è un metodo della classe Class (ottenibile da getClass()) che
 *      restituisce il nome completo della classe, compreso il package.
 *
 *    • getSimpleName() è un altro metodo della classe Class che restituisce solo
 *      il nome della classe senza il package.
 *
 */

public class Territorio3 {
    // Variabili
    double superficie; // valore in Kmq
    int abitanti;

    // Costruttore
    public Territorio3(double s, int a) {
        superficie = s;
        abitanti = a;
    }

    // Metodo densita
    double densita() {
        return abitanti / superficie;
    }

    // Sovrascrittura di toString per visualizzare le informazioni dettagliate dell'oggetto
    @Override
    public String toString() {
        return "\nTerritorio3{ \n" +
                "   superficie=" + superficie + " kmq, \n" +
                "   abitanti=" + abitanti + ", \n" +
                "   densita=" + densita() + " ab/kmq\n" +
                "}";
    }

    public static void main(String[] args) {
        Territorio3 t = new Territorio3(257.3, 12250);
        Territorio3 t2 = new Territorio3(475.98, 98750);

        System.out.println("+--------------------------+");
        System.out.println("Oggetto t: " + t); // Ora t.toString() fornisce una descrizione dettagliata
        System.out.println("+--------------------------+");
        System.out.println("Oggetto t2: " + t2); // Ora t2.toString() fornisce una descrizione dettagliata
        System.out.println("+--------------------------+");

        if (t instanceof Territorio3) {
            System.out.println("L'oggetto t è un'istanza della classe Territorio3.");
        }
        if (t2 instanceof Territorio3) {
            System.out.println("L'oggetto t2 è un'istanza della classe Territorio3.");
        }
        System.out.println("+--------------------------+");

        Object t3 = new Territorio4(0, 0);

        if (t3 instanceof Territorio3) {
            System.out.println("L'oggetto t3 è un'istanza della classe Territorio3.");
        } else {
            System.out.println("t3 è istanza di Territorio3? " + (t3 instanceof Territorio3));
            // Ottenere la classe dell'oggetto
            System.out.println("Classe completa di t4: " + t3.getClass().getName());         // Nome completo, es. com.civiletti.intro.Territorio2
            System.out.println("Classe semplice di t4: " + t3.getClass().getSimpleName());

            // Risali la gerarchia delle classi e stampa le superclassi
            Class<?> superClass = t3.getClass().getSuperclass();
            while (superClass != null) {
                System.out.println("Superclasse: " + superClass.getName());
                superClass = superClass.getSuperclass();
            }
        }

        System.out.println("+--------------------------+");
        Object t4 = new Territorio4(0, 0);
        if (t4 instanceof Territorio3) {
            System.out.println("L'oggetto t4 è un'istanza della classe Territorio3.");
        } else {
            // Risali la gerarchia delle classi e stampa le superclassi e le interfacce
            Class<?> currentClass = t4.getClass();
            while (currentClass != null) {
                System.out.println("Classe/Superclasse: " + currentClass.getName());

                // Stampa le interfacce implementate dalla classe corrente
                Class<?>[] interfaces = currentClass.getInterfaces();
                for (Class<?> interf : interfaces) {
                    System.out.println("  Implementa l'interfaccia: " + interf.getName());
                }

                // Vai alla superclasse
                currentClass = currentClass.getSuperclass();
            }
        }
    }
}

