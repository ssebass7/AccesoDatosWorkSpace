package paquete.ejemplofile;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ClasePrincipal {

	public static void main(String[] args) {
		Scanner leerNom = new Scanner(System.in);

		boolean condicion = false;
		boolean condicionTiempoEspera = false;
		String path = "C:\\Users\\sseba\\Desktop\\";
		while (!condicion) {
			if (condicionTiempoEspera) {
				EntradaSalidaprofe.esperar();
			} else {
				condicionTiempoEspera = true;
			}

			int opcion = EntradaSalidaprofe.mostrarMenu();
			switch (opcion) {

			case 1:
				System.out.println(EntradaSalidaprofe.texto());
//				System.out.println("Introduce el nombre de la carpeta");
				String nombre = leerNom.next();
				File archivo = new File(path + nombre);
				archivo.mkdir();

				System.out.println(EntradaSalidaprofe.comprobacionEjecucion());

				break;
			case 2:
				System.out.println(EntradaSalidaprofe.texto());
//				System.out.println("Nombre de la carpeta para borrar");
				String nombre2 = leerNom.next();
				File archivo2 = new File(path + nombre2);

				if (archivo2.exists()) {
					archivo2.delete();
					EntradaSalidaprofe.valor = true;
					System.out.println(EntradaSalidaprofe.comprobacion2y4());

					// System.out.println("borrado");
				} else {
					EntradaSalidaprofe.valor = false;
					EntradaSalidaprofe.caso2o4 = true;
					System.out.println(EntradaSalidaprofe.comprobacion2y4());
//					System.out.println("No se ha encotrado la carpeta");

				}
				break;
			case 3:
				System.out.println(EntradaSalidaprofe.texto());
				// System.out.println("Nombre del Fichero para crear");
				String nombre3 = leerNom.next();
				File archivo3 = new File(path + nombre3);
				System.out.println(EntradaSalidaprofe.comprobacionEjecucion());

				try {
					archivo3.createNewFile();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 4:
				System.out.println(EntradaSalidaprofe.texto());
				// System.out.println("Nombre para borrar fichero");
				String nombre4 = leerNom.next();
				File archivo4 = new File(path + nombre4);

				if (archivo4.exists()) {
					archivo4.delete();
					EntradaSalidaprofe.valor = true;
					System.out.println(EntradaSalidaprofe.comprobacion2y4());
				} else {
					EntradaSalidaprofe.valor = false;
					EntradaSalidaprofe.caso2o4 = false;
					System.out.println(EntradaSalidaprofe.comprobacion2y4());

				}
				break;
			case 5:
				condicion = true;
				break;
			}
		}
		System.out.println(EntradaSalidaprofe.fin());
	}

}
