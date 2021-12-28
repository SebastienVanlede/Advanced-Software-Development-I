package domein;

public class Held {

	private Wapen wapen;

	public void valAan() {
		wapen.valAan();
	}

	/**
	 * 
	 * @param wapen
	 */
	public void setWapen(Wapen wapen) {
		this.wapen = wapen;
	}

}