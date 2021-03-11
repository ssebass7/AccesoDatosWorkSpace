import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import org.w3c.dom.ls.LSInput;

public class AccesoFichero {

	public void AccesoFichero() {
		ClasePrincipal clP = new ClasePrincipal();
		File f = new File(clP.rutaContaminacion);

		FileReader lector = null;
		BufferedReader br = null;
		Contaminacion p;
		String valorH = "";
		try {
			lector = new FileReader(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br = new BufferedReader(lector);
		String linea = "";
		try {
			linea = br.readLine();
			linea = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String columna[];
		int cont = 0;
		while (linea != null) {
			ArrayList<Float> listaH = new ArrayList<Float>();
			listaH.clear();
			columna = linea.split(";");
			String estacion = columna[2];
			String magnitud = columna[3];
			String ano = columna[5];
			String mes = columna[6];
			String dia = columna[7];
			String h = "";
			int filaH = 8;
			for (int i = 0; i < 22; i++) {

				listaH.add(Float.parseFloat(columna[filaH]));
				filaH += 2;
			}

			p = new Contaminacion(estacion, magnitud, ano, mes, dia, listaH);
			ClasePrincipal.lista.add(p);

//			System.out.println(" *Estación*: " + p.getEstacion() + " *Magnitud*: " + p.getMagnitud() + " *Fecha*: "
//					+ p.getAno() + "/" + p.getMes() + "/" + p.getDia() + " *H*: ");

			try {
				linea = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		/*
		 * String contaminacion = "CONTAMINACIÓN = *Estación*: " + estacion +
		 * " *Magnitud*: " + magnitud + " *Fecha*: " + ano + "/" + mes + "/" + dia +
		 * " H:" + h;
		 */
	}

	public static void fileWriter() {
		FileWriter fw = null;
		try {
			fw = new FileWriter(ClasePrincipal.ruta2);
			fw.write(ClasePrincipal.html_tabla);
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ProcessBuilder pb = new ProcessBuilder(ClasePrincipal.ruta_g, ClasePrincipal.ruta2);
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String nombreEstacion(String estaci) {
		HashMap<String, String> estaciones = new HashMap<String, String>();
		estaciones.put("ESTACION", "ESTACIÓN");
		estaciones.put("4", "Pza. de España");
		estaciones.put("8", "Escuelas Aguirre");
		estaciones.put("11", "Av. Ramón y Cajal");
		estaciones.put("16", "Arturo Soria");
		estaciones.put("17", "Villaverde Alto");
		estaciones.put("18", "C/ Farolillo");
		estaciones.put("24", "Casa de Campo");
		estaciones.put("27", "Barajas");
		estaciones.put("35", "Pza. del Carmen");
		estaciones.put("36", "Moratalaz");
		estaciones.put("38", "Cuatro Caminos");
		estaciones.put("39", "Barrio del Pilar");
		estaciones.put("40", "Vallecas");
		estaciones.put("47", "Méndez Álvaro");
		estaciones.put("48", "Pº. Castellana");
		estaciones.put("49", "Retiro");
		estaciones.put("50", "Pza. Castilla");
		estaciones.put("54", "Ensanche Vallecas ");
		estaciones.put("55", "Urb. Embajada (Barajas)");
		estaciones.put("58", "El Pardo");
		estaciones.put("57", "Sanchinarro");
		estaciones.put("59", "Parque Juan Carlos I");
		estaciones.put("60", "Tres Olivos ");
		return estaciones.get(estaci);

	}

	public static String nombreMagnitud(String magnitu) {
		HashMap<String, String> magnitudes = new HashMap<String, String>();
		magnitudes.put("MAGNITUD", "MAGNITUD");
		magnitudes.put("1", "Dioxido de Azufre");
		magnitudes.put("6", "Mononoxido de Carbono");
		magnitudes.put("7", "Monoxido de Nitrogeno");
		magnitudes.put("8", "Dioxido de Nitrogeno");
		magnitudes.put("9", "Particulas < 2.5 um");
		magnitudes.put("10", "Particulas < 10 um");
		magnitudes.put("12", "Oxidos de Nitrogeno");
		magnitudes.put("14", "Ozono");
		magnitudes.put("20", "Tolueno");
		magnitudes.put("30", "Benceno");
		magnitudes.put("35", "Etilbenceno");
		magnitudes.put("37", "Metaxileno");
		magnitudes.put("38", "Paraxileno");
		magnitudes.put("39", "Ortoxileno");
		magnitudes.put("42", "Hidrocarburos totales");
		magnitudes.put("43", "Metano");
		magnitudes.put("44", "Hidrocarburos no metanicos(hexano)");
		return magnitudes.get(magnitu);

	}

}
