/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.civiletti.javafxdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * FXML Controller class
 *
 * @author S. Civiletti
 */
public class FXMLController implements Initializable {

    @FXML
    private Button btnCliccami;
    private Label labelInfo;
    @FXML
    private Label labelJFXInfo;
    @FXML
    private Label labelJAVAInfo;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
            var javaVersion = SystemInfo.javaVersion();
            var javafxVersion = SystemInfo.javafxVersion();
            
            labelJFXInfo.setText("Versione JavaFX " + javafxVersion);
            labelJAVAInfo.setText("Versione Java " + javaVersion);
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
//        if (event.getSource() == btnCliccami) {
//            System.out.println("Mi hai cliccato!");
//        }
        System.out.println("Mi hai cliccato!");
    }

}
