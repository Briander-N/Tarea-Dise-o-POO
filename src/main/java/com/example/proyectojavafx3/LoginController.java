package com.example.proyectojavafx3;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ComboBox<String> cbRol;

    @FXML
    public void initialize() {

        cbRol.getItems().addAll(
                "Administrador",
                "Empleado"
        );
    }

    @FXML
    private void ingresar() {

        String usuario = txtUsuario.getText();
        String password = txtPassword.getText();
        String rol = cbRol.getValue();

        if (usuario.isEmpty() || password.isEmpty() || rol == null) {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(null);
            alerta.setContentText("Complete todos los campos");
            alerta.showAndWait();

            return;
        }

        if (usuario.equals("admin") &&
                password.equals("1234") &&
                rol.equals("Administrador")) {

            abrirDashboard();

        } else {

            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Login");
            alerta.setHeaderText(null);
            alerta.setContentText("Credenciales incorrectas");
            alerta.showAndWait();

        }
    }
    private void abrirDashboard() {

        try {

            FXMLLoader loader =
                    new FXMLLoader(
                            getClass().getResource("dashboard.fxml")
                    );

            Scene scene = new Scene(loader.load());

            scene.getStylesheets().add(
                    getClass()
                            .getResource("dashboard.css")
                            .toExternalForm()
            );

            Stage stage = new Stage();

            stage.setTitle("Dashboard");
            stage.setScene(scene);

            stage.setWidth(1200);
            stage.setHeight(700);
            stage.setResizable(false);

            stage.show();

            Stage actual =
                    (Stage) txtUsuario.getScene().getWindow();

            actual.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}