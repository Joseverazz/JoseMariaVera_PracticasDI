package com.example.t4_elementos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import com.example.t4_elementos.utils.*;
import java.net.URL;
import java.util.ResourceBundle;

public class ElementosController implements Initializable  {

    private ObservableList<Persona> listaCombo, listaChoice, listaListView;

    @FXML
    CheckBox checkRegistro;

    @FXML
    GridPane panelRegistro;

    @FXML
    BorderPane panelGeneral;

    @FXML
    ChoiceBox<Persona> choice;

    @FXML
    ComboBox<Persona> combo;

    @FXML
    Label textoCombo, textoChoice;

    @FXML
    RadioButton checkOpUno,checkOpDos,checkOpTres;

    @FXML
    Button btnNormal, btnComprobar;

    @FXML
    ToggleButton btnToggle;

    @FXML
    ListView<Persona> listView;

    ToggleGroup grupoCheck; // necesita instancia




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        iniciarElementos();
        iniciarListas();
        acciones();
    }

    private void iniciarListas() {
        listaCombo.addAll(new Persona("Jose ","Maria", 1234),
                new Persona("jorge", "maset", 1234),
                new Persona("Luis", "perez", 2345),
                new Persona("Mateo", "garcia", 3456));
        listaChoice.addAll(new Persona("Jose ","Maria", 1234),
                new Persona("jorge", "maset", 1234),
                new Persona("Luis", "perez", 2345),
                new Persona("Mateo", "garcia", 3456));
        listaListView.addAll(new Persona("Jose ","Maria", 1234),
                new Persona("jorge", "maset", 1234),
                new Persona("Luis", "perez", 2345),
                new Persona("Mateo", "garcia", 3456),
                new Persona("Jose ","Maria", 1234),
                new Persona("jorge", "maset", 1234),
                new Persona("Luis", "perez", 2345),
                new Persona("Mateo", "garcia", 3456),
                new Persona("Jose ","Maria", 1234),
                new Persona("jorge", "maset", 1234),
                new Persona("Luis", "perez", 2345),
                new Persona("Mateo", "garcia", 3456),
                new Persona("Jose ","Maria", 1234),
                new Persona("jorge", "maset", 1234),
                new Persona("Luis", "perez", 2345),
                new Persona("Mateo", "garcia", 3456),
                new Persona("Jose ","Maria", 1234),
                new Persona("jorge", "maset", 1234),
                new Persona("Luis", "perez", 2345),
                new Persona("Mateo", "garcia", 3456));
    }

    private void iniciarElementos() {
        combo.setItems(listaCombo);
        choice.setItems(listaChoice);
        listView.setItems(listaListView);
        panelGeneral.getChildren().remove(panelRegistro);
        grupoCheck.getToggles().addAll(checkOpUno,checkOpDos,checkOpTres);
        checkOpUno.setUserData(new Persona("jorge", "maset", 1234));
        checkOpDos.setUserData(new Persona("Luis", "maset", 2345));
        checkOpTres.setUserData(new Persona("Mateo", "maset", 3456));
    }

    private void instancias() {

        grupoCheck = new ToggleGroup();

        listaCombo = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
        listaListView = FXCollections.observableArrayList();
    }

    private void acciones() {

        btnNormal.setOnAction(new ManejoPulsaciones());
        btnComprobar.setOnAction(new ManejoPulsaciones());

        //choice.setOnAction(new ManejoOpciones());
        //combo.setOnAction(new ManejoOpciones());
        choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue<? extends Persona> observableValue, Persona persona, Persona t1) {
                textoChoice.setText(t1.getApellido());
            }
        });

        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue<? extends Persona> observableValue, Persona persona, Persona t1) {
                textoCombo.setText(t1.getApellido());
            }
        });

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

        grupoCheck.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue,
                                Toggle toggle, Toggle t1) {

               //System.out.println(((RadioButton)(t1)).getText());
                System.out.println(((Persona) t1.getUserData()).getNombre());
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
    class ManejoOpciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if (actionEvent.getSource() == choice)
            {
                textoChoice.setText(choice.getSelectionModel().getSelectedItem().getApellido());
            }
            if (actionEvent.getSource() == combo)
            {
                textoCombo.setText(combo.getSelectionModel().getSelectedItem().getApellido());
            }
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {

            if (actionEvent.getSource()== btnNormal){

               /* if(checkOpUno.isSelected()){

                    System.out.println("check uno selecionado");
                }*/

                System.out.println(((RadioButton)(grupoCheck.getSelectedToggle())).getText());

            } else if(actionEvent.getSource() == btnToggle){
                if(btnToggle.isSelected()){
                    System.out.println("Boton selecionado");
                } else{
                    System.out.println("Boton no selecionado");
                }
            } else if (actionEvent.getSource() == btnComprobar){
                choice.getSelectionModel().getSelectedItem().mostrarDatos();
                combo.getSelectionModel().getSelectedItem().mostrarDatos();
            }
        }
    }
}