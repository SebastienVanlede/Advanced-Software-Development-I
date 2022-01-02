package domein;

import java.io.Serializable;
import java.util.Objects;

public class Auto implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nummerplaat;
    private String merk;
    private String model;

    public Auto(String nummerplaat, String merk, String model) {
        this.nummerplaat = nummerplaat;
        this.merk = merk;
        this.model = model;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNummerplaat() {
        return nummerplaat;
    }

    public void setNummerplaat(String nummerplaat) {
        this.nummerplaat = nummerplaat;
    }

    @Override
    public String toString() {
        return String.format("nummerplaat= %s, merk= %s, model = %s",
                nummerplaat, merk, model);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.nummerplaat);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Auto other = (Auto) obj;
        return Objects.equals(this.nummerplaat, other.nummerplaat);
    }
}
