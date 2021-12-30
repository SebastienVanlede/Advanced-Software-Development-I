package gui;

import domein.DomeinController;
import domein.ObservableInteger;
import domein.Observer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ObservableIntegerFrameController extends VBox implements Observer {

    @FXML
    private Label lblValue;

    @FXML
    private Label lblDoubleValue;

    @FXML
    private Button btnUp;

    @FXML
    private Button btnDown;

    private DomeinController domeinController;

    public ObservableIntegerFrameController(DomeinController domeinController) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ObservableIntegerFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    private void up(ActionEvent event) {
        domeinController.up();
    }

    @FXML
    private void down(ActionEvent event) {
        domeinController.down();
    }

    @Override
    public void update(int value) {
        lblValue.setText(String.format("Value: %d", value));
        lblDoubleValue.setText(String.format("DoubleValue: %d", domeinController.getDoubleValue()));
    }
}
