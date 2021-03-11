package paquete.ejemploBite;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class ClasePrincipal {

	public static void main(String[] args) {
		ArrayList lista = new ArrayList();
		String letraLeida = "";
		try {
			FileInputStream fis = new FileInputStream("C:\\Users\\sseba\\Desktop\\fichero.txt");
			int b = fis.read();
			int cont = 0;
			while (b != -1) {
				char letraleidaChar = (char) b;
				System.out.println("Byte leido: " + letraleidaChar);
				if (b != 13) {
					letraLeida = letraLeida + letraleidaChar;
					b = fis.read();
				} else {
					lista.add(letraLeida);
					letraLeida = "";
					b = fis.read();
				}
			}
			lista.add(letraLeida);
			System.out.println(" ");
			System.out.println("*FRASES DEL TEXTO:*");
			for (int i = 0; i < lista.size(); i++) {
				System.out.println("-Frase: " + (i + 1));
				System.out.println(lista.get(i));
				System.out.println("");
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}