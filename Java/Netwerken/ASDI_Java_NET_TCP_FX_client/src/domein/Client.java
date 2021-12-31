package domein;

import java.io.EOFException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends domeinCommon.ChatBody {

    private final String chatServer;

    public Client(String host) {
        super("CLIENT", "SERVER>>> TERMINATE");
        chatServer = host;
    }

    @Override
    public void run() {
        runClient();
    }

    private void runClient() {
        try {
            makeConnection();
            getStreams();
            processConnection();            
        } catch (EOFException eofException) {
            updateDisplay("\nServer terminated connection");
        } catch (IOException ex) {
            updateDisplay(ex.getMessage());
        } finally {
            closeConnection();
        }
    }

    private void makeConnection() throws IOException {
        socket = new Socket(InetAddress.getByName(chatServer), 12345);
        updateDisplay("Connected to: " + socket.getInetAddress().getHostName());
    }

}
