module com.example.proyectojavafx3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.proyectojavafx3 to javafx.fxml;
    exports com.example.proyectojavafx3;
}