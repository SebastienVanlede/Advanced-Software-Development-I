 package gui;

import domain.Account;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AccountControllerPanelController extends HBox {

    private final Account domainController;
    
    @FXML
    private Label lblAmount;
    @FXML
    private TextField txtAmount;
    @FXML
    private Button btnDeposit;
    @FXML
    private Button btnWithdraw;   

    public AccountControllerPanelController(Account domainController) {
        this.domainController = domainController;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountControllerPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    private void deposit(ActionEvent event) {
        try {
            domainController.deposit(Double.parseDouble(txtAmount.getText()));
        } catch (NumberFormatException exception) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid amount").showAndWait();
        } catch (IllegalArgumentException exception) {
            new Alert(Alert.AlertType.ERROR, exception.getMessage()).showAndWait();
        }
    }

    @FXML
    private void withdraw(ActionEvent event) {
        try {
            domainController.withdraw(Double.parseDouble(txtAmount.getText()));
        } catch (NumberFormatException exception) {
            new Alert(Alert.AlertType.ERROR, "Please enter a valid amount").showAndWait();
        } catch (IllegalArgumentException exception) {
            new Alert(Alert.AlertType.ERROR, exception.getMessage()).showAndWait();
        }
    }
}

