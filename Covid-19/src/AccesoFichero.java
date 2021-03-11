
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.w3c.dom.ls.LSInput;

public class AccesoFichero {

	static HashMap<String, ArrayList<Covid_19>> mapa_ccaa = new HashMap();

	public void AccesoFichero() {
		ClasePrincipal clP = new ClasePrincipal();
		File f = new File(clP.rutaCovid19);

		FileReader lector = null;
		BufferedReader br = null;
		Covid_19 c;

		
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
		while (linea != null) {
			columna = linea.split(",");
			String ccaa_iso = columna[0];
			String fecha = columna[1];
			String num_casos = columna[2];
			String num_casos_prueba_pcr = columna[3];

			c = new Covid_19(fecha, num_casos, num_casos_prueba_pcr);
			if (mapa_ccaa.containsKey(ccaa_iso)) {
				mapa_ccaa.get(ccaa_iso).add(c);
			} else {
				ArrayList<Covid_19> lista = new ArrayList();
				lista.add(c);
				mapa_ccaa.put(ccaa_iso, lista);
			}
			try {
				linea = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public static void fileWriter() {
		String index = TablaHTML.crearIndex(mapa_ccaa);
		try {
			FileWriter fwI;
			fwI = new FileWriter("C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\workspaceAD\\Covid-19\\CCAA\\TablaCovid19.html");
			fwI.write(index);
			fwI.close();

			mapa_ccaa.forEach((key, valor) -> {
				try {
					FileWriter fw;
					String tabla_HTML;
					fw = new FileWriter("C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\workspaceAD\\Covid-19\\CCAA\\TablaCovid19" + key + ".html");
					tabla_HTML = TablaHTML.crearTablaHTML(key, valor);
					fw.write(tabla_HTML);
					fw.close();
				} catch (IOException e) { // TODO Auto-generated catch block
					e.printStackTrace();
				}
			});

			Runtime.getRuntime().exec(
					"C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\workspaceAD\\Covid-19\\CCAA\\TablaCovid19.html");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
