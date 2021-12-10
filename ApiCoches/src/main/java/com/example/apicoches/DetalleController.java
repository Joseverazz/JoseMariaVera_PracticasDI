package com.example.apicoches;

import com.example.apicoches.utils.Coche;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetalleController implements Initializable {
    @FXML
    Button btnComprar;

    @FXML
    Label labelCoche, labelCaballos, labelModelo, labelFabricante, labelPrecio;

    @FXML
    ImageView imagenCoche;

    @FXML
    CheckBox checkFinanciado;

    @FXML
    VBox financiado, noFinanciado;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnComprar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if(checkFinanciado.isSelected()){

                }
            }
        });

    }

    public void comunicarCoche(Coche coche){
        labelCaballos.setText(String.valueOf(coche.getCaballos()));
        labelCoche.setText(coche.getMarca().toUpperCase()+" "+coche.getModelo());
        labelFabricante.setText(coche.getMarca());
        labelPrecio.setText(String.valueOf(coche.getPrecio()));
        labelModelo.setText(coche.getModelo());
        imagenCoche.setImage(new Image(coche.getImagen()));

    }
}