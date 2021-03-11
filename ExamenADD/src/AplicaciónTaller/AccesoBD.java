package AplicaciónTaller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.w3c.dom.ls.LSInput;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class AccesoBD {

	static int precioProducto;
	static String nombreUsuario;

	public static Statement crearConexion() {
		Statement stmt = null;
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tienda_virtual", "root", "");
			stmt = c.createStatement();
			System.out.println("conexion realizada");
		} catch (SQLException e) {
			System.out.println("conexion no ejecutada");
			e.printStackTrace();

		}
		;
		return stmt;
	}

	public static ArrayList listarProductosCompra() {
		Statement stmt = AccesoBD.crearConexion();
		Producto prod = new Producto();
		ArrayList<Producto> listaProductosCompra = new ArrayList();

		String query = "SELECT * FROM tienda";
		try {
			ResultSet resultados = stmt.executeQuery(query);
			while (resultados.next()) {
				prod = new Producto();
				String nombreProducto = resultados.getString("producto");
				int precioProducto = resultados.getInt("precio");
				int stockProducto = resultados.getInt("stock");
				prod.setNombre(nombreProducto);
				prod.setPrecio(precioProducto);
				prod.setStock(stockProducto);
				listaProductosCompra.add(prod);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaProductosCompra;
	}

	public String realizarCompra(int numProducto, ArrayList<Producto> listaProductosCompra) {
		Statement stmt = AccesoBD.crearConexion();
		int cont = 0;
		String nombre = "";

		for (Producto producto : listaProductosCompra) {
			cont++;
			if (cont == numProducto) {
				nombre = producto.getNombre();
				precioProducto = producto.getPrecio() - 1;

			} else {
			
			}
		}
		String query = "UPDATE tienda SET stock = '" + precioProducto + "'  WHERE  '" + nombre + "'";

		try {
			int resultados = stmt.executeUpdate(query);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return nombre;

	}

	public int obtenerPrecioProducto() {
		return precioProducto;

	}

	public void crearCarrito(ArrayList<Producto> nombreProducto) {
		Statement stmt = AccesoBD.crearConexion();
		Producto prod = new Producto();

		for (Producto producto : nombreProducto) {

			String queryInsert = "INSERT INTO carrito_compra VALUES('" + producto.getNombre() + "','"
					+ producto.getPrecio() + "','" + producto.getStock() + "')";
			try {
				stmt.executeUpdate(queryInsert);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static ArrayList listarCarrito() {
		Statement stmt = AccesoBD.crearConexion();
		Producto prod = new Producto();
		ArrayList<Producto> listaCarrito = new ArrayList();

		String query = "SELECT * FROM carrito_compra";
		try {
			ResultSet resultados = stmt.executeQuery(query);
			while (resultados.next()) {
				prod = new Producto();
				String nombreProducto = resultados.getString("producto");
				int precioProducto = resultados.getInt("precio");
				int stockProducto = resultados.getInt("stock");
				prod.setNombre(nombreProducto);
				prod.setPrecio(precioProducto);
				prod.setStock(stockProducto);
				listaCarrito.add(prod);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaCarrito;
	}

	public int obtenerSaldoUsuario(String nombreUsuario) {
		Statement stmt = AccesoBD.crearConexion();
		String query = "SELECT saldo FROM usuarios WHERE nombre = '" + nombreUsuario + "'";
		Producto prod = new Producto();
		int saldo = 0;
		try {
			ResultSet resultados = stmt.executeQuery(query);
			while (resultados.next()) {

				saldo = resultados.getInt("saldo");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return saldo;
	}

	public boolean obtenerNombreUsuario(String nombreUsuarioTeclado) {
		Statement stmt = AccesoBD.crearConexion();
		String query = "SELECT * FROM usuarios";
		boolean condicion = true;
		try {
			ResultSet resultados = stmt.executeQuery(query);
			while (resultados.next()) {

				String nombre = resultados.getString("nombre");
				String saldo = resultados.getString("saldo");
				if (nombreUsuarioTeclado.equals(nombre)) {
					condicion = true;
				} else {
					condicion = false;
				}

			}

		} catch (SQLException e) {
			condicion = false;
			e.printStackTrace();
		}
		return condicion;
	}

	public ArrayList listarUsuarios() {
		Statement stmt = AccesoBD.crearConexion();
		Usuario us = new Usuario();
		ArrayList<Usuario> listaUsuarios = new ArrayList();

		String query = "SELECT * FROM usuarios";
		try {
			ResultSet resultados = stmt.executeQuery(query);
			while (resultados.next()) {
				String nombreUsiario = resultados.getString("nombre");
				int saldoUsuario = resultados.getInt("saldo");
				us.setNombre(nombreUsiario);
				us.setSaldo(saldoUsuario);
				listaUsuarios.add(us);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listaUsuarios;
	}

	public ArrayList buscarValoresPorNombre(String nombreProducto) {
		Statement stmt = AccesoBD.crearConexion();
		Producto prod = new Producto();
		String querySelect = "SELECT * FROM tienda WHERE producto = '" + nombreProducto + "'";
		ArrayList<Producto> listaProductosPorNombre = new ArrayList();
		try {
			ResultSet resultados = stmt.executeQuery(querySelect);
			while (resultados.next()) {
				String nombreProductoReal = resultados.getString("producto");
				int precioProducto = resultados.getInt("precio");
				int stockProducto = resultados.getInt("stock");
				prod.setNombre(nombreProducto);
				prod.setPrecio(precioProducto);
				prod.setStock(stockProducto);
				listaProductosPorNombre.add(prod);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return listaProductosPorNombre;
	}

	private void cambiarValoresSaldo(int precioProducto) {
		ClasePrincipal cl = new ClasePrincipal();
		Statement stmt = AccesoBD.crearConexion();
		nombreUsuario = cl.nombreUsuario;
		int saldoUsuario = obtenerSaldoUsuario(nombreUsuario);
		String query = "UPDATE usuarios SET saldo = '" + (saldoUsuario - precioProducto) + "'  WHERE  '" + nombreUsuario
				+ "'";

		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void cambiarValoresStock(int stock, String nombreProducto) {
		Statement stmt = AccesoBD.crearConexion();
		String query = "UPDATE tienda SET stock = '" + (stock - 1) + "'  WHERE  '" + nombreProducto + "'";

		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
