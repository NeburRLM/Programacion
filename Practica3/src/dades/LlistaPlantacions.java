package dades;

//INÉS
public class LlistaPlantacions {
	private Plantacions[] plantes;
	private int numPlantes;
	private final static int maxRodal = 10;

	public LlistaPlantacions(int dim) {
		plantes = new Plantacions[dim];
		numPlantes = 0;
	}

	public LlistaPlantacions copia() {
		LlistaPlantacions paux = new LlistaPlantacions(numPlantes);
		for (int i = 0; i < numPlantes; i++)
			paux.afegeixPlantacio(plantes[i]);
		return paux;
	}

	public void mostrarPlantacions(String tipusTerr) {
		String aux = "";
		int i = 0;
		while (i < numPlantes) {
			if (plantes[i].esIgualTerreny(tipusTerr)) {
				aux = aux + plantes[i] + "\n";
			}
			i++;
		}
		System.out.println(aux);
	}

	public void afegeixPlantacio(Plantacions p) {
		if (numPlantes < plantes.length && p.getRodal() <= maxRodal) {
			plantes[numPlantes] = p;
			numPlantes++;
		}
	}

	public void eliminarPlantacio(String nomPartida, int any) {
		int i = 0;
		while (i < numPlantes) {
			if (plantes[i].esIgualNom(nomPartida) && plantes[i].esIgualAny(any)) {
				for (int j = i; j < numPlantes - 1; j++) {
					plantes[j] = plantes[j + 1];
				}
				numPlantes--;
			} else {
				i++;
			}
		}
	}

	public void canviarAny(String nomPartida, int any, int anyCanvi) {
		int i = 0;
		while (i < numPlantes) {
			plantes[i].canviAnyPlantacio(nomPartida, any, anyCanvi);
			i++;
		}
	}

	public void modificarDades(String nomPartida, int any, int rodal, String tipusTer, double superf) {
		int i = 0;
		while (i < numPlantes) {
			plantes[i].modificarDadesRodals(nomPartida, any, rodal, tipusTer, superf);
			i++;
		}
	}

	public String toString() {
		String mLlista = "";
		for (int i = 0; i < numPlantes; i++) {
			mLlista = mLlista + plantes[i] + "\n";
		}
		return mLlista;
	}
}
