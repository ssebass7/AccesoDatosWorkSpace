import java.util.ArrayList;

public class Persona {
	public  Persona(String nombre, String apellido, String edad) {
		String persona = "*Nombre: " + nombre + " *Apellido: " + apellido + " *Edad: " + edad;
		EjercicioSplit.listaPersona.add(persona);
	
	}
}
