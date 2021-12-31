package domein;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Formatter;
import java.util.Scanner;

public class FileServer {

    // attributen voor netwerkconnectie en streams
//--
    private Scanner sockInput;
    private Formatter sockOutput;
    private Socket socket;
//--

    public void run() {
        // initialiseer server
        try (ServerSocket serverSocket = new ServerSocket(44444, 10)) {
            System.out.println("Fileserver up");
            // wacht tot een client verbindig maakt
            // verwerk al de verzoeken van een client tot deze afsluit
            // delegeer naar hulpmethode processClient
            // wacht opnieuw op een client, blijft dit doen

            while (true) {
                try {
                    System.out.println("Fileserver waiting...");
                    socket = serverSocket.accept();
                    processClient();

                } catch (IOException ex) {
                    System.out.println("Problemen : " + ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("Problemen met server connectie : " + ex.getMessage());
        }
    }

    private void processClient() {
        // verwerk al de verzoeken van een client volgens het afgesproken protocol
        // tot deze afsluit
        // sluit dan ook de connectie met deze client
        // maak gebruik van de 3 onderstaande hulpmethoden
        try {
            sockInput = new Scanner(socket.getInputStream());
            sockOutput = new Formatter(socket.getOutputStream());

            while (sockInput.hasNextLine()) {
                String actie = sockInput.nextLine();
                switch (actie) {
                    case "READ" -> {
                        File file = new File(sockInput.nextLine());
                        System.out.println("READ" + file.getName());
                        if (file.exists())
                            sendFile(file);
                        else
                            sendNoFile();
                    }
                    case "REWRITE" -> {
                        File file = new File(sockInput.nextLine());
                        System.out.println("REWRITE" + file.getName());
                        readAndSaveUpdateFile(file);

                    }
                }
            }
            socket.close();
        } catch (IOException ex) {
            System.out.println("Problemen met client connectie : " + ex.getMessage());
        }
    }

    private void sendFile(File file) throws IOException {
        sockOutput.format("%s%n", "FOUND");
        sockOutput.flush();
        try (Scanner diskFile = new Scanner(file)) {
            while (diskFile.hasNext()) {
                sockOutput.format("%s%n", diskFile.nextLine());
                sockOutput.flush();
            }
        }
        sockOutput.format("%s%n", "*E*O*F*");
        sockOutput.flush();
    }

    private void sendNoFile() {
        sockOutput.format("%s%n", "NOTFOUND");
        sockOutput.flush();
    }

    private void readAndSaveUpdateFile(File file) throws IOException {
        try (Formatter diskFile = new Formatter(file)) {
            String line;
            while (!(line = sockInput.nextLine()).equals("*E*O*F*")) {
                diskFile.format("%s%n", line);

            }
        }

    }

}
