package com.mycompany.tareaunidad2;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FormularioPrincipalController {

    @FXML private Button btnReservas;
    @FXML private Button btnSalir;

    @FXML
    private void handlebtnReservas(ActionEvent event) throws Exception {
        Stage stage = (Stage) btnReservas.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        stage.setScene(new Scene(root));
        stage.setTitle("Hotel - Reservas");
        stage.show();
    }

    @FXML
    private void handlebtnSalir(ActionEvent event) {
        Platform.exit();
        System.exit(0);
    }
}
