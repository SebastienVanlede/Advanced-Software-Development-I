package main;
import domain.Account;
import gui.AccountFrameController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class StartUp extends Application {

    @Override
    public void start(Stage stage) {
        Account domainController = new Account("Account 1", 1000.00);
        Scene scene = new Scene(new AccountFrameController(domainController));
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.setTitle("Account");
        
         // The stage will not get smaller than its preferred (initial) size.
        stage.setOnShown((WindowEvent t) -> {
            stage.setMinWidth(stage.getWidth());
            stage.setMinHeight(stage.getHeight());
        });
        stage.show();
    }

    public static void main(String... args) {
        Application.launch(StartUp.class, args);
    }
}
