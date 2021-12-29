package domein;

import java.util.ArrayList;
import java.util.Collection;

public class Sporter implements Comparable<Sporter> {

	private int lidNr;
	private String naam, voornaam, email;
	private Collection<Reductiebon> reductiebonLijst;

	public Sporter(int lidNr, String naam, String voornaam, String email) {
		setLidNr(lidNr);
		setNaam(naam);
		setVoornaam(voornaam);
		setEmail(email);
		reductiebonLijst = new ArrayList<>();
	}

	public Collection<Reductiebon> getReductiebonLijst() {
		return reductiebonLijst;
	}

	public int getLidNr() {
		return lidNr;
	}

	public void setLidNr(int lidNr) {
		this.lidNr = lidNr;
	}

	public java.lang.String getNaam() {
		return naam;
	}

	public void setNaam(java.lang.String naam) {
		this.naam = naam;
	}

	public java.lang.String getVoornaam() {
		return voornaam;
	}

	public void setVoornaam(java.lang.String voornaam) {
		this.voornaam = voornaam;
	}

	public java.lang.String getEmail() {
		return email;
	}

	public void setEmail(java.lang.String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return String.format("sporter %d, %s %s heeft %d reductiebon(nen)", lidNr, naam, voornaam,
				reductiebonLijst.size());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + lidNr;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Sporter other = (Sporter) obj;
		if (this.lidNr != other.lidNr) {
			return false;
		}
		return true;
	}

	public void voegReductieBonToe(Reductiebon reductieBon) {
		reductiebonLijst.add(reductieBon);
	}

	@Override
	public int compareTo(Sporter sporter) {
		throw new UnsupportedOperationException();
	}


}
