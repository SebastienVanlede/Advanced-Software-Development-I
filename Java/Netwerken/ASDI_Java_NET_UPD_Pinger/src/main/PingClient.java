package main;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PingClient {
    private InetAddress host ;
    private String hostName = "localhost"; //default
    private int portnr = 5555;  //default
    private final int PINGAANTAL = 10;
    private final int TOKEN_TIMESTAMP = 2; //positie in packet
    private final int MAX_WAIT_TIME = 1000;
    private long min = 999999, max = 0, somRTT = 0;
    private int aangekomen = 0;

    public static void main(String[] args) {
        new PingClient().run(args);
    }

    public void run(String args[])  {
//        try {
            if (args.length>0) {
                hostName =args[0];
            }
            if (args.length ==2){
                portnr = Integer.parseInt(args[1]);
            }
 //TODO           
          //maak netwerkconnectie


//TODO
          // verstuur PINGAANTAL keer een bericht met huidig tijdstip
          int pingNr=1;
          
          
          // data voor bericht:
                SimpleDateFormat timeNow = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
                String timedStr = timeNow.format(new Date(System.currentTimeMillis()));
                String message = String.format("Ping #%d %s (%s)", pingNr, System.currentTimeMillis(), timedStr );
//TODO
                // verpak bericht, verstuur en wacht op antwoord print de ontvangenData
                // update de teller
            

               
               //System.out.printf("min: %d, max: %d, gem: %d, packets loss: %.0f%%%n", min, max, somRTT/PINGAANTAL
               //                                                                         ,(PINGAANTAL-aangekomen)/(double)PINGAANTAL*100);
         //} //end-try
           //catch (
                
    }

    private void printData(DatagramPacket request) {
 //haal de info uit het ontvangen packet, toon op de console
 //TODO       


        
        //System.out.printf("%s  Received from %s (RTT=%dms)%n", response,  request.getAddress().getHostAddress(), rtt);
        //updateRTTs(rtt);  
    }

    private void updateRTTs(long rtt) {
//bereken  min, max, somRTT (voor gemiddelde
//TODO

    }
}