public class Covid_19 {

	private String fecha, num_casos, num_casos_prueba_pcr;

	public Covid_19(String fecha, String num_casos, String num_casos_prueba_pcr) {

		this.fecha = fecha;
		this.num_casos = num_casos;
		this.num_casos_prueba_pcr = num_casos_prueba_pcr;

	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNum_casos() {
		return num_casos;
	}

	public void setNum_casos(String num_casos) {
		this.num_casos = num_casos;
	}

	public String getNum_casos_prueba_pcr() {
		return num_casos_prueba_pcr;
	}

	public void setNum_casos_prueba_pcr(String num_casos_prueba_pcr) {
		this.num_casos_prueba_pcr = num_casos_prueba_pcr;
	}

}
