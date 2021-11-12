package com.example.t4_elementos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ElementosController implements Initializable  {

    @FXML
    CheckBox checkRegistro;

    @FXML
    GridPane panelRegistro;

    @FXML
    BorderPane panelGeneral;


    @FXML
    RadioButton checkOpUno,checkOpDos,checkOpTres;

    @FXML
    Button btnNormal;

    @FXML
    ToggleButton btnToggle;

    ToggleGroup grupocheck; // necesita instancia


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        iniciarElementos();

        acciones();
    }

    private void iniciarElementos() {

        grupocheck.getToggles().addAll(checkOpUno,checkOpDos,checkOpTres);

    }

    private void instancias() {

        grupocheck = new ToggleGroup();
    }

    private void acciones() {

        btnNormal.setOnAction(new ManejoPUlsaciones());
        //btnToggle.setOnAction(new ManejoPUlsaciones());
        btnToggle.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                //System.out.println(newValue);
                btnNormal.setDisable(newValue);// si pulso se desabilita el boton normal
            }
        });

        checkOpUno.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {

                checkOpUno.setDisable(newValue);
            }
        });

        grupocheck.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {

               ((RadioButton)(t1)).getText();
               System.out.println(((RadioButton)(t1)).getText());
            }
        });

        checkRegistro.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {

                if(t1){
                    panelGeneral.setLeft(panelRegistro);
                }else{
                    panelGeneral.getChildren().remove(panelRegistro);
                }

            }
        });

    }

    class ManejoPUlsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

        if (actionEvent.getSource()== btnNormal){

           /* if(checkOpUno.isSelected()){

                System.out.println("check uno selecionado");
            }*/

            System.out.println(((RadioButton)(grupocheck.getSelectedToggle())).getText());

        } else if(actionEvent.getSource() == btnToggle){

            if(btnToggle.isSelected()){
                System.out.println("Boton selecionado");
            } else{
                System.out.println("Boton no selecionado");
            }
        }

        }
    }
}