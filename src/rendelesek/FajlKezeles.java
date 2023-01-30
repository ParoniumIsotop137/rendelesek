package rendelesek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FajlKezeles {

	private static BufferedReader br;
	private static List<Vevo> rendelesek = new ArrayList<Vevo>();
	private static List<RendeltTermek> termekek = new ArrayList<RendeltTermek>();
	private static List<TermekRaktar> raktar = new ArrayList<TermekRaktar>();

	public List<Vevo> BeolvasRendeleseket(String fajlnev, String elvalaszto) {

		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"));

			while (br.ready()) {
				String[] sor = br.readLine().split(elvalaszto);
				if (sor[0].equalsIgnoreCase("M")) {
					{
						Vevo v = new Vevo(LocalDate.parse((sor[1]).replace(".", "-")), Integer.parseInt(sor[2]), sor[3],
								0, false);
						rendelesek.add(v);
					}
				}
			}
			br.close();

		} catch (Exception e) {
			System.err.println("Hiba az adatok beolvasásakor! " + e.getMessage());
		}

		return rendelesek;
	}

	public List<RendeltTermek> BeolvasTermekeket(String fajlnev, String elvalaszto) {

		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"));

			while (br.ready()) {
				String[] sor = br.readLine().split(elvalaszto);
				if (sor[0].equalsIgnoreCase("T")) {
					{
						RendeltTermek rt = new RendeltTermek(Integer.parseInt(sor[1]), sor[2],
								Integer.parseInt(sor[3]));
						termekek.add(rt);
					}
				}
			}
			br.close();

		} catch (Exception e) {
			System.err.println("Hiba az adatok beolvasásakor! " + e.getMessage());
		}

		return termekek;

	}

	public List<TermekRaktar> BeolvasRaktarKeszletet(String fajlnev, String elvalaszto) {

		try {

			br = new BufferedReader(new InputStreamReader(new FileInputStream(fajlnev), "UTF-8"));

			while (br.ready()) {
				String[] sor = br.readLine().split(elvalaszto);

				TermekRaktar tr = new TermekRaktar(sor[0], sor[1], Integer.parseInt(sor[2]), Integer.parseInt(sor[3]),
						false, 0);
				raktar.add(tr);

			}
			br.close();

		} catch (Exception e) {
			System.err.println("Hiba az adatok beolvasásakor! " + e.getMessage());
		}

		return raktar;
	}

	public void LevelekIrasa(String fajlnev, String elvalaszto, List<Vevo> vevok) {

		try {

			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev, false), "UTF-8");

			String kiir;

			for (Vevo vevo : vevok) {

				if (vevo.isSzallithato()) {
					kiir = vevo.getEmailCim() + elvalaszto
							+ "A rendelését két napon belül szállítjuk. A rendelés értéke: "
							+ String.valueOf(vevo.getFizetendo()) + "Ft.";
				} else {
					kiir = vevo.getEmailCim() + elvalaszto
							+ "A rendelése függő állapotba került. Hamarosan értesítjük a szállítás időpontjáról.";
				}

				out.write(kiir + "\n");

			}

			out.close();
		} catch (Exception e) {
			System.err.println("Hiba az adatok írásakor! " + e.getMessage());
		}
		System.out.println("A levelek fájlba írása sikeresen megtörtént!");

	}

	public void BeszerzesIrasa(String fajlnev, String elvalaszto, List<TermekRaktar> keszlet) {

		try {

			OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(fajlnev, false), "UTF-8");

			String kiir;

			for (TermekRaktar raktar : keszlet) {
				if (raktar.isKifogyott()) {
					kiir = raktar.getTermekCikkszam() + elvalaszto + String.valueOf(raktar.getRendelendoMennyiseg());
					out.write(kiir + "\n");
				}
			}
			out.close();

		} catch (Exception e) {
			System.err.println("Hiba az adatok írásakor! " + e.getMessage());
		}
		System.out.println("\nA beszerzési lista fájlba írása sikeresen megtörtént!");
	}

}
