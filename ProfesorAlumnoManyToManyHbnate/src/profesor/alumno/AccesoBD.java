package profesor.alumno;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

public class AccesoBD {
	static StandardServiceRegistry s=null;
	static SessionFactory sf=null;
	static Session sesion=null;
	public static void inicializarConexion()
	{
		s=new StandardServiceRegistryBuilder().configure().build();
		sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
		sesion=sf.openSession();
	}
	public static void grabarProfesor(Profesor p) {
		Transaction t=sesion.beginTransaction();
		sesion.save(p);
		t.commit();
		
	}

	public static void grabarAlumno(Alumno a) {
		 Transaction t=sesion.beginTransaction();
		sesion.save(a);
		t.commit();
		
	}

	public static List<Profesor> recuperarProfesores() {
		Query<Profesor> q=sesion.createQuery("FROM Profesor");
		
		return q.getResultList();
	}

	public static List<Alumno> recuperarAlumnos() {
		Query<Alumno> q=sesion.createQuery("FROM Alumno");
		return q.getResultList();
	}

	public static void asociarProfesorAlumno(int id_profesor, String id_alumnos) {
		Profesor p=recuperarProfesorPorId(id_profesor);
		String query = "from Alumno where id in (:ids)";
		String []ids=id_alumnos.split(",");
		List<Integer> lista_ids=new ArrayList();
		for (String id: ids)
		{
			lista_ids.add(Integer.valueOf(id));
		}
		Query q = sesion.createQuery(query);
		q.setParameter("ids", lista_ids);
		List<Alumno> alumnos=q.getResultList();
		List<Profesor> lista_profesores=new ArrayList();
		lista_profesores.add(p);
		p.setLista_alumnos(alumnos);
		Transaction t=sesion.beginTransaction();
		for (Alumno a: alumnos)
		{
			a.setProfesores(lista_profesores);
			sesion.update(a);
		}
		sesion.update(p);
		t.commit();
	}
	public static Profesor recuperarProfesorPorId(int id)
	{
		Query<Profesor> q=sesion.createQuery("FROM Profesor WHERE id="+id);
		
		return q.getSingleResult();
	}
	public static Alumno recuperarAlumnoPorId(int id)
	{
		Query<Alumno> q=sesion.createQuery("FROM Alumno WHERE id="+id);
		
		return q.getSingleResult();
	}

}
