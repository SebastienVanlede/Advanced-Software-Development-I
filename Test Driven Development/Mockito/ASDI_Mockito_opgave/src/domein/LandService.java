package domein;

import persistentie.PersistentieController;

public class LandService {

    //REFACTORING
    private PersistentieController persistentieController;

	public LandService() {
        this(new PersistentieController());
    }

    public LandService(PersistentieController persistentieController) {
        this.persistentieController = persistentieController;
    }

    public LandStatistiek geefLandStatistiek(String code) {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("code mag niet leeg zijn");
        }

        Land land = persistentieController.findLand(code);
        if (land == null) {
            return null;
        }

        int oppervlakteAlleLanden = persistentieController.findOppervlakteAlleLanden();
        double verhouding = (double) (land.getOppervlakte())
                / oppervlakteAlleLanden;
        return new LandStatistiek(code, verhouding);
    }
}
