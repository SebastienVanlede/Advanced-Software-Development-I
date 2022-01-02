package clients;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Formatter;

public class ClientAanbieder {

    public static void main(String[] args) {
        new ClientAanbieder().run();
    }

    private void run() {
        System.out.println("Client Aanbieder stuurt een aanbieding");

        //  Maak een TCP verbinding met localhost op poort 23400
        //       Stuur een regel (= auto in aanbieding) "1DEF256", "Opel", "Combo"
        //     Beeindig de client
        try (Socket socket = new Socket(InetAddress.getLocalHost(), 23400)) {
            Formatter sockOutput = new Formatter(socket.getOutputStream());
            sockOutput.format("%s %s %s%n", "1DEF256", "Opel", "Combo");
            sockOutput.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

    }

}
