module OOPIII_NET_lab_TCP_FX_FileTransfer_Client_Opgave {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;
	opens gui to javafx.graphics, javafx.fxml;
	opens main to javafx.graphics, javafx.fxml;
}