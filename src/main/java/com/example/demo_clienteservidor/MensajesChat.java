package com.example.demo_clienteservidor;

public class MensajesChat  {
    private String mensaje;

    public MensajesChat(){
    }

    public String getMensaje(){
        return mensaje;
    }

    public void setMensaje(String mensaje){
        this.mensaje = mensaje;
        // Indica que el mensaje ha cambiado
        this.setChanged();
        // Notifica a los observadores que el mensaje ha cambiado y se lo pasa
        // (Internamente notifyObservers llama al metodo update del observador)
        this.notifyObservers(this.getMensaje());
    }

    private void notifyObservers(String mensaje) {
    }

    private void setChanged() {
    }

    public void addObserver(ConexionCliente conexionCliente) {
    }
}
