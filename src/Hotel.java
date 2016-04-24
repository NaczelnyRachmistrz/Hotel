import java.util.*;
public class Hotel {
	Pokój [] pokoje;
	Recepcjonista [] recepcjoniści;
	public Hotel(Pokój[] pokoje, Recepcjonista[] recepcjoniści) {
		this.pokoje = pokoje;
		this.recepcjoniści = recepcjoniści;
	}
	
	public Zamówienie przyjmijZamówienie(Klient klient, Ankieta ankieta) {
		return new Zamówienie(klient, ankieta);
	}
	
	private boolean czyZłyPokój(Pokój [] pokój) {
		for (Pokój x : pokój) {
			for (int i = 0; i < pokoje.length; i++) {
				if (x.dajNr() == pokoje[i].dajNr()) {
					break;
				}
				if (i == pokoje.length - 1) {
					return true;
				}
			}
		}
		return false;
	}
	
	private boolean czyZłyRecepcjonista(Recepcjonista [] recepcjonista) {
		for (Recepcjonista x : recepcjonista) {
			for (int i = 0; i < recepcjoniści.length; i++) {
				if (x.dajImię().equals(recepcjoniści[i].dajImię()) && x.dajNazwisko().equals(recepcjoniści[i].dajNazwisko())) {
					break;
				}
				if (i == recepcjoniści.length - 1) {
					return true;
				}
			}
		}
		return false;
	}
	public void akceptuj(Zamówienie [] zamówienie, Pokój [] pokój, 
			Recepcjonista [] recepcjonista)  {
		if (czyZłyPokój(pokój)) {
			System.out.println("Nieprawidłowa lista pokojów!");
			return;
		}
		if (czyZłyRecepcjonista(recepcjonista)) {
			System.out.println("Nieprawidłowa lista recepcjonistów!");
			return;
		}
		ArrayDeque<Zamówienie> zamówienia = new ArrayDeque<Zamówienie>();
		Pokój [] wolnePokoje;
		Pokój proponowanyPokój;
		Zamówienie akt;
		Recepcjonista aktRecep;
		for (int i = 0; i < zamówienie.length; i++) {
			zamówienia.addLast(zamówienie[i]);
		}
		int iter = -1;
		while (!zamówienia.isEmpty()) {
			iter++;
			iter = (iter == recepcjonista.length ? 0:iter);
			proponowanyPokój = null;
			akt = zamówienia.pollFirst();
			aktRecep = recepcjonista[iter];
			System.out.println("Recepcjonista: " + aktRecep.toString());
			System.out.println("Zamówienie: " + akt.dajAnkietę().toString());
			wolnePokoje = Recepcjonista.wolnePokoje(pokoje, akt.dajAnkietę());
			if (wolnePokoje.length == 0) {
				System.out.println("Brak wolnych pokojów w podanym terminie!");
				System.out.println("Klient: " + akt.dajKlienta().toString());
				System.out.println("Do zobaczenia w innym terminie!\n");
				continue;
			}
			proponowanyPokój = aktRecep.zaproponujPokój(wolnePokoje, akt.dajAnkietę());
			if (proponowanyPokój == null) {
				System.out.println("Brak pokoju spełniającego wszystkie wymagania!");
				System.out.println("Klient: " + akt.dajKlienta().toString());
				System.out.println("nie;\n");
				akt.zwiększLicznik();
				if (akt.dajLicznik() < 3) {
					zamówienia.addLast(akt);
				}
			} else {
				System.out.println("Proponowany pokój: " + proponowanyPokój.toString());
				System.out.println("Klient: " + akt.dajKlienta().toString());
				if (akt.dajKlienta().czyAkceptujesz(proponowanyPokój, akt.dajAnkietę())) {
					System.out.println("tak;\n");
					proponowanyPokój.dodajRezerwację(akt.dajAnkietę().dajDatęPrzyjazdu(),
							akt.dajAnkietę().dajDługośćPobytu());
				} else {
					System.out.println("nie;\n");
					akt.zwiększLicznik();
					if (akt.dajLicznik() < 3) {
						zamówienia.addLast(akt);
					}
				}
			}
		}
	}
	
	
	public Pokój[] dajPokoje() {
		return pokoje;
	}

	public Recepcjonista[] dajRecepcjonistów() {
		return recepcjoniści;
	}

	public static void main(String args[]) {
		
		//Testy - deklaracja kilku obiektów każdej klasy
		Recepcjonista [] recepcjonista = new Recepcjonista[5];
		recepcjonista[0] = new Hazardzista("Jan", "Kowalski");
		recepcjonista[1] = new Aproksymator("Jan", "Nowak");
		recepcjonista[2] = new Perfekcjonista("Maria", "Nowak");
		recepcjonista[3] = new Perfekcjonista("Janusz", "Korwin-Mikke");
		recepcjonista[4] = new Złośliwiec("Donald", "Tusk");
		Pokój [] pokój = new Pokój[5];
		pokój[0] = new Pokój(1, 4, 200, Kolor.JASNOZIELONY, StylWystroju.RUSTYKALNY,
				Kierunek.PÓŁNOC, true);
		pokój[1] = new Pokój(2, 6, 300, Kolor.PURPUROWY, StylWystroju.ORIENTALNY,
				Kierunek.POŁUDNIE, false);
		pokój[2] = new Pokój(3, 2, 150, Kolor.SELEDYNOWY, StylWystroju.NOWOCZESNY,
				Kierunek.WSCHÓD, true);
		pokój[3] = new Pokój(4, 2, 120, Kolor.MORSKI, StylWystroju.MORSKI,
				Kierunek.ZACHÓD, true);
		pokój[4] = new Pokój(5, 1, 100, Kolor.JASNOZIELONY, StylWystroju.SECESYJNY,
				Kierunek.POŁUDNIE, false);
		Hotel hotel1 = new Hotel(pokój, recepcjonista);
		Ankieta [] ankieta = new Ankieta[7];
		Klient [] klient = new Klient[7];
		Calendar [] kalendarz = new Calendar[7];
		KartkaKalendarza [] data = new KartkaKalendarza[7];
		Zamówienie [] zamówienie = new Zamówienie[7];
		kalendarz[0] = Calendar.getInstance();
		kalendarz[0].set(2016, 8, 24);
		data[0] = new KartkaKalendarza(kalendarz[0]);
		ankieta[0] = new  Ankieta(data[0], 7, 200, 4, Kolor.SELEDYNOWY,
			StylWystroju.RUSTYKALNY, Kierunek.PÓŁNOC, true);
		klient[0] = new KlientPołowiczny("Jerzy", "Malinowski");
		zamówienie[0] = new Zamówienie(klient[0], ankieta[0]);
		kalendarz[1] = Calendar.getInstance();
		kalendarz[1].set(2016, 8, 28);
		data[1] = new KartkaKalendarza(kalendarz[1]);
		ankieta[1] = new  Ankieta(data[1], 17, 300, 4, Kolor.JASNOZIELONY,
			StylWystroju.NOWOCZESNY, Kierunek.POŁUDNIE, false);
		klient[1] = new KlientWidokowy("Joanna", "Wiśniewska");
		zamówienie[1] = new Zamówienie(klient[1], ankieta[1]);
		kalendarz[2] = Calendar.getInstance();
		kalendarz[2].set(2016, 8, 26);
		data[2] = new KartkaKalendarza(kalendarz[2]);
		ankieta[2] = new  Ankieta(data[2], 3, 500, 1, Kolor.MORSKI,
			StylWystroju.MORSKI, Kierunek.ZACHÓD, true);
		klient[2] = new KlientPerfekcjonista("Jacek", "Lewandowski");
		zamówienie[2] = new Zamówienie(klient[2], ankieta[2]);
		kalendarz[3] = Calendar.getInstance();
		kalendarz[3].set(2016, 8, 27);
		data[3] = new KartkaKalendarza(kalendarz[3]);
		ankieta[3] = new  Ankieta(data[3], 2, 200, 4, Kolor.PURPUROWY,
			StylWystroju.ORIENTALNY, Kierunek.WSCHÓD, false);
		klient[3] = new KlientBudżetowy("Ping", "Pong");
		zamówienie[3] = new Zamówienie(klient[3], ankieta[3]);
		kalendarz[4] = Calendar.getInstance();
		kalendarz[4].set(2016, 8, 24);
		data[4] = new KartkaKalendarza(kalendarz[4]);
		ankieta[4] = new  Ankieta(data[4], 10, 1, 2, Kolor.SELEDYNOWY,
			StylWystroju.SECESYJNY, Kierunek.POŁUDNIE, true);
		klient[4] = new KlientBudżetowy("Tomasz", "Wojciechowski");
		zamówienie[4] = new Zamówienie(klient[4], ankieta[4]);
		kalendarz[5] = Calendar.getInstance();
		kalendarz[5].set(2016, 8, 26);
		data[5] = new KartkaKalendarza(kalendarz[5]);
		ankieta[5] = new  Ankieta(data[5], 4, 200, 4, Kolor.SELEDYNOWY,
			StylWystroju.MORSKI, Kierunek.WSCHÓD, true);
		klient[5] = new KlientPołowiczny("Piotr", "Nowak");
		zamówienie[5] = new Zamówienie(klient[5], ankieta[5]);
		kalendarz[6] = Calendar.getInstance();
		kalendarz[6].set(2016, 8, 7);
		data[6] = new KartkaKalendarza(kalendarz[6]);
		ankieta[6] = new  Ankieta(data[6], 3, 1, 100, Kolor.SELEDYNOWY,
			StylWystroju.RUSTYKALNY, Kierunek.PÓŁNOC, true);
		klient[6] = new KlientPołowiczny("Janusz", "Kowal");
		zamówienie[6] = new Zamówienie(klient[6], ankieta[6]);
	/*	pokój[0].dodajRezerwację(kalendarz[0], 10);
		kalendarz[1].set(2016, 8, 15);
		System.out.println(pokój[0].czyWolnyTermin(kalendarz[1], 10));
		System.out.println(klient[0].toString());
		System.out.println(pokój[0].toString());
		System.out.println(ankieta[0].toString());
		System.out.println(zamówienie[0].dajAnkietę().toString());*/
		hotel1.akceptuj(zamówienie, hotel1.dajPokoje(), hotel1.dajRecepcjonistów());
	}
}
