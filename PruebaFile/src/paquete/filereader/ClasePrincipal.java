package paquete.filereader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ClasePrincipal {
	public static void main(String[] args) {
		String linea ="Pepe,Perez,35";
		String datos[] = linea.split(",");
		for (String string : datos) {
			System.out.println(string);
		}
//		File f = new File("C:\\Users\\sseba\\Desktop\\fichero.txt");
//		FileReader lector = null;
//		BufferedReader br = null;
//		int contador = 0;
//		try {
//			lector = new FileReader(f);
//			br = new BufferedReader(lector);
//			String linea = br.readLine();
//			while (linea != null) {
//				System.out.println(linea);
//				linea = br.readLine();
//				contador++;
//			}
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			try {
//				br.close();
//				lector.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
}
