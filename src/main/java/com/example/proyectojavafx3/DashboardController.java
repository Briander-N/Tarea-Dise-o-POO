package com.example.proyectojavafx3;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class DashboardController {

    @FXML
    private TextField txtCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtStock;

    @FXML
    private ComboBox<String> cbCategoria;

    @FXML
    private ComboBox<String> cbEstado;

    @FXML
    private TableView<Producto> tablaProductos;

    @FXML
    private TableColumn<Producto, String> colCodigo;

    @FXML
    private TableColumn<Producto, String> colNombre;

    @FXML
    private TableColumn<Producto, String> colCategoria;

    @FXML
    private TableColumn<Producto, Double> colPrecio;

    @FXML
    private TableColumn<Producto, Integer> colStock;

    @FXML
    private TableColumn<Producto, String> colEstado;

    private final ObservableList<Producto> lista =
            FXCollections.observableArrayList();

    private Producto seleccionado;

    @FXML
    public void initialize() {

        cbCategoria.getItems().addAll(
                "Tecnología",
                "Ropa",
                "Hogar",
                "Alimentos"
        );

        cbEstado.getItems().addAll(
                "Activo",
                "Inactivo"
        );

        colCodigo.setCellValueFactory(
                new PropertyValueFactory<>("codigo"));

        colNombre.setCellValueFactory(
                new PropertyValueFactory<>("nombre"));

        colCategoria.setCellValueFactory(
                new PropertyValueFactory<>("categoria"));

        colPrecio.setCellValueFactory(
                new PropertyValueFactory<>("precio"));

        colStock.setCellValueFactory(
                new PropertyValueFactory<>("stock"));

        colEstado.setCellValueFactory(
                new PropertyValueFactory<>("estado"));

        tablaProductos.setItems(lista);

        tablaProductos.getSelectionModel()
                .selectedItemProperty()
                .addListener((obs, oldValue, nuevo) -> {

                    if (nuevo != null) {

                        seleccionado = nuevo;

                        txtCodigo.setText(nuevo.getCodigo());
                        txtNombre.setText(nuevo.getNombre());
                        txtPrecio.setText(
                                String.valueOf(nuevo.getPrecio()));

                        txtStock.setText(
                                String.valueOf(nuevo.getStock()));

                        cbCategoria.setValue(
                                nuevo.getCategoria());

                        cbEstado.setValue(
                                nuevo.getEstado());
                    }
                });
    }

    @FXML
    private void guardar() {

        try {

            Producto p = new Producto(
                    txtCodigo.getText(),
                    txtNombre.getText(),
                    cbCategoria.getValue(),
                    Double.parseDouble(txtPrecio.getText()),
                    Integer.parseInt(txtStock.getText()),
                    cbEstado.getValue()
            );

            lista.add(p);

            limpiar();

        } catch (Exception e) {

            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(
                    "Ingrese datos válidos"
            );
            alert.showAndWait();
        }
    }
    @FXML
    private void actualizar() {

        if (seleccionado != null) {

            seleccionado.setCodigo(txtCodigo.getText());
            seleccionado.setNombre(txtNombre.getText());
            seleccionado.setCategoria(cbCategoria.getValue());

            seleccionado.setPrecio(
                    Double.parseDouble(txtPrecio.getText()));

            seleccionado.setStock(
                    Integer.parseInt(txtStock.getText()));

            seleccionado.setEstado(cbEstado.getValue());

            tablaProductos.refresh();
        }
    }

    @FXML
    private void eliminar() {

        if (seleccionado != null) {

            Alert confirmacion =
                    new Alert(Alert.AlertType.CONFIRMATION);

            confirmacion.setTitle("Eliminar");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText(
                    "¿Desea eliminar este producto?"
            );

            if (confirmacion.showAndWait().get()
                    == ButtonType.OK) {

                lista.remove(seleccionado);
                limpiar();
            }
        }
    }

    @FXML
    private void limpiar() {

        txtCodigo.clear();
        txtNombre.clear();
        txtPrecio.clear();
        txtStock.clear();

        cbCategoria.setValue(null);
        cbEstado.setValue(null);

        seleccionado = null;
    }

    @FXML
    private void nuevo() {

        limpiar();
    }
}