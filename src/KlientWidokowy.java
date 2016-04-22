
public class KlientWidokowy extends Klient{

	public KlientWidokowy(String imię, String nazwisko, Ankieta ankieta) {
		super(imię, nazwisko, ankieta);
	}
	public boolean czyAkceptujesz(Pokój pokój) {
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
