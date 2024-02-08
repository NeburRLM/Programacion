package dades;

//INÉS
public class Plantacions {
	private String nomPartida;
	private int anyPlantacio;
	private int rodal;
	private String tipusTerreny;
	private double superfRodal;

	public Plantacions(String nomPartida, int anyPlantacio, int rodal, String tipusTerreny, double superfRodal) {
		this.nomPartida = nomPartida;
		this.anyPlantacio = anyPlantacio;
		this.rodal = rodal;
		this.tipusTerreny = tipusTerreny;
		this.superfRodal = superfRodal;
	}

	public boolean esIgualNom(String nomPartida) {
		return (nomPartida.equalsIgnoreCase(this.nomPartida));
	}

	public boolean esIgualAny(int any) {
		if (any == anyPlantacio)
			return true;
		else
			return false;
	}

	public boolean esIgualRodal(int rodal) {
		if (rodal == this.rodal)
			return true;
		else
			return false;
	}

	public int getRodal() {
		return this.rodal;
	}

	public boolean esIgualTerreny(String tipusTerreny) {
		return (tipusTerreny.equalsIgnoreCase(this.tipusTerreny));
	}

	public void canviAnyPlantacio(String nomPartida, int any, int anyCanvi) {
		if (nomPartida.equalsIgnoreCase(this.nomPartida) && any == this.anyPlantacio) {
			this.anyPlantacio = anyCanvi;
		}
	}

	public void modificarDadesRodals(String nomPartida, int any, int rodal, String tipusTer, double superf) {
		if (nomPartida.equalsIgnoreCase(this.nomPartida) && any == this.anyPlantacio && rodal == this.rodal) {
			this.tipusTerreny = tipusTer;
			this.superfRodal = superf;
		}
	}

	public void setTipusTerreny(String terreny) {
		this.tipusTerreny = terreny;
	}

	public void setSuperfRodal(double superf) {
		this.superfRodal = superf;
	}

	public Plantacions copia() {
		Plantacions planta = new Plantacions(nomPartida, anyPlantacio, rodal, tipusTerreny, superfRodal);
		return planta;
	}

	public String toString() {
		return "Plantacions [nomPartida=" + nomPartida + ", anyPlantacio=" + anyPlantacio + ", rodal=" + rodal
				+ ", tipusTerreny=" + tipusTerreny + ", superfRodal=" + superfRodal + "]";
	}
}
