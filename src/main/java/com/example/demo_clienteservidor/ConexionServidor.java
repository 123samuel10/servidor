package com.example.demo_clienteservidor;

import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Logger;

public class ConexionServidor implements ActionListener {
    private Logger log = Logger.getLogger(String.valueOf(ConexionServidor.class));
    private Socket socket;
    private TextField tfMensaje;
    private String usuario;
    private DataOutputStream salidaDatos;


    public ConexionServidor(Socket socket, TextField text, String nombre) {
        this.socket = socket;
        this.tfMensaje = text;
        this.usuario = nombre;
        try {
            this.salidaDatos = new DataOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            // log.error("Error al crear el stream de salida : " + ex.getMessage());
        } catch (NullPointerException ex) {
            // log.error("El socket no se creo correctamente. ");
        }
    }

    public ConexionServidor() {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            salidaDatos.writeUTF(usuario + ": " + tfMensaje.getText() );
            tfMensaje.setText("");
        } catch (IOException ex) {
            //log.error("Error al intentar enviar un mensaje: " + ex.getMessage());
        }
    }

    public String getUsuario() {
        return usuario;
    }
}
