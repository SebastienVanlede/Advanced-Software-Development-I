module ASDI_NET_TCP_FX_common {
	exports gui;
	exports domeinCommon;

	requires javafx.base;
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens gui to javafx.graphics, javafx.fxml;
	opens startUp to javafx.graphics, javafx.fxml;
}