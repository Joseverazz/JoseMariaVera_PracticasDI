package com.example.josemariavera;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class PedidosController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}