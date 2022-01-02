package domein;

public class DomeinController {

    private Garage garage;

    public DomeinController() {
       garage = new Garage("autoObjecten.dat", "onderhoudObjecten.dat");
    } 

    public String autoMap_ToString() {
        return garage.autoMap_ToString();
    }

    public String autoOnderhoudMap_ToString() {
        return garage.autoOnderhoudMap_ToString(); 
    }

    public String overzicht_ToString() {
        return garage.overzicht_ToString();
    }
    
}
