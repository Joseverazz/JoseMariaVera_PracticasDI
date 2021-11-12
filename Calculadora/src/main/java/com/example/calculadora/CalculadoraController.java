package com.example.calculadora;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.ResourceBundle;

public class CalculadoraController implements Initializable,EventHandler<ActionEvent> {
    @FXML
    TextField tResultado;
    @FXML
    GridPane gridBtn,gridBtn2;
    @FXML
    CheckBox chRegistro, chCientifica;


    String operacion = "           ";

    /*
    @FXML
    private Button bCero,bUno,bDos,bTres, bCuatro, bCinco,bSeis,bSiete,bOcho,bNueve,
            bBorrar,bMasMenos, bPorcentaje,bMultiplicacion,bSuma,bResta,bDivision,bIgual;

    private final Button[] bNumeros= {bCero,bUno,bDos,bTres, bCuatro, bCinco,bSeis,bSiete,bOcho,bNueve};
*/
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();

        acciones();
    }

    private void personalizarBotones() {
    }

    private void acciones() {
        ObservableList<Node> listaBotones = gridBtn.getChildren();
        ObservableList<Node> listaBoton = gridBtn2.getChildren();

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
        }
        else if (bAux.getText().equals("+/-")) {
            if (tResultado.getText().charAt(0) == '-')
                tResultado.setText(tResultado.getText().substring(1));
            else
                tResultado.setText("-"+tResultado.getText());
        }
        else if(bAux.getText().equals("+")|| bAux.getText().equals("-")||
                bAux.getText().equals("x")|| bAux.getText().equals("/")||
                bAux.getText().equals("%")) {
            operacion = tResultado.getText()+bAux.getText();
            tResultado.setText("");
        }
        else if (bAux.getText().equals("=")){
            tResultado.setText(operacion());
        }
        else {
            tResultado.appendText(bAux.getText());
        }


    }

    private String operacion() {
        int resultado = Integer.parseInt(operacion.substring(0,operacion.length()-1));
                //Integer.parseInt(tResultado.getText());
        if (operacion.charAt(operacion.length()-1) == '+')
            return String.valueOf(resultado+Integer.parseInt(tResultado.getText()));
        else if (operacion.charAt(operacion.length()-1) == '-')
            return String.valueOf(resultado-Integer.parseInt(tResultado.getText()));
        else if (operacion.charAt(operacion.length()-1) == 'x')
            return String.valueOf(resultado*Integer.parseInt(tResultado.getText()));
        else if (operacion.charAt(operacion.length()-1) == '%')
            return String.valueOf(resultado%Integer.parseInt(tResultado.getText()));
        else if (operacion.charAt(operacion.length()-1) == '/')
            return String.valueOf(resultado/Integer.parseInt(tResultado.getText()));

        return "";
    }
}