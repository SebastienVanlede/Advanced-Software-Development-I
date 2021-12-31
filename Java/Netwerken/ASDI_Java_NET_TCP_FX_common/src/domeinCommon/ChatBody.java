package domeinCommon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public abstract class ChatBody extends Thread {
    private ObjectOutputStream output;
    private ObjectInputStream input;
    private String chatMessage;
    private SimpleStringProperty displayArea = new SimpleStringProperty();
    private SimpleBooleanProperty connected = new SimpleBooleanProperty();
    protected Socket socket;
    private final String name;
    private final String STOP;

    public ChatBody( String name, String stop) {
        this.name = name;
        STOP = stop;
    }

    @Override
    public abstract void run();

    public StringProperty displayAreaProperty() {
        return displayArea;
    }

    public BooleanProperty connectedProperty() {
        return connected;
    }

    public void updateDisplay(String mes) {
        displayArea.set(mes);
    }
    
    protected void getStreams() throws IOException {
        output = new ObjectOutputStream(socket.getOutputStream());
        output.flush();
        input = new ObjectInputStream(socket.getInputStream());
        updateDisplay("\nGot I/O streams\n");
    }
    

    private void setConnected(boolean isConnected) {
        connected.set(isConnected);
    }
    
    public void sendMessage(String message) {
        try {
            output.writeObject(name +">>> " + message);
            output.flush();
            updateDisplay("\n"+ name+ ">>> " + message);
        } catch (IOException ioException) {
            updateDisplay("\nError writing object");
        }
    }
 
    protected void processConnection() throws IOException {
        String message = "Connection successful";
        sendMessage(message);
        setConnected(true);
        while (!message.equals(STOP)) {
            try {
                message = (String) input.readObject();
                updateDisplay("\n" + message);
            } catch (ClassNotFoundException ex) {
                updateDisplay("\nUnknown object type received");
            }
        }
    }
    
    protected void closeConnection() {
        updateDisplay("\nTerminating connection\n");
        setConnected(false);
        try {
            if (socket!=null) {
                socket.close();
            }
        } catch (IOException ex) {
            updateDisplay(ex.getMessage());
        }
    }
    
}
