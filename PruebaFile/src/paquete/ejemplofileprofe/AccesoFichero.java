package paquete.ejemplofileprofe;

import java.io.File;
import java.io.IOException;

public class AccesoFichero {
	public static void esperar() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			System.out.println("Fallo de espera");
		}
	}

	public static int crearCarpeta(String ruta_completa) {
		// TODO Auto-generated method stub
		File f = new File(ruta_completa);

		int codigo = 0;
		if (f.isDirectory()) {
			codigo = 4;

		} else {
			try {
				boolean creado = f.mkdir();
				if (creado) {
					codigo = 0;
					EntradaSalidaprofe.tipo = "Carpeta creada";
				} else {
					codigo = 1;
					EntradaSalidaprofe.tipo = "borrar la carpeta";
				}
			} catch (SecurityException e) {
				codigo = 2;
			}
		}
		return codigo;
	}

	public static int borrarCarpeta(String ruta_completa) {

		File f = new File(ruta_completa);
		int codigo = 0;
		if (f.exists()) {
			f.delete();
			codigo = 0;
			EntradaSalidaprofe.tipo = "Carpeta borrada";

		} else {
			codigo = 1;
			EntradaSalidaprofe.tipo = "borrar la carpeta";
		}
		return codigo;
	}

	public static int crearFichero(String ruta_completa) {

		File f = new File(ruta_completa);

		int codigo = 0;
		if (f.isFile()) {
			codigo = 4;
		} else {
			try {
				boolean creado = f.createNewFile();
				if (creado) {
					codigo = 0;
					EntradaSalidaprofe.tipo = "Fichero creado";
				} else {
					codigo = 1;
				}

			} catch (IOException e) {
				codigo = 2;
				EntradaSalidaprofe.tipo = "crear el fichero";
			}

		}
		return codigo;
	}

	public static int borrarFichero(String ruta_completa) {

		File f = new File(ruta_completa);
		int codigo = 0;
		if (f.exists()) {
			f.delete();
			codigo = 0;
			EntradaSalidaprofe.tipo = "Fichero borrado";

		} else {
			codigo = 1;
			EntradaSalidaprofe.tipo = "borrar el fichero";
		}
		return codigo;
	}

	public static int salir() {

		int codigo = 5;
		return codigo;
	}

}
