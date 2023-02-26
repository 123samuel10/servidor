package com.example.demo_clienteservidor;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Logger;




public class ClienteChat{
    private int puerto;
    private String host;
    private String nombre;
    private Socket socket;
    @FXML
    private Button click;

    @FXML
    private TextField escribir;

    @FXML
    private TextArea mostrar;


    private Logger log = Logger.getLogger(String.valueOf(ClienteChat.class));


    public ClienteChat(String nombre, int puerto, String host) {
        this.nombre=nombre;
        this.host=host;
        this.puerto=puerto;


        log.info("Quieres conectarte a " + host+"" + " en el puerto " +puerto + " con el nombre de ususario: " +nombre + ".");

        // Se crea el socket para conectar con el Sevidor del Chat
        try {
            socket = new Socket(host,puerto);
        } catch (UnknownHostException ex) {
            //  log.error("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        } catch (IOException ex) {
            // log.error("No se ha podido conectar con el servidor (" + ex.getMessage() + ").");
        }

        // Accion para el boton enviar

        ConexionServidor conexionServidor=new ConexionServidor(socket,escribir,nombre);
        System.out.println(conexionServidor);
        click=new Button();
        click.setText("wsss");

    }




    @FXML
    void btn2(ActionEvent event) throws IOException{
        mostrar.setText(nombre+":"+escribir.getText());
    }



    public ClienteChat() {

    }







    public void recibirMensajesServidor(){
        // Obtiene el flujo de entrada del socket
        DataInputStream entradaDatos = null;
        String mensaje;
        try {
            entradaDatos = new DataInputStream(socket.getInputStream());
        } catch (IOException ex) {
            // log.error("Error al crear el stream de entrada: " + ex.getMessage());
        } catch (NullPointerException ex) {
            // log.error("El socket no se creo correctamente. ");
        }

        // Bucle infinito que recibe mensajes del servidor
        boolean conectado = true;
        while (conectado) {
            try {
                mensaje = entradaDatos.readUTF();
               escribir.setText(mensaje + System.lineSeparator());
                mostrar.setText("hola");
            } catch (IOException ex) {
                //  log.error("Error al leer del stream de entrada: " + ex.getMessage());
                conectado = false;
            } catch (NullPointerException ex) {
                // log.error("El socket no se creo correctamente. ");
                conectado = false;
            }
        }

    }



    public static void main(String[] args) {
        // Carga el archivo de configuracion de log4J
        //PropertyConfigurator.configure("log4j.properties");

        ClienteChat c = new ClienteChat();
        c.recibirMensajesServidor();
    }



}
