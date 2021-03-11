package paquete.ejemplofile;

import java.util.Scanner;

public class EntradaSalidaprofe {

	static int num;
	static boolean valor;
	static boolean caso2o4;

	public static void esperar() {
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			System.out.println("Fallo de espera");
		}
	}

	public static int mostrarMenu() {
		System.out.println(" ");
		System.out.println("MENU:");
		System.out.println("1-Crear carpeta  (introducir numero'1')");
		System.out.println("2-Borrar carpeta (introducir numero'2')");
		System.out.println("3-Crear fichero  (introducir numero'3')");
		System.out.println("4-Borrar fichero (introducir numero'4')");
		System.out.println("5-Salir          (introducir numero'5')");
		System.out.println("");
		System.out.println("Introduce un numero para realizar la función correspondiente:");
		Scanner sc = new Scanner(System.in);
		try {
			int num = sc.nextInt();
			EntradaSalidaprofe.num = num;
			if (num > 5) {
				System.out.println("//Introduce unicamente valores entre 1 y 5//");
			}
		} catch (Exception e) {
			System.out.println("//Introduce unicamente numeros//");
		}
		return num;
	}

	public static String texto() {
		String mensaje = " Introduce el nombre";
		if (num == 1)
			mensaje = mensaje + " de la carpeta:";
		if (num == 2)
			mensaje = mensaje + " de la carpeta a borrar:";
		if (num == 3)
			mensaje = mensaje + " del Fichero a crear:";
		if (num == 4)
			mensaje = mensaje + " para borrar fichero:";
		return mensaje;
	}

	public static String comprobacionEjecucion() {
		String mensaje = "";

		String mensajeTrue = "//Operación realizada//";
		mensaje = mensajeTrue;

		return mensaje;
	}

	public static String comprobacion2y4() {
		String mensaje = "";
		if (valor) {
			mensaje = "//Borrado//";

		} else {
			if (caso2o4) {
				mensaje = "//No se ha encotrado la carpeta//";
			} else {
				mensaje = "//No se ha encotrado el fichero//";

			}
		}

		return mensaje;
	}

	public static String fin() {
		String mensaje = "//Ha salido del sistema//";

		return mensaje;
	}

	{

	};
}
