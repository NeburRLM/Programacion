package dades;

//RUBÉN
public class PlantaArbustiva extends Planta {

	private static final long serialVersionUID = 1L;
	private int quantAbsorcio;
	private int vidaUtil;

	public PlantaArbustiva(String nom, String tipus, int quantAbsorcio, int vidaUtil) {
		super(nom, tipus);
		this.quantAbsorcio = quantAbsorcio;
		this.vidaUtil = vidaUtil;
	}

	public int getQuantAbsorcio() {
		return quantAbsorcio;
	}

	public void setQuantAbsorcio(int quantAbsorcio) {
		this.quantAbsorcio = quantAbsorcio;
	}

	public int getVidaUtil() {
		return vidaUtil;
	}

	public void setVidaUtil(int vidaUtil) {
		this.vidaUtil = vidaUtil;
	}

	@Override
	public PlantaArbustiva copia() {
		PlantaArbustiva p = new PlantaArbustiva(this.getNom(), this.getTipus(), this.getQuantAbsorcio(),
				this.getVidaUtil());
		return p;
	}

	public int quantitatAbsorcio(int edat) {
		int absorcio = 0;

		if ((edat < 5) || (edat > vidaUtil)) {
			absorcio = 0;
		}
		if ((edat > 5) && (edat < vidaUtil)) {
			absorcio = this.getQuantAbsorcio();
		}

		return absorcio;
	}

	@Override
	public String toString() {
		return "PlantaArbustiva [" + super.toString() + " Quantitat absorcio= " + quantAbsorcio + ", Vida util= "
				+ vidaUtil + "]";
	}

}
