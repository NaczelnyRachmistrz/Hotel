
public class KlientBudżetowy extends Klient{

	public KlientBudżetowy(String imię, String nazwisko, Ankieta ankieta) {
		super(imię, nazwisko, ankieta);
	}

	public boolean czyAkceptujesz(Pokój pokój) {
		if (pokój.dajCenę() <= this.ankieta.dajMaksCenę()) {
			return true;
		} else {
			return false;
		}
	}
	
	public String toString() {
		return super.toString() + "budżetowa.";
	}
}
