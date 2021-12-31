package main;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.SecureRandom;

 /*
  * Server to process ping requests over UDP.
  */
 public class PingServer
 {
    private static final double LOSS_RATE = 0.3;
    private static final int AVERAGE_DELAY = 100;  // milliseconds

    public static void main(String[] args) throws Exception
    {  int port = 5555; // default value
       // Get command line argument.
       if (args.length == 1) {
          port   = Integer.parseInt(args[0]);
       }
       System.out.println("Ping reply server started: uses port " + port);
       // Create random number generator for use in simulating 
       // packet loss and network delay.
       SecureRandom random = new SecureRandom();

       // Create a datagram socket for receiving and sending UDP packets
       // through the port specified on the command line.
       DatagramSocket socket = new DatagramSocket(port);
       // Create a datagram packet to hold incomming UDP packet.
       DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
       // Processing loop.
       while (true) {
          // Block until the host receives a UDP packet.
          socket.receive(request);
          
          // Print the recieved data.
          printData(request);

          // Decide whether to reply, or simulate packet loss.
          if (random.nextDouble() < LOSS_RATE) {
             System.out.println("   Reply not sent.");
             continue; 
          }

          // Simulate network delay.
          Thread.sleep(random.nextInt(AVERAGE_DELAY) * 2  );

          // Send reply.
          InetAddress clientHost = request.getAddress();
          int clientPort = request.getPort();
          byte[] buf = request.getData();
          DatagramPacket reply = new DatagramPacket(buf, buf.length, clientHost, clientPort);
          socket.send(reply);

          System.out.println("   Reply sent.");
       }
    } //einde main

    /* 
     * Print ping data to the standard output stream.
     */
    private static void printData(DatagramPacket request) throws Exception
    {
       // Obtain references to the packet's array of bytes.
       byte[] buf = request.getData();
       String line = new String(buf, request.getOffset(), request.getLength());
       // Print host address and data received from it.
       System.out.printf( "Received from %s : %s%n", request.getAddress().getHostAddress(), line );
    } //einde printData
 } // einde PingServer