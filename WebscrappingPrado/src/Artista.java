import java.util.List;

public class Artista {

	private String nombre;
	private List<Cuadro> listaObras;

	public Artista(String nombre, List<Cuadro> listaObras) {
		super();
		this.nombre = nombre;
		this.listaObras = listaObras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cuadro> getListaObras() {
		return listaObras;
	}

	public void setListaObras(List<Cuadro> listaObras) {
		this.listaObras = listaObras;
	}

	@Override
	public String toString() {
		return "Artista [nombre=" + nombre + ", listaObras=" + listaObras + "]";
	}

}
