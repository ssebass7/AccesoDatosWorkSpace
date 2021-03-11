import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicioAEMET {
	@GET("ovcswlocalizacionrc/ovccallejero.asmx/ConsultaProvincia")
	Call<Raiz> pedirProvincia();
	
}
