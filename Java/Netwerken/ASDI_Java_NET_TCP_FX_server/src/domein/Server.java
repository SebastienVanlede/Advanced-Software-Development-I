package domein;

import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;

public class Server extends domeinCommon.ChatBody {

    private ServerSocket server;
    private int numberOfConnections = 1;

    public Server() {
        super("SERVER", "CLIENT>>> TERMINATE");
    }

    @Override
    public void run() {
        runServer();
    }

    private void runServer() {
        try {
            server = new ServerSocket(12345, 100);
            while (true) {
                try {
                    makeConnection();
                    getStreams();
                    processConnection();
                } catch (EOFException eofException) {
                    updateDisplay("\nClient terminated connection");
                } catch (IOException ex) {
                    updateDisplay(ex.getMessage());
                } finally {
                    closeConnection();
                    ++numberOfConnections;
                }
            }
        } catch (IOException ex) {
            updateDisplay("\nNo ServerSocket : " + ex.getMessage());
        }
    }

    private void makeConnection() throws IOException {
        updateDisplay("Waiting for connection\n");
        socket = server.accept();
        updateDisplay("Connection " + numberOfConnections + " received from: "
                + socket.getInetAddress().getHostName());
    }

}
