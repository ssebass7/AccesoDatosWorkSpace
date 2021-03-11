package paquete.ejemplofileprofe;

import java.io.File;

public class ClasePrincipalprofe {
	static boolean todoCorrecto = true;

	public static void main(String[] args) {
		int opcion = 0;

		opcion = EntradaSalidaprofe.mostrarMenu();

		File f;
		String ruta_base = "C:\\Users\\sseba\\Desktop\\";
		while (opcion != EntradaSalidaprofe.SALIR) {
			while (todoCorrecto == false) {
				AccesoFichero.esperar();
				opcion = EntradaSalidaprofe.mostrarMenu();
			}
			while (opcion != EntradaSalidaprofe.SALIR) {
				String nombre = EntradaSalidaprofe.preguntarNombre();
				String ruta_completa = ruta_base + nombre;
				switch (opcion) {
				case EntradaSalidaprofe.CREAR_CARPETA:
					int codigo_respuesta = AccesoFichero.crearCarpeta(ruta_completa);
					EntradaSalidaprofe.mostrarRespuesta(codigo_respuesta);
					todoCorrecto = false;
					break;
				case EntradaSalidaprofe.BORRAR_CARPETA:
					codigo_respuesta = AccesoFichero.borrarCarpeta(ruta_completa);
					EntradaSalidaprofe.mostrarRespuesta(codigo_respuesta);
					todoCorrecto = false;
					break;
				case EntradaSalidaprofe.CREAR_FICHERO:
					codigo_respuesta = AccesoFichero.crearFichero(ruta_completa);
					EntradaSalidaprofe.mostrarRespuesta(codigo_respuesta);
					todoCorrecto = false;
					break;
				case EntradaSalidaprofe.BORRAR_FICHERO:
					codigo_respuesta = AccesoFichero.borrarFichero(ruta_completa);
					EntradaSalidaprofe.mostrarRespuesta(codigo_respuesta);
					todoCorrecto = false;
					break;

				}
				while (todoCorrecto == false) {
					AccesoFichero.esperar();
					opcion = EntradaSalidaprofe.mostrarMenu();
				}
			}

		}
		int codigo_respuesta = AccesoFichero.salir();
		EntradaSalidaprofe.mostrarRespuesta(codigo_respuesta);
	}

}
