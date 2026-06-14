module com.example.tareadisenio {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tareadisenio to javafx.fxml;
    exports com.example.tareadisenio;
}