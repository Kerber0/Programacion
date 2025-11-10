module com.mycompany.tareaunidad2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.tareaunidad2 to javafx.fxml;
    exports com.mycompany.tareaunidad2;
}
