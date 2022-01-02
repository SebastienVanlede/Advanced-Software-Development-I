package domein;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Onderhoud implements Serializable  {
	private static final long serialVersionUID = 1L;
    private LocalDate begindatum;
    private LocalDate einddatum;
    private String nummerplaat;
    public Onderhoud(LocalDate begindatum, LocalDate einddatum, String nummerplaat) {
        this.begindatum = begindatum;
        this.einddatum = einddatum;
        this.nummerplaat = nummerplaat;
    }

    public LocalDate getBegindatum() {
        return begindatum;
    }

    public void setBegindatum(LocalDate begindatum) {
        this.begindatum = begindatum;
    }

    public LocalDate getEinddatum() {
        return einddatum;
    }

    public void setEinddatum(LocalDate einddatum) {
        this.einddatum = einddatum;
    }

    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    @Override
    public String toString() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-uuuu");
        return String.format("nummerplaat %s van %s t.e.m. %s",
                nummerplaat,
                begindatum.format(format),
                einddatum.format(format));
    }

}
