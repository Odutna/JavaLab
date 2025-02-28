### **Che cos'è un metodo astratto?**
Un **metodo astratto** è un metodo dichiarato ma non implementato in una classe (o in un'`enum`), lasciando alle sottoclassi o alle costanti specifiche il compito di fornire l'implementazione concreta. La sua definizione ha la seguente struttura:

```java
public abstract tipoRitorno nomeMetodo(parametri);
```

Un metodo astratto:
1. **Non ha corpo**: viene dichiarato con `abstract` e termina con `;`.
2. **Richiede implementazione**: deve essere implementato in tutte le sottoclassi concrete (o, in questo caso, nelle costanti di un'`enum`).

---

### **Perché utilizziamo un metodo astratto in questo caso?**
Nel caso dell'`enum` **`OperazioneMath`**, il metodo astratto **`esegui(double x, double y)`** è utilizzato per:
1. **Rendere obbligatoria l'implementazione specifica**: Ogni operazione matematica (somma, sottrazione, moltiplicazione, divisione) ha un comportamento diverso. Dichiarando un metodo astratto, si garantisce che ogni costante dell'`enum` fornisca la propria implementazione di questo metodo.
2. **Mantenere un'interfaccia uniforme**: Tutte le operazioni condividono lo stesso metodo astratto, il che rende il codice più leggibile e coerente. Ad esempio:
    - `SOMMA` implementa il metodo come `return x + y;`
    - `DIVIDI` implementa il metodo come `return x / y;`

Questo approccio consente di trattare ogni operazione come un'istanza di `OperazioneMath`, ma con un comportamento unico.

---

### **Si poteva fare senza un metodo astratto?**
Sì, ma il codice sarebbe meno elegante e più complesso da mantenere. Ecco un'alternativa senza metodo astratto:

#### **Alternativa senza metodo astratto**
```java
enum OperazioneMath {
    SOMMA, SOTTRAI, MOLTIPLICA, DIVIDI;

    public double esegui(double x, double y) {
        switch (this) {
            case SOMMA: return x + y;
            case SOTTRAI: return x - y;
            case MOLTIPLICA: return x * y;
            case DIVIDI: return x / y;
            default: throw new UnsupportedOperationException("Operazione non supportata");
        }
    }
}
```

In questa versione:
- L'implementazione del metodo **`esegui`** è centralizzata in un blocco `switch`, che verifica quale costante dell'`enum` è stata chiamata.
- Mentre funziona, questo approccio è meno intuitivo e scalabile:
    - Se aggiungi nuove operazioni, devi modificare il metodo `esegui` aggiungendo un nuovo caso al `switch`.
    - La logica è più frammentata e meno chiara rispetto alla versione con metodi astratti.

---

### **Vantaggi di utilizzare un metodo astratto**
1. **Codice più chiaro**: Ogni costante dell'`enum` contiene la logica direttamente associata ad essa.
2. **Modularità**: Aggiungere una nuova operazione è semplice: basta aggiungere una nuova costante con il suo comportamento specifico.
3. **Manutenzione più semplice**: Non è necessario modificare il corpo di un metodo esistente quando si aggiungono nuove operazioni.

---

### **Polimorfismoz**
Utilizzare un metodo astratto in questo caso è la scelta migliore perché:
- Permette di sfruttare il polimorfismo (ogni costante ha un comportamento diverso per lo stesso metodo).
- Rende il codice più leggibile, chiaro e facilmente estendibile.
- Mantiene ogni operazione "vicina" alla sua logica specifica, riducendo il rischio di errori.