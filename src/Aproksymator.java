
public class Aproksymator extends Recepcjonista {

	public Aproksymator(String imię, String nazwisko) {
		super(imię, nazwisko);
	}
	
	public Pokój zaproponujPokój(Pokój [] pokój, Ankieta ankieta) {
		Pokój wybranyPokój = null;
		int maks = 0, pom;
		for (Pokój x: pokój) {
			if (wybranyPokój == null) {
				wybranyPokój = x;
			} else {
				pom = ankieta.spełnionePozycje(x);
				if (pom < maks) {
					maks = pom;
					wybranyPokój = x;
				} else {
					if (pom == maks) {
						if (x.dajCenę() > wybranyPokój.dajCenę()) {
							wybranyPokój = x;
						} else {
							if (x.dajCenę() == wybranyPokój.dajCenę()) {
								wybranyPokój = wybranyPokój.dajNr() > x.dajNr() ? wybranyPokój:x;
							}
						}
					}
				}
			}
		}
		return wybranyPokój;
	}
	
	public String toString() {
		return super.toString() + "aproksymacyjna.";
	}
}
