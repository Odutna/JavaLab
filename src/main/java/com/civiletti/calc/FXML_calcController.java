package com.civiletti.calc;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author S. Civiletti
 */
public class FXML_calcController implements Initializable {

    @FXML
    private AnchorPane anchorPaneCalc; // Pannello principale dell'interfaccia calcolatrice
    @FXML
    private Region RegionCalc; // Area all'interno del pannello principale
    @FXML
    private Label lblRisultato; // Etichetta per la visualizzazione del risultato

    private double operando1 = 0; // Variabile per memorizzare il primo operando
    private double operando2 = 0;
    private String operatore = ""; // Variabile per memorizzare l'operatore (+, -, *, /,...)
    private boolean primoOperando = true; // Flag per indicare se si sta inserendo il primo operando

    Model model = new Model(); // Oggetto del modello per eseguire i calcoli
    @FXML
    private StackPane stackPaneRisultato;
    @FXML
    private Button btnDiviso;
    @FXML
    private Button btnMoltiplica;
    @FXML
    private Button btnSottrai;
    @FXML
    private Button btnSomma;
    @FXML
    private Button btnUguale;
    @FXML
    private Button btnDecimale;

    /**
     * Metodo di inizializzazione della classe controller. In questa fase
     * vengono eseguite le operazioni di inizializzazione necessarie per il
     * corretto funzionamento della calcolatrice.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO: Aggiungere eventuali operazioni di inizializzazione specifiche per la calcolatrice
    }

    /**
     * Metodo per la gestione dei click sui pulsanti numerici. Questo metodo
     * viene invocato ogni volta che l'utente clicca su un pulsante numerico
     * (0-9).
     *
     * @param event Evento associato al click del pulsante
     */
    @FXML
    private void gestioneNumeri(ActionEvent event) {
        // Se si sta inserendo il primo operando, si cancella il contenuto precedente dell'etichetta del risultato
        if (primoOperando) {
            lblRisultato.setText("");
            primoOperando = false;
        }

        // Si ottiene il valore del pulsante cliccato
        String valore = ((Button) event.getSource()).getText();

        // Si concatena il valore del pulsante al contenuto attuale dell'etichetta del risultato
        lblRisultato.setText(lblRisultato.getText() + valore);
    }

    /**
     * Metodo per la gestione dei click sui pulsanti degli operatori (+, -, *,
     * /, =). Questo metodo viene invocato ogni volta che l'utente clicca su un
     * pulsante operatore.
     *
     * @param event Evento associato al click del pulsante
     */
    @FXML
    private void gestioneOperatori(ActionEvent event) {

        String valore = ((Button) event.getSource()).getText(); // Valore del pulsante operatore

        // Se l'utente non clicca sul pulsante '='
        if (!valore.equals("=")) {
            // Se non è stato inserito alcun numero (e per esempio si clicca su = ), si ignora il click
            if (!operatore.isEmpty()) {
                return;
            }

            // Si aggiorna l'operatore con il nuovo valore
            operatore = valore;

            // Si converte il primo operando dal formato stringa a formato double
            operando1 = Double.parseDouble(lblRisultato.getText());

            // Si cancella il contenuto dell'etichetta del risultato
            lblRisultato.setText("");
        } else {
            // Se non è stato inserito alcun operatore, si ignora il click
            if (operatore.isEmpty()) {
                return;
            }

            primoOperando = true;
            // Si converte il secondo operando dal formato stringa a formato double
            operando2 = Double.parseDouble(lblRisultato.getText());

            try {
                System.out.println("operando1: " + operando1 + " operando2: " + operando2 + " operatore: " + operatore);
                // Si esegue il calcolo utilizzando il modello
                double risultato = model.calcolatrice(operando1, operando2, operatore);
                System.out.println("risultato: " + risultato);
                // Si formatta il risultato in base alle proprie esigenze (ad esempio, decimali)
                // Opzione 1: Formato con virgola e due cifre decimali
                DecimalFormat df = new DecimalFormat("#,###.##"); // Formato con virgola e due cifre decimali
                String risultatoFormattato = df.format(risultato);

                // Opzione 2: Sostituzione del punto con la virgola
                // String risultatoFormattato = String.valueOf(risultato).replace(".", ",");
                // Si visualizza il risultato formattato sull'etichetta
//                lblRisultato.setText(risultatoFormattato);
                lblRisultato.setText(String.valueOf(risultato));
            } catch (Exception e) { // Gestione degli errori
                // In caso di eccezione (ad esempio, divisione per zero), si visualizza un messaggio di errore
                lblRisultato.setText("Errore: " + e.getMessage());
            }

            // Resetta l'operatore
            operatore = "";

        }
    }

    @FXML
    private void gestioneAC(ActionEvent event) {
        // Resetta l'operatore
        operatore = "";
        lblRisultato.setText("0");
        primoOperando = true;
    }

    @FXML
    private void gestioneSegno(ActionEvent event) {

        String valore = ((Button) event.getSource()).getText(); // Valore del pulsante operatore

        // Se l'utente non clicca sul pulsante '='
        if (!valore.equals("=")) {
            // Se non è stato inserito alcun numero (e per esempio si clicca su = ), si ignora il click
            if (!operatore.isEmpty()) {
                return;
            }

            // Si converte il primo operando dal formato stringa a formato long
            operando1 = -1 * Double.parseDouble(lblRisultato.getText());

            // Si cancella il contenuto dell'etichetta del risultato
            lblRisultato.setText(operando1 + "");
        } else {
            // Se non è stato inserito alcun operatore, si ignora il click
            if (operatore.isEmpty()) {
                return;
            }

            primoOperando = true;
            // Si converte il secondo operando dal formato stringa a formato double
            operando2 = -1 * Double.parseDouble(lblRisultato.getText());

            try {

                lblRisultato.setText(operando2 + "");
            } catch (Exception e) { // Gestione degli errori
                // In caso di eccezione (ad esempio, divisione per zero), si visualizza un messaggio di errore
                lblRisultato.setText("Errore: " + e.getMessage());
            }

            // Resetta l'operatore
            operatore = "";

        }
    }

    @FXML
    private void gestionePercentuale(ActionEvent event) {

        String valore = ((Button) event.getSource()).getText(); // Valore del pulsante operatore

        // Se l'utente non clicca sul pulsante '='
        if (!valore.equals("=")) {
            // Se non è stato inserito alcun numero (e per esempio si clicca su = ), si ignora il click
            if (!operatore.isEmpty()) {
                return;
            }

            // Si converte il primo operando dal formato stringa a formato long
            operando1 = Double.parseDouble(lblRisultato.getText()) / 100;

            // Si cancella il contenuto dell'etichetta del risultato
            lblRisultato.setText(operando1 + "");
        } else {
            // Se non è stato inserito alcun operatore, si ignora il click
            if (operatore.isEmpty()) {
                return;
            }

            primoOperando = true;
            // Si converte il secondo operando dal formato stringa a formato double
            operando2 = Double.parseDouble(lblRisultato.getText()) / 100;

            try {
                lblRisultato.setText(operando2 + "");
            } catch (Exception e) { // Gestione degli errori
                // In caso di eccezione (ad esempio, divisione per zero), si visualizza un messaggio di errore
                lblRisultato.setText("Errore: " + e.getMessage());
            }

            // Resetta l'operatore
            operatore = "";
        } // Fine else
    }

    @FXML
    private void gestioneDecimali(ActionEvent event) {
        if (event.getSource() == btnDecimale) {
            // Si concatena il valore del pulsante al contenuto attuale dell'etichetta del risultato
            lblRisultato.setText(lblRisultato.getText() + ".");
        }
    }
}
