package com.example.t_repaso;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<Event>{

    @FXML
    Button botonUno,botonDos,botonTres;

    DropShadow dropShadow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        acciones();
    }

    private void instancias() {
        dropShadow = new DropShadow();
    }

    private void acciones(){
        botonUno.addEventHandler(ActionEvent.ACTION,this);
        botonDos.addEventHandler(ActionEvent.ACTION,this);
        botonTres.setOnAction(new ManejoPulsaciones());
        //botonUno.setOnMouseEntered(new ManejoRaton());
        botonUno.addEventHandler(MouseEvent.MOUSE_ENTERED,this);
        botonUno.setOnMouseExited(new ManejoRaton());
        botonDos.setOnMouseEntered(new ManejoRaton());
        botonDos.setOnMouseExited(new ManejoRaton());
        botonTres.setOnMouseEntered(new ManejoRaton());
        botonTres.setOnMouseExited(new ManejoRaton());

    }

    @Override
    public void handle(Event event) {
        if (event.getEventType() == ActionEvent.ACTION) {
            if(event.getSource() == botonUno)
                System.out.println("Pulsado Boton 1");
            else {
                System.out.println("Pulsado Boton 2 o 3");
            }
        }
        else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
            ((Button)(event.getSource())).setEffect(null);
        }
        else{
            ((Button)(event.getSource())).setEffect(dropShadow);
        }
    }

    class ManejoPulsaciones implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent actionEvent) {
            if(actionEvent.getSource() == botonUno)
                System.out.println("Pulsado Boton 1");
            else {
                System.out.println("Pulsado Boton 2 o 3");
            }
        }
    }

    class ManejoRaton implements EventHandler<MouseEvent>{

        @Override
        public void handle(MouseEvent mouseEvent) {
            if (mouseEvent.getEventType() == MouseEvent.MOUSE_EXITED) {
                ((Button)(mouseEvent.getSource())).setEffect(null);
            }
            else{
                ((Button)(mouseEvent.getSource())).setEffect(dropShadow);
            }
        }
    }
}