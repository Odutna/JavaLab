package com.civiletti.esercitazione;

/**
 *
 *
 * Nell'ambito della gestione dei dati utente, l'azienda XY necessita dell'implementazione di
 * un'applicazione che consenta di memorizzare i dati dei propri dipendenti.
 *
 * Al candidato è richiesta la progettazione di un'applicazione con le seguenti caratteristiche:
 *
 *     la creazione di una classe Persona per la gestione delle credenziali d'accesso
 *     e la registrazione dei dati personali, inclusi nome e cognome.
 *
 *
 * SPECIFICHE:
 *
 * La classe deve implementare metodi per l'inserimento di dati, la visualizzazione di dati singoli
 * e multipli, la ricerca di un utente per cognome e un metodo main per testare il codice.
 *
 * È necessario rispettare i principi di incapsulamento dei dati e information hiding, diversamente,
 * anche in caso di applicazione perfettamente funzionante, verranno sottratti punti pari a 2 dal
 * punteggio finale.
 *
 * Specifiche:
 *
 * 1. **Login e Inserimento delle Credenziali:**
 *   - Implementare un metodo userLogin che richieda all'utente di inserire un username e una
 *     password.
 *   - Utilizzare un oggetto Scanner come parametro del metodo per consentire la flessibilità
 *     e la riusabilità del codice.
 *
 * 2. **Inserimento di un Dato Singolo:**
 *
 *   - Implementare un metodo `inserisciDati` che chieda all'utente di inserire nome e cognome.
 *   - Utilizzare un oggetto `Scanner` come parametro del metodo.
 *
 * 3. **Visualizzazione di un Dato Singolo:**
 *   - Implementare un metodo visualizzaDato che visualizzi il nome e il cognome di una persona.
 *
 * 4. **Inserimento di più dati contemporaneamente:**
 *   - Implementare un metodo `inserisciDatiMultipli` che consenta l'inserimento di un array di
 *     oggetti `Persona`.
 *   - Utilizzare un oggetto `Scanner` come parametro del metodo.
 *
 * 5. **Visualizzazione di più dati contemporaneamente:**
 *   - Implementare un metodo `visualizzaDatiMultipli` che visualizzi i dati di tutte le persone
 *     presenti nell'array.
 *
 * 6. **Ricerca di un Utente per Cognome:**
 *   - Implementare un metodo `trovaUtentePerCognome` che accetti un array di oggetti `Persona`
 *     e un cognome da cercare.
 *   - Restituire o visualizzare i dati della persona trovata.
 *
 * 7. **Metodo Main per il Test del Codice:**
 *   - Implementare un metodo `main` che permetta di testare le funzionalità della classe `Persona`.
 *   - Utilizzare un oggetto `Scanner` per gestire l'input dell'utente.
 *
 */

import java.util.Scanner;

// Classe per gestire i dati personali
class Dati {
    private String nome;
    private String cognome;
    private int id;
    private static int contatore = 0;

    public Dati() {
        this.id = ++contatore;
    }

    // Metodi Getters
    public String getNome() { return nome; }
    public String getCognome() { return cognome; }
    public int getId() { return id; }

    // Metodi Setters
    public void setNome(String nome) { this.nome = nome; }
    public void setCognome(String cognome) { this.cognome = cognome; }
}

// Classe per gestire le credenziali di accesso
class Login {
    private String username;
    private String password;

    public Login() {
        this.username = "admin";
        this.password = "12345";
    }

    public boolean verificaCredenziali(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
}

public class Persona {
    private Login login;

    public Persona() {
        this.login = new Login();
    }

    public boolean userLogin(Scanner scanner) {
        System.out.print("Inserisci username: ");
        String username = scanner.nextLine();
        System.out.print("Inserisci password: ");
        String password = scanner.nextLine();

        return login.verificaCredenziali(username, password);
    }

    public Dati inserisciDati(Scanner scanner) {
        Dati d = new Dati();

        System.out.print("Inserisci nome: ");
        d.setNome(scanner.nextLine());

        System.out.print("Inserisci cognome: ");
        d.setCognome(scanner.nextLine());

        return d;
    }

    public void visualizzaDato(Dati d) {
        System.out.println("ID: " + d.getId());
        System.out.println("Nome: " + d.getNome());
        System.out.println("Cognome: " + d.getCognome());
    }

    public void visualizzaDati(Dati[] dati) {
        for (Dati d : dati) {
            if (d != null) {
                visualizzaDato(d);
                System.out.println("===============");
            }
        }
    }

    public void visualizzaUtentiPerCognome(Dati[] datiArray, String cognomeCercato) {
        boolean utenteTrovato = false;
        for (Dati utente : datiArray) {
            if (utente != null && utente.getCognome().equalsIgnoreCase(cognomeCercato)) {
                visualizzaDato(utente);
                utenteTrovato = true;
            }
        }

        if (!utenteTrovato) {
            System.out.println("Nessun utente trovato con il cognome: " + cognomeCercato);
        }
    }

    public static int menu(Scanner scanner){
        System.out.println("\nScegli un'operazione:");
        System.out.println("1. Visualizza tutti gli utenti");
        System.out.println("2. Visualizza utente specifico");
        System.out.println("3. Cerca utente per cognome");
        System.out.println("4. Esci");

        return Integer.parseInt(scanner.nextLine());
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Persona p = new Persona();

        System.out.println("Benvenuto al sistema di gestione dipendenti");

        // Login
        while (!p.userLogin(scanner)) {
            System.out.println("Credenziali non valide. Riprova.");
        }

        System.out.println("Login effettuato con successo!\n");

        // Inserimento dati
        System.out.print("Quanti utenti vuoi inserire? ");
        int maxUser = Integer.parseInt(scanner.nextLine());

        Dati[] dati = new Dati[maxUser];

        for (int i = 0; i < maxUser; i++) {
            System.out.println("\nInserimento dati utente " + (i + 1));
            dati[i] = p.inserisciDati(scanner);
        }

        // Menu operazioni
        boolean continua = true;

        while (continua) {
            int scelta = menu(scanner);

            switch (scelta) {
                case 1:
                    System.out.println("\nElenco di tutti gli utenti:");
                    System.out.println("===============");
                    p.visualizzaDati(dati);
                    break;
                case 2:
                    System.out.print("\nInserisci l'ID dell'utente da visualizzare: ");
                    int id = Integer.parseInt(scanner.nextLine()) - 1;
                    if (id >= 0 && id < dati.length) {
                        p.visualizzaDato(dati[id]);
                    } else {
                        System.out.println("ID non valido");
                    }
                    break;
                case 3:
                    System.out.print("\nInserisci il cognome da cercare: ");
                    String cognome = scanner.nextLine();
                    p.visualizzaUtentiPerCognome(dati, cognome);
                    break;
                case 4:
                    continua = false;
                    break;
                default:
                    System.out.println("Scelta non valida");
            }
        }
        scanner.close();
        System.out.println("Arrivederci!");
    }
}
