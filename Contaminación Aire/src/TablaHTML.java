import java.util.ArrayList;

public class TablaHTML {
	public static String crearTablaHTML(ArrayList<Contaminacion> lista) {
		String tabla = "<table border = '1'>";
		int cont = 0;
		tabla += "<tr>";
		tabla += "<th>" + "ESTACION" + "</th>";
		tabla += "<th>" + "MAGNITUD" + "</th>";
		tabla += "<th>" + "FECHA" + "</th>";
		for (int i = 0, b = 1; i < 24; i++, b++) {
			tabla += "<th>" + i + "-" + b + "</th>";
		}
		tabla += "</tr>";
		for (Contaminacion contaminacion : lista) {

			tabla = tabla + "<tr>";
			tabla += "<td>" + AccesoFichero.nombreEstacion(contaminacion.getEstacion()) + "</td>";
			tabla += "<td>" + AccesoFichero.nombreMagnitud(contaminacion.getMagnitud()) + "</td>";
			tabla += "<td>" + contaminacion.getAno() + "</td>";
			tabla += "<td>" + contaminacion.getMes() + "</td>";
			tabla += "<td>" + contaminacion.getDia() + "</td>";
			for (int i = 0; i < contaminacion.getListaH().size(); i++) {
				tabla += "<td style=\'background-color:"
						+ colorearTabla(contaminacion.getListaH(), contaminacion.getListaH().get(i)) + "'\' >"
						+ contaminacion.getListaH().get(i) + "</td>";
			}
			tabla += "</tr>";

			cont++;
		}
		tabla += "</table>";
		return tabla;

	}

	private static String colorearTabla(ArrayList<Float> listaFloat, Float pos) {
		ArrayList<Float> flt = listaFloat;
		float posicion = pos;
		float max = 0;
		float min = flt.get(0);
		for (int i = 0; i < flt.size() - 1; i++) {
			if (flt.get(i) > max) {
				max = flt.get(i);
			}
			if (flt.get(i) < min) {
				min = flt.get(i);
			}
		}
		float rojo = 255 / (max - min) * posicion + (255 * min / (min - max));
		float verde = 255 - rojo;
		String rgb = "rgb(" + rojo + "," + verde + ",0)";
		return rgb;
	}
}
