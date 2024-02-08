package dades;

//RUBÉN
import java.io.Serializable;

public abstract class Planta implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nom;
	private String tipus;

	public Planta(String nom, String tipus) {
		this.nom = nom;
		this.tipus = tipus;

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTipus() {
		return tipus;
	}

	public abstract Planta copia();

	public abstract int quantitatAbsorcio(int edat);

	public void setTipus(String tipus) {
		this.tipus = tipus;
	}

	@Override
	public String toString() {
		return " nom=" + nom + ", tipus=" + tipus + ",";
	}

}
