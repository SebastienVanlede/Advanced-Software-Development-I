package domein;

import java.util.List;
import java.util.Map;
import persistentie.PersistentieController;

public class BierWinkel {

    private final List<Bier> bieren;
    private PersistentieController pc = new PersistentieController();

    public BierWinkel() {
        bieren = pc.inlezenBieren("bieren.txt");
    }
    
    //TODO type Map aanvullen
    public Map opzettenOverzichtBierPerNaam() {
    	//TODO
    	
    	return null;
    }
    

    //TODO type Map aanvullen
    public Map opzettenOverzichtBierenPerSoort() {
       //TODO
    	
    	return null;
    }

    public Map<String, Long> opzettenAantalBierenPerSoort() {
      //TODO
    	
    	return null;
    }

}
