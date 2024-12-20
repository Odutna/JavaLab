# Classe Punto

---
## • 1) Costruttore di copia
Il **secondo costruttore** della classe è un **costruttore di copia**, utilizzato per creare un nuovo oggetto duplicando i valori degli attributi di un oggetto esistente. In Java, il compilatore seleziona automaticamente il costruttore corretto in base ai parametri forniti al momento dell’invocazione:

- **Primo costruttore**: viene scelto quando vengono forniti due parametri di tipo `double`. Questi parametri rappresentano le coordinate del punto da creare.
- **Secondo costruttore (costruttore di copia)**: viene scelto quando come argomento viene passato un oggetto della stessa classe, in questo caso un oggetto di tipo `Punto`.

Il **costruttore di copia** crea un nuovo oggetto e inizializza i suoi attributi copiando i valori degli attributi dell’oggetto passato come parametro. Questo approccio garantisce che il nuovo oggetto sia una replica indipendente dell’originale, consentendo di manipolare i due oggetti separatamente senza interferenze.

### Dettagli aggiuntivi:
1. **Indipendenza degli oggetti**: anche se il nuovo oggetto ha gli stessi valori iniziali, occupa una posizione diversa nella memoria (heap), quindi qualsiasi modifica al nuovo oggetto non influenzerà l’oggetto originale, e viceversa.
2. **Utilizzo pratico**: il costruttore di copia è utile, ad esempio, quando si vuole duplicare un oggetto per effettuare delle modifiche senza alterare l’originale.
3. **Implementazione tipica**:
   Ecco un esempio di implementazione di un costruttore di copia nella classe `Punto`:
   ```java
   public Punto(Punto p) {
       this.x = p.getX();
       this.y = p.getY();
   }
   ```

Con questo meccanismo, la classe `Punto` diventa più flessibile e adatta a scenari che richiedono una gestione accurata degli oggetti e dei loro stati.

---

# • 2) Metodo equals()

Come il metodo `toString` il **metodo di utilità `equals`** è ereditato dalla classe `Object`, ma è spesso necessario ridefinirlo (override) per adattarlo alle specifiche esigenze della classe.

Se il metodo `equals` non viene ridefinito, il suo comportamento predefinito sarà equivalente all’operatore di confronto `==`. Questo significa che restituirà `true` **solo se due oggetti sono effettivamente lo stesso oggetto in memoria (heap)**, ovvero se i due riferimenti puntano alla stessa istanza. Tuttavia, questo non è il concetto di uguaglianza che il programmatore di solito intende, soprattutto per classi personalizzate, dove l'uguaglianza può essere definita in base al valore degli attributi.

### Ridefinizione del metodo `equals`
Per confrontare due oggetti in base ai loro **valori** e non ai riferimenti, è necessario ridefinire `equals` nella classe. L’implementazione deve rispettare le seguenti proprietà:
1. **Riflessività**: `x.equals(x)` deve restituire sempre `true`.
2. **Simmetria**: `x.equals(y)` deve restituire lo stesso risultato di `y.equals(x)`.
3. **Transitività**: se `x.equals(y)` e `y.equals(z)` sono `true`, allora anche `x.equals(z)` deve essere `true`.
4. **Coerenza**: il risultato di `equals` non deve cambiare fintanto che gli oggetti confrontati non vengono modificati.
5. **Null-safety**: `x.equals(null)` deve restituire sempre `false`.

Ecco un esempio di implementazione del metodo `equals` per la classe `Punto`:
```java
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true; // Sono lo stesso oggetto
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false; // Oggetto null o di tipo diverso
    }
    Punto other = (Punto) obj; // Cast sicuro
    return Double.compare(x, other.x) == 0 && Double.compare(y, other.y) == 0; // Confronto per valore
}
```

### Dettagli sull'implementazione:
1. **Controllo di riferimento**: `this == obj` verifica se i due oggetti sono lo stesso riferimento.
2. **Controllo del tipo**: `getClass()` assicura che i due oggetti siano della stessa classe (evita problemi con l'ereditarietà).
3. **Confronto per valore**: `Double.compare()` è preferibile all’operatore `==` per i tipi numerici, poiché gestisce correttamente i valori speciali come `NaN` o il segno di `0.0`.

### Esempio di utilizzo:
```java
Punto p1 = new Punto(1.0, 2.0);
Punto p2 = new Punto(1.0, 2.0);
Punto p3 = new Punto(2.0, 3.0);

System.out.println(p1.equals(p2)); // true: i valori di x e y coincidono
System.out.println(p1.equals(p3)); // false: i valori di x e y sono diversi
System.out.println(p1.equals(null)); // false: un oggetto non è mai uguale a null
```

### Conclusione:
Ridefinire `equals` è fondamentale per fornire un concetto di uguaglianza personalizzato che vada oltre il semplice confronto dei riferimenti. Questo è particolarmente utile per strutture dati come `HashMap` o `HashSet`, dove il metodo `equals` viene utilizzato per determinare se un oggetto è già presente.

---

## • 3) Test dei metodi di una classe

La pratica di includere un metodo `main` all’interno di una classe per testare i suoi metodi è accettabile solo per **classi piuttosto semplici**. Tuttavia, quando si ha a che fare con classi più complesse, è **consigliabile creare una classe di test separata**. Questa classe includerà il proprio metodo `main`, che si occuperà di:
- Istanziare uno o più oggetti della classe da testare.
- Chiamare i metodi da verificare, assicurandosi che funzionino come previsto.

### Vantaggi di una classe di test separata:
1. **Chiarezza del codice**: la logica della classe principale rimane pulita e focalizzata sulla sua responsabilità primaria.
2. **Manutenibilità**: i test possono essere modificati o ampliati senza influenzare la classe principale.
3. **Utilizzo di framework di testing**: permette di integrare strumenti come JUnit per test più robusti e automatizzati.

Esempio di classe di test:
```java
public class PuntoTest {
    public static void main(String[] args) {
        Punto p1 = new Punto(1.0, 2.0);
        Punto p2 = new Punto(3.0, 4.0);

        System.out.println("Distanza tra p1 e p2: " + p1.distanza(p2));
        System.out.println("P1 e P2 sono uguali? " + p1.equals(p2));
    }
}
```

---

## • 4) Concetti di boxing, unboxing e autoboxing

### **Boxing e Unboxing**
- Il **boxing** è l’operazione di **incapsulare** un valore di tipo primitivo (come `int`, `double`, ecc.) in un oggetto della **classe wrapper** corrispondente (ad esempio `Integer`, `Double`).
- L’**unboxing** è l’operazione opposta: **estrarre** un valore di tipo primitivo da un oggetto wrapper.

Ad esempio:
```java
// Boxing
Integer x = Integer.valueOf(123);

// Unboxing
int y = x.intValue();
```

### **Autoboxing**
Il linguaggio Java supporta l’**autoboxing**, che consente la conversione automatica tra tipi primitivi e oggetti delle classi wrapper:
```java
Integer x = 123; // Autoboxing: da int a Integer
int y = x;       // Unboxing: da Integer a int
Integer z = y;   // Autoboxing: da int a Integer
```

#### **Osservazione**
Con l’autoboxing, è possibile creare oggetti senza invocare esplicitamente l’operatore `new`, rendendo il codice più semplice e leggibile. Tuttavia, è importante essere consapevoli che:
- L’autoboxing può introdurre **inefficienza**: ogni operazione di boxing/unboxing comporta una creazione e distruzione di oggetti.
- Può portare a errori inattesi, ad esempio quando si usano wrapper nelle strutture dati (es. `HashMap`).

---

## • 5) Classi wrapper e metodi statici

Le classi wrapper non servono solo per incapsulare tipi primitivi, ma offrono anche **metodi statici di utilità**, che possono essere utilizzati senza istanziare oggetti. Ad esempio:
```java
int numero = Integer.parseInt("123"); // Conversione da String a int
String str = Integer.toString(456);   // Conversione da int a String
```

### **Classe `Math`**
Un esempio notevole di classe con **metodi statici di utilità** è la classe `Math`, che fa parte del package `java.lang` (importato automaticamente). Poiché i tipi primitivi non sono oggetti, la classe `Math` fornisce un’ampia gamma di metodi per:
- Calcoli matematici comuni (es. radici quadrate, logaritmi, funzioni trigonometriche).
- Operazioni avanzate (es. `pow` per le potenze).

Esempio:
```java
double radice = Math.sqrt(16);  // Calcolo della radice quadrata
double potenza = Math.pow(2, 3); // Calcolo della potenza (2^3)
double seno = Math.sin(Math.PI / 2); // Calcolo del seno
```

---

## **Conclusione**
Le classi wrapper e la classe `Math` sono strumenti fondamentali in Java per colmare il divario tra tipi primitivi e oggetti. Esse rendono il linguaggio più flessibile e potente, offrendo al programmatore una gamma di metodi e funzionalità che semplificano molte operazioni comuni.

---

## • 6) Classe String – approfondimenti



### **Uso dell’operatore `+` in Java**

L’operatore `+` in Java è **polimorfico** e può agire come:
- **Operatore di concatenazione** se uno degli operandi è una stringa.
- **Operatore aritmetico** se entrambi gli operandi sono numerici.

Questa caratteristica, se non utilizzata con attenzione, può portare a **risultati inaspettati**, come dimostrato nel seguente esempio:

#### **Esempio 1**:
```java
System.out.println("numero di telefono " + 1 + 5 + ": " + 339 + 1116798);
System.out.println(339 + 1116798 + " numero di telefono " + 1 + 5);
```

#### **Output**:
```
numero di telefono 15: 3391116798
1450797 numero di telefono 15
```

#### **Spiegazione**:
1. **Prima istruzione**:
    - Il primo operando è una stringa (`"numero di telefono "`), quindi l’operatore `+` viene interpretato come operatore di concatenazione.
    - Tutti gli operandi successivi vengono automaticamente **convertiti in stringhe**.
    - Risultato: `"numero di telefono 15: 3391116798"`

2. **Seconda istruzione**:
    - I primi due operandi (`339` e `1116798`) sono numerici, quindi viene eseguita la **somma aritmetica** (`339 + 1116798 = 1450797`).
    - Il risultato numerico viene poi concatenato con la stringa successiva.
    - Risultato: `"1450797 numero di telefono 15"`

#### **Esempio 2 - Soluzione corretta**:
Per ottenere sempre un comportamento di concatenazione, è possibile forzare il primo operando a essere una stringa:
```java
System.out.println("" + 339 + 1116798 + " numero di telefono " + 1 + 5);
```

#### **Output**:
```
3391116798 numero di telefono 15
```

---

### **Metodi delle stringhe in Java**

Le stringhe in Java sono oggetti immutabili, quindi ogni modifica crea un nuovo oggetto. Per lavorare con le stringhe, Java fornisce una serie di metodi utili. Ecco una tabella che riassume i metodi principali, con alcuni **esempi di utilizzo**:

| **Metodo**                             | **Descrizione**                                                                                                                                          | **Esempio**                                  | **Output**                         |
|----------------------------------------|----------------------------------------------------------------------------------------------------------------------------------------------------------|----------------------------------------------|------------------------------------|
| `s.length()`                           | Restituisce il numero di caratteri della stringa `s`.                                                                                                    | `"ciao".length()`                            | `4`                                |
| `s.charAt(ind)`                        | Restituisce il carattere alla posizione `ind` (indicizzata da 0).                                                                                         | `"ciao".charAt(1)`                           | `'i'`                              |
| `s.indexOf('x')`                       | Ritorna l’indice della prima occorrenza di `'x'`, oppure `-1` se non è presente.                                                                          | `"ciao".indexOf('a')`                        | `2`                                |
| `s1.equals(s2)`                        | Restituisce `true` se le stringhe `s1` e `s2` hanno lo stesso contenuto.                                                                                  | `"ciao".equals("ciao")`                      | `true`                             |
| `s2 = s1.substring(start, end)`        | Restituisce la sottostringa di `s1` compresa tra gli indici `start` e `end` (escluso quest’ultimo).                                                        | `"ciao".substring(1, 3)`                     | `"ia"`                             |
| `s2 = s1.replace('A', 'a')`            | Sostituisce tutte le occorrenze di `'A'` con `'a'` in `s1` e restituisce la nuova stringa.                                                                | `"JAVA".replace('A', 'a')`                   | `"JaVa"`                           |
| `String.format(format, args)`          | Restituisce una stringa formattata secondo il modello `format` e i valori di `args`.                                                                      | `String.format("Il numero è %d", 42)`        | `"Il numero è 42"`                 |
| `s1.concat(s2)`                        | Concatena la stringa `s2` alla fine della stringa `s1`. **Nota:** l’operatore `+` è più comune per concatenare le stringhe.                                | `"Hello".concat(" World")`                   | `"Hello World"`                    |
| `s1.toUpperCase()`                     | Restituisce una copia della stringa `s1` con tutti i caratteri maiuscoli.                                                                                 | `"java".toUpperCase()`                       | `"JAVA"`                           |
| `s1.toLowerCase()`                     | Restituisce una copia della stringa `s1` con tutti i caratteri minuscoli.                                                                                 | `"JAVA".toLowerCase()`                       | `"java"`                           |
| `s1.startsWith(prefix)`                | Restituisce `true` se la stringa `s1` inizia con il prefisso `prefix`.                                                                                     | `"ciao".startsWith("ci")`                    | `true`                             |
| `s1.endsWith(suffix)`                  | Restituisce `true` se la stringa `s1` termina con il suffisso `suffix`.                                                                                    | `"ciao".endsWith("ao")`                      | `true`                             |
| `s1.trim()`                            | Rimuove gli spazi bianchi iniziali e finali dalla stringa `s1`.                                                                                           | `"   ciao  ".trim()`                         | `"ciao"`                           |
| `String.join(delimiter, array)`        | Restituisce una stringa in cui gli elementi dell’array sono concatenati con il delimitatore specificato.                                                  | `String.join("-", "A", "B", "C")`            | `"A-B-C"`                          |
| `s.split(regex)`                       | Divide la stringa `s` in un array di sottostringhe utilizzando il separatore specificato (`regex`).                                                       | `"a,b,c".split(",")`                         | `["a", "b", "c"]`                  |

---

### **Conclusione**
L’operatore `+` polimorfico e i numerosi metodi delle stringhe in Java offrono una grande flessibilità nella manipolazione delle stringhe. Tuttavia, è fondamentale comprendere le loro peculiarità per evitare errori e sfruttarli al meglio nelle applicazioni.