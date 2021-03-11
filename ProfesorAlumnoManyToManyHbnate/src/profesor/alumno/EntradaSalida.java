package profesor.alumno;

import java.util.List;
import java.util.Scanner;

public class EntradaSalida {

	public static Profesor pedirDatosProfesor() {
		// TODO Auto-generated method stub
		Profesor p=new Profesor();
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el nombre del profesor: ");
		String nombre=sc.nextLine();
		p.setNombre(nombre);
		return p;
	}

	public static Alumno pedirDatosAlumno() {
		Alumno p=new Alumno();
		Scanner sc=new Scanner(System.in);
		System.out.println("Introduce el nombre del alumno: ");
		String nombre=sc.nextLine();
		p.setNombre(nombre);
		return p;
	}

	public static int mostrarMenu() {
		/*1-Insertar profesor
2-Insertar alumno
3-Asociar profesor-alumno*/
		System.out.println("Elija una opción:");
		System.out.println("1-Insertar profesor");
		System.out.println("2-Insertar alumno");
		System.out.println("3-Asociar profesor-alumno");
		System.out.println("4-Listar profesores");
		System.out.println("5-Buscar profesor (por nombre)");
		System.out.println("6-Salir");
		Scanner sc=new Scanner(System.in);
		int opcion=sc.nextInt();
		return opcion;
	}

	public static int seleccionarProfesor(List<Profesor> lista_profesores) {
	for (Profesor p: lista_profesores)
	{
		System.out.println(p.getId()+"-"+p.getNombre());
	}
	Scanner sc=new Scanner(System.in);
	int opcion=sc.nextInt();
	return opcion;
	}

	public static String seleccionarAlumnos(List<Alumno> lista_alumnos) {
		for (Alumno p: lista_alumnos)
		{
			System.out.println(p.getId()+"-"+p.getNombre());
		}
		Scanner sc=new Scanner(System.in);
		String ids=sc.nextLine();
		return ids;
	}

	public static void mostrarProfesores(List<Profesor> profesores) {
		for(Profesor p: profesores)
		{
			System.out.println("NOMBRE PROFESOR: "+p.getNombre()+"\n");
			System.out.println("ALUMNOS: "+"\n");
			for (Alumno a: p.getLista_alumnos())
			{
				if(a!=null)
				{
				System.out.println(a.getNombre()+"\n");
				}
				
			}
			System.out.println("****************\n");
			
		}
		
	}

}
