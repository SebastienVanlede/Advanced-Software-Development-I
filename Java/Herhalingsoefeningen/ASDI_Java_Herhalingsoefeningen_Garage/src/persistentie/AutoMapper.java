package persistentie;

import java.util.List;

import domein.Auto;
import java.io.File;

public class AutoMapper {

    private File naamBestand;

    public AutoMapper(File naamBestand) {
        this.naamBestand = naamBestand;
    }
    
    public List<Auto> geefAutos() {
    	return new ObjectStreamManipulaties().leesObject(naamBestand);
    }

}
