# Lab 7

---

### **Polimorfismo in Java**
Il **polimorfismo** è uno dei **principi fondamentali della programmazione orientata agli oggetti (OOP)**. Si riferisce alla capacità di un oggetto di assumere **forme diverse**, cioè comportarsi in modi diversi a seconda del contesto.

#### **Principi chiave del polimorfismo**:
1. **Overloading (polimorfismo statico)**:  
   Lo stesso metodo può avere **più versioni**, differenziate dal numero o dal tipo dei parametri.
    - **Esempio**:
      ```java
      class Calcolatrice {
          int somma(int a, int b) {
              return a + b;
          }
 
          double somma(double a, double b) {
              return a + b;
          }
      }
      ```

2. **Overriding (polimorfismo dinamico)**:  
   Una classe derivata può **ridefinire un metodo della classe base**, modificandone il comportamento.
    - **Esempio**:
      ```java
      class Animale {
          void verso() {
              System.out.println("L'animale emette un verso generico");
          }
      }
 
      class Cane extends Animale {
          @Override
          void verso() {
              System.out.println("Il cane abbaia");
          }
      }
      ```

3. **Ereditarietà e polimorfismo ad hoc**:  
   Una **classe figlia** può essere trattata come un’istanza della **classe padre**. In questo modo, lo stesso riferimento può assumere **forme diverse**.
    - **Esempio**:
      ```java
      Animale a = new Cane(); // Il riferimento è di tipo Animale, ma l'oggetto è un Cane
      a.verso();              // Output: "Il cane abbaia"
      ```

---

### **Tipi di Polimorfismo**
1. **Polimorfismo statico (a tempo di compilazione)**:
    - Realizzato tramite **overloading** di metodi o operatori.
    - Il compilatore determina quale metodo invocare in base ai parametri.
    - **Esempio**:
      ```java
      void stampa(int x) {
          System.out.println("Numero intero: " + x);
      }
 
      void stampa(double x) {
          System.out.println("Numero decimale: " + x);
      }
      ```

2. **Polimorfismo dinamico (a tempo di esecuzione)**:
    - Realizzato tramite **overriding** di metodi.
    - Il metodo chiamato dipende dal tipo reale dell’oggetto al momento dell’esecuzione.
    - **Esempio**:
      ```java
      Animale a = new Cane();
      a.verso(); // Determinato a runtime: stampa "Il cane abbaia".
      ```

---

### **Esempio completo: Overriding con polimorfismo**

```java
import com.civiletti.veicolo.v1.Veicolo;

class com.civiletti.veicolo.

Veicolo {
   void suonaClacson () {
      System.out.println("Il veicolo emette un suono generico.");
   }
}

class Auto extends Veicolo {
   @Override
   void suonaClacson() {
      System.out.println("L'auto suona: Beep Beep!");
   }
}

class Camion extends Veicolo {
   @Override
   void suonaClacson() {
      System.out.println("Il camion suona: Honk Honk!");
   }
}

public class TestPolimorfismo {
   public static void main(String[] args) {
      Veicolo v1 = new Auto();
      Veicolo v2 = new Camion();

      v1.suonaClacson(); // Output: "L'auto suona: Beep Beep!"
      v2.suonaClacson(); // Output: "Il camion suona: Honk Honk!"
   }
}
```

---

### **Osservazioni**
- **Immutabilità della classe `String`** garantisce sicurezza e performance in molti contesti, ma richiede strumenti alternativi per modifiche frequenti.
- **Polimorfismo** consente una maggiore flessibilità e riutilizzabilità del codice, rendendo il sistema più modulare e manutenibile.


---

### **Immutabilità della classe `String` in Java**
La **classe `String` in Java è immutabile**, il che significa che **una volta creato un oggetto `String`, il suo valore non può essere modificato**. Ogni operazione che sembra modificare una stringa in realtà crea un nuovo oggetto con il valore aggiornato, lasciando inalterato l’oggetto originale.

#### **Esempio di immutabilità**:
```java
String s1 = "ciao";
String s2 = s1.toUpperCase(); // s1 rimane invariata
System.out.println(s1); // Output: ciao
System.out.println(s2); // Output: CIAO
```

- **Cosa succede qui?**
    - `s1.toUpperCase()` non modifica la stringa originale `s1`, ma crea un **nuovo oggetto** con il valore `"CIAO"`, assegnato a `s2`.

#### **Vantaggi dell'immutabilità**:
1. **Sicurezza e thread-safety**: Le stringhe immutabili possono essere condivise tra più thread senza preoccuparsi di condizioni di competizione o modifiche indesiderate.
2. **Caching**: Oggetti `String` immutabili possono essere memorizzati nella **String Pool**, riducendo il consumo di memoria e migliorando le prestazioni.
3. **Comportamento prevedibile**: Poiché il valore non cambia, è più semplice ragionare e lavorare con stringhe.

#### **Svantaggi**:
- L’immutabilità può risultare inefficiente in applicazioni che richiedono modifiche frequenti alle stringhe. In questi casi, è preferibile usare classi come `StringBuilder` o `StringBuffer`, che offrono oggetti mutabili.

---



