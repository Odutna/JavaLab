
---

## **Esempio semplice: Uso delle sottostringhe**
Supponiamo di avere una stringa che rappresenta un URL e vogliamo estrarre il nome del dominio:

### **Codice**
```java
public class SottostringaEsempio {
    public static void main(String[] args) {
        String url = "https://giorgimi.edu.it/circolare/";

        // Trova la posizione del "//" e del primo "/"
        int start = url.indexOf("//") + 2; // Salta "https://"
        int end = url.indexOf("/", start); // Fine del dominio

        // Estrarre il dominio
        String domain = (end == -1) ? url.substring(start) : url.substring(start, end);

        System.out.println("Il dominio è: " + domain); // Output: giorgimi.edu.it
    }
}
```

### **Risultato**
```
Il dominio è: giorgimi.edu.it
```

---

## **Validazione di un'email con Regex**
Regex (espressioni regolari) è un approccio potente e conciso per verificare la validità di una stringa. Vediamo un esempio dettagliato.

### **Codice**
```java
import java.util.regex.Pattern;

public class EmailValidatorRegex {
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        // Espressione regolare per la validazione
        String emailRegex = "^[a-zA-Z][a-zA-Z0-9._%+-]*@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

        // Verifica della stringa con il pattern
        return Pattern.matches(emailRegex, email);
    }

    public static void main(String[] args) {
        String email1 = "esempio@test.com";
        String email2 = "1nonvalida@test.com";
        String email3 = "non.valida.@com";

        System.out.println(email1 + " è valida? " + isValidEmail(email1)); // true
        System.out.println(email2 + " è valida? " + isValidEmail(email2)); // false
        System.out.println(email3 + " è valida? " + isValidEmail(email3)); // false
    }
}
```

---

### **Regex spiegato**
1. `^` - Inizio della stringa.
2. `[a-zA-Z]` - Deve iniziare con una lettera.
3. `[a-zA-Z0-9._%+-]*` - Può contenere lettere, numeri, punti, underscore, e simboli `%+-`.
4. `@` - Deve contenere il simbolo `@`.
5. `[a-zA-Z0-9.-]+` - Il dominio può contenere lettere, numeri, punti e trattini.
6. `\\.` - Deve contenere un punto (`.`).
7. `[a-zA-Z]{2,}$` - L'estensione del dominio deve avere almeno 2 lettere (es. `.com`, `.it`).
8. `$` - Fine della stringa.

---

### **Risultato**
```
esempio@test.com è valida? true
1nonvalida@test.com è valida? false
non.valida.@com è valida? false
```

---

## **Osservazioni**
- **Regex**: Ideale per scenari complessi come la validazione di email; garantisce controlli completi.
- **Sottostringhe**: Utile per operazioni semplici, come estrarre parti di una stringa.

