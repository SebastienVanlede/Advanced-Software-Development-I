package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import domein.Client;
import gui.ChatFrame;

public class StartUpClient extends Application {

    @Override
    public void start(Stage stage) {
        String host = getParameters().getRaw().isEmpty()?"localhost":getParameters().getRaw().get(0);
        Client client = new Client(host);
        Scene scene = new Scene(new ChatFrame(client));
        client.start();
        stage.setTitle("Chat Client");
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
        Application.launch(StartUpClient.class, args);
    }
}
