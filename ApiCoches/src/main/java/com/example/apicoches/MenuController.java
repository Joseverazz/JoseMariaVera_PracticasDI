package com.example.apicoches;

import com.example.apicoches.utils.Coche;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private Label labelCoche, labelCoche1, labelCoche2;

    @FXML
    private ChoiceBox<String> choiceMarca, choiceMarca1,choiceMarca2;

    @FXML
    private ChoiceBox<Coche> choiceModelo, choiceModelo1, choiceModelo2;

    @FXML
    private Button btnComparar, btnSeleccionar;

    @FXML
    private ImageView imagen, imagen1, imagen2;

    private ObservableList<String> listaMarca, listaMarca1, listaMarca2;
    private ObservableList<Coche> listaModelo, listaModelo1, listaModelo2;

    private boolean seleccionado1, seleccionado2;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarElementos();
        acciones();
        lecturaJsonMarca();
    }

    private void lecturaJsonMarca() {
        String url = "https://private-anon-1c2173d7ab-carsapi1.apiary-mock.com/manufacturers";
        try {
            InputStream inputStream = new URL(url).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String linea = "";
            StringBuffer stringBuffer = new StringBuffer();

            while ((linea=bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }

            JSONArray arrayCoches = new JSONArray(stringBuffer.toString());

            for (int i = 0; i < arrayCoches.length(); i++) {
                JSONObject marca = arrayCoches.getJSONObject(i);
                listaMarca.add(marca.getString("name"));
                listaMarca1.add(marca.getString("name"));
                listaMarca2.add(marca.getString("name"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void lecturaJsonModelo(ObservableList<Coche> lista, String marca) {
        String url = "https://private-anon-1c2173d7ab-carsapi1.apiary-mock.com/cars";
        try {
            lista.clear();
            InputStream inputStream = new URL(url).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String linea = "";
            StringBuffer stringBuffer = new StringBuffer();

            while ((linea=bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }

            JSONArray arrayCoches = new JSONArray(stringBuffer.toString());

            for (int i = 0; i < arrayCoches.length(); i++) {
                JSONObject coche = arrayCoches.getJSONObject(i);
                if (coche.getString("make").equals(marca)){
                    String marcas = coche.getString("make");
                    String modelo = coche.getString("model");
                    String imagen = coche.getString("img_url");
                    int caballos = coche.getInt("horsepower");
                    double precio = coche. getInt("price");
                    Coche cocheActual = new Coche(marcas, modelo,imagen, caballos, precio);
                    lista.add(cocheActual);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void acciones() {
        choiceMarca.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                choiceModelo.setDisable(false);
                lecturaJsonModelo(listaModelo,t1);
                labelCoche.setText(t1.toUpperCase());
            }
        });
        choiceMarca1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                choiceModelo1.setDisable(false);
                lecturaJsonModelo(listaModelo1,t1);
                labelCoche1.setText(t1.toUpperCase());
            }
        });
        choiceMarca2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                choiceModelo2.setDisable(false);
                lecturaJsonModelo(listaModelo2,t1);
                labelCoche2.setText(t1.toUpperCase());
            }
        });
        choiceModelo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Coche>() {
            @Override
            public void changed(ObservableValue<? extends Coche> observableValue, Coche coche, Coche t1) {
                if (t1 != null){
                    imagen.setImage(new Image(t1.getImagen()));
                    labelCoche.setText(t1.getMarca().toUpperCase()+" "+t1.getModelo());
                    btnSeleccionar.setDisable(false);
                }
                else{
                    imagen.setImage(new Image("http://ts4.mm.bing.net/th?id=OIP.M9e8c70aff2632ee58fc97806bf5b83ffH0&pid=15.1"));
                    btnSeleccionar.setDisable(true);
                }
            }
        });
        choiceModelo1.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Coche>() {
            @Override
            public void changed(ObservableValue<? extends Coche> observableValue, Coche coche, Coche t1) {
                if (t1 != null){
                    imagen1.setImage(new Image(t1.getImagen()));
                    labelCoche1.setText(t1.getMarca().toUpperCase()+" "+t1.getModelo());
                    seleccionado1 = true;
                    if(seleccionado2){
                        btnComparar.setDisable(false);
                    }
                }
                else{
                    imagen1.setImage(new Image("http://ts4.mm.bing.net/th?id=OIP.M9e8c70aff2632ee58fc97806bf5b83ffH0&pid=15.1"));
                    seleccionado1 = false;
                    btnComparar.setDisable(true);
                }
            }
        });
        choiceModelo2.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Coche>() {
            @Override
            public void changed(ObservableValue<? extends Coche> observableValue, Coche coche, Coche t1) {
                if (t1 != null){
                    imagen2.setImage(new Image(t1.getImagen()));
                    labelCoche2.setText(t1.getMarca().toUpperCase()+" "+t1.getModelo());
                    seleccionado2 = true;
                    if(seleccionado1){
                        btnComparar.setDisable(false);
                    }
                }
                else{
                    imagen2.setImage(new Image("http://ts4.mm.bing.net/th?id=OIP.M9e8c70aff2632ee58fc97806bf5b83ffH0&pid=15.1"));
                    seleccionado2 = false;
                    btnComparar.setDisable(true);
                }
            }
        });
        btnSeleccionar.setOnAction(new EventHandler<ActionEvent>() {
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
                    detalleController.comunicarCoche(choiceModelo.getSelectionModel().getSelectedItem());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Scene scene = new Scene(root, 600, 400);
                stage.setScene(scene);
                stage.setTitle("Detalles");
                stage.show();
            }
        });
    }


    private void asociarElementos() {
        choiceMarca.setItems(listaMarca);
        choiceMarca1.setItems(listaMarca1);
        choiceMarca2.setItems(listaMarca2);
        choiceModelo.setItems(listaModelo);
        choiceModelo1.setItems(listaModelo1);
        choiceModelo2.setItems(listaModelo2);

    }

    private void instancias() {
        listaMarca = FXCollections.observableArrayList();
        listaMarca1 = FXCollections.observableArrayList();
        listaMarca2 = FXCollections.observableArrayList();
        listaModelo = FXCollections.observableArrayList();
        listaModelo1 = FXCollections.observableArrayList();
        listaModelo2 = FXCollections.observableArrayList();
    }
}