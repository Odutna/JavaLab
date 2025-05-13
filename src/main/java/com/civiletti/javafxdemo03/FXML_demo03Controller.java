/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.civiletti.javafxdemo03;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Region;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
/**
 * FXML Controller class
 *
 * @author S.Civiletti
 */
public class FXML_demo03Controller implements Initializable {


    @FXML
    private Button btnGenera;
    @FXML
    private Label lblNumero;
    @FXML
    private Label lblTextNumero;
    @FXML
    private AnchorPane anchorPaneID;
    @FXML
    private Region regionBottom;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void handleBtnGeneraAction(ActionEvent event) {
        
        if(event.getSource() == btnGenera){
            
            Random random = new Random();
            int numero = random.nextInt(100) + 1;
            lblNumero.setText(Integer.toString(numero));
            
        }
        
    }

}
