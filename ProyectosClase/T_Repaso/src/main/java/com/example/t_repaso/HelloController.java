package com.example.t_repaso;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    @FXML
    Button botonUno,botonDos,botonTres;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void acciones(){
        botonUno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Pulsado 1");
            }
        });

        botonDos.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Pulsado 2");
            }
        });

        botonTres.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.out.println("Pulsado 3");
            }
        });
    }
}