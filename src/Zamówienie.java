
public class Zamówienie {
	private int licznik;
	private Klient klient;
	private Ankieta ankieta;
	public Zamówienie(Klient klient, Ankieta ankieta) {
		this.klient = klient;
		this.ankieta = ankieta;
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
