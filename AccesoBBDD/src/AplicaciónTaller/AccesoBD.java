package AplicaciónTaller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.ls.LSInput;

import com.mysql.cj.jdbc.DatabaseMetaData;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

public class AccesoBD {

	public static Statement crearConexion() {
		Statement stmt = null;
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/TallerCoches", "root", "");
			stmt = c.createStatement();
			System.out.println("conexion realizada");
		} catch (SQLException e) {
			System.out.println("conexion no ejecutada");
			e.printStackTrace();

		}
		;
		return stmt;
	}

	public static ArrayList listarVehiculo() {
		Statement stmt = AccesoBD.crearConexion();
		ArrayList<String> strListaVehiculos = new ArrayList();

		String query = "SELECT * FROM taller";
		try {
			ResultSet resultados = stmt.executeQuery(query);
			while (resultados.next()) {
				String marca = resultados.getString("marca");
				String modelo = resultados.getString("modelo");
				String potencia = resultados.getString("potencia");
				String matricula = resultados.getString("matricula");
				String averia = resultados.getString("averia");
				String strVehiculos = (marca + "-" + modelo + "-" + potencia + "-" + matricula + "-" + averia);
				strListaVehiculos.add(strVehiculos);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return strListaVehiculos;
	}

	public static boolean grabarVehículo(ArrayList<Vehiculo> listaVehiculos) {
		Statement stmt = AccesoBD.crearConexion();
		Vehiculo v = listaVehiculos.get(0);

		String query = "INSERT INTO taller VALUES('" + v.getMarca() + "','" + v.getModelo() + "','" + v.getPotencia()
				+ "','" + v.getMatricula() + "','" + v.getAveria() + "')";
		boolean condicion = true;
		try {
			condicion = true;
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
			condicion = false;
		}
		return condicion;

	}

	public static ArrayList buscarPorMatricula(String matricula) {
		Statement stmt = AccesoBD.crearConexion();

		String query = "SELECT * FROM taller WHERE matricula = '" + matricula + "'";
		ArrayList<String> strListaVehiculos = new ArrayList();
		boolean condicion = true;
		try {
			ResultSet resultados = stmt.executeQuery(query);

			while (resultados.next()) {
				String marca = resultados.getString("marca");
				String modelo = resultados.getString("modelo");
				String potencia = resultados.getString("potencia");
				String matricula2 = resultados.getString("matricula");
				String averia = resultados.getString("averia");
				String resutadoBuscqueda = (marca + "-" + modelo + "-" + potencia + "-" + matricula + "-" + averia);
				strListaVehiculos.add(resutadoBuscqueda);
			}
			condicion = true;
		} catch (SQLException e) {
			condicion = false;
			e.printStackTrace();
		}
		EntradaSalida.mensajeConfirmacion(condicion);
		return strListaVehiculos;
	}
}
