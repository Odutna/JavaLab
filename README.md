# JavaLab
Laboratori Java

# Sintesi della sezione: Arrays, OOP e Best Practices

## Indice
- [Arrays in Java](#arrays-in-java)
- [Annotazioni Java](#annotazioni-java)
- [Method Chaining](#method-chaining)
- [Principi OOP di Base](#principi-oop-di-base)
- [Esempi Pratici](#esempi-pratici)
- [Generics](#generics)

## Arrays in Java

Gli array in Java sono strutture dati che consentono di memorizzare una sequenza di elementi dello stesso tipo. Sono oggetti e hanno caratteristiche specifiche:

### Caratteristiche Principali
- Dimensione fissa una volta creati
- Indici basati su zero (0 - lunghezza-1)
- Memorizzazione sequenziale in memoria
- Accesso diretto agli elementi tramite indice

### Dichiarazione e Inizializzazione
```java
// Dichiarazione e allocazione
int[] array1 = new int[5];

// Dichiarazione e inizializzazione diretta
int[] array2 = {1, 2, 3, 4, 5};

// Dichiarazione separata
int[] array3;
array3 = new int[]{1, 2, 3, 4, 5};
```

### Operazioni Comuni
- Inserimento elementi
- Lettura elementi
- Iterazione (for tradizionale o for-each)
- Ricerca di valori
- Ordinamento

Ecco l'espansione del documento originale sugli array in Java:

```markdown
## Arrays in Java

Gli array in Java sono strutture dati che consentono di memorizzare una sequenza di elementi dello stesso tipo. Sono oggetti e hanno caratteristiche specifiche.

### Caratteristiche Principali
- Dimensione fissa una volta creati
- Indici basati su zero (0 - lunghezza-1)
- Memorizzazione sequenziale in memoria
- Accesso diretto agli elementi tramite indice

### Dichiarazione e Inizializzazione
```java
// Array di interi
int[] array1 = new int[5];

// Array di stringhe
String[] nomi = {"Mario", "Luigi", "Giovanni"};

// Array di char
char[] caratteri = {'a', 'b', 'c', 'd', 'e'};

// Dichiarazione separata
int[] array3;
array3 = new int[]{1, 2, 3, 4, 5};
```

### Metodi di Inserimento

#### Inserimento con For Tradizionale
```java
// Inserimento di valori in un array di interi
int[] numeri = new int[5];
for (int i = 0; i < numeri.length; i++) {
    numeri[i] = i * 2;  // 0, 2, 4, 6, 8
}

// Inserimento di valori in un array di stringhe
String[] citta = new String[3];
for (int i = 0; i < citta.length; i++) {
    citta[i] = "Città " + (i + 1);
}
```

#### Inserimento con For-Each
```java
// Modifica di un array di interi
int[] numeri = {1, 2, 3, 4, 5};
for (int num : numeri) {
    System.out.println(num * 2);  // Stampa: 2, 4, 6, 8, 10
}

// Elaborazione array di stringhe
String[] nomi = {"Mario", "Luigi", "Giovanni"};
for (String nome : nomi) {
    System.out.println(nome.toUpperCase());
}
```

### Operazioni su Array di Char
```java
// Creazione e manipolazione
char[] alfabeto = new char[26];
for (int i = 0; i < alfabeto.length; i++) {
    alfabeto[i] = (char) ('a' + i);
}

// Conversione stringa in array di char
String parola = "Java";
char[] caratteri = parola.toCharArray();

// Inversione array di char
for (int i = 0; i < caratteri.length / 2; i++) {
    char temp = caratteri[i];
    caratteri[i] = caratteri[caratteri.length - 1 - i];
    caratteri[caratteri.length - 1 - i] = temp;
}
```

### Principali Metodi per Array di Stringhe

#### Metodi di Base e Manipolazione
```java
String[] nomi = {"Mario", "Luigi", "Giovanni"};

// Lunghezza dell'array
int lunghezza = nomi.length;

// Metodi di Confronto e Ricerca
// equals() per confronto di contenuto
boolean uguali = nomi[0].equals("Mario");  // true
boolean ignoraCase = nomi[0].equalsIgnoreCase("mario");  // true

// Ricerca di un elemento
boolean presente = false;
for (String nome : nomi) {
    if (nome.equals("Luigi")) {
        presente = true;
        break;
    }
}

// Ricerca con Stream API (Java 8+)
boolean presenteStream = Arrays.stream(nomi)
                               .anyMatch(nome -> nome.equals("Luigi"));

// Split - Divisione di stringhe in array
String frase = "Java è un linguaggio potente";
String[] parole = frase.split(" ");  // Divide per spazio

// Split con Espressioni Regolari
String[] elementi = "mele,banane;arance:uva".split("[,;:]");

// Metodi di Manipolazione
for (String nome : nomi) {
    // Conversioni
    System.out.println(nome.toUpperCase());     // Maiuscolo
    System.out.println(nome.toLowerCase());     // Minuscolo
    
    // Rimozione spazi
    String nomeTrimmato = nome.trim();
    
    // Verifica inizio/fine
    boolean iniziaCon = nome.startsWith("M");
    boolean finisceCon = nome.endsWith("i");
}

// Ricerca e Sostituzione
String[] nuoviNomi = new String[nomi.length];
for (int i = 0; i < nomi.length; i++) {
    // Sostituisce tutti i caratteri
    nuoviNomi[i] = nomi[i].replace('i', 'o');
    
    // Sostituzione con Regex
    nuoviNomi[i] = nomi[i].replaceAll("[aeiou]", "*");
}

// Matching con Espressioni Regolari
boolean matchPattern = "Mario".matches("[A-Za-z]+");  // Solo lettere
boolean emailValida = "esempio@email.com".matches("^[A-Za-z0-9+_.-]+@(.+)$");

// Ordinamento
Arrays.sort(nomi);  // Ordina lessicograficamente
Arrays.sort(nomi, String.CASE_INSENSITIVE_ORDER);  // Ordine case-insensitive
```

#### Esempi Avanzati di Regex
```java
// Validazione input
String[] input = {"mario123", "Luigi!", "Giovanni_Rossi"};
Pattern pattern = Pattern.compile("^[A-Za-z]+$");  // Solo lettere

for (String nome : input) {
    Matcher matcher = pattern.matcher(nome);
    if (matcher.matches()) {
        System.out.println(nome + " è valido");
    } else {
        System.out.println(nome + " non è valido");
    }
}
```

#### Note sulla Sintassi Stream
```java
// Spiegazione dettagliata della sintassi Stream
Arrays.stream(nomi)           // Converte l'array in uno stream
      .anyMatch(nome -> nome.equals("Luigi"));  
      // Lambda expression 
      // nome -> è un parametro 
      // nome.equals("Luigi") è il corpo della lambda
```

### Metodi Principali di String
- `length()`: Lunghezza stringa
- `charAt(int index)`: Carattere in posizione
- `substring(int begin, int end)`: Estrae sottostringa
- `contains(CharSequence s)`: Verifica contenimento
- `indexOf(String str)`: Trova posizione sottostringа



### Considerazioni Aggiuntive
- La dimensione dell'array è fissa dopo la creazione
- Gli indici partono sempre da 0
- Accesso e modifica degli elementi avviene tramite indice
- Gli array sono oggetti in Java, non primitive



## Annotazioni Java

Le annotazioni sono metadati che possono essere aggiunti al codice Java. Forniscono informazioni aggiuntive al compilatore e possono essere utilizzate da strumenti di sviluppo e framework.

### Annotazioni Java Principali

#### Annotazioni di Ereditarietà e Metodi
- `@Override`:
    - Indica che un metodo sovrascrive un metodo della classe padre
    - Verifica a compile-time che il metodo esista nella classe padre
    - Previene errori di firma del metodo

- `@Inherited`:
    - Permette a un'annotazione di essere ereditata dalle sottoclassi
    - Utile per creare annotazioni personalizzate trasmissibili

#### Annotazioni di Gestione Codice
- `@Deprecated`:
    - Marca un elemento come obsoleto
    - Genera warning durante la compilazione
    - Suggerisce agli sviluppatori alternative moderne

- `@SuppressWarnings`:
    - Disattiva specifici warning del compilatore
    - Tipi comuni: `"unchecked"`, `"rawtypes"`, `"deprecated"`
    - Utilizzare con parsimonia per mantenere la qualità del codice

#### Annotazioni Funzionali
- `@FunctionalInterface`:
    - Dichiara un'interfaccia come funzionale
    - Deve contenere esattamente un metodo astratto
    - Supporta le espressioni lambda in Java 8+

#### Annotazioni per Test
- `@Test`:
    - Usata per identificare metodi di test unitari (JUnit)
    - Può specificare timeout e comportamenti attesi
    - Fondamentale per la verifica automatizzata del codice

#### Annotazioni di Documentazione
- `@author`: Specifica l'autore del codice
- `@version`: Indica la versione corrente
- `@param`: Documenta i parametri di un metodo
- `@return`: Descrive il valore di ritorno
- `@throws`: Documenta le eccezioni sollevate

### Esempio Completo
```java
/**
 * Classe dimostrativa delle annotazioni Java
 * @author Nome Cognome
 * @version 1.0
 */
public class EsempioAnnotazioni {
    /**
     * Metodo che effettua una divisione
     * @param numeratore Primo numero 
     * @param denominatore Secondo numero
     * @return Risultato della divisione
     * @throws ArithmeticException Se denominatore è zero
     */
    @Override
    public double dividi(int numeratore, int denominatore) {
        if (denominatore == 0) {
            throw new ArithmeticException("Divisione per zero!");
        }
        return (double) numeratore / denominatore;
    }

    /**
     * Metodo deprecato, usare dividi()
     * @deprecated Non più utilizzabile dalla versione 2.0
     */
    @Deprecated
    public int vecchiaDivisione(int a, int b) {
        return a / b;
    }

    @Test
    public void testDivisione() {
        // Logica di test
    }
}
```

## Method Chaining

Il Method Chaining è un pattern di progettazione che permette di chiamare più metodi in sequenza sulla stessa istanza di un oggetto. Ogni metodo restituisce un riferimento all'oggetto stesso (`this`).

### Vantaggi
- Codice più conciso e leggibile
- Riduzione delle variabili temporanee
- Fluidità nell'API

### Esempio
```java
persona.setNome("Mario")
      .setCognome("Rossi")
      .setEta(30)
      .setIndirizzo("Via Roma 1");
```

## Principi OOP di Base

### Incapsulamento
L'incapsulamento è uno dei principi fondamentali della programmazione orientata agli oggetti che combina i dati con i metodi che operano su quei dati all'interno di un'unità o oggetto.

#### Getter e Setter
- **Getter**: Metodi per accedere ai dati privati
- **Setter**: Metodi per modificare i dati privati
- Permettono di controllare l'accesso e la modifica dei dati
- Facilitano la manutenzione e l'evoluzione del codice

```java
public class Persona {
    private String nome;
    
    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
}
```

## Esempi Pratici

Gli esempi forniti mostrano diverse operazioni comuni con gli array:

### 1. Ricerca del Massimo e Minimo
```java
public static int findMaxIndex(int[] array) {
    int maxIndex = 0;
    for (int i = 1; i < array.length; i++) {
        if (array[i] > array[maxIndex]) {
            maxIndex = i;
        }
    }
    return maxIndex;
}
```

### 2. Inversione Array
```java
public int[] invertiArray(int[] numeri) {
    int[] arrayInvertito = new int[numeri.length];
    for (int i = numeri.length - 1; i >= 0; i--) {
        arrayInvertito[numeri.length - 1 - i] = numeri[i];
    }
    return arrayInvertito;
}
```

### 3. Elaborazione Stringhe
```java
public int contaSpazi(String s) {
    int conta = 0;
    for(int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == ' ') {
            conta++;
        }
    }
    return conta;
}
```

## Generics

I Generics in Java permettono di creare classi, interfacce e metodi che possono lavorare con diversi tipi di dati mantenendo la type-safety.

### Vantaggi
- Type safety a compile-time
- Eliminazione dei cast espliciti
- Possibilità di implementare algoritmi generici

### Esempio Base
```java
public class ScatolaGenerica<T> {
    private T contenuto;
    
    public void setContenuto(T contenuto) {
        this.contenuto = contenuto;
    }
    
    public T getContenuto() {
        return contenuto;
    }
}
```

### Utilizzo
```java
ScatolaGenerica<String> scatolaString = new ScatolaGenerica<>();
scatolaString.setContenuto("Esempio");

ScatolaGenerica<Integer> scatolaInt = new ScatolaGenerica<>();
scatolaInt.setContenuto(42);
```

---

Questa guida fornisce una panoramica dei concetti fondamentali della programmazione in Java, con particolare attenzione agli array e ai principi OOP. Gli esempi pratici mostrano l'applicazione di questi concetti in scenari reali.
