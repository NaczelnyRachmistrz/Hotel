
public class KlientWidokowy extends Klient{

	public KlientWidokowy(String imię, String nazwisko) {
		super(imię, nazwisko);
	}
	public boolean czyAkceptujesz(Pokój pokój, Ankieta ankieta) {
		if (pokój.dajKierunekOkna() == ankieta.dajKierunekOkna()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return super.toString() + "widokowa.";
	}
}
