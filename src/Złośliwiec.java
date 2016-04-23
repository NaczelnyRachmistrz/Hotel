
public class Złośliwiec extends Recepcjonista{
	
	public Złośliwiec(String imię, String nazwisko) {
		super(imię, nazwisko);
	}

	public Pokój zaproponujPokój(Pokój [] pokój, Ankieta ankieta) {
		Pokój wybranyPokój = null;
		int min = 6, pom;
		for (Pokój x: pokój) {
			if (wybranyPokój == null) {
				wybranyPokój = x;
				min = ankieta.spełnionePozycje(x);
			} else {
				pom = ankieta.spełnionePozycje(x);
				if (pom < min) {
					min = pom;
					wybranyPokój = x;
				} else {
					if (pom == min) {
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
		return super.toString() + "złośliwa.";
	}
}
