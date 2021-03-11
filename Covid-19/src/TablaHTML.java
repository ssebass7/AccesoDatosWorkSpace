import java.util.ArrayList;
import java.util.HashMap;

public class TablaHTML {

	public static String crearTablaHTML(String key, ArrayList<Covid_19> lista) {
		String tabla = "<html><body><table border = '1'><tr><th> " + key
				+ "</th><th>Num_casos</th><th>Num_casos_Prueba_PCR</th></tr>";
		for (Covid_19 covid19 : lista) {

			tabla += "<tr>";
			tabla += "<td>" + covid19.getFecha() + "</td>";
			tabla += "<td>" + covid19.getNum_casos() + "</td>";
			tabla += "<td>" + covid19.getNum_casos_prueba_pcr() + "</td>";
			tabla += "</tr>";
		}
		tabla += "</table></body></html>";
		return tabla;

	}

	public static String crearIndex(HashMap<String, ArrayList<Covid_19>> mapa_ccaa) {
		String index = "<html><body>";
		for (String comunidad : mapa_ccaa.keySet()) {
			index += "<a href= 'TablaCovid19" + comunidad + ".html'<h3>" + comunidad + "</h3></a><br>";
		}
		index += "</body></html>";
		return index;
	}

}