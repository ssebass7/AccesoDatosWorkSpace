import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {
	public static void pintarDatos(ArrayList<String> strListaDatos) {
		System.out.println(" ");
		System.out.println("//Provincias registradas//\n");
		for (int i = 0; i < strListaDatos.size(); i++) {
			System.out.println(strListaDatos.get(i));
		}
	}
	
	public static String pedirMunicipios(){
		Scanner sc = new Scanner(System.in);
		
		System.out.println("//Mostrador Municipios//");
		System.out.println("Introduce el numero de provincia");
		String numProv = sc.nextLine();
		System.out.println("Cargando...");
		
		return numProv;
	}

	public static void menuSYSO(int num) {

		switch (num) {
		case 0:
			// BBDD VACIA
			System.out.println("//LA BASE DE DATOS ESTA VACIA//");
			break;
		case 1:
			// BBDD CON DATOS
			System.out.println("//LA BASE DE DATOS CONTIENE VALORES//");
			break;
		case 2:
			// BBDD CON DATOS
			System.out.println("//CONEXION REALIZADA//");
			break;
		case 3:
			// BBDD CON DATOS
			System.out.println("//CONEXION NO REALIZADA//");
			break;
		default:
			break;
		}

	}

}
