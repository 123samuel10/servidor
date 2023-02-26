module com.example.demo_clienteservidor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires java.desktop;


    opens com.example.demo_clienteservidor to javafx.fxml;
    exports com.example.demo_clienteservidor;

}