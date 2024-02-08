package dades;

public class Terreny {
	private int nPlantes;
	private String especie;
	
	public Terreny(int nPlantes, String especie) {
		super();
		this.nPlantes = nPlantes;
		this.especie = especie;
	}

	public int getnPlantes() {
		return nPlantes;
	}

	public void setnPlantes(int nPlantes) {
		this.nPlantes = nPlantes;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}
	
	
}
