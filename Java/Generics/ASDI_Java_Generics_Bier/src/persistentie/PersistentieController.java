package persistentie;

import domein.Bier;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersistentieController {

   private BierMapper bierMapper;

    public List<Bier> leesBieren(File besnaam) {
        if (bierMapper == null) {
            bierMapper = new BierMapper();
        }
        return bierMapper.leesBieren(besnaam);
    }
     
    //TODO stap 3, maak de methode generiek
    public <E extends Serializable> void persisteerObject(Object object, File besnaam) {
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(besnaam.toPath()))) {
            out.writeObject(object);
        } catch (IOException ex) {
            Logger.getLogger(BierMapper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
