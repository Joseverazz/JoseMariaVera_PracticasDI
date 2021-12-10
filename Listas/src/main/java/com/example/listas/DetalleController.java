package com.example.listas;

import com.example.listas.utils.Pelicula;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class DetalleController implements Initializable {

    @FXML
    Label labelTitulo, labelDescripcion, labelPopularidad;

    @FXML
    ImageView imagen;

    @FXML
    Button botonContestar;

    ListasController listasController;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        botonContestar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                listasController.metodoContestar("Peticion procesada");
                Stage ventana = (Stage) botonContestar.getScene().getWindow();
                ventana.close();
            }
        });
        
    }

    public void comunicarPelicula(Pelicula pelicula, ListasController listasController){
        this.listasController = listasController;
        labelDescripcion.setText(pelicula.getDescripcion());
        labelTitulo.setText(pelicula.getTitulo());
        labelPopularidad.setText(String.valueOf(pelicula.getPopularidad()));
        imagen.setImage(new Image(pelicula.getImagen()));
    }
}