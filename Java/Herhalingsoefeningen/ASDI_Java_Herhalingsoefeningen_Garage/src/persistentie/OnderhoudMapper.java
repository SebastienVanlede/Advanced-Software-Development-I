package persistentie;

import domein.Onderhoud;

import java.io.File;
import java.util.List;

public class OnderhoudMapper {

    private File naamBestand;

    public OnderhoudMapper(File naamBestand) {
        this.naamBestand = naamBestand;
    }

    public List<Onderhoud> geefOnderhoudVanAutos() {
        return new ObjectStreamManipulaties().leesObjecten(naamBestand);
    }

}
