
public class KlientBudżetowy extends Klient{

	public KlientBudżetowy(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	public boolean czyAkceptujesz(Pokój pokój, Ankieta ankieta) {
		if (pokój.dajCenę() <= ankieta.dajMaksCenę()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return super.toString() + "budżetowa.";
	}
}
