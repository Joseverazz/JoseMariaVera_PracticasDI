package com.example.josemariavera;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import com.example.josemariavera.utils.Pedido;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class PedidosController implements Initializable, EventHandler<ActionEvent> {
    @FXML
    Button btnActivar, btnPedido;
    @FXML
    TextField nombre, apellido, direccion, telefono, usuario, contrasena;
    @FXML
    CheckBox chQueso, chCebolla, chJamon, chChampinones, chSalsa, chSalchichas;
    @FXML
    TextArea textPedidos;
    @FXML
    Label labelPrecio;
    @FXML
    HBox panel;

    List<Pedido> pedidos = new ArrayList<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        acciones();
    }

    private void acciones() {
        btnActivar.setOnAction(this);
        btnPedido.setOnAction(this);
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnActivar) {
            if (usuario.getText().equals("Usuario1") && contrasena.getText().equals("12345"))
                {
                    panel.setDisable(false);
                }
            }

            if (actionEvent.getSource() == btnPedido) {
                if (!nombre.getText().isEmpty() && !apellido.getText().isEmpty() &&
                        !direccion.getText().isEmpty() && !telefono.getText().isEmpty())
                {
                    int nIngredientes = 0;

                    if (chQueso.isSelected()) {
                        nIngredientes++;
                    }
                    if (chSalsa.isSelected()) {
                        nIngredientes++;
                    }
                    if (chSalchichas.isSelected()) {
                        nIngredientes++;
                    }
                    if (chCebolla.isSelected()) {
                        nIngredientes++;
                    }
                    if (chJamon.isSelected()) {
                        nIngredientes++;
                    }
                    if (chChampinones.isSelected()) {
                        nIngredientes++;
                    }


                    pedidos.add(new Pedido(nombre.getText(), apellido.getText(),
                            direccion.getText(), Integer.parseInt(telefono.getText()), nIngredientes));

                    textPedidos.appendText(nombre.getText() + "-" + telefono.getText() + "\n");
                    int precio = Integer.parseInt(labelPrecio.getText().substring(18))+nIngredientes*2;
                    labelPrecio.setText("Precio acumulado: "+precio);
                }
            }
        }
}