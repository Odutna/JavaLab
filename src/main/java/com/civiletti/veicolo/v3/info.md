# pom.xml
```xml
    <dependencies>
        <dependency>
            <groupId>org.jline</groupId>
            <artifactId>jline</artifactId>
            <version>3.21.0</version>
        </dependency>
    </dependencies>
```
# Compila
```bash
javac -d . -classpath /Users/antudo/.m2/repository/org/jline/jline/3.21.0/jline-3.21.0.jar TestVeicolo.java Veicolo.java InfoVeicolo.java Mappa.java TestMovimento.java
```
# Esegui
```bash
java -classpath .:/Users/antudo/.m2/repository/org/jline/jline/3.21.0/jline-3.21.0.jar com.civiletti.veicolo.v2.TestMovimento

```

# Maven
Dalla root dove è presente il file pom.xml
```bash
mvn compile
mvn exec:java -Dexec.mainClass="com.civiletti.veicolo.v3.TestMovimento"

```
# macOS Terminal

```bash
vim ~/.zshrc
```
Incolla, salva e chiudi (wq)

```bash
export CLASSPATH=".:/Users/antudo/.m2/repository/org/jline/jline/3.21.0/jline-3.21.0.jar"
```

```bash
source ~/.zshrc
```
# Windows:
Pannello di Controllo > Sistema > Impostazioni Avanzate > Variabili d'Ambiente.

Aggiungere una nuova variabile utente o modifica CLASSPATH esistente (sostituire mio_utente xon il propio nome utente):
```makefile
.;C:\Users\mio_utente\.m2\repository\org\jline\jline\3.21.0\jline-3.21.0.jar
```
Ora si può compilare ed eseguire senza specificare il classpath:
```batch
javac -d . TestVeicolo.java Veicolo.java InfoVeicolo.java Mappa.java TestMovimento.java
java com.civiletti.veicolo.v3.TestMovimento
```

