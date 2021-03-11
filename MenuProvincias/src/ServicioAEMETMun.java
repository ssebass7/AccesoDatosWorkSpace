import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioAEMETMun {
	@GET("ovcswlocalizacionrc/ovccallejero.asmx/ConsultaMunicipio?Provincia=madrid&Municipio=")
	Call<RaizProvMun> pedirMunicipio();
}
