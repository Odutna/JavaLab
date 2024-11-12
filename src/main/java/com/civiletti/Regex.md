### Dizionario Regex – Espressioni Regolari:

1. **Caratteri letterali**:
    - `a`, `b`, `c` ...: corrispondono ai caratteri specifici stessi.

2. **Metacaratteri**:
    - `.`: Qualsiasi carattere (eccetto il carattere di nuova linea).
    - `^`: Inizia con (o negazione se usato all'interno delle parentesi quadre `[^]`).
    - `$`: Finisce con.
    - `*`: Zero o più ripetizioni.
    - `+`: Una o più ripetizioni.
    - `?`: Zero o una ripetizione (può rendere un quantificatore "greedy" non "greedy").
    - `\`: Carattere di escape per indicare caratteri speciali come `\.` (punto), `\d` (cifra).

3. **Gruppi e insiemi**:
    - `[abc]`: Uno qualsiasi tra `a`, `b` o `c`.
    - `[^abc]`: **Negazione**, qualsiasi carattere tranne `a`, `b` o `c`.
    - `[a-z]`: Qualsiasi lettera minuscola da `a` a `z`.
    - `[A-Z]`: Qualsiasi lettera maiuscola da `A` a `Z`.
    - `[0-9]`: Qualsiasi cifra da `0` a `9`.
    - `[a-zA-Z]`: Qualsiasi lettera (sia minuscola che maiuscola).
    - `[aeiou]`: Solo vocali.
    - `[^aeiou]`: Qualsiasi carattere che **non** sia una vocale.

4. **Classi predefinite**:
    - `\d`: Cifra (`[0-9]`).
    - `\D`: Non cifra (`[^0-9]`).
    - `\w`: Carattere alfanumerico (`[a-zA-Z0-9_]`).
    - `\W`: Non alfanumerico (`[^a-zA-Z0-9_]`).
    - `\s`: Spazio bianco (spazio, tab, nuova linea).
    - `\S`: Non spazio bianco (`[^ \t\r\n\f\v]`).

5. **Quantificatori**:
    - `{n}`: Esattamente `n` ripetizioni.
    - `{n,}`: Almeno `n` ripetizioni.
    - `{n,m}`: Tra `n` e `m` ripetizioni.

### Esempi:

- **Solo vocali**: `[aeiouAEIOU]`
- **Solo consonanti** (negazione delle vocali): `[^aeiouAEIOU]`
- **Solo consonanti**: `[b-df-hj-np-tv-zB-DF-HJ-NP-TV-Z]` 
- **Corrispondenza di un carattere specifico con escape**: `\.` corrisponde a un punto letterale.

### Spiegazione dell'uso delle vocali:

Se vuoi creare una regex per ottenere solo vocali, puoi usare:
```java
String vocali = "[aeiouAEIOU]";
```

Se vuoi **negare** le vocali e mantenere solo le consonanti, puoi usare:
```java
String consonanti = "[^aeiouAEIOU]";
```

In questa regex, stai dicendo al motore di corrispondenza: "qualsiasi carattere che non sia una vocale".

---

# Metodi Java che sfruttano le espressioni regolari (Regex)

In Java, le espressioni regolari possono essere utilizzate con vari metodi delle classi della libreria `java.util.regex` e con metodi delle classi `String` e `Scanner`. 

Esempio di metodi principali che sfruttano le regex:

### 1. **Metodi della classe `String`**:

- **`split(String regex)`**: Divide una stringa in un array di stringhe, usando una regex come delimitatore.

  ```java
  String testo = "Java,Python,C++,C";
  String[] linguaggi = testo.split(",");  // Risultato: ["Java", "Python", "C++", "C"]
  ```
  
- **`matches(String regex)`**: Verifica se l'intera stringa corrisponde alla regex specificata.

  ```java
  String parola = "ciao";
  boolean corrisponde = parola.matches("[a-z]+");  // Risultato: true
  ```

- **`replaceAll(String regex, String replacement)`**: Sostituisce tutte le occorrenze corrispondenti alla regex con la stringa specificata.
  
  ```java
  String testo = "Ciao 123 Java 456";
  String risultato = testo.replaceAll("\\d+", "NUMERO");  // Risultato: "Ciao NUMERO Java NUMERO"
  ```

- **`replaceFirst(String regex, String replacement)`**: Sostituisce solo la prima occorrenza corrispondente alla regex con la stringa specificata.

  ```java
  String testo = "Ciao 123 Java 456";
  String risultato = testo.replaceFirst("\\d+", "NUMERO");  // Risultato: "Ciao NUMERO Java 456"
  ```

### 2. **Classe `Scanner`**:

- **`useDelimiter(String pattern)`**: Imposta una regex come delimitatore per separare i token.

  ```Java
    Scanner sc = new Scanner("Java;Python;C++");
    sc.useDelimiter(";");
      while (sc.hasNext()) {
          System.out.println(sc.next()); // Stampa "Java", "Python", "C++"
      }
  ```

### 3. **Classe `Pattern`** (dal pacchetto `java.util.regex`):

- **`Pattern.compile(String regex)`**: Crea un oggetto `Pattern` che rappresenta una regex compilata.
  ```Java
  Pattern pattern = Pattern.compile("[a-z]+");
  ```

### 4. **Classe `Matcher`** (dal pacchetto `java.util.regex`):

- **`matches()`**: Verifica se l'intera stringa corrisponde alla regex.
  ```java
  Matcher matcher = pattern.matcher("ciao");
  boolean corrisponde = matcher.matches();  // true
  ```

- **`find()`**: Trova la prossima occorrenza che corrisponde alla regex.
  ```java
  Matcher matcher = pattern.matcher("ciao mondo");
  while (matcher.find()) {
      System.out.println("Trovato: " + matcher.group());
  }
  ```

- **`group()`**: Restituisce la sottostringa corrispondente all'ultima corrispondenza trovata.
- **`replaceAll(String replacement)`**: Sostituisce tutte le occorrenze corrispondenti con una stringa specificata.
- **`replaceFirst(String replacement)`**: Sostituisce solo la prima occorrenza corrispondente.

### 5. **Esempi pratici**:

- **Verifica di un'email**:
  ```java
  String email = "esempio@dominio.com";
  boolean valida = email.matches("^[\\w.-]+@[\\w.-]+\\.[a-z]{2,}$");  // Risultato: true
  ```

- **Estrazione di numeri da una stringa**:
  ```java
  String testo = "Numero 123 e numero 456";
  Pattern pattern = Pattern.compile("\\d+");
  Matcher matcher = pattern.matcher(testo);
  while (matcher.find()) {
      System.out.println("Numero trovato: " + matcher.group());  // Stampa 123 e 456
  }
  ```

