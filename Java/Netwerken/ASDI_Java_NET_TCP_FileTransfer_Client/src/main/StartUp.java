package main;

import domein.FileTransfer;
import gui.FileTransferFrameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartUp extends Application {

    @Override
    public void start(Stage stage) {
        String host = getParameters().getRaw().isEmpty()?"localhost":getParameters().getRaw().get(0);
        FileTransfer fileTransfer =new FileTransfer(host);
        Scene scene = new Scene(new FileTransferFrameController(fileTransfer));
        stage.setTitle("File Transfer Client");
        stage.setScene(scene);
        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown((WindowEvent t) -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });
        stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, e -> {
            fileTransfer.closeConnection();
            System.exit(0);});
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(StartUp.class, args);
    }
}
