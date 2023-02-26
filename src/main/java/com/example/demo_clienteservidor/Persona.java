package com.example.demo_clienteservidor;

public class Persona {
    private String usuario;
    private String host;
    private int puerto;

    public Persona(String usuario,String host,int puerto) {
        this.usuario=usuario;
        this.host = host;
        this.puerto=puerto;
    }

    public String getUsuario() {
        return usuario;
    }

    public int getPuerto() {
        return puerto;
    }

    public String getHost() {
        return host;
    }
}
