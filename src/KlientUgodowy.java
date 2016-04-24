
public class KlientUgodowy extends Klient {
	
	public KlientUgodowy(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	public boolean czyAkceptujesz(Pokój pokój, Ankieta ankieta) {
		return true;
	}
	
	public String toString() {
		return super.toString() + "ugodowa.";
	}
}
