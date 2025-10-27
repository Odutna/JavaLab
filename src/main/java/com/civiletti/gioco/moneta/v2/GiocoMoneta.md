# Gioco del Lancio della Moneta 

## Descrizione generale

Il programma simula un **gioco di testa o croce** in cui l’utente sceglie una faccia della moneta e il sistema effettua **5 lanci casuali**.  
Vince chi ottiene **almeno 3 risultati** corrispondenti alla propria scelta.

Durante il gioco, il giocatore può anche **puntare una somma di denaro** (5€, 7€ o 10€) per rendere la sfida più interessante.  
Alla fine di ogni sessione viene mostrato il bilancio totale e il numero di partite giocate.

---

## Struttura del progetto

Il progetto è organizzato nel package:

~~~
com.civiletti.gioco.moneta.v2
~~~


Contiene due classi principali:

- **Moneta** → rappresenta una moneta con due possibili stati (`TESTA`, `CROCE`).
- **ProvaMoneta** → gestisce la logica di gioco, il punteggio e l’interazione con l’utente.

---

## Classe `Moneta`

### Ruolo
Rappresenta la moneta e incapsula la logica di generazione casuale della faccia.

### Codice
```java
public class Moneta {

    public static final int TESTA = 0;
    public static final int CROCE = 1;

    private int faccia;

    public Moneta() {
        lancia();
    }

    public void lancia() {
        faccia = (int)(Math.random() * 2); // genera 0 o 1
    }

    public boolean isTesta() {
        return (faccia == TESTA);
    }

    @Override
    public String toString() {
        return isTesta() ? "Testa" : "Croce";
    }
}


# Class diagram del lancio di una moneta


```Java
import java.util.Random;
    ...
    int lancio = random.nextInt(2); // Genera un numero casuale (0 o 1)
```


[![](https://mermaid.ink/img/pako:eNp9Uk2P0zAQ_SuWT602ZJuodj4EB7asOK1AtNrDEg6D46aWknFlOxVL1V_ET-C2vwzHbaBUBfuQmed5nnkv3lOha0lLKlqw9p2CxkBXIfGrVkYKpzSS1V2Fwx7QUEceNEoHZH_EhvWKKHRkDUIo-IPeEOvAKUHWCqENJav75eoteUNm_61afPqwuPdVyXnVsetkOiLk9paIjYIOSAvoG0-m5-U7reqrB1-1biUgUXYlrbs4XDqjsCFOH4Px8HBpwUejd_AvH3bKd3VwCQuN7orscZ5aOmk678FjoGsjJwPLCtk6eK-0gAGLwlVBVxh_etll26MXtRSAKI1nT6-0DN50oHBylPn5CwHT2HOxQ3DS9zqO_9JbkpcfvYWXnxXSiDZG1bR0ppcR7bwAGFIaPKmo28hOVrT0YS3X0LeuohUePG0L-KR1NzKN7psNLdfQWp_12xqcPL3H3yj0_rc8oxg5sh5ceji94OHj75FYS7PQ3gRaJlkWGtFyT7_5tOAxT_KUs3mSpfMZzyP67GHG47TIOWMsZ_M0Ldghot_DbLM4SxNeZDnnRcI54-zwC-hN-MI?type=png)](https://mermaid.live/edit#pako:eNp9Uk2P0zAQ_SuWT602ZJuodj4EB7asOK1AtNrDEg6D46aWknFlOxVL1V_ET-C2vwzHbaBUBfuQmed5nnkv3lOha0lLKlqw9p2CxkBXIfGrVkYKpzSS1V2Fwx7QUEceNEoHZH_EhvWKKHRkDUIo-IPeEOvAKUHWCqENJav75eoteUNm_61afPqwuPdVyXnVsetkOiLk9paIjYIOSAvoG0-m5-U7reqrB1-1biUgUXYlrbs4XDqjsCFOH4Px8HBpwUejd_AvH3bKd3VwCQuN7orscZ5aOmk678FjoGsjJwPLCtk6eK-0gAGLwlVBVxh_etll26MXtRSAKI1nT6-0DN50oHBylPn5CwHT2HOxQ3DS9zqO_9JbkpcfvYWXnxXSiDZG1bR0ppcR7bwAGFIaPKmo28hOVrT0YS3X0LeuohUePG0L-KR1NzKN7psNLdfQWp_12xqcPL3H3yj0_rc8oxg5sh5ceji94OHj75FYS7PQ3gRaJlkWGtFyT7_5tOAxT_KUs3mSpfMZzyP67GHG47TIOWMsZ_M0Ldghot_DbLM4SxNeZDnnRcI54-zwC-hN-MI)

# Inizializzazione del lancio nel costruttore

Nel costruttore della classe `Moneta`, si può decidere di chiamare subito il metodo `lancia()` per inizializzare l'oggetto con un valore casuale (Testa o Croce) al momento della creazione:
```java
public class Moneta {
    private int faccia; // 0 = Testa, 1 = Croce
    private Random random;

    public Moneta() {
        random = new Random();
        lancia(); // inizializza la moneta con un valore casuale
    }

    public void lancia() {
        faccia = random.nextInt(2);
    }

    public int getFaccia() {
        return faccia;
    }
}
```

## 🔍 Perché inserire `lancia()` nel costruttore?

* **Inizializzazione coerente**: ogni nuova `Moneta` ha subito uno stato valido (Testa o Croce), evitando valori "non inizializzati".
* **Astrazione del comportamento**: la classe stessa si occupa della sua logica interna, senza delegarla all'esterno.
* **Maggiore realismo**: quando si crea una moneta, è come se venisse automaticamente "lanciata" almeno una volta.

## 🧠 Alternativa didattica

Se invece si preferisce controllare manualmente quando avviene il lancio (es. per ripetere esperimenti o confronti tra oggetti), si può omettere la chiamata a `lancia()` nel costruttore e invocarla esplicitamente nel `main`:
```java
Moneta m = new Moneta();
m.lancia();
System.out.println(m.getFaccia());
```

## 💡 In sintesi:

* **Inserire `lancia()` nel costruttore** → garantisce un oggetto subito "pronto".
* **Lasciarlo fuori** → offre più controllo al programmatore sul momento dell'azione.