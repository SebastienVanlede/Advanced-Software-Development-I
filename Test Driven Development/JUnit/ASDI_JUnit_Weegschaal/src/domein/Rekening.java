package domein;

public class Rekening {

    private String rekeningnummer;

    public Rekening(String rekeningnummer) {
        setRekeningnummer(rekeningnummer);
    }

    private void setRekeningnummer(String rekeningnummer) {
        if (rekeningnummer == null || rekeningnummer.isBlank()) {
            throw new IllegalArgumentException("rekeningnummer niet ingevuld");
        }

        if (!rekeningnummer.matches("\\d{3}-\\d{7}-\\d{2}")) {
            throw new IllegalArgumentException("rekeningnummer in verkeerd formaat");
        }
        String[] token = rekeningnummer.split("-");

        if (token[0].matches("[0]{3}") || token[1].matches("[0]{7}")) {
            throw new IllegalArgumentException(
                    "eerste en/of tweede deel van rekeningnummer mogen niet enkel uit nullen bestaan");
        }

        long eerste10Cijfers = Long.parseLong(token[0] + token[1]);
        long laatste2Cijfers = Long.parseLong(token[2]);

        if (eerste10Cijfers % 97L != laatste2Cijfers)
            throw new IllegalArgumentException("verkeerde cijfers in rekeningnummer");

        this.rekeningnummer = rekeningnummer;
    }
}