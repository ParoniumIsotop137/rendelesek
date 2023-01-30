package rendelesek;

public class RendeltTermek {

	private int rendelesSzam;
	private String termekCikkszam;
	private int rendeltMennyiseg;

	public RendeltTermek(int rendelesSzam, String termekCikkszam, int rendeltMennyiseg) {
		this.rendelesSzam = rendelesSzam;
		this.termekCikkszam = termekCikkszam;
		this.rendeltMennyiseg = rendeltMennyiseg;
	}

	public int getRendelesSzam() {
		return rendelesSzam;
	}

	public void setRendelesSzam(int rendelesSzam) {
		this.rendelesSzam = rendelesSzam;
	}

	public String getTermekCikkszam() {
		return termekCikkszam;
	}

	public void setTermekCikkszam(String termekCikkszam) {
		this.termekCikkszam = termekCikkszam;
	}

	public int getRendeltMennyiseg() {
		return rendeltMennyiseg;
	}

	public void setRendeltMennyiseg(int rendeltMennyiseg) {
		this.rendeltMennyiseg = rendeltMennyiseg;
	}

	public int AratSzamol(int ar) {
		return this.rendeltMennyiseg * ar;

	}

	@Override
	public String toString() {
		return "Rendelés száma: " + this.rendelesSzam + ", termék cikkszáma: " + this.termekCikkszam
				+ ", rendelt mennnyiség: " + this.rendeltMennyiseg + "db";
	}

}
