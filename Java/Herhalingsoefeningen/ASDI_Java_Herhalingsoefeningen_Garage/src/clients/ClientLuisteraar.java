package clients;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ClientLuisteraar {
    public static void main(String[] args) {
        new ClientLuisteraar().run();
    }

    private void run() {
        System.out.println("Client Luisteraar ontvangt de lijst");
        //TODO  Maak een UDP toegang om een pakket te ontvangen op poort 9999
        try (DatagramSocket datagramSocket = new DatagramSocket(9999)) {
            byte[] buffer = new byte[100];
            DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
            //Wacht op het pakket en toon de ontvangen lijst van auto's af op het scherm
            datagramSocket.receive(datagramPacket);
            System.out.println(new String(datagramPacket.getData(), datagramPacket.getOffset(), datagramPacket.getLength()));
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        //      Beeindig de client


    }

}
