# Tabelle con i codici ANSI più comuni per formattare il testo e aggiungere colori. 

Puoi utilizzare questi codici nei terminali che supportano ANSI (come macOS, Linux, e anche Windows moderni con supporto abilitato).

---

### **Tabella Codici ANSI**
| **Codice ANSI**        | **Effetto**                      | **Esempio di Utilizzo** |
|-------------------------|-----------------------------------|--------------------------|
| `\033[0m`              | Reset tutte le impostazioni      | `System.out.print("\033[0m")` |
| `\033[1m`              | Testo in grassetto               | `\033[1mGrassetto`      |
| `\033[4m`              | Testo sottolineato               | `\033[4mSottolineato`   |
| `\033[7m`              | Colori invertiti                 | `\033[7mInvertito`      |
| `\033[30m`             | Testo Nero                       | `\033[30mNero`          |
| `\033[31m`             | Testo Rosso                      | `\033[31mRosso`         |
| `\033[32m`             | Testo Verde                      | `\033[32mVerde`         |
| `\033[33m`             | Testo Giallo                     | `\033[33mGiallo`        |
| `\033[34m`             | Testo Blu                        | `\033[34mBlu`           |
| `\033[35m`             | Testo Magenta                    | `\033[35mMagenta`       |
| `\033[36m`             | Testo Ciano                      | `\033[36mCiano`         |
| `\033[37m`             | Testo Bianco                     | `\033[37mBianco`        |
| `\033[90m`             | Testo Grigio scuro               | `\033[90mGrigio Scuro`  |
| `\033[91m`             | Testo Rosso chiaro               | `\033[91mRosso Chiaro`  |
| `\033[92m`             | Testo Verde chiaro               | `\033[92mVerde Chiaro`  |
| `\033[93m`             | Testo Giallo chiaro              | `\033[93mGiallo Chiaro` |
| `\033[94m`             | Testo Blu chiaro                 | `\033[94mBlu Chiaro`    |
| `\033[95m`             | Testo Magenta chiaro             | `\033[95mMagenta Chiaro`|
| `\033[96m`             | Testo Ciano chiaro               | `\033[96mCiano Chiaro`  |
| `\033[97m`             | Testo Bianco brillante           | `\033[97mBianco`        |

---

### **Sfondo**
| **Codice ANSI**         | **Effetto**                     | **Esempio di Utilizzo** |
|--------------------------|----------------------------------|--------------------------|
| `\033[40m`              | Sfondo Nero                     | `\033[40mNero`          |
| `\033[41m`              | Sfondo Rosso                    | `\033[41mRosso`         |
| `\033[42m`              | Sfondo Verde                    | `\033[42mVerde`         |
| `\033[43m`              | Sfondo Giallo                   | `\033[43mGiallo`        |
| `\033[44m`              | Sfondo Blu                      | `\033[44mBlu`           |
| `\033[45m`              | Sfondo Magenta                  | `\033[45mMagenta`       |
| `\033[46m`              | Sfondo Ciano                    | `\033[46mCiano`         |
| `\033[47m`              | Sfondo Bianco                   | `\033[47mBianco`        |
| `\033[100m`             | Sfondo Grigio scuro             | `\033[100mGrigio Scuro` |
| `\033[101m`             | Sfondo Rosso chiaro             | `\033[101mRosso Chiaro` |
| `\033[102m`             | Sfondo Verde chiaro             | `\033[102mVerde Chiaro` |
| `\033[103m`             | Sfondo Giallo chiaro            | `\033[103mGiallo Chiaro`|
| `\033[104m`             | Sfondo Blu chiaro               | `\033[104mBlu Chiaro`   |
| `\033[105m`             | Sfondo Magenta chiaro           | `\033[105mMagenta Chiaro`|
| `\033[106m`             | Sfondo Ciano chiaro             | `\033[106mCiano Chiaro` |
| `\033[107m`             | Sfondo Bianco brillante         | `\033[107mBianco`       |

---

### **Effetti combinati**
Puoi combinare più codici ANSI. Per esempio:
```java
System.out.println("\033[1;31;47mTesto in rosso grassetto con sfondo bianco\033[0m");
```

---

### **Note:**
1. **Reset:** Usa sempre `\033[0m` alla fine per ripristinare i colori ed evitare che influenzino il resto del testo.
2. **Portabilità:** Non tutti i terminali supportano i colori ANSI, ma macOS, Linux e versioni moderne di Windows (con terminale aggiornato) funzionano correttamente.
3. **Esempio Java:**
   ```java
   public class AnsiExample {
       public static void main(String[] args) {
           System.out.println("\033[1;32mTesto in verde grassetto\033[0m");
           System.out.println("\033[31;43mTesto rosso con sfondo giallo\033[0m");
       }
   }
   ```