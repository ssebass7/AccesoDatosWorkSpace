import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.ls.LSInput;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Vehiculo> listaVehiculos = new ArrayList();
		Vehiculo v = new Vehiculo();
		String peticion = sc.nextLine();
		System.out.println("Introduce la marca del vehiculo");
		v.setMarca(sc.nextLine());
		System.out.println("Introduce el modelo del vehiculo");
		v.setModelo(sc.nextLine());
		System.out.println("Introduce la potencia del vehiculo");
		v.setPotencia(sc.nextLine());
		System.out.println("Introduce la matricula del vehiculo");
		v.setMatricula(sc.nextLine());
		System.out.println("Introduce la averia del vehiculo");
		v.setAveria(sc.nextLine());
		listaVehiculos.add(v);
		}
	}
