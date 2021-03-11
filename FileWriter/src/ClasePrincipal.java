import java.io.FileWriter;
import java.util.HashMap;

public class ClasePrincipal {
	public static void main(String[] args) {
		HashMap<Integer,String> mapa= new HashMap();
		mapa.put(28, "Plaza España");
		mapa.get(28);
		try {
			String html_tabla = PintarHTML.crearTabla(lista);
			FileWriter fw = new FileWriter("C:\\Users\\sseba\\Desktop\\PruebaFileWriter.txt", true);
			fw.write("\n Me llamo Antonio");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
