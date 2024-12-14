package com.civiletti.gioco.moneta.v3;

/**
 * classe che realizza una moneta con valore testa(0) o croce (1)
 */

public class Moneta{

    private final int TESTA = 0;
    private final int CROCE = 1; // Superflua

    private int faccia;

    // Costruttore
    public Moneta(){
        lancia();
    }

    // Lancio casuale della moneta
    public void lancia(){
        faccia = (int)(Math.random() * 2);   // Numeri tra (0 ÷ 0.999..) * 2 = [0 ÷ 1.999..] e 2 (escluso) --> 0 ÷ 1
        //System.out.println("> " + faccia); // Test
    }

    // Ritorna True se il valore e' TESTA cioè 0
    public boolean isTesta(){
        return faccia == TESTA;
    }

    // Ritorna il nome della faccia corrente – converte 0/1 in "Testa"/"Croce"
    public String toString(){
        return isTesta() ? "Testa" : "Croce";
    }
}
