package paquete.persona;

import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Entity;

@Entity
public class Cliente {
	@Id 
	
	private int id;
	
	private String nombre_calle;
	
	private int numero_calle;
	
	@OneToOne
	private Producto persona;

	
	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getNombre_calle() {
		return nombre_calle;
	}




	public void setNombre_calle(String nombre_calle) {
		this.nombre_calle = nombre_calle;
	}




	public int getNumero_calle() {
		return numero_calle;
	}




	public void setNumero_calle(int numero_calle) {
		this.numero_calle = numero_calle;
	}




	public Producto getPersona() {
		return persona;
	}




	public void setPersona(Producto persona) {
		this.persona = persona;
	}




	@Override
	public String toString() {
		return "Direccion [id=" + id + ", nombre_calle=" + nombre_calle + ", numero_calle=" + numero_calle + "]";
	}
	
	
}
