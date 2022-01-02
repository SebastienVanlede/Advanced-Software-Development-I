package domein;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class KoopjesService extends Thread {
    private List<Auto> koopjes = new ArrayList<>();
    private List<InetAddress> clients = new ArrayList<>();

    public KoopjesService() { // voorlopig een klant op localhost (dit werken we niet verder uit, klanten
        // kunnen zich hier registreren)
        try {
            clients.add(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        //TODO voorzie zowel toegang tot UDP (uitvoer lijst van auto's) als TCP (invoer auto's)
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            try (ServerSocket serverSocket = new ServerSocket(23400, 5)) {
                while (true) {
                    // start lus om telkens de info van een aanbieder te ontvangen
                    System.out.println("wacht op aanbieder");
                    Socket socket = serverSocket.accept();
                    // indien verbinding lees de info
                    Scanner sockInput = new Scanner(socket.getInputStream());
                    koopjes.add(new Auto(sockInput.next(), sockInput.next(), sockInput.next()));
                    System.out.println("aanbieding toegevoegd");
                    // beeindig de TCP verbinding
                    socket.close();
                    // maak pakketje klaar met de lijst van auto's als een string en verstuur naar alle geregistreerde ClientLuisteraars
                    DatagramPacket datagramPacket = new DatagramPacket(koopjes.toString().getBytes(), koopjes.toString().getBytes().length);
                    clients.forEach(clientAddress -> {
                        System.out.println("Stuur datagram naar client");
                        try {
                            datagramPacket.setPort(9999);
                            datagramPacket.setAddress(clientAddress);
                            datagramSocket.send(datagramPacket);
                        } catch (IOException ioe) {
                            ioe.printStackTrace();
                        }
                    });
                }
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        } catch (SocketException se) {
            se.printStackTrace();
        } //einde lus


    }
}
