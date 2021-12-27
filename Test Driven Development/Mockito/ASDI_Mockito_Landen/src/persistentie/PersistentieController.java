package persistentie;

import domein.Land;

public class PersistentieController {
    private LandMapper landMapper;

    public Land findLand(String code) {
        loadLandMapper();
        return landMapper.findLand(code);
    }

    public int findOppervlakteAlleLanden() {
        loadLandMapper();
        return landMapper.findOppervlakteAlleLanden();
    }

    private void loadLandMapper() {
        if (landMapper == null)
            landMapper = new LandMapper();
    }
}
