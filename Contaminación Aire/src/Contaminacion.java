import java.util.ArrayList;

public class Contaminacion {
	private String estacion, magnitud, ano, mes, dia;
	ArrayList<Float> listaH;

	public Contaminacion(String estacion, String magnitud, String ano, String mes, String dia,
			ArrayList<Float> listaH) {

		this.estacion = estacion;
		this.magnitud = magnitud;
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
		this.listaH = listaH;

	}

	public String getEstacion() {
		return estacion;
	}

	public String getMagnitud() {
		return magnitud;
	}

	public String getAno() {
		return ano;
	}

	public String getMes() {
		return mes;
	}

	public String getDia() {
		return dia;
	}

	public ArrayList<Float> getListaH() {
		return listaH;
	}

//	public void setListaH(ArrayList<String> listaH) {
//		this.listaH = listaH;
//	}

//	public void setEstacion(String estacion) {
//		this.estacion = estacion;
//	}
//
//	public void setMagnitud(String magnitud) {
//		this.magnitud = magnitud;
//	}
//
//	public void setAno(String ano) {
//		this.ano = ano;
//	}
//
//	public void setMes(String mes) {
//		this.mes = mes;
//	}
//
//	public void setDia(String dia) {
//		this.dia = dia;
//	}
//
//	public void setH(String h) {
//		this.h = h;
//	}

}
