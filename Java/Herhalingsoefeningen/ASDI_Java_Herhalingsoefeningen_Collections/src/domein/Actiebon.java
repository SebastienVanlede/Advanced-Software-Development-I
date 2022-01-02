package domein;

import java.time.LocalDate;

public class Actiebon extends Reductiebon {
	private String beschrijving;

	public Actiebon(String beschrijving, String reductiebonCode, int percentage, LocalDate einddatum) {
		super(reductiebonCode, percentage, einddatum);
	}

	public String getBeschrijving() {
		return beschrijving;
	}

	public void setBeschrijving(String beschrijving) {
		this.beschrijving = beschrijving;
	}
}
