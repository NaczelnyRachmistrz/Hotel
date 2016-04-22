
public abstract class Recepcjonista {
	private String imię;
	private String nazwisko;
	public Recepcjonista(String imię, String nazwisko) {
		this.imię = imię;
		this.nazwisko = nazwisko;
	}
	
	public abstract Pokój zaproponujPokój(Pokój [] pokoje);
	public String dajImię() {
		return imię;
	}
	public String dajNazwisko() {
		return nazwisko;
	}
	public String toString() {
		return imię + " " + nazwisko + ", ";
	}
	
}
