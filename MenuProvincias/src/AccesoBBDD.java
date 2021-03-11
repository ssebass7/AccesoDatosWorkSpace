import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AccesoBBDD {

	private static boolean condicionConexion;

	public static boolean isCondicionConexion() {
		return condicionConexion;
	}

	public static void setCondicionConexion(boolean condicionConexion) {
		AccesoBBDD.condicionConexion = condicionConexion;
	}

	public static Statement crearConexion() {
		Statement stmt = null;
		boolean condicionConexion = true;
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/Provincias", "root", "");
			stmt = c.createStatement();
			condicionConexion = true;
//			System.out.println("conexion realizada");
		} catch (SQLException e) {
			condicionConexion = false;
//			System.out.println("conexion no ejecutada");
			e.printStackTrace();

		}
		setCondicionConexion(condicionConexion);

		return stmt;
	}

	public static boolean comprobarNull() {

		Statement stmt = crearConexion();

		String query = "SELECT * FROM provinciasxml";

		boolean condicionNull = true;

		try {
			ResultSet resultados = stmt.executeQuery(query);
			if (resultados.next() == false) {
				condicionNull = true;
			} else {
				condicionNull = false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return condicionNull;

	}

	public static void grabarDatos(List<Provincia> listaProvincias) {

		Statement stmt = AccesoBBDD.crearConexion();

		for (int i = 0; i < listaProvincias.size(); i++) {

			Provincia p = listaProvincias.get(i);
			String query = "INSERT INTO provinciasxml VALUES('" + p.getCpine() + "','" + p.getNp() + " ')";
			try {
				stmt.executeUpdate(query);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public static ArrayList buscarDatos() {
		Statement stmt = AccesoBBDD.crearConexion();

		String query = "SELECT * FROM provinciasxml";
		ArrayList<String> strListaVehiculos = new ArrayList();
		boolean condicion = true;
		try {
			ResultSet resultados = stmt.executeQuery(query);

			while (resultados.next()) {
				String codigo = resultados.getString("codigo");
				String nombre = resultados.getString("nombre");
				String resutadoBuscqueda = (codigo + "-" + nombre);
				strListaVehiculos.add(resutadoBuscqueda);
			}
			condicion = true;
		} catch (SQLException e) {
			condicion = false;
			e.printStackTrace();
		}
		return strListaVehiculos;
	}

}
