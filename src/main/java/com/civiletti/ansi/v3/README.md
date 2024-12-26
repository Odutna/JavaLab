# ANSICodeGenerator

## **1. Cosa fa il codice**
Il programma genera codici ANSI per formattare il testo (effetti, colori del testo e dello sfondo) in un terminale. Gli utenti possono selezionare opzioni interattive per aggiungere colori o effetti e visualizzare il risultato direttamente nel terminale.


---

## **2. Struttura del programma**
Il programma è suddiviso in:
- **Enumerazioni (Effect, Color):** rappresentano rispettivamente gli effetti e i colori disponibili.
- **Funzioni utilitarie:** per visualizzare opzioni, accettare input e generare codici ANSI.
- **Funzione `main`:** gestisce il flusso principale del programma.

---

#### Funzionamento
1. Chiede all'utente se desidera aggiungere effetti e colori.
2. Utilizza `StringBuilder` per costruire il codice ANSI dinamicamente.
3. Visualizza il codice e un esempio di testo formattato.
4. Ripete il processo finché l'utente non decide di terminare.

---

## **3. Analisi del codice**

>### • Nota sull'enumerazione:
>L'enumerazione è come una lista di costanti - ogni elemento dell'enum è un oggetto unico e immutabile (non modificabile).
Quando definisci un enum, Java:
>- Crea una classe che estende `java.lang.Enum`
>- Assegna a ogni costante un valore numerico ordinale (naturale) (0, 1, 2...)
>- Crea un oggetto singleton per ogni costante (`Singleton` è pattern di progettazione che garantisce che una classe abbia una sola istanza (un solo oggetto) e fornisce un punto di accesso globale a essa. In un enum, ogni costante è un singleton, esiste una sola istanza di BOLD, una sola di ITALIC, etc.)
>
>```java
>    BOLD("1", "Grassetto")     // ordinale = 0
>    DIM("2", "Luminosità")     // ordinale = 1
>    ITALIC("3", "Italico")     // ordinale = 2
>```
>
>### • Metodi principali:
>
>- `values()`: Restituisce array di tutte le costanti
>- `valueOf(String)`: Converte stringa nel corrispondente enum
>- `ordinal()`: Restituisce posizione (0-based) della costante
>- `name()`: Restituisce nome della costante come stringa
>```java
>    // Iterare su tutti i colori
>    for (Color color : Color.values()) {
>        System.out.println(color.description);      // Stampa: Nero, Rosso, Verde...
>        System.out.println(color.ordinal());        // Stampa: 0, 1, 2...
>        System.out.println(color.name());           // Stampa: BLACK, RED, GREEN...
>    }
>    
>    // Convertire stringa in enum
>    Color red = Color.valueOf("RED");               // red = Color.RED
>```
>
>## • Metodo costruttore `enum`
>In un enum Java, il costruttore funziona in modo speciale:
>### Es:
>
>```java
>    private Color(String fgCode, String bgCode, String description) {
>        this.fgCode = fgCode;
>        this.bgCode = bgCode;
>        this.description = description;
>    }
>```
>
>- Viene chiamato automaticamente durante l'inizializzazione della classe per ogni costante enumerata
>- Riceve i parametri specificati dopo il nome della costante
>- Ogni costante diventa un oggetto con i propri valori inizilizzati dai parametri del costruttore
>  - fgCode: primo parametro (es. "30" per BLACK)
>  - bgCode: secondo parametro (es. "40" per BLACK)
>  - description: terzo parametro (es. "Nero" per BLACK)
>  - •••
>- Le costanti vengono inizializzate una sola volta quando la classe viene caricata, creando oggetti immutabili (campi final).

### **a. Enumerazione Effect**

```java
private enum Effect {
    BOLD("1", "Grassetto"),
    DIM("2", "Luminosità ridotta"),
    ITALIC("3", "Italico"),
    UNDERLINE("4", "Sottolineato"),
    BLINK_SLOW("5", "Lampeggiante lento"),
    NEGATIVE("7", "Negativo"),
    HIDDEN("8", "Nascosto"),
    STRIKETHROUGH("9", "Barrato");

    private final String code;
    private final String description;

    Effect(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
```
- **Funzione:** Definisce una lista di effetti ANSI disponibili.
- **Attributi:**
    - `code`: codice ANSI per l'effetto.
    - `description`: descrizione leggibile dall'utente.
- Ogni effetto ha un codice ANSI associato (es. "1" per grassetto).

#### 1. **Definizione dell'enumerazione**
- `private enum Effect`:
    - Definisce un tipo personalizzato chiamato `Effect` che è un elenco fisso di costanti.
    - È marcato come `private`, il che significa che è accessibile solo all'interno della classe in cui è definito.

#### 2. **Enumeratori**
Ogni elemento dell'enumerazione (ad esempio, `BOLD`, `DIM`, `ITALIC`, ecc.) rappresenta un tipo specifico di effetto ANSI.

- **Formato**:
  ```java
  ENUM_NAME("CODICE", "DESCRIZIONE")
  ```
    - `"CODICE"`: Il codice ANSI associato all'effetto.
    - `"DESCRIZIONE"`: Una stringa che descrive l'effetto in modo leggibile per l'utente.

- **Esempio**:
  ```java
  BOLD("1", "Grassetto")
  ```
    - Rappresenta il codice ANSI `1` per il grassetto.
    - La descrizione leggibile è "Grassetto".

#### 3. **Attributi privati**
- `private final String code;`:
    - Contiene il codice ANSI dell'effetto.
    - Marcato come `final`, quindi il valore è immutabile dopo l'inizializzazione.

- `private final String description;`:
    - Contiene una descrizione testuale dell'effetto.

#### 4. **Costruttore**
- **Scopo**:
  ```java
  Effect(String code, String description)
  ```
    - Inizializza i valori `code` e `description` per ogni enumeratore.
    - Ogni enumeratore chiama implicitamente questo costruttore con i valori specifici.

- **Implementazione**:
  ```java
  this.code = code;
  this.description = description;
  ```
    - Il costruttore assegna i parametri forniti agli attributi dell'enumerazione.

#### 5. **Esempio di utilizzo**
Se si vuole accedere ai valori dell'enumerazione:

```java
Effect effetto = Effect.BOLD;
System.out.println(effetto.code); // Output: "1"
System.out.println(effetto.description); // Output: "Grassetto"
```

---

### Perché utilizzare un `enum`?
1. **Chiarezza del codice**:
    - Ogni effetto è definito in modo leggibile e autoesplicativo.
    - Riduce gli errori rispetto all'uso di stringhe o numeri "magici" direttamente nel codice.

2. **Tipo sicuro**:
    - `Effect` è un tipo specifico e fortemente tipizzato, quindi non possono essere aggiunti valori non validi accidentalmente.

3. **Centralizzazione**:
    - Tutte le informazioni sugli effetti ANSI (codici e descrizioni) sono raccolte in un'unica struttura.

4. **Facilità di estensione**:
    - Per aggiungere un nuovo effetto, basta aggiungere un nuovo enumeratore con il suo codice e descrizione.

---

### `Effect(String code, String description)`
- Questo è il **costruttore** dell'enumerazione.
- **Funzione**:
    - Viene invocato automaticamente per ogni enumeratore definito (ad esempio, `BOLD`, `DIM`, ecc.).
    - Riceve due parametri: il codice ANSI e la descrizione leggibile.
    - Assegna questi valori agli attributi privati `code` e `description`.

---

### Utilizzo nel main
```java
    for (Effect effect : Effect.values()) {
        if (askYesNo(scanner, effect.description + "?", effect.code)) {
        ansiCode.append(effect.code).append(";");
        }
    }
```
- `Effect.values()` restituisce un array di tutte le costanti enum
- Il ciclo itera su ogni effetto (BOLD, DIM, ITALIC...)
- Per ogni effetto:
  - Chiede all'utente se vuole applicarlo usando la descrizione (es. "Grassetto?")
Se l'utente risponde sì, aggiunge il codice dell'effetto (es. "1;") alla stringa ANSI

  - Quindi se l'utente sceglie grassetto e italico, ansiCode conterrà "1;3;" (i codici per BOLD e ITALIC).

```java
    Effect bold = Effect.BOLD;               // Accesso diretto
    Effect[] effects = Effect.values();      // Array di tutti gli effetti
    int position = Effect.ITALIC.ordinal();  // Posizione di ITALIC (2)
    Effect effect = Effect.valueOf("BOLD");  // Converte stringa in enum
```

---

### **b. Enumerazione Color**

```java
private enum Color {
    BLACK("30", "40", "Nero"),
    RED("31", "41", "Rosso"),
    GREEN("32", "42", "Verde"),
    YELLOW("33", "43", "Giallo"),
    BLUE("34", "44", "Blu"),
    PURPLE("35", "45", "Viola"),
    CYAN("36", "46", "Ciano"),
    GRAY("37", "47", "Grigio"),
    WHITE("97", "7", "Bianco");

    private final String fgCode; // Codice per il testo
    private final String bgCode; // Codice per lo sfondo
    private final String description;

    Color(String fgCode, String bgCode, String description) {
        this.fgCode = fgCode;
        this.bgCode = bgCode;
        this.description = description;
    }

    public String getFgCode() {
        return fgCode;
    }

    public String getBgCode() {
        return bgCode;
    }

    public String getDescription() {
        return description;
    }
}
```
- **Funzione:** Definisce i colori ANSI per il testo e lo sfondo.
- **Attributi:**
    - `fgCode`: codice ANSI per il colore del testo (30–37).
    - `bgCode`: codice ANSI per il colore dello sfondo (40–47).
    - `description`: descrizione leggibile dall'utente.

#### 1. **Dichiarazione dei Valori Enum**
Ogni valore enum (ad esempio `BLACK`, `RED`, `GREEN`) rappresenta un colore e definisce tre parametri:
- `fgCode`: Codice ANSI per il colore del **testo**.
- `bgCode`: Codice ANSI per il colore dello **sfondo**.
- `description`: Una descrizione leggibile del colore in italiano.

**Esempio**:
- `BLACK`:
    - `fgCode`: `30` (colore nero per il testo)
    - `bgCode`: `40` (colore nero per lo sfondo)
    - `description`: "Nero"

#### 2. **Costruttore dell'Enum**
```java
Color(String fgCode, String bgCode, String description) {
    this.fgCode = fgCode;
    this.bgCode = bgCode;
    this.description = description;
}
```
Il costruttore viene invocato automaticamente per ciascun valore enum durante la sua inizializzazione.
- **`fgCode`**: Memorizza il codice del colore del testo.
- **`bgCode`**: Memorizza il codice del colore dello sfondo.
- **`description`**: Memorizza una descrizione leggibile del colore.

#### 3. **Metodi Getter**
I metodi `getFgCode()`, `getBgCode()` e `getDescription()` restituiscono rispettivamente i valori dei campi `fgCode`, `bgCode` e `description`.

**Esempio di utilizzo:**
```java
Color color = Color.RED;
System.out.println("Codice testo: " + color.getFgCode()); // Output: 31
System.out.println("Codice sfondo: " + color.getBgCode()); // Output: 41
System.out.println("Descrizione: " + color.getDescription()); // Output: Rosso
```

### Funzionamento
Quando si utilizza l'enum `Color`, si accede direttamente ai suoi valori predefiniti, semplificando la selezione dei colori senza ricordare i codici ANSI.

#### Visualizzazione dei Colori
Un esempio pratico per visualizzare i colori potrebbe essere:
```java
for (Color color : Color.values()) {
    System.out.printf("\033[%sm%s\033[0m \n", color.getFgCode(), color.getDescription());
}
```
Questo frammento genera un elenco di colori, applicando il colore del testo corrispondente alla descrizione.

### Analisi dei Codici ANSI
- **Codici Testo** (foreground): Vanno da `30` a `37` per i colori standard e `90` a `97` per i colori intensi.
- **Codici Sfondo** (background): Vanno da `40` a `47` per i colori standard e `100` a `107` per i colori intensi.

### Enum `Color`
Organizza i codici ANSI in modo strutturato e leggibile, rendendo il codice più intuitivo e riducendo il rischio di errori quando si lavora con le sequenze ANSI.

---


### **c. Funzione displayColors**
Il metodo `displayColors` è responsabile della visualizzazione dei colori disponibili per il testo o per lo sfondo in formato ANSI, insieme ai relativi codici. Mostra ogni colore formattato usando il suo codice ANSI, rendendo evidente l'aspetto visivo dei colori applicati al testo.

```java
private static void displayColors(boolean isBackground) {
    for (Color color : Color.values()) {
        String code = isBackground ? color.getBgCode() : color.getFgCode();
        System.out.printf("\033[%sm%s (%s)\033[0m ", code, color.getDescription(), code);
    }
    System.out.println();
}
```
- **Scopo:** Mostra i colori disponibili nel terminale, con esempi visivi.
- **Parametri:**
    - `isBackground`: se vero, mostra i codici per lo sfondo; altrimenti per il testo.
- **ANSI utilizzato:**
    - `\033[` inizializza la sequenza ANSI.
    - `%sm` applica il colore.
    - `\033[0m` resetta la formattazione.

1. **Parametro `isBackground`**:
    - Questo parametro booleano determina quale tipo di codice ANSI visualizzare:
        - `true`: Visualizza i codici dei colori per lo sfondo (`bgCode`).
        - `false`: Visualizza i codici dei colori per il testo (`fgCode`).

2. **Ciclo `for` sui valori di `Color`**:
    - Il metodo itera su tutti i valori dell'enumerazione `Color` usando `Color.values()`.
    - Ogni valore rappresenta un colore definito nell'enumerazione.

3. **Selezione del codice ANSI**:
    - Se `isBackground` è `true`, viene selezionato il codice ANSI per lo sfondo (`bgCode`).
    - Altrimenti, viene selezionato il codice ANSI per il testo (`fgCode`).

4. **Formato della stampa (`System.out.printf`)**:
    - Il metodo utilizza i codici ANSI per formattare e colorare il testo mostrato in output.
    - Struttura dell'output:
        - `\033[%sm`: Applica il codice ANSI per colorare il testo o lo sfondo.
        - `%s`: Descrizione del colore (ad esempio, "Rosso").
        - `(%s)`: Mostra il codice ANSI stesso per riferimento.
        - `\033[0m`: Resetta lo stile per evitare che influenzi il resto dell'output.

5. **Esempio di output**:
    - Per il colore rosso (`RED`) del testo:
      ```
      \033[31mRosso (31)\033[0m
      ```
    - Per il colore rosso dello sfondo:
      ```
      \033[41mRosso (41)\033[0m
      ```

6. **`System.out.println()` finale**:
    - Aggiunge una nuova linea al termine della stampa di tutti i colori, migliorando la leggibilità.

### Utilizzo del metodo
Questo metodo è utilizzato in contesti in cui si desidera mostrare all'utente i colori disponibili, come nel caso di un'applicazione interattiva che permette di personalizzare il testo o lo sfondo con colori ANSI.

### Esempio di invocazione
```java
// Mostra i colori disponibili per il testo
System.out.println("Colori disponibili per il testo:");
displayColors(false);

// Mostra i colori disponibili per lo sfondo
System.out.println("Colori disponibili per lo sfondo:");
displayColors(true);
```

### Comportamento dinamico
L'output del metodo cambierà a seconda del valore del parametro `isBackground`:
- `false`: Mostrerà i colori formattati per il testo.
- `true`: Mostrerà i colori formattati per lo sfondo.

### Osservazioni:
- Consente una visualizzazione chiara e formattata dei colori disponibili.
- Facilita la scelta dei codici da parte dell'utente grazie all'anteprima visiva.
- È altamente riutilizzabile in qualsiasi contesto in cui si usano colori ANSI.

---

### **d. Funzione getColorChoice**
Il metodo `getColorChoice` consente di ottenere una scelta valida di colore (testo o sfondo) da parte dell'utente, utilizzando un oggetto `Scanner` per leggere l'input e validare il codice inserito rispetto a un elenco di colori definiti nell'enumerazione `Color`.

```java
private static String getColorChoice(Scanner scanner, boolean isBackground) {
    while (true) {
        System.out.print("Inserisci codice colore: ");
        String code = scanner.nextLine().trim();

        for (Color color : Color.values()) {
            if ((isBackground && color.getBgCode().equals(code)) ||
                    (!isBackground && color.getFgCode().equals(code))) {
                return code;
            }
        }
        System.out.println("Codice non valido. Riprova.");
    }
}
```
- **Scopo:** Consente all'utente di selezionare un colore valido.
- **Logica:**
    - Controlla se l'input corrisponde a un codice valido per testo o sfondo.
    - Ripete la richiesta finché non riceve un codice valido.


1. **Ciclo infinito**:
    - Il metodo utilizza un ciclo `while (true)` per continuare a richiedere l'input finché l'utente non inserisce un valore valido.

2. **Richiesta di input**:
    - Stampa il messaggio `"Inserisci codice colore:"` e legge la linea successiva con `scanner.nextLine().trim()`.
    - Il metodo rimuove eventuali spazi iniziali o finali dall'input con `trim()`.

3. **Validazione dell'input**:
    - Scorre tutti i valori definiti nell'enumerazione `Color` utilizzando un ciclo `for`.
    - Controlla se il codice inserito corrisponde:
        - Al codice di sfondo (`bgCode`) se `isBackground` è `true`.
        - Al codice di testo (`fgCode`) se `isBackground` è `false`.

4. **Codice valido**:
    - Se il codice corrisponde a un colore valido, viene immediatamente restituito.

5. **Codice non valido**:
    - Se il codice non corrisponde a nessun colore, viene mostrato il messaggio `"Codice non valido. Riprova."` e il ciclo riprende.

---

### Esempio:
#### Input valido
- Se `isBackground` è `false` e l'utente inserisce `31`:
    - Il metodo verifica che `31` corrisponde a `RED` (colore di testo).
    - Restituisce il valore `"31"`.

#### Input non valido
- Se l'utente inserisce `99`:
    - Il metodo non trova alcuna corrispondenza nell'enumerazione `Color`.
    - Mostra il messaggio `"Codice non valido. Riprova."` e ripete la richiesta di input.

### Miglioramenti possibili
- **Controllo sugli input non numerici**:
    - Aggiungere un controllo per gestire eventuali errori di input, come caratteri non numerici.
- **Messaggi più dettagliati**:
    - Fornire un elenco dei codici validi per evitare errori frequenti da parte dell'utente.

---

### **e. Funzione askYesNo**

```java
private static boolean askYesNo(Scanner scanner, String question, String ansiEffect) {
    System.out.print("\033[" + ansiEffect + "m" + question + " \033[0m(y/n) ");
    return scanner.nextLine().trim().equalsIgnoreCase("y");
}
```
- **Scopo:** Chiede all'utente una risposta sì/no, con la possibilità di formattare la domanda con un effetto ANSI.
- **ANSI utilizzato:**
    - `\033[` inizializza l'effetto ANSI specificato da `ansiEffect`.
    - `\033[0m` resetta la formattazione.

---

### **f. Flusso principale (main)**

---

>## • **Nota su `StringBuilder`**
>La classe `StringBuilder` è usata per costruire in modo efficiente stringhe ANSI concatenate.
>
>#### Vantaggi
>- **Efficienza:** A differenza di `String`, che crea nuove istanze ad ogni modifica, `StringBuilder` opera sulla stessa istanza, riducendo l'overhead.
>- **Metodi utili:**
   >    - `append(String s)`: Aggiunge una stringa al termine della sequenza.
>    - `replace(int start, int end, String s)`: Sostituisce una porzione della stringa con una nuova.
>    - `toString()`: Converte il contenuto in una `String`.
>

---

```java
StringBuilder ansiCode = new StringBuilder("\033[");
```
- **Cosa fa:** Inizializza una stringa ANSI.

```java
String finalCode = ansiCode.toString().replaceAll(";$", "m");
```
- **Cosa fa:** Rimuove l'ultimo punto e virgola `;` e aggiunge `m` per terminare correttamente il codice ANSI.
- **Spiegazione del simbolo `$` in regex:**
    - `$` indica la **fine della stringa**.
    - La regex `;$` cerca un punto e virgola che si trova alla fine della stringa e lo sostituisce con `m`.

```java
System.out.println("Esempio: " + finalCode + "Testo di esempio\033[0m");
```
- **Cosa fa:** Applica il codice ANSI generato a una stringa di esempio e la resetta con `\033[0m`.

---

### **g. Loop per generare più codici**

```java
do {
    // Codice per generare ANSI
} while (askYesNo(scanner, "Vuoi generare un altro codice?", "1"));
```
- **Cosa fa:** Ripete l'intero processo finché l'utente non risponde "n".

---

### **4. Output del programma**
- **Codice ANSI generato:**
    - Mostra il codice generato, es. `\033[1;31;44m`.
- **Esempio visivo:**
    - Applica il codice generato al testo "Testo di esempio" e lo mostra nel terminale.

---

### **5. Conclusione**
Questo programma permette agli utenti di sperimentare con la formattazione ANSI in modo interattivo, mostrando un'implementazione chiara di effetti e colori personalizzati. La combinazione di enumerazioni, funzioni modulari e input utente rende il codice facile da estendere e mantenere.


### **6. Possibili miglioramenti**
- Aggiungere un'interfaccia grafica per facilitare la selezione.
- Consentire salvataggi di combinazioni preferite.
- Implementare il supporto per codici ANSI 256 colori.

