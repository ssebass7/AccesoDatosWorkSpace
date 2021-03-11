package paquete.persona;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Entity;

@Entity
public class Producto {

	@Id
	@GeneratedValue
	private int id;
	private String nombre, apellido;
	
	@OneToOne/*One Persona to One Direccion*/
	/*Si ponemos @AToB A se refiere a la entidad y B a la propiedad*/
	
	private Cliente direccion;

	
	
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



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public Cliente getDireccion() {
		return direccion;
	}



	public void setDireccion(Cliente direccion) {
		this.direccion = direccion;
	}



	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion + "]";
	}
	
	
}
