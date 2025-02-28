>### • Enumerazione:
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
>
> **`Enum`**: un enum <u>può avere lo stesso nome del file</u>, ma non è obbligatorio. È spesso una buona pratica farlo per chiarezza, ma non è una regola rigida.
> 
> ```java
> public static Colore fromCodice(String codice) {
>   for (Colore c : values()) {
>       if (c.codiceEsadecimale.equalsIgnoreCase(codice)) {
>           return c;
>       }
>   }
> }
>```
> Nel contesto degli `enum` in Java, il metodo statico `values()` restituisce un array contenente tutti i valori dell'enum. In altre parole, crea un elenco ordinato di tutte le costanti che sono state definite all'interno dell'enum.
>
>Come funziona l'iterazione con `for (Colore c : values())`?
>
>Questo tipo di iterazione, `for-each` o `enhanced for loop`, è un modo elegante e conciso per iterare su tutti gli elementi di un **array** o di una **collezione**.
>
>Nel esempio specifico, ecco cosa succede:
>
>- >Creazione dell'array: Quando scrivi Colore.values(), viene creato un array di tipo Colore[] che contiene tutte le costanti dell'enum Colore.
>- >Iterazione: Il ciclo for-each prende ogni elemento dell'array (cioè ogni costante dell'enum) e lo assegna alla variabile c di tipo Colore.
>- >Confronto: All'interno del ciclo, si confronta il codice esadecimale della costante corrente (c.codiceEsadecimale) con il codice passato come parametro al metodo.
>- >Restituzione: Se viene trovata una corrispondenza, la costante viene restituita immediatamente.
>

> 