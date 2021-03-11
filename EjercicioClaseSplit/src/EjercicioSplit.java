import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class EjercicioSplit {
	static ArrayList listaPersona = new ArrayList();

	public static void main(String[] args) {
		File f = new File("C:\\Users\\sseba\\Desktop\\horario.csv");
		FileReader lector = null;
		BufferedReader br = null;
		Persona p;
		try {
			lector = new FileReader(f);
			br = new BufferedReader(lector);
			String linea = br.readLine();
			while (linea != null) {
				String palabra[] = linea.split(",");

				String nombre = palabra[0];
				String apellido = palabra[1];
				String edad = palabra[2];
				p = new Persona(nombre, apellido, edad);
				linea = br.readLine();
			}
			for (int i = 0; i < listaPersona.size(); i++) {
				System.out.println(listaPersona.get(i));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				br.close();
				lector.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
