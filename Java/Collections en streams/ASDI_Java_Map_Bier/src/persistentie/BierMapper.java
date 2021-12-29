package persistentie;

import domein.Bier;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BierMapper {

    public List<Bier> inlezenBieren(String naamBestand) {
        List<Bier> bieren = new ArrayList<>();
        String naam, soort, brouwerij;
        double alcoholgehalte, beoordeling;

        try (Scanner scanner = new Scanner(new File(naamBestand))) {
            while (scanner.hasNext()) {
                naam = scanner.next();
                soort = scanner.next();
                alcoholgehalte = scanner.nextDouble();
                beoordeling = scanner.nextDouble();
                brouwerij = scanner.nextLine().trim();
                bieren.add(new Bier(naam, soort, alcoholgehalte, beoordeling, brouwerij));
            }
        } catch (IOException ioe) {
            Logger.getLogger(BierMapper.class.getName()).log(Level.SEVERE, null, ioe);
        }
        return bieren;

    }

//    public List<Bier> inlezenBieren(String naamBestand) {
//        List<Bier> bieren = new ArrayList<>();
//
//        try (Stream<String> stream = Files.lines(Paths.get(naamBestand))) {
//            stream.forEach(line -> {
//                Scanner scanner = new Scanner(line);
//                bieren.add(new Bier(scanner.next(), scanner.next(), scanner.nextDouble(), scanner.nextDouble(), scanner.nextLine().trim()));
//            });
//        } catch (IOException ioe) {
//            Logger.getLogger(BierMapper.class.getName()).log(Level.SEVERE, null, ioe);
//        }
//
//        return bieren;
//
//    }
}
