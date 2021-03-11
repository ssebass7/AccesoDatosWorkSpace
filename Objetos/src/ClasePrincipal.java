import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.imageio.stream.FileImageInputStream;

public class ClasePrincipal {
	public static void main(String[] args) {
		Persona p = new Persona("Paco", "Perez", 10);
		try {
			FileOutputStream fos = new FileOutputStream("C:\\Users\\sseba\\Desktop\\objeto.txt");

			ObjectOutputStream os = new ObjectOutputStream(fos);
			os.writeObject(p);
			os.close();
			fos.close();
			FileInputStream fis = new FileInputStream("C:\\Users\\sseba\\Desktop\\objeto.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Persona persona = (Persona) ois.readObject();
			System.out.println("He leido " + persona);
			System.out.println();
		} catch (IOException e) {
			e.printStackTrace();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
