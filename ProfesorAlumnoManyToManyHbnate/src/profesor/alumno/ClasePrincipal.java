package profesor.alumno;

import java.util.List;

public class ClasePrincipal {

	public static void main(String[] args) {
		int opcion=EntradaSalida.mostrarMenu();
		AccesoBD.inicializarConexion();
	while(opcion!=6)
	{
		switch(opcion)
		{
		case 1:
			//Insertar profesor
			Profesor p=EntradaSalida.pedirDatosProfesor();
			AccesoBD.grabarProfesor(p);
			break;
		case 2:
			//Insertar alumno
			Alumno a=EntradaSalida.pedirDatosAlumno();
			/*En realidad grabarAlumno y grabarProfesor
			 *  hacen lo mismo. Pongo diferentes nombres por claridad*/
			AccesoBD.grabarAlumno(a);
			
			break;
		case 3:
			//Asociar profesor-alumno
			List<Profesor> lista_profesores=AccesoBD.recuperarProfesores();
			int id_profesor=EntradaSalida.seleccionarProfesor(lista_profesores);
			List<Alumno> lista_alumnos=AccesoBD.recuperarAlumnos();
			String id_alumnos=EntradaSalida.seleccionarAlumnos(lista_alumnos);
			/***id_alumnos es un String con los id de alumnos separador por comas*/
			AccesoBD.asociarProfesorAlumno(id_profesor, id_alumnos);
			break;
		case 4:
			//Listar profesores
			List<Profesor> profesores=AccesoBD.recuperarProfesores();
			EntradaSalida.mostrarProfesores(profesores);
			break;
		case 5:
			//Buscar profesor (por nombre)
			break;
		
		}
		 opcion=EntradaSalida.mostrarMenu();
	}
}

}
