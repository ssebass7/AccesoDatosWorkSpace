package profesor.alumno;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class Profesor {
	@Id
	@GeneratedValue
	private int id;
	
	private String nombre;
	@ManyToMany
	private List<Alumno> lista_alumnos;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public List<Alumno> getLista_alumnos() {
		return lista_alumnos;
	}
	public void setLista_alumnos(List<Alumno> lista_alumnos) {
		this.lista_alumnos = lista_alumnos;
	}
	@Override
	public String toString() {
		return "Profesor [id=" + id + ", nombre=" + nombre + ", lista_alumnos=" + lista_alumnos + "]";
	}
	
	
}
