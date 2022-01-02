package persistentie;

import java.util.List;

import domein.Auto;
import domein.Onderhoud;
import java.io.File;

public class PersistentieController {

    private final File auto;
    private final File onderhoud;

    public PersistentieController(File auto, File onderhoud) {
        this.auto = auto;
        this.onderhoud = onderhoud;
    }

    public List<Auto> geefAutos() {
        return new AutoMapper(auto).geefAutos();
    }

    public List<Onderhoud> geefOnderhoudVanAutos() {
        return new OnderhoudMapper(onderhoud).
                geefOnderhoudVanAutos();
    }

}
