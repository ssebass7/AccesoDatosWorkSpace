package AplicaciónTaller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

public class ClasePrincipal {

	static ArrayList<Vehiculo> listaVehiculos = new ArrayList();;

	public static void main(String[] args) {

		int opcion = EntradaSalida.mostrarMenu();
		while (opcion != EntradaSalida.SALIR) {
			EntradaSalida.esperar();

			switch (opcion) {

			case EntradaSalida.NUEVO_VEHICULO:
				listaVehiculos = EntradaSalida.pedirVehiculo();
				boolean condicion = AccesoBD.grabarVehículo(listaVehiculos);
				EntradaSalida.mensajeConfirmacion(condicion);
				break;
			case EntradaSalida.LISTAR_VEHICULOS:
				ArrayList<String> strListaVehiculos = AccesoBD.listarVehiculo();
				EntradaSalida.pintarCoche(strListaVehiculos);
				break;
			case EntradaSalida.BUSCAR_VEHICULO:
				String matricula = EntradaSalida.pedirMatricula();
				ArrayList<String> strBusquedaListaVehiculos = AccesoBD.buscarPorMatricula(matricula);
				EntradaSalida.pintarCoche(strBusquedaListaVehiculos);

				break;

			case EntradaSalida.CREAR_COPIA:
				ArrayList<String> strCopiaListaVehiculos = AccesoBD.listarVehiculo();
				EntradaSalida.copiaCSV(strCopiaListaVehiculos);
				break;
			case EntradaSalida.SALIR:

				break;
			}
			EntradaSalida.esperar();
			opcion = EntradaSalida.mostrarMenu();
		}
		System.out.println("Cargando...");
		EntradaSalida.esperar();
		System.out.println(EntradaSalida.fin());
	}

}
