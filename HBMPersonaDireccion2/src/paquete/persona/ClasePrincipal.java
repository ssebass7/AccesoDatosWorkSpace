package paquete.persona;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class ClasePrincipal {

	public static void main(String[] args) {/*
		Persona p = new Persona();
		p.setApellido("Perez");
		p.setNombre("Manuel");
	*/
		Direccion d = new Direccion();
		d.setNombre_calle("Calle Pez");
		d.setNumero_calle(8);
		/*d.setPersona(p);
		p.setDireccion(d);*/
		
		StandardServiceRegistry s=new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
		Session sesion=sf.openSession();
		Query q1 = sesion.createQuery("From Persona where apellido = 'Sin direccion'");
		Persona persona_buscada = (Persona) q1.getResultList().get(0);
		d.setPersona(persona_buscada);
		Transaction t = sesion.beginTransaction();
		persona_buscada.setDireccion(d);
		sesion.save(d);
		sesion.save(persona_buscada);
		t.commit();
		Query q = sesion.createQuery("From Persona");
		List<Persona> lista_personas = q.getResultList();
		for(Persona persona:lista_personas) {
			System.out.println(persona);
		}
	}
}
