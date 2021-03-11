
public class Cuadro {

	private String ruta_cuadro, titulo;

	public Cuadro(String ruta_cuadro, String titulo) {
		super();
		this.ruta_cuadro = ruta_cuadro;
		this.titulo = titulo;
	}

	public String getRuta_cuadro() {
		return ruta_cuadro;
	}

	public void setRuta_cuadro(String ruta_cuadro) {
		this.ruta_cuadro = ruta_cuadro;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Override
	public String toString() {
		return "Cuadro [ruta_cuadro=" + ruta_cuadro + ", titulo=" + titulo + "]";
	}
	
	
	
	
}
