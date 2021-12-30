module OOPIII_MVC_observerPattern_javaFx {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.base;
	requires javafx.fxml;
	requires java.desktop;
	opens gui to javafx.graphics, javafx.fxml, javafx.base, javafx.controls;
	opens main to javafx.graphics, javafx.fxml; 
}

