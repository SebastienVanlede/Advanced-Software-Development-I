package persistentie;

import domein.Land;

public class PersistentieController {

   private LandMapper landMapper;
   private ContinentMapper continentMapper;

    public Land findLand(String code) {
        loadLandMapper();
        return landMapper.findLand(code);
    }

    public int findOppervlakteAlleLanden() {
        loadLandMapper();
        return landMapper.findOppervlakteAlleLanden();
    }

    public long findAantalBewoners(String continent) {
        loadContinentMapper();
        return continentMapper.findAantalBewoners(continent);
    }

    public long findGeboortecijfers(String continent) {
        loadContinentMapper();
        return continentMapper.findGeboortecijfers(continent);
    }

    public long findSterfteCijfer(String continent) {
        loadContinentMapper();
        return continentMapper.findSterfteCijfer(continent);
    }

    private void loadLandMapper() {
        if (landMapper == null) {
            landMapper = new LandMapper();
        }
    }

    private void loadContinentMapper() {
        if (continentMapper == null) {
            continentMapper = new ContinentMapper();
        }
    }

}
