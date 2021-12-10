package com.example.listas;
import com.example.listas.utils.Pelicula;
import com.example.listas.utils.Persona;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ResourceBundle;

public class ListasController implements Initializable {
    @FXML
    private ChoiceBox choice;

    @FXML
    private ComboBox combo;

    @FXML
    private Button btnComprobar, btnDetalle;

    @FXML
    private ListView listView;

    @FXML
    private Label labelCombo, labelChoice;

    @FXML
    private ImageView imagenView;

    private ObservableList<Persona> listaCombo;

    private ObservableList<Persona> listaChoice;

    private ObservableList<Pelicula> listaPeliculas;

    private Task tareaJson;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        instancias();
        iniciarListas();
        asociarElementos();
        acciones();
        lecturaJson();
    }

    private void lecturaJson() {
        tareaJson = new Task() {
            @Override
            protected Object call() throws Exception {
                String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=4ef66e12cddbb8fe9d4fd03ac9632f6e&language=en-US&page=1";
                try {
                    InputStream inputStream = new URL(url).openStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                    //String respuesta = bufferedReader.readLine();
                    //JSONObject jsonGeneral = new JSONObject(respuesta);
                    // arrayResultados = jsonGeneral.getJSONArray("results");
                    //JSONObject objetoPelicula = arrayResultados.getJSONObject(12);
                    String linea = "";
                    StringBuffer stringBuffer = new StringBuffer();

                    while ((linea=bufferedReader.readLine())!=null){
                        stringBuffer.append(linea);
                    }

                    JSONObject jsonObject = new JSONObject(stringBuffer.toString());
                    JSONArray arrayPeliculas = jsonObject.getJSONArray("results");

                    for (int i = 0; i < arrayPeliculas.length(); i++) {
                        JSONObject pelicula = arrayPeliculas.getJSONObject(i);
                        int id = pelicula.getInt("id");
                        String titulo = pelicula.getString("original_title");
                        String descripcion = pelicula.getString("overview");
                        String imagen = "https://image.tmdb.org/t/p/w500"+pelicula.getString("poster_path");
                        Double popularidad = pelicula.getDouble("popularity");
                        Pelicula peliculaActual = new Pelicula(id,titulo,descripcion,imagen,popularidad);
                        listaPeliculas.add(peliculaActual);
                    }

                    /*
                    Pelicula pelicula;
                    for (int i = 0; i < arrayResultados.length(); i++)
                    {
                        JSONObject objetoPelicula = arrayResultados.getJSONObject(i);
                        int id = objetoPelicula.getInt("id");
                        String titulo = objetoPelicula.getString("original_title");
                        String descripcion = objetoPelicula.getString("overview");
                        String imagen = "https://image.tmdb.org/t/p/w500"+objetoPelicula.getString("poster_path");
                        Double popularidad = objetoPelicula.getDouble("popularity");
                        pelicula = new Pelicula(id,titulo,descripcion,imagen,popularidad);
                        listaPeliculas.add(pelicula);
                    }
                    */
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };


    }

    public void metodoContestar(String mensaje){
        System.out.println(mensaje);
    }

    private void acciones() {
        btnComprobar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Thread(tareaJson).start();
            }
        });
        btnDetalle.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (listView.getSelectionModel().getSelectedIndex()<0){
                    System.out.println("No hay nada");
                }
                else{
                    Stage stage = new Stage();
                    FXMLLoader loader = null;
                    Parent root = null;
                    DetalleController detalleController = null;
                    try {
                        loader = new FXMLLoader(getClass().getResource("detalle-view.fxml"));
                        root = loader.load();
                        detalleController = loader.getController();
                        detalleController.comunicarPelicula((Pelicula) listView.getSelectionModel().getSelectedItem(),
                                ListasController.this);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(root, 400, 400);
                    stage.setScene(scene);
                    stage.setTitle("Detalles");
                    stage.show();
                }
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                Pelicula peliculaSeleccionada = (Pelicula) t1;
                imagenView.setImage(new Image(peliculaSeleccionada.getImagen()));
            }
        });

        combo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue<? extends Persona> observableValue, Persona persona, Persona t1) {
                labelCombo.setText(t1.getNombre()+" "+t1.getApellidos());
            }
        });

        choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Persona>() {
            @Override
            public void changed(ObservableValue<? extends Persona> observableValue, Persona persona, Persona t1) {
                labelChoice.setText(t1.getNombre()+" "+t1.getApellidos());
            }
        });
    }

    private void iniciarListas() {
        listaCombo.addAll(new Persona("Miguel", "Hernandez", "123456789", 23, 1234567),
                new Persona("Facundo", "Collado", "123456789", 21, 1234567),
                new Persona("Raul", "Rodriguez", "123456789", 25, 1234567));
        listaChoice.addAll(new Persona("Miguel", "Hernandez", "123456789", 23, 1234567),
                new Persona("Facundo", "Collado", "123456789", 21, 1234567),
                new Persona("Raul", "Rodriguez", "123456789", 25, 1234567));
    }

    private void asociarElementos() {
        choice.setItems(listaChoice);
        combo.setItems(listaCombo);
        listView.setItems(listaPeliculas);
    }

    private void instancias() {
        listaCombo = FXCollections.observableArrayList();
        listaChoice = FXCollections.observableArrayList();
        listaPeliculas = FXCollections.observableArrayList();
    }
}