package gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class AccountTextViewPanelController 
       extends HBox implements PropertyChangeListener  {
    @FXML
    private Label lblBalance;
    @FXML
    private TextField txtBalance;

 // domainController.addPropertyChangeListener(this);

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        double balance = (Double) evt.getNewValue();
        txtBalance.setText(moneyFormat.format(balance));
    }
    
  // NumberFormat for US dollars
    private NumberFormat moneyFormat = NumberFormat.getCurrencyInstance(Locale.US);

    public AccountTextViewPanelController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountTextViewPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}