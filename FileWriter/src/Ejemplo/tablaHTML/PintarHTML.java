package Ejemplo.tablaHTML;

public class PintarHTML {
	public static String crearTabla(ArrayList<Persona> lista) {
		String tabla = "<table>";
		for (Persona persona : lista) {
			tabla = tabla + "<tr>";
			tabla += "<td>" + persona.getNombre() + "</td>";
			tabla += "<td>" + persona.getEmail() + "</td>";
			tabla += "<td>" + persona.getTelefono() + "</td>";
			tabla += "</tr>";

		}
		tabla+="</table>";
		String inicio = "</html><head></head><body>";
		String fin = "</body></html>";
		return tabla;

	}

}
