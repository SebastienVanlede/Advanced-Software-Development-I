module ASDI_NET_TCP_FX_server {
	requires javafx.base;
	requires javafx.graphics;
	requires ASDI_NET_TCP_FX_common;
	opens main to javafx.graphics, javafx.fxml, OOPIII_NET_TCP_FX_common;
}