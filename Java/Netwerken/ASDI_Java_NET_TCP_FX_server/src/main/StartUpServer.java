package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import domein.Server;
import gui.ChatFrame;

public class StartUpServer extends Application {

    @Override
    public void start(Stage stage) {
        Server server = new Server();
        Scene scene = new Scene(new ChatFrame(server));
        server.start();
        stage.setTitle("Chat Server");
        stage.setScene(scene);
        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown((WindowEvent t) -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });
        stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, e -> System.exit(0));
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(StartUpServer.class, args);
    }
}