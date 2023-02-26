package com.example.demo_clienteservidor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Interfaz {


    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    private Button btnEnviar;

    @FXML
    private TextArea mostrar;

    // private Logger log = Logger.getLogger(String.valueOf(Interfaz.class));


    @FXML
    private TextField escribirCliente;
    @FXML
    private TextField escribirPuerto;
    @FXML
    private TextField escribirHost;


    ArrayList<Persona>personas=new ArrayList<>();
    @FXML
    void btn(ActionEvent event) {
        String nombre = escribirCliente.getText();
        int puerto = Integer.parseInt(escribirPuerto.getText());
        String host = escribirHost.getText();


        System.out.println("USUARIO: " + nombre + " PUERTO: " + puerto + " HOST: " + host);
        ClienteChat clienteChat=new ClienteChat(nombre,puerto,host);
        System.out.println(clienteChat);


    }
    @FXML
    void cambiarPg(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("cliente.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Stage stage=(Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
    }

    public ArrayList<Persona> getPersonas() {
        return personas;
    }
}