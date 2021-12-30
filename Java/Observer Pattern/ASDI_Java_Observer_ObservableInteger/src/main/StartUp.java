package main;

import domein.DomeinController;
import domein.ObservableInteger;
import gui.ObservableIntegerFrameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartUp extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new ObservableIntegerFrameController(new DomeinController()));

        stage.setScene(scene);
        stage.setTitle("Observable Integer");

        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown(e -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });

        stage.show();
    }

    public static void main(String... args) {
        Application.launch(StartUp.class, args);
    }
}
