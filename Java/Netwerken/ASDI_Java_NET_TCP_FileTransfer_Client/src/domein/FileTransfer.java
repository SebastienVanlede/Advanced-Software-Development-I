package domein;

import java.io.IOException;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class FileTransfer {

    //Attributen netwerkverbinding/streams
    //
    private Socket socket;
    private Scanner sockInput;
    private Formatter sockOutput;
    //

    public FileTransfer(String host) {
        try {
            //Maak verbinding met server, init attributen
            //
            socket = new Socket(host, 44444);
            sockInput = new Scanner(socket.getInputStream());
            sockOutput = new Formatter(socket.getOutputStream());
            //
        } catch (IOException ex) {
            System.out.println("Probleem " + ex.getMessage());
        }
    }

    public String readFile(String fileNaam) {
        //verzoek server om bestand  'fileNaam' door te sturen
        //lees het bestand in als de server het doorstuurt
        //
        sockOutput.format("%s%n", "READ");
        sockOutput.format("%s%n", fileNaam);
        sockOutput.flush();
        String reactie = sockInput.nextLine();
        if (reactie.equals("FOUND")) {
            String line;
            StringBuilder fileContent = new StringBuilder();
            while (!(line = sockInput.nextLine()).equals("*E*O*F*")) {
                fileContent.append(line).append(System.lineSeparator());
            }
            return fileContent.toString();
        }
        //
        return "BESTAND NIET GEVONDEN";
    }

    public void updateFile(String fileContents, String fileNaam) {
        //meld de server dat je het gewijzigde bestand gaat doorsturen
        //geef de eventueel gewijzigde bestandsnaam mee door
        //bij onveranderde bestandsnaam zal de server het originele bestand overschrijven
        //stuur het bestand door naar de server
        sockOutput.format("%s%n%s%n", "REWRITE", fileNaam);
        sockOutput.flush();
        sockOutput.format("%s%n", fileContents);
        sockOutput.format("%s%n", "*E*O*F*");
        sockOutput.flush();

    }

    public void closeConnection() {
        try {
            //
            socket.close();
            //
        } catch (IOException ex) {
            System.out.println("Probleem " + ex.getMessage());
        }
    }

    //De laatste regel moet eindigen met de systeem einde regel.
    //Enkel \n of \r is niet goed.
    //De laatste regel moet eindigen met de systeem einde regel.
    //Enkel \n of \r is niet goed.
    public String fixEOL(String text) {
        if (!text.endsWith(System.lineSeparator())) {
            int count = 0;
            int lastChar = text.length() - 1;
            if (lastChar >= 0 && (text.charAt(lastChar) == '\n' ||
                    text.charAt(lastChar) == '\r')) {
                count++;
            }
            if (lastChar > 0 && (text.charAt(lastChar - 1) == '\r')) {
                count++;
            }
            if (count > 0) {
                text = text.substring(0, text.length() - count);
            }
            return text + System.lineSeparator();
        }
        return text;
    }

}
