package com.example.t_repaso;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable, EventHandler<Event>{

    @FXML
    Button botonUno,botonDos,botonTres;

    @FXML
    TextField textoCentro;

    DropShadow dropShadow;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        personalizarBotones();

        acciones();
    }

    private void personalizarBotones() {
        botonTres.setBackground(null);
        botonTres.setBorder(null);
        botonTres.setText(null);
        botonTres.setGraphic(new ImageView(new Image(HelloApplication.class.getResourceAsStream("playS.png"))));
        botonDos.setBackground(null);
        botonDos.setBorder(null);
        botonDos.setText(null);
        botonDos.setGraphic(new ImageView(new Image(HelloApplication.class.getResourceAsStream("playRed.png"))));

    }

    private void instancias() {
        dropShadow = new DropShadow();
    }

    private void acciones(){
        textoCentro.addEventHandler(KeyEvent.KEY_RELEASED, this);
        textoCentro.addEventHandler(KeyEvent.KEY_PRESSED, this);
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
            if(event.getSource() == botonUno) {
                String textoCapturado = textoCentro.getText();
                System.out.println(textoCapturado);
            }
            else {
                System.out.println("Pulsado Boton 2 o 3");
            }
        }
        else if (event.getEventType() == MouseEvent.MOUSE_EXITED) {
            ((Button)(event.getSource())).setEffect(null);
        }
        else if (event.getEventType() == MouseEvent.MOUSE_ENTERED){
            ((Button)(event.getSource())).setEffect(dropShadow);
        }
        else if (event.getEventType() == KeyEvent.KEY_RELEASED)
        {
            if (((TextField)(event.getSource())).getText().length()>9)
                event.consume();
            else
                System.out.println(((TextField)(event.getSource())).getText());
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

            if (botonDos == mouseEvent.getSource()){
                if (mouseEvent.getEventType() == MouseEvent.MOUSE_ENTERED)
                    ((Button)(mouseEvent.getSource())).setGraphic(new ImageView(new Image(HelloApplication.class.getResourceAsStream("playBlue.png"))));
                else
                    ((Button)(mouseEvent.getSource())).setGraphic(new ImageView(new Image(HelloApplication.class.getResourceAsStream("playRed.png"))));
            }
        }
    }
}