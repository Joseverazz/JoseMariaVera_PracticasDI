package com.example.calculadora;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable,EventHandler<ActionEvent> {
    @FXML
    TextField tResultado;
    @FXML
    TextArea textRegistro;
    @FXML
    GridPane gridBtn,gridBtn2;
    @FXML
    CheckBox chRegistro, chCientifica;
    @FXML
    BorderPane borderPane;
    @FXML
    HBox boxRegistro;

    String operacion = "";

    double n1;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();

        acciones();
    }

    private void personalizarBotones() {
    }

    private void acciones() {
        borderPane.getChildren().remove(gridBtn2);
        gridBtn.setPrefWidth(600);
        borderPane.getChildren().remove(boxRegistro);

        ObservableList<Node> listaBotones = gridBtn.getChildren();
        ObservableList<Node> listaBoton = gridBtn2.getChildren();
        chCientifica.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1){
                    borderPane.setLeft(gridBtn2);
                    if (chRegistro.isSelected()){
                        gridBtn.setPrefWidth(400);
                    }
                    else {
                        gridBtn.setPrefWidth(500);
                    }
                }
                else
                {
                    borderPane.getChildren().remove(gridBtn2);
                    if (chRegistro.isSelected()){
                        gridBtn.setPrefWidth(500);
                    }
                    else {
                        gridBtn.setPrefWidth(600);
                    }
                }
            }
        });
        chRegistro.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                if (t1){
                    borderPane.setRight(boxRegistro);
                    if (chCientifica.isSelected()){
                        gridBtn.setPrefWidth(400);
                    }
                    else {
                        gridBtn.setPrefWidth(500);
                    }
                }
                else
                {
                    borderPane.getChildren().remove(boxRegistro);
                    if (chCientifica.isSelected()){
                        gridBtn.setPrefWidth(500);
                    }
                    else {
                        gridBtn.setPrefWidth(600);
                    }
                }
            }
        });
        for (Node item:
             listaBotones) {
            ((Button) item).setOnAction(this);
        }

        for (Node item:
                listaBoton) {
            ((Button) item).setOnAction(this);
        }
    }

    private void instancias() {
        DropShadow dropShadow;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Button bAux = (Button) actionEvent.getSource();
        if (bAux.getText().equals("C")){
            tResultado.setText("");
            operacion = "";
        }
        else if (bAux.getText().equals("+/-")) {
            if (tResultado.getText().charAt(0) == '-')
                tResultado.setText(tResultado.getText().substring(1));
            else
                tResultado.setText("-"+tResultado.getText());
        }
        else if(bAux.getText().equals("+")|| bAux.getText().equals("-")||
                bAux.getText().equals("x")|| bAux.getText().equals("/")||
                bAux.getText().equals("%") ) {
            operacion = bAux.getText();
            n1 = Double.parseDouble(tResultado.getText());
            tResultado.setText("");
        }
        else if (bAux.getText().equals("sen(x)")||
                bAux.getText().equals("cos(x)")|| bAux.getText().equals("tan(x)")||
                bAux.getText().equals("log(x)")){
            operacion = bAux.getText();
            n1 = Double.parseDouble(tResultado.getText());
            String op = operacion2();
            textRegistro.appendText(bAux.getText().substring(0, operacion.length() - 3)+tResultado.getText()+")="+Double.parseDouble(op)*100/100.0+"\n");
            tResultado.setText(op);
        }
        else if (bAux.getText().equals("x^2")){
            operacion = bAux.getText();
            n1 = Double.parseDouble(tResultado.getText());
            String op = operacion2();
            textRegistro.appendText(tResultado.getText()+"^2="+op+"\n");
            tResultado.setText(op);
        }
        else if (bAux.getText().equals("=")){
            String op = operacion();
            textRegistro.appendText(n1+operacion+tResultado.getText()+"="+Double.parseDouble(op)*100/100.0+"\n");
            tResultado.setText(op);
        }
        else {
            tResultado.appendText(bAux.getText());
        }


    }

    private String operacion() {
        if (operacion.equals("+"))
            return String.valueOf(n1+Double.parseDouble(tResultado.getText()));
        else if (operacion.equals("-"))
            return String.valueOf(n1-Double.parseDouble(tResultado.getText()));
        else if (operacion.equals("x"))
            return String.valueOf(n1*Double.parseDouble(tResultado.getText()));
        else if (operacion.equals("%"))
            return String.valueOf(n1%Double.parseDouble(tResultado.getText()));
        else if (operacion.equals("/"))
            return String.valueOf(n1/Double.parseDouble(tResultado.getText()));


        return "";
    }
    private String operacion2() {

        if (operacion.equals("sen(x)")) {
            return String.valueOf(Math.sin(n1));
        }
        else if (operacion.equals("cos(x)")){
            return String.valueOf(Math.cos(n1));
        }
        else if (operacion.equals("tan(x)")){
            return String.valueOf(Math.tan(n1));
        }
        else if (operacion.equals("log(x)")){
            return String.valueOf(Math.log(n1));
        }
        else if (operacion.equals("x^2")){
            return String.valueOf(Math.pow(n1,2));
        }
        return "";
    }
}