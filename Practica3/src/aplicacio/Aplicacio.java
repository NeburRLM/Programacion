package aplicacio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;
import dades.LlistaPlantacions;
import dades.LlistaPlantes;
import dades.PlantaArbustiva;
import dades.Plantacions;
import dades.Planta;

public class Aplicacio {

	static Scanner teclat = new Scanner(System.in);
	static LlistaPlantes llistaPlantes;
	static LlistaPlantacions llistaPlantacions;

	static Plantacions plantes;

	public static void main(String[] args) throws IOException {

		llistaPlantes = new LlistaPlantes(contLinias("Arbustos.txt"));// Rubén
		Planta novaPlanta = new PlantaArbustiva("Ceanothus thyrsiflorus", "Arbustiva", 68, 150);// Rubén
		llistaPlantes = carregaDadesPlantes("Arbustos.txt");// Rubén

		llistaPlantacions = new LlistaPlantacions(contLinias("Plantacions.txt"));// Inés
		plantes = new Plantacions("Les Clarianes", 2021, 0, "CalcariSolana", 0.55);// Inés
		llistaPlantacions = carregaDadesPlantacions("Plantacions.txt");// Inés

		System.out.println("Dades carregades correctament!!!"); //fata controlar-ho mitjançant excepcions

		// RUBÉN
		System.out.println("........................................");

		System.out.println("1.Mostra plantes");
		System.out.println(llistaPlantes.toString());

		System.out.println("........................................");
		System.out.println("2.Afegir nova planta");
		llistaPlantes.afegeixPlanta(novaPlanta);
		System.out.println("Planta afegida correctament!!!"); //fata controlar-ho mitjançant excepcions
		
		System.out.println("........................................");
		System.out.println("3.Serialitzar");
		
		guardarDadesPlantesSerialitzat("ObjectePlanta.ser", llistaPlantes); //guarda la llista de plantes en un fitxer binari
		llegirDadesPlantesSerialitzat("ObjectePlanta.ser", llistaPlantes);	//llegeix i mostra la llista de plantes d'un fitxer binari

		System.out.println("........................................");

		System.out.println("4.Donada una espècie i una edat, mostrar la quantitat de CO2 que permet absorbir");
		
		//Falta fer exepcions per comprovar que les dades que es passen per paràmetre són vàlides
		System.out.println("Absorció co2 Genista scorpius-> "+llistaPlantes.quantitatAbsorcioLlista("Genista scorpius", 3));
		System.out.println("Absorció co2 Erica multiflora-> "+llistaPlantes.quantitatAbsorcioLlista("Erica multiflora", 8));
		System.out.println("Absorció co2 Genista scorpius-> "+llistaPlantes.quantitatAbsorcioLlista("Genista scorpius", 100));

		// INÉS
		System.out.println("........................................");
		// Mostra la llista de totes les plantacions
		System.out.println("LListat de plantacions");
		System.out.println(llistaPlantacions);
		System.out.println("........................................");
		// Mostra la llista d'un tipus de terreny en específic
		System.out.println("Llista de CalcariSolana");
		llistaPlantacions.mostrarPlantacions("CalcariSolana");
		System.out.println("........................................");
		// No mostrarà res perqué no existeix
		llistaPlantacions.mostrarPlantacions("SorraSolana");
		System.out.println("........................................");
		// Afegim una plantació a la llista
		System.out.println("Afegir plantacio");
		llistaPlantacions.afegeixPlantacio(plantes);
		System.out.println(llistaPlantacions);
		System.out.println("........................................");
		// Eliminem un tipus de plantació de la llista
		System.out.println("eliminar plantacio");
		llistaPlantacions.eliminarPlantacio("Els trossos", 2015);
		System.out.println(llistaPlantacions);
		System.out.println("........................................");
		// No s'eliminarà res perqué no trobarà cap plantació amb aquestes
		// característiques
		llistaPlantacions.eliminarPlantacio("Els trossos", 2019);
		llistaPlantacions.eliminarPlantacio("Les Clarianes", 2015);
		System.out.println(llistaPlantacions);
		System.out.println("........................................");
		// Canviem l'any de plantació d'una plantació en específic
		System.out.println("canviar any");
		llistaPlantacions.canviarAny("Finca les pedres", 2018, 2020);
		System.out.println(llistaPlantacions);
		System.out.println("........................................");
		// No s'observaran canvis perqué no existeixen plantacions amb aquestes
		// característiques
		llistaPlantacions.canviarAny("Finca les pedres", 2019, 2020);
		llistaPlantacions.canviarAny("Les Clarianes", 2018, 2020);
		System.out.println(llistaPlantacions);
		System.out.println("........................................");
		// Modifiquem les dades d'un tipus de plantació en concret
		System.out.println("modificar dades");
		llistaPlantacions.modificarDades("Finca les pedres", 2020, 2, "CalcariObaga", 0.1);
		System.out.println(llistaPlantacions);
		System.out.println("........................................");
		// No es modificaran les dades perqué no existeixen aquestes plantacions amb les
		// característiques introduides
		llistaPlantacions.modificarDades("Les Plamoses", 2020, 2, "CalcariObaga", 0.1);
		llistaPlantacions.modificarDades("Finca les pedres", 2025, 2, "CalcariObaga", 0.1);
		llistaPlantacions.modificarDades("Finca les pedres", 2020, 9, "CalcariObaga", 0.1);

		System.out.println("........................................");
		System.out.println("Adeu, fins la próxima!!!");

	}

	// RUBÉN
	private static int contLinias(String nomFitxer) throws IOException { //calcula les linies existents en el fitxer .txt i aixi saber la dimensió que ha de tenir la llista inicialment
		BufferedReader bf = new BufferedReader(new FileReader(nomFitxer));
		int dim = (int) bf.lines().count();
		bf.close();
		return dim;
	}

	// RUBÉN
	private static LlistaPlantes carregaDadesPlantes(String nomFitxer) throws IOException {
		Scanner entrada = new Scanner(new File(nomFitxer));
		int dim = contLinias(nomFitxer);
		LlistaPlantes lPlantes = new LlistaPlantes(dim);
		String info;
		String nom;
		int quantAbsorcio;
		int vidaUtil;
		Scanner trossejar;
		info = entrada.nextLine();
		// System.out.println(info);
		try {
			while (entrada.hasNext()) {
				info = entrada.nextLine();
				trossejar = new Scanner(info);
				trossejar.useDelimiter(";");

				nom = trossejar.next();
				quantAbsorcio = trossejar.nextInt();
				vidaUtil = trossejar.nextInt();
				;

				// System.out.println(nom + " " + quantAbsorcio+ " "+ vidaUtil);

				Planta p = new PlantaArbustiva(nom, "Arbustiva", quantAbsorcio, vidaUtil);
				lPlantes.afegeixPlanta(p);

			}

		} catch (NoSuchElementException e) {
			entrada.close();
			System.out.println(e);
		}
		return lPlantes;
	}

	// RUBÉN
	private static void guardarDadesPlantesSerialitzat(String nomFitxer, LlistaPlantes llista) {
		ObjectOutputStream outputFile;
		try {
			outputFile = new ObjectOutputStream(new FileOutputStream(nomFitxer));

			outputFile.writeObject(llista);

			outputFile.close();
		} catch (IOException e) {
			System.out.println("Error amb el fitxer");
		}
	}

	// RUBÉN
	private static void llegirDadesPlantesSerialitzat(String nomFitxer, LlistaPlantes llista) {
		ObjectInputStream inputFile;
		LlistaPlantes l = new LlistaPlantes(5);
		try {
			inputFile = new ObjectInputStream(new FileInputStream(nomFitxer));
			l = (LlistaPlantes) inputFile.readObject();

			System.out.println(l.toString());

			inputFile.close();
		} catch (IOException e) {
			System.out.println("Error amb el fitxer");
		} catch (ClassNotFoundException e) {
			System.out.println("Error en el format del fitxer " + e);
		} catch (ClassCastException e) {
			System.out.println("Classe error fitxer");
		}
	}

	// INÉS
	private static LlistaPlantacions carregaDadesPlantacions(String nomFitxer) throws IOException {
		int dim = contLinias(nomFitxer);
		LlistaPlantacions llistaP = new LlistaPlantacions(dim);
		Scanner separador;
		BufferedReader fitxer = new BufferedReader(new FileReader(nomFitxer));

		String linia;
		String nomPartida;
		int anyPlantacio;
		int rodal;
		String tipusTerreny;
		double superfRodal;

		linia = fitxer.readLine();
		try {
			while (linia != null) {
				separador = new Scanner(linia);
				separador.useDelimiter(";");
				separador.useLocale(Locale.ENGLISH);

				nomPartida = separador.next();
				anyPlantacio = separador.nextInt();
				rodal = separador.nextShort();
				tipusTerreny = separador.next();
				superfRodal = separador.nextFloat();

				Plantacions plantacio = new Plantacions(nomPartida, anyPlantacio, rodal, tipusTerreny, superfRodal);
				llistaP.afegeixPlantacio(plantacio);

				linia = fitxer.readLine();

			}
		} catch (NoSuchElementException e) {
			fitxer.close();
		}
		return llistaP;
	}
}
