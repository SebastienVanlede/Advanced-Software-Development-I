package gui;

import domain.Account;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.GridPane;

public class AccountFrameController extends GridPane {

    private final Account domainController;
    private final AccountControllerPanelController accountControllerPanel;
    private final AccountTextViewPanelController accountTextViewPanel;
    private final AccountBarGraphViewPanelController accountBarGraphViewPanel;

    public AccountFrameController(Account domainController) {
        this.domainController = domainController;

        accountControllerPanel = new AccountControllerPanelController(domainController);
        accountTextViewPanel = new AccountTextViewPanelController();
        accountBarGraphViewPanel = new AccountBarGraphViewPanelController();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

        domainController.addPropertyChangeListener(accountTextViewPanel);
        domainController.addPropertyChangeListener(accountBarGraphViewPanel);

        this.add(accountControllerPanel, 0, 0);
        this.add(accountTextViewPanel, 0, 1);
        this.add(accountBarGraphViewPanel, 0, 2);

    }
}

