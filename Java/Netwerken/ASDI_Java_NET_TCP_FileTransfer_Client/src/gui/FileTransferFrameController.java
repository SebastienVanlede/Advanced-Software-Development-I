package gui;

import domein.FileTransfer;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class FileTransferFrameController extends BorderPane {

    @FXML
    private TextField txtFileNaam;
    @FXML
    private Button btnSaveBack;
    @FXML
    private TextArea txaArea;

    private final FileTransfer fileTransfer;

    public FileTransferFrameController(FileTransfer fileTransfer) {
        this.fileTransfer = fileTransfer;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FileTransferFrame.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @FXML
    private void actionTxtFileNaam(ActionEvent event) {
        txaArea.setText(fileTransfer.readFile(txtFileNaam.getText()));
    }

    @FXML
    private void btnSaveBack(ActionEvent event) {
        fileTransfer.updateFile(txaArea.getText(), txtFileNaam.getText());
    }


}
