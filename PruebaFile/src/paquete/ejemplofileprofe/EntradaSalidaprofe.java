package paquete.ejemplofileprofe;

import java.util.Scanner;

public class EntradaSalidaprofe {
	public static final int CREAR_CARPETA = 1;
	public static final int BORRAR_CARPETA = 2;
	public static final int CREAR_FICHERO = 3;
	public static final int BORRAR_FICHERO = 4;
	public static final int SALIR = 5;

	public static String tipo;

	public static int mostrarMenu() {
		System.out.println(CREAR_CARPETA + "-CREAR CARPETA");
		System.out.println(BORRAR_CARPETA + "-BORRAR CARPETA");
		System.out.println(CREAR_FICHERO + "-CREAR FICHERO");
		System.out.println(BORRAR_FICHERO + "-BORRAR FICHERO");
		System.out.println(SALIR + "-SALIR");
		System.out.println("Introduce el numero correspondiente para realizar la función:");
		Scanner sc = new Scanner(System.in);
		int opcion = 0;
		try {
			opcion = sc.nextInt();
			if (opcion > 5) {
				ClasePrincipalprofe.todoCorrecto = false;
				System.out.println("//Introduce unicamente valores entre 1 y 5//");
			} else {
				ClasePrincipalprofe.todoCorrecto = true;
			}

		} catch (Exception e) {
			ClasePrincipalprofe.todoCorrecto = false;
			System.out.println("//Introduce unicamente numeros//");
		}
		return opcion;
	}

	public static String preguntarNombre() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Escriba el nombre");
		String nombre = sc.nextLine();
		return nombre;

	}

	public static void mostrarRespuesta(int codigo_respuesta) {
		switch (codigo_respuesta) {
		case 0:
			System.out.println(tipo + " correctamente");
			break;
		case 1:
			System.out.println("No se ha podido " + tipo + "");
			break;
		case 2:
			System.out.println("Ha habido algún problema de seguridad");
			break;
		case 4:
			System.out.println("Ya existe. No se puede crear");
			break;
		case 5:
			System.out.println("Esperando...");
			AccesoFichero.esperar();
			System.out.println("Saliste del sistema");
			break;
		}
	}
}
