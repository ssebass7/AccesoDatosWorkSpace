import java.util.ArrayList;
import java.util.List;

import javax.swing.text.TabableView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

public class ClasePrincipal {

	public static void main(String[] args) {

		Retrofit retrofit = new Retrofit.Builder().baseUrl("http://ovc.catastro.meh.es/ovcservweb/")
				.addConverterFactory(SimpleXmlConverterFactory.create()).build();
		ServicioAEMET servicio = retrofit.create(ServicioAEMET.class);
		Call<Raiz> llamada = servicio.pedirProvincia();
		llamada.enqueue(new Callback<Raiz>() {

			@Override
			public void onResponse(Call<Raiz> call, Response<Raiz> response) {
				Raiz r = response.body();
//				System.out.println("Datos: " + r);
				boolean condicionNull = AccesoBBDD.comprobarNull();
				List<Provincia> listaProvincias = r.getProvinciero();
				if (condicionNull) {

					EntradaSalida.menuSYSO(0);
					AccesoBBDD.grabarDatos(listaProvincias);

				} else {
					EntradaSalida.menuSYSO(1);

				}
				ArrayList<String> strListaDatos = AccesoBBDD.buscarDatos();
				boolean condicionConexion = AccesoBBDD.isCondicionConexion();
				if (condicionConexion) {
					EntradaSalida.menuSYSO(2);
				} else {
					EntradaSalida.menuSYSO(3);
				}
				EntradaSalida.pintarDatos(strListaDatos);
				EntradaSalida enSa = new EntradaSalida();
				String numProv = enSa.pedirMunicipios();

				Retrofit retrofitMun = new Retrofit.Builder().baseUrl("http://ovc.catastro.meh.es/ovcservweb/")
						.addConverterFactory(SimpleXmlConverterFactory.create()).build();
				ServicioAEMETMun servicioMun = retrofitMun.create(ServicioAEMETMun.class);
				Call<RaizProvMun> llamadaMun = servicioMun.pedirMunicipio();
				llamadaMun.enqueue(new Callback<RaizProvMun>() {

					@Override
					public void onResponse(Call<RaizProvMun> call, Response<RaizProvMun> response) {
						RaizProvMun r = response.body();
						List<Municipio> listaMunicipios = r.getMunicipiero();
						List<Municipio> listImprMunicipio = null;
						for (Municipio mun : listaMunicipios) {
							if (numProv.equals(String.valueOf(mun.getLocat()))) {
								listImprMunicipio.add(mun);
							}
							else {
								System.out.println("No existe la provincia");
							}
						}
						System.out.println("//Municipios//");
						for (int i = 0; i < listImprMunicipio.size(); i++) {
							System.out.println(listImprMunicipio.get(i));
						}

					}

					@Override
					public void onFailure(Call<RaizProvMun> call, Throwable t) {
						System.out.println("error: " + t.getLocalizedMessage());

					}
				});

			}

			@Override
			public void onFailure(Call<Raiz> call, Throwable t) {
				System.out.println("error: " + t.getLocalizedMessage());
			}
		});

	}

}
