package persistentie;

import domein.Bier;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class BierMapper {

    public List<Bier> leesBieren(File besnaam) {
        List<Bier> bieren = new ArrayList<>();
        try (Stream<String> stream = Files.lines(besnaam.toPath())) {
            stream.forEach(regel -> {
                Scanner scanner = new Scanner(regel);
                String bierNaam = scanner.next();
                scanner.next();
                double alcohol = scanner.nextDouble();
                bieren.add(new Bier(bierNaam, alcohol));
            });
        } catch (IOException ex) {
            Logger.getLogger(BierMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bieren;
    }

}
