package domein;

import java.time.LocalDate;
import java.util.Objects;

public class Reductiebon {

	private String reductiebonCode;
    private int percentage;
    private LocalDate einddatum;
	
    public Reductiebon(String reductiebonCode, int percentage, LocalDate einddatum)
    {
    	setReductiebonCode(reductiebonCode);	
    	setPercentage(percentage);
    	setEinddatum(einddatum);
    }
    
    public java.lang.String getReductiebonCode() {
		return reductiebonCode;
	}
	
	public void setReductiebonCode(java.lang.String reductiebonCode) {
		this.reductiebonCode = reductiebonCode;
	}
	
	public int getPercentage() {
		return percentage;
	}
	
	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}
	
	public java.time.LocalDate getEinddatum() {
		return einddatum;
	}
	
	public void setEinddatum(java.time.LocalDate einddatum) {
		this.einddatum = einddatum;
	}
    
	@Override
    public String toString()
    {
        return String.format("%s, korting %d%%, geldig t.e.m. %3$te %3$tb %3$tY",
        		reductiebonCode, percentage, einddatum);
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((reductiebonCode == null) ? 0 : reductiebonCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Reductiebon other = (Reductiebon) obj;
        if (!Objects.equals(this.reductiebonCode, other.reductiebonCode))
        {
            return false;
        }
        return true;
	}

}
