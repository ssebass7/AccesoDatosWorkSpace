package AplicaciónTaller;

import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;


public class EntradaSalida {
	public static final int NUEVO_VEHICULO = 1;
	public static final int LISTAR_VEHICULOS = 2;
	public static final int BUSCAR_VEHICULO = 3;
	public static final int CREAR_COPIA = 4;
	public static final int SALIR = 5;
	private static boolean condicion = true;

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
		System.out.println(NUEVO_VEHICULO + "-NUEVO_VEHICULO");
		System.out.println(LISTAR_VEHICULOS + "-LISTAR_VEHICULOS");
		System.out.println(BUSCAR_VEHICULO + "-BUSCAR_VEHICULO");
		System.out.println(CREAR_COPIA + "-CREAR_COPIA");
		System.out.println(SALIR + "-SALIR");
		System.out.println("");
		System.out.println("Introduce un numero para realizar la función correspondiente:");
		Scanner sc = new Scanner(System.in);
		int num = 0;
		try {
			num = sc.nextInt();
			if (num > 5) {
				System.out.println("//Introduce unicamente valores entre 1 y 5//");
			}
		} catch (Exception e) {
			System.out.println("//Introduce unicamente numeros//");
		}
		return num;
	}

	public static String fin() {
		String mensaje = "//Ha salido del sistema//";

		return mensaje;
	}

	public static ArrayList pedirVehiculo() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Vehiculo> listaVehiculos = new ArrayList();
		Vehiculo v = new Vehiculo();
		System.out.println("Introduce la marca del vehiculo:");
		v.setMarca(sc.nextLine());
		System.out.println("Introduce el modelo del vehiculo:");
		v.setModelo(sc.nextLine());
		System.out.println("Introduce la potencia del vehiculo:");
		v.setPotencia(sc.nextLine());
		System.out.println("Introduce la matricula del vehiculo:");
		v.setMatricula(sc.nextLine());
		System.out.println("Introduce la averia del vehiculo:");
		v.setAveria(sc.nextLine());
		listaVehiculos.add(v);
		return listaVehiculos;

	}

	public static String pedirMatricula() {
		Scanner sc = new Scanner(System.in);
		String matricula = "";
		System.out.println("Introduce la matricula del vehículo a buscar:");
		matricula = sc.nextLine();

		return matricula;
	}

	public static void mensajeConfirmacion(boolean condicion) {
		String mensajeConf = "";
		EntradaSalida.condicion = condicion;
		if (condicion) {
			System.out.println("//Petición realizada correctamente//");
		} else {
			System.out.println("//ERROR.Petición no realizada//");
		}
	}

	public static void setCondicon(boolean condicion) {
		EntradaSalida.condicion = condicion;
	}

	public static boolean getCondicion() {
		return condicion;
	}

	public static void pintarCoche(ArrayList<String> strListaVehiculos) {
		System.out.println(" ");
		System.out.println("//Vehiculos Registrados//\n");
		for (int i = 0; i < strListaVehiculos.size(); i++) {
			System.out.println(strListaVehiculos.get(i));
		}
	}

	public static void copiaCSV(ArrayList<String> strCopiaListaVehiculos) {

		File f = new File(
				"C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\workspaceAD\\AccesoBBDD\\ficheroTaller\\ficheroVehiculos.csv");
		boolean condicion = true;
		try {
			FileWriter fw = new FileWriter(f);
			for (String copia : strCopiaListaVehiculos) {
				String linea = copia.replace("-", ";");
				fw.write(linea + "\n");
			}
			fw.close();
			condicion = true;
		} catch (Exception e) {
			condicion = true;
			e.printStackTrace();
		}
		EntradaSalida.mensajeConfirmacion(condicion);
	}
}
