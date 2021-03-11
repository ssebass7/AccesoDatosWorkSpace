import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ClasePrincipal {
	static String rutaContaminacion = "";
	static ArrayList<Contaminacion> lista = new ArrayList();
	static String ruta_g;
	static String ruta2;
	static String html_tabla;

	public static void main(String[] args) {

		ruta_g = "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chrome.exe";
		ruta2 = "C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\workspaceAD\\Contaminación Aire\\TablaContaminacion.html";
		rutaContaminacion = "C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\workspaceAD\\Contaminación Aire\\horario.csv";
		AccesoFichero ac = new AccesoFichero();
		ac.AccesoFichero();
		html_tabla = TablaHTML.crearTablaHTML(lista);
		AccesoFichero.fileWriter();
	}
}