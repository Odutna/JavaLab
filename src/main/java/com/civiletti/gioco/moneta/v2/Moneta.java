package com.civiletti.gioco.moneta.v2;

/**
 * classe che realizza una moneta con valore testa(0) o croce (1)
 */

import java.util.Random;

public class Moneta{

    private final int TESTA = 0;
    private final int CROCE = 1;

    private int faccia;

    // Costruttore
    public Moneta(){
        lancia();
    }

    // Lancio casuale della moneta
    public void lancia(){
        faccia = (int)(Math.random() * 2);  // Numeri tra (0 ÷ 0.999..) * 2 = [0 ÷ 1.999..] e 2 (escluso) --> 0 ÷ 1
        //System.out.println("> " + faccia); // Test
    }

    // Ritorna VERO se il valore e' TESTA cioè 0
    public boolean isTesta(){
        return (faccia == TESTA);
    }

    // Ritorna nome della faccia corrente – converte 0/1 in "Testa"/"Croce"
    public String toString(){

        String nomeFaccia;

    /*
    if (faccia == TESTA)
      nomeFaccia = "Testa";
    else
      nomeFaccia = "Croce";
    */

        nomeFaccia = isTesta() ? "Testa" : "Croce";

        return nomeFaccia;
    }
}
