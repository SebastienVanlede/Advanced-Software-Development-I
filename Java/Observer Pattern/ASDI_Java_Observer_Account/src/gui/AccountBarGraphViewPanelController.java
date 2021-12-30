package gui;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class AccountBarGraphViewPanelController extends Pane implements PropertyChangeListener{

    private double balance;

    public AccountBarGraphViewPanelController() {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("AccountBarGraphViewPanel.fxml"));
        loader.setRoot(this);
        loader.setController(this);
        try {
            loader.load();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        this.balance = (Double) evt.getNewValue();
        draw();
    }
    
    
    private void reset(Canvas canvas, Color color) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(color);
        gc.fillRect(1, 1, canvas.getWidth(), canvas.getHeight());

    }

    private void draw() {

        Group root = new Group();
        Scene s = new Scene(root, 300, 300, Color.BLACK);
        final Canvas canvas = new Canvas(250, 250);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        reset(canvas, Color.BEIGE);

        int barLength = (int) ((balance / 10000.0) * 200);
        if (balance >= 0.0) {
            gc.setFill(Color.BLACK);
            gc.fillRect(105, 15, barLength, 20);
        } // if balance is negative, draw graph in red 
        else {
            gc.setFill(Color.RED);
            gc.fillRect(105 + barLength, 15, -barLength, 20);
        }

        // draw vertical and horizontal axes
        gc.setFill(Color.BLACK);
        gc.strokeLine(5, 25, 205, 25);
        gc.strokeLine(105, 5, 105, 45);

        // draw graph labels
        gc.setFont(new Font("SansSerif", 10));
        gc.fillText("-$5,000", 5, 10);
        gc.fillText("$0", 110, 10);
        gc.fillText("+$5,000", 166, 10);
        getChildren().add(canvas);
    }


}

