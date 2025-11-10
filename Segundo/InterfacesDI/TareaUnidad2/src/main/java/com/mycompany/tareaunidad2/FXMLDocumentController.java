package com.mycompany.tareaunidad2;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Region;   
import javafx.stage.Stage;

import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class FXMLDocumentController {

    @FXML private TextField txtDni;
    @FXML private TextField txtNombre;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtLocalidad;
    @FXML private TextField txtProvincia;

    @FXML private DatePicker dpLlegada;
    @FXML private DatePicker dpSalida;
    @FXML private TextField txtPersonas;
    @FXML private ComboBox<String> comboBox;

    @FXML private CheckBox checkBox;
    @FXML private Label labelAviso;

    @FXML private RadioButton rbAd;    
    @FXML private RadioButton rbMp;    
    @FXML private RadioButton rbPc;   
    @FXML private RadioButton rbOtro;  

    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @FXML
    private void initialize() {
        comboBox.getItems().setAll(
            "Doble de uso individual",
            "Doble",
            "Junior Suite",
            "Suite"
        );
        labelAviso.setVisible(false);
        rbAd.setSelected(true);
    }

    @FXML
    private void handleCheckBox() {
        labelAviso.setVisible(checkBox.isSelected());
    }

    @FXML
    private void handleAceptar() {
        if (dpLlegada.getValue() == null || dpSalida.getValue() == null) {
            showError("Fechas incompletas", "Debes seleccionar fecha de llegada y salida.");
            return;
        }
        if (comboBox.getValue() == null) {
            showError("Tipo de habitación", "Debes seleccionar un tipo de habitación.");
            return;
        }
        String personasTxt = Optional.ofNullable(txtPersonas.getText()).orElse("").trim();
        if (personasTxt.isEmpty() || !personasTxt.matches("\\d+")) {
            showError("Número de personas", "Introduce un número válido de personas.");
            return;
        }

        String regimen = getRegimenSeleccionado();
        String fumador = checkBox.isSelected() ? "Sí" : "No";

        StringBuilder sb = new StringBuilder();
        sb.append("— DATOS PERSONALES —").append("\n")
          .append("DNI: ").append(nz(txtDni.getText())).append("\n")
          .append("Nombre: ").append(nz(txtNombre.getText())).append("\n")
          .append("Dirección: ").append(nz(txtDireccion.getText())).append("\n")
          .append("Localidad: ").append(nz(txtLocalidad.getText())).append("\n")
          .append("Provincia: ").append(nz(txtProvincia.getText())).append("\n\n")

          .append("— DATOS DE LA RESERVA —").append("\n")
          .append("Llegada: ").append(dpLlegada.getValue().format(fmt)).append("\n")
          .append("Salida: ").append(dpSalida.getValue().format(fmt)).append("\n")
          .append("Personas: ").append(personasTxt).append("\n")
          .append("Tipo de habitación: ").append(comboBox.getValue()).append("\n")
          .append("Fumador: ").append(fumador).append("\n")
          .append("Régimen: ").append(regimen);

        if (checkBox.isSelected()) {
            sb.append("\n\n")
              .append("AVISO: En virtud de la ley de sanidad se informa a los clientes de que ")
              .append("solo podrán fumar en las habitaciones reservadas para tal fin.");
        }

        Alert a = new Alert(Alert.AlertType.INFORMATION);
        a.setTitle("Confirmación de reserva");
        a.setHeaderText("La reserva se ha procesado");
        a.setContentText(sb.toString());
        a.getDialogPane().setMinHeight(Region.USE_PREF_SIZE); // <-- ya compila
        a.showAndWait();
    }

    @FXML
    private void handleCancelar() {
        Stage stage = (Stage) labelAviso.getScene().getWindow();
        stage.close();
    }

    private String getRegimenSeleccionado() {
        if (rbAd.isSelected()) return "Alojamiento y desayuno";
        if (rbMp.isSelected()) return "Media pensión";
        if (rbPc.isSelected()) return "Pensión completa";
        if (rbOtro.isSelected()) return "Otro";
        return "No especificado";
    }

    private String nz(String s) {
        return s == null ? "" : s.trim();
    }

    private void showError(String titulo, String msg) {
        Alert e = new Alert(Alert.AlertType.ERROR);
        e.setTitle("Faltan datos");
        e.setHeaderText(titulo);
        e.setContentText(msg);
        e.showAndWait();
    }
}
