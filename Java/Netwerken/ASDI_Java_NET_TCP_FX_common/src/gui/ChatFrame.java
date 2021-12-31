package gui;

import java.io.IOException;

import domeinCommon.ChatBody;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class ChatFrame extends BorderPane {

    @FXML
    private TextField txtChatEntry;
    @FXML
    private TextArea txtChatDisplay;
    private final ChatBody chatBody;

    public ChatFrame(ChatBody chatBody) {
        this.chatBody = chatBody;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("ChatFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
        chatBody.displayAreaProperty().addListener((observableValue, oldValue, newValue) -> 
                Platform.runLater( () -> txtChatDisplay.appendText(newValue) )
        );
        chatBody.connectedProperty().addListener((observableValue, oldValue, newValue) -> 
               Platform.runLater( () -> txtChatEntry.setEditable(newValue) )
        );
    }

    @FXML
    private void txtChatEntryAction(ActionEvent event) {
        chatBody.sendMessage(txtChatEntry.getText());
        txtChatEntry.clear();
    }
}
