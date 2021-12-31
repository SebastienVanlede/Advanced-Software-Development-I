package startUp;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartUp extends Application {


    @Override
    public void start(Stage stage) {
        stage.setTitle("Chat Gui Body");
        stage.setScene(new Scene(new GridPane()));
        // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown((WindowEvent t) -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });
        stage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, e -> System.exit(0));
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(StartUp.class, args);
    }
}