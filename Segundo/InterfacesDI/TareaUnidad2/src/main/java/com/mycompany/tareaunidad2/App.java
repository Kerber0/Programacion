package com.mycompany.tareaunidad2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(App.class.getResource("FormularioPrincipal.fxml"));
        Scene scene = new Scene(loader.load());
        stage.setTitle("Hotel - Principal");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) { launch(); }
}
