package AplicaciónTaller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class ClasePrincipal {

	static ArrayList<Producto> listaProductosCompra = new ArrayList();
	static ArrayList<Producto> listaCarrito = new ArrayList();
	static AccesoBD acBBDD = new AccesoBD();
	static EntradaSalida entSal = new EntradaSalida();
	static String nombreUsuario;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		nombreUsuario = sc.nextLine();
		boolean condicion = acBBDD.obtenerNombreUsuario(nombreUsuario);
		if (condicion) {
			int opcion = entSal.mostrarMenu();
			while (opcion != entSal.SALIR) {
				entSal.esperar();

				switch (opcion) {

				case EntradaSalida.COMPRAR:
					listaProductosCompra = acBBDD.listarProductosCompra();
					entSal.pintarListaCompra(listaProductosCompra);
					int numProducto = entSal.pedirCompra();
					String nombreProducto = acBBDD.realizarCompra(numProducto, listaProductosCompra);
					ArrayList<Producto> listaProductosPorNombre = acBBDD.buscarValoresPorNombre(nombreProducto);
					acBBDD.crearCarrito(listaProductosPorNombre);
					System.out.println("Lista Carrito creada");

					break;
				case EntradaSalida.VER_PRODUCTOS_COMPRADOS:
					ArrayList<Producto> listaCarrito = acBBDD.listarCarrito();
					entSal.pintarCarrito(listaCarrito);
					break;
				case EntradaSalida.VER_SALDO:
					int saldo = acBBDD.obtenerSaldoUsuario(nombreUsuario);
					entSal.pintarSaldo(saldo);
					break;

				case EntradaSalida.VOLCAR_EN_CSV:

					ArrayList<String> strlistaProductosCompra = entSal
							.pasarProductosArrayString(acBBDD.listarProductosCompra());
					entSal.copiaCSVlistaTienda(strlistaProductosCompra);

					ArrayList<String> strlistaUsuarios = entSal.pasarUsuariosArrayString(acBBDD.listarUsuarios());
					entSal.copiaCSVusuarios(strlistaUsuarios);
					break;
				case EntradaSalida.SALIR:

					break;
				}
				entSal.esperar();
				opcion = entSal.mostrarMenu();
			}
		}
		System.out.println("Cargando...");
		entSal.esperar();
		System.out.println(entSal.fin());
	}

}
