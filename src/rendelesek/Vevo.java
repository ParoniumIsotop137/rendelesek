package rendelesek;

import java.time.LocalDate;

public class Vevo {

	private LocalDate rendelesDatuma;
	private int rendelesSzama;
	private String emailCim;
	private int fizetendo;
	private boolean szallithato;

	public Vevo(LocalDate rendelesDatuma, int rendelesSzama, String emailCim, int fizetendo, boolean szallithato) {
		this.rendelesDatuma = rendelesDatuma;
		this.rendelesSzama = rendelesSzama;
		this.emailCim = emailCim;
		this.fizetendo = fizetendo;
		this.szallithato = szallithato;
	}

	public LocalDate getRendelesDatuma() {
		return rendelesDatuma;
	}

	public void setRendelesDatuma(LocalDate rendelesDatuma) {
		this.rendelesDatuma = rendelesDatuma;
	}

	public int getRendelesSzama() {
		return rendelesSzama;
	}

	public void setRendelesSzama(int rendelesSzama) {
		this.rendelesSzama = rendelesSzama;
	}

	public String getEmailCim() {
		return emailCim;
	}

	public void setEmailCim(String emailCim) {
		this.emailCim = emailCim;
	}

	public int getFizetendo() {
		return fizetendo;
	}

	public void setFizetendo(int fizetendo) {
		this.fizetendo = fizetendo;
	}

	public boolean isSzallithato() {
		return szallithato;
	}

	public void setSzallithato(boolean szallithato) {
		this.szallithato = szallithato;
	}

	@Override
	public String toString() {
		return "Rendelés dátuma: " + this.rendelesDatuma + ", rendelés száma: " + this.rendelesSzama + ", email cím: "
				+ this.emailCim + ", fizetendő: " + this.fizetendo + "Ft, szálítható-e: "
				+ ((this.szallithato) ? "Igen" : "Nem");
	}

}
