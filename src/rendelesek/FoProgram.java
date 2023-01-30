package rendelesek;

import java.util.List;

public class FoProgram {

	public static void main(String[] args) {

		FajlKezeles fajl = new FajlKezeles();

		List<Vevo> vevok = fajl.BeolvasRendeleseket("F:\\Kurs\\Feladatok\\Rendelesek\\rendeles.csv", ";");
		List<RendeltTermek> termekek = fajl.BeolvasTermekeket("F:\\Kurs\\Feladatok\\Rendelesek\\rendeles.csv", ";");
		List<TermekRaktar> keszlet = fajl.BeolvasRaktarKeszletet("F:\\Kurs\\Feladatok\\Rendelesek\\raktar.csv", ";");

		/*
		 * System.out.println("Vevők adatai:\n");
		 * vevok.stream().forEach(System.out::println);
		 * System.out.println("\nMegrendelt termékek listája:\n");
		 * termekek.stream().forEach(System.out::println);
		 * System.out.println("\nRaktárkészlet:\n");
		 * keszlet.stream().forEach(System.out::println);
		 */

		for (Vevo vevoAdat : vevok) {
			for (RendeltTermek termek : termekek) {
				for (TermekRaktar raktar : keszlet) {
					if (vevoAdat.getRendelesSzama() == termek.getRendelesSzam()
							&& termek.getTermekCikkszam().equals(raktar.getTermekCikkszam())) {
						if (raktar.getRaktariDarabSzam() > termek.getRendeltMennyiseg()) {
							raktar.setRaktariDarabSzam((raktar.getRaktariDarabSzam() - termek.getRendeltMennyiseg()));
							vevoAdat.setSzallithato(true);
							vevoAdat.setFizetendo(vevoAdat.getFizetendo() + (termek.AratSzamol(raktar.getAr())));
						} else if (raktar.getRaktariDarabSzam() < termek.getRendeltMennyiseg()) {
							int kulonbseg = termek.getRendeltMennyiseg() - raktar.getRaktariDarabSzam();
							raktar.setRendelendoMennyiseg(raktar.getRendelendoMennyiseg() + kulonbseg);
							vevoAdat.setSzallithato(false);
							raktar.setKifogyott(true);
						}
					}
				}
			}
		}
		fajl.LevelekIrasa("F:\\Kurs\\Feladatok\\Rendelesek\\levelek.csv", ";", vevok);
		fajl.BeszerzesIrasa("F:\\Kurs\\Feladatok\\Rendelesek\\beszerzes.csv", ";", keszlet);

	}

}
