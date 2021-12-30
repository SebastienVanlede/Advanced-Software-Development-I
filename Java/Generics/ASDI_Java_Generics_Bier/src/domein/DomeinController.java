package domein;

import persistentie.PersistentieController;

import java.io.File;
import java.util.List;

public class DomeinController {
    
    private PersistentieController pc = new PersistentieController();
    
    public void persisteerBierGegevensAlsObject(String tekstFileNaam, String objectFileNaam){    
    	//TODO zie stap3
        List<Bier> listBier = pc.leesBieren(new File(tekstFileNaam));
        MyListIterable<Bier> myListIterable = new MyListIterable<>();
        listBier.forEach(myListIterable::insertAtBack);
        pc.persisteerObject(myListIterable, new File(objectFileNaam));
        
    }
    
}
