package AplicaciónTaller;

import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class EntradaSalida {
	public static final int COMPRAR = 1;
	public static final int VER_PRODUCTOS_COMPRADOS = 2;
	public static final int VER_SALDO = 3;
	public static final int VOLCAR_EN_CSV = 4;
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
		Scanner sc = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("MENU:");
		System.out.println(COMPRAR + "-COMPRAR");
		System.out.println(VER_PRODUCTOS_COMPRADOS + "-VER_PRODUCTOS_COMPRADOS");
		System.out.println(VER_SALDO + "-VER_SALDO");
		System.out.println(VOLCAR_EN_CSV + "-VOLCAR_EN_CSV");
		System.out.println(SALIR + "-SALIR");
		System.out.println("");
		System.out.println("Introduce un numero para realizar la función correspondiente:");
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

	public static void pintarListaCompra(ArrayList<Producto> ListaProductosCompra) {
		System.out.println(" ");
		System.out.println("//Productos de la tienda//\n");
		int cont = 0;
		for (Producto producto : ListaProductosCompra) {
			cont++;
			System.out.println(cont + "-" + producto.getNombre() + "(" + producto.getPrecio() + "€)");
		}
	}

	public static void copiaCSVlistaTienda(ArrayList<String> strCopiaListaTienda) {

		File f = new File(
				"C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\workspaceAD\\ExamenADD\\ficheroExamenADD\\ficheroTienda.csv");
		boolean condicion = true;
		try {
			FileWriter fw = new FileWriter(f);
			for (String copia : strCopiaListaTienda) {

				fw.write(copia + "\n");
			}
			fw.close();
			condicion = true;
		} catch (Exception e) {
			condicion = true;
			e.printStackTrace();
		}
		EntradaSalida.mensajeConfirmacion(condicion);
	}

	public static void copiaCSVusuarios(ArrayList<String> strCopiaListaUsuarios) {

		File f = new File(
				"C:\\Users\\sseba\\Desktop\\Sebas\\DAM2\\Acceso a Datos\\workspaceAD\\ExamenADD\\ficheroExamenADD\\ficheroUsuarios.csv");
		boolean condicion = true;
		try {
			FileWriter fw = new FileWriter(f);
			for (String copia : strCopiaListaUsuarios) {
				fw.write(copia + "\n");
			}
			fw.close();
			condicion = true;
		} catch (Exception e) {
			condicion = true;
			e.printStackTrace();
		}
		EntradaSalida.mensajeConfirmacion(condicion);
	}

	public static int pedirCompra() {
		Scanner sc = new Scanner(System.in);
		int numProducto = 0;
		System.out.println("Introduce el producto que desea comprar:");
		numProducto = sc.nextInt();

		return numProducto;

	}

	public static void pintarCarrito(ArrayList<Producto> carritoCompra) {
		System.out.println(" ");
		System.out.println("//Tu Carrito de la Compra//\n");
		int cont = 0;
		for (Producto producto : carritoCompra) {
			cont++;
			System.out.println(cont + "-" + producto.getNombre() + "(" + producto.getPrecio() + ")");
		}
	}

	public static void pintarSaldo(int saldo) {

		System.out.println("El sueldo del usuario es: " + saldo + "€");
	}

	public static ArrayList pasarProductosArrayString(ArrayList<Producto> listaProductosCompra) {
		ArrayList<String> strlistaProductosCompra = new ArrayList();
		for (Producto producto : listaProductosCompra) {
			String linea = "" + producto.getNombre() + ";" + producto.getPrecio() + ";" + producto.getStock() + ";";
			strlistaProductosCompra.add(linea);
		}
		return strlistaProductosCompra;

	}

	public static ArrayList pasarUsuariosArrayString(ArrayList<Usuario> listaUsuarios) {
		ArrayList<String> strlistaUsuarios = new ArrayList();

		for (Usuario usuario : listaUsuarios) {
			String linea = "" + usuario.getNombre() + ";" + usuario.getSaldo() + ";";
			strlistaUsuarios.add(linea);
		}
		return strlistaUsuarios;

	}
}
