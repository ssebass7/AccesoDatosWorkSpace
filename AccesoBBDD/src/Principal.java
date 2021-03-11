import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

public class Principal {
	public static void main(String[] args) {
		try {
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "root", "");
			Statement stmt = c.createStatement();
			String query = "INSERT into alumnos VALUES('Pepe','Perez',10)";
			String query2 = "SELECT * FROM alumnos";
			stmt.executeUpdate(query);
			ResultSet resultados = stmt.executeQuery(query2);
			while (resultados.next()) {
				String nombre = resultados.getString("nombre");
				String apellido = resultados.getString("apellido");
				System.out.println(nombre + " " + apellido);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
