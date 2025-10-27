package com.civiletti.gioco.moneta.v2;

/**
 * classe che realizza una moneta con valore testa(0) o croce (1)
 */

public class Moneta{

    public static final int TESTA = 0;
    public static final int CROCE = 1;  // non serve perché i valori sono 2 e si può andare per esclusione

    private int faccia;

    // Costruttore
    // Quando si lancia la moneta ho una faccia randomica di default, ai fini del gioco non cambia nulla ma segue
    // una modellazione fedele all’oggetto reale e se un domani si vuole riusare la classe Moneta in un altro programma
    // (ad esempio una simulazione o test di probabilità), allora mantenerla randomica all’inizializzazione diventa
    // utile per coerenza semantica.

    public Moneta(){
        lancia();
    }

    // Lancio casuale della moneta
    public void lancia(){
        faccia = (int)(Math.random() * 2);  // Numeri tra (0 ÷ 0.999..) * 2 = [0 ÷ 1.999..] e 2 (escluso) --> 0 ÷ 1
    }

    // Ritorna VERO se il valore è TESTA, cioè 0
    public boolean isTesta(){
        return (faccia == TESTA);
    }

    // Ritorna "Testa" o "Croce"
    @Override
    public String toString() {
        return isTesta() ? "Testa" : "Croce";
    }
}
