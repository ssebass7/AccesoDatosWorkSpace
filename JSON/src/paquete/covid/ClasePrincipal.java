package paquete.covid;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ClasePrincipal {

//	public static String tabla;

	public static void main(String[] args) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://datos.comunidad.madrid/")
				.addConverterFactory(GsonConverterFactory.create()).build();

		InterfazCOVID service = retrofit.create(InterfazCOVID.class);
		Call<Data> llamada = service.recuperaIncidencias();
		llamada.enqueue(new Callback<Data>() {

			@Override
			public void onResponse(Call<Data> call, Response<Data> response) {
				// TODO Auto-generated method stub

				Data d = response.body();
				System.out.println("TODO HA IDO BIEN");

				List<Incidencia> incidencias = d.getData();
				String tabla = TablaHTML.crearTablaHTML(incidencias);
				AccesoFichero.fileWriter(tabla);

			}

			@Override
			public void onFailure(Call<Data> call, Throwable t) {
				// TODO Auto-generated method stub

				System.out.println("Ha habido un fallo: " + t.getMessage());
			}
		});
		System.out.println("hola buenas");
	}
}
