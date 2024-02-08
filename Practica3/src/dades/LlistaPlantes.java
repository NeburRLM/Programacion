package dades;

//RUBÉN
import java.io.Serializable;

public class LlistaPlantes implements Serializable {

	private static final long serialVersionUID = 1L;
	private Planta[] plantes;
	private int numPlantes;

	public LlistaPlantes(int dim) {
		plantes = new Planta[dim];
		numPlantes = 0;
	}

	public LlistaPlantes copia() {
		LlistaPlantes aux = new LlistaPlantes(numPlantes);
		for (int i = 0; i < numPlantes; i++)
			aux.afegeixPlanta(plantes[i]);

		return aux;
	}

	public void afegeixPlanta(Planta p) {
		if (numPlantes >= plantes.length) {
			Planta[] aux = new Planta[plantes.length * 2]; //si la taula de plantes està plena, duplicarem la dimensió de la taula per a que poguem afegir més plantes
			for (int i = 0; i < numPlantes; i++)
				aux[i] = plantes[i];
			plantes = aux;
		}
		plantes[numPlantes] = p.copia();
		numPlantes++;
	
	}

	public int quantitatAbsorcioLlista(String especie, int edat) {

		int i = 0;
		int abs = 0;

		while ((i < numPlantes) && (abs == 0)) {
			if (especie.equalsIgnoreCase(plantes[i].getNom())) {
				abs = plantes[i].quantitatAbsorcio(edat);
			}
			i++;

		}
		return abs;

	}

	@Override
	public String toString() {
		String aux;

		aux = "Plantes => numPlantes: " + numPlantes;
		for (int i = 0; i < numPlantes; i++) {
			aux = aux + "\n\t[" + i + "] " + plantes[i];
		}

		return aux;
	}

}
