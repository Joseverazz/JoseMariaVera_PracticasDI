package com.example.apicoches;

import com.example.apicoches.utils.Coche;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class CompararController implements Initializable {
    @FXML
    Button btnComprar1, btnComprar2;

    @FXML
    Label labelNombre1, labelCaballos1, labelModelo1, labelFabricante1, labelPrecio1;

    @FXML
    Label labelNombre2, labelCaballos2, labelModelo2, labelFabricante2, labelPrecio2;

    @FXML
    ImageView imagen1, imagen2;

    Coche coche1,coche2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        btnComprar1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();
                FXMLLoader loader = null;
                Parent root = null;
                DetalleController detalleController = null;
                try {
                    loader = new FXMLLoader(getClass().getResource("detalle-view.fxml"));
                    root = loader.load();
                    detalleController = loader.getController();
                    detalleController.comunicarCoche(coche1);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setTitle("Detalles");
                stage.show();


                Stage ventana = (Stage) btnComprar1.getScene().getWindow();
                ventana.close();
            }
        });
        btnComprar2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Stage stage = new Stage();
                FXMLLoader loader = null;
                Parent root = null;
                DetalleController detalleController = null;
                try {
                    loader = new FXMLLoader(getClass().getResource("detalle-view.fxml"));
                    root = loader.load();
                    detalleController = loader.getController();
                    detalleController.comunicarCoche(coche2);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setTitle("Detalles");
                stage.show();

                Stage ventana = (Stage) btnComprar2.getScene().getWindow();
                ventana.close();
            }
        });

    }

    public void comunicarCoche(Coche coche, Coche coche2){
        labelCaballos1.setText(String.valueOf(coche.getCaballos()));
        labelNombre1.setText(coche.getMarca().toUpperCase()+" "+coche.getModelo());
        labelFabricante1.setText(coche.getMarca());
        labelPrecio1.setText(String.valueOf(coche.getPrecio()));
        labelModelo1.setText(coche.getModelo());
        imagen1.setImage(new Image(coche.getImagen()));
        labelCaballos2.setText(String.valueOf(coche2.getCaballos()));
        labelNombre2.setText(coche2.getMarca().toUpperCase()+" "+coche2.getModelo());
        labelFabricante2.setText(coche2.getMarca());
        labelPrecio2.setText(String.valueOf(coche2.getPrecio()));
        labelModelo2.setText(coche2.getModelo());
        imagen2.setImage(new Image(coche2.getImagen()));
        this.coche1 = coche;
        this.coche2 = coche2;

    }
}