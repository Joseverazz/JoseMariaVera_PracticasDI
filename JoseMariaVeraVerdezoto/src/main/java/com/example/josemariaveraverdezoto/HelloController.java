package com.example.josemariaveraverdezoto;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private Button btnAleatorio, btnCategoria;

    @FXML
    private ChoiceBox<String> choiceCategoria;

    @FXML
    private ImageView imagenChuck;

    @FXML
    private ListView<String> listChiste;

    ObservableList<String> listaCategorias, listaChistes;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        asociarElementos();
        lecturaJSONcategorias();
        acciones();
    }

    private void acciones() {
        btnAleatorio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                generarChiste("");
            }
        });
        btnCategoria.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (choiceCategoria.getSelectionModel().getSelectedItem() == null){
                    System.out.println("No hay categoria seleccionada");
                }
                else{
                    generarChiste(choiceCategoria.getSelectionModel().getSelectedItem());
                }
            }
        });
    }

    private void generarChiste(String categoria) {
        String url = "https://api.chucknorris.io/jokes/random";
        if (!categoria.equals("")){
            url = url+"?category="+categoria;
        }
        try {
            InputStream inputStream = new URL(url).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String linea = "";
            StringBuffer stringBuffer = new StringBuffer();

            while ((linea=bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }

            JSONObject chiste = new JSONObject(stringBuffer.toString());

            listaChistes.add(chiste.getString("value"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void asociarElementos() {
        choiceCategoria.setItems(listaCategorias);
        listChiste.setItems(listaChistes);
    }

    private void lecturaJSONcategorias() {
        String url = "https://api.chucknorris.io/jokes/categories";
        try {
            InputStream inputStream = new URL(url).openStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String linea = "";
            StringBuffer stringBuffer = new StringBuffer();

            while ((linea=bufferedReader.readLine())!=null){
                stringBuffer.append(linea);
            }

            JSONArray arrayCategorias = new JSONArray(stringBuffer.toString());

            for (int i = 0; i < arrayCategorias.length(); i++) {
                String categoria = arrayCategorias.getString(i);
                listaCategorias.add(categoria);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void instancias() {
        imagenChuck.setImage(new Image("https://api.chucknorris.io/img/chucknorris_logo_coloured_small@2x.png"));
        listaCategorias = FXCollections.observableArrayList();
        listaChistes = FXCollections.observableArrayList();
    }
}