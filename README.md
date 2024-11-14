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

## Annotazioni Java

Le annotazioni sono metadati che possono essere aggiunti al codice Java. Forniscono informazioni aggiuntive al compilatore e possono essere utilizzate da strumenti di sviluppo e framework.

### Annotazioni Principali
- `@Override`: Indica che un metodo sovrascrive un metodo della classe padre
- `@Deprecated`: Marca un elemento come obsoleto
- `@SuppressWarnings`: Disattiva specifici warning del compilatore
- `@FunctionalInterface`: Dichiara un'interfaccia come funzionale (con un solo metodo astratto)
- `@Test`: Usata per i test unitari (JUnit)

### Esempio
```java
public class Esempio {
    @Override
    public String toString() {
        return "Esempio di annotazione";
    }

    @Deprecated
    public void metodoVecchio() {
        // Metodo deprecato
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
