
public class Zamówienie {
	private int licznik;
	private Ankieta ankieta;
	private Klient klient;
	
	public Zamówienie(Ankieta ankieta, Klient klient) {
		this.ankieta = ankieta;
		this.klient = klient;
	}

	public int dajLicznik() {
		return licznik;
	}

	public Ankieta dajAnkietę() {
		return ankieta;
	}

	public Klient dajKlienta() {
		return klient;
	}
	
	public void zwiększLicznik() {
		licznik++;
	}
}
