package rendelesek;

public class TermekRaktar {

	private String termekCikkszam;
	private String megnevezes;
	private int ar;
	private int raktariDarabSzam;
	private boolean kifogyott;
	private int rendelendoMennyiseg;

	public TermekRaktar(String termekCikkszam, String megnevezes, int ar, int raktariDarabSzam, boolean kifogyott,
			int rendelendoMennyiseg) {
		this.termekCikkszam = termekCikkszam;
		this.megnevezes = megnevezes;
		this.ar = ar;
		this.raktariDarabSzam = raktariDarabSzam;
		this.kifogyott = kifogyott;
		this.rendelendoMennyiseg = rendelendoMennyiseg;
	}

	public String getMegnevezes() {
		return megnevezes;
	}

	public void setMegnevezes(String megnevezes) {
		this.megnevezes = megnevezes;
	}

	public String getTermekCikkszam() {
		return termekCikkszam;
	}

	public void setTermekCikkszam(String termekCikkszam) {
		this.termekCikkszam = termekCikkszam;
	}

	public int getAr() {
		return ar;
	}

	public void setAr(int ar) {
		this.ar = ar;
	}

	public int getRaktariDarabSzam() {
		return raktariDarabSzam;
	}

	public void setRaktariDarabSzam(int raktariDarabSzam) {
		this.raktariDarabSzam = raktariDarabSzam;
	}

	public boolean isKifogyott() {
		return kifogyott;
	}

	public void setKifogyott(boolean kifogyott) {
		this.kifogyott = kifogyott;
	}

	@Override
	public String toString() {
		return "Termék cikkszáma: " + this.termekCikkszam + " megnevezése: " + this.megnevezes + ", ára: " + this.ar
				+ "Ft, raktári mennyiség: " + this.raktariDarabSzam + "db, elfogyott: "
				+ ((this.kifogyott) ? "Igen" : "Nem") + " rendelendő mennyiség: " + this.rendelendoMennyiseg + "db";
	}

	public int getRendelendoMennyiseg() {
		return rendelendoMennyiseg;
	}

	public void setRendelendoMennyiseg(int rendelendoMennyiseg) {
		this.rendelendoMennyiseg = rendelendoMennyiseg;
	}

}
