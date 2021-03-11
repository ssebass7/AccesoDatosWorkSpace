package paquete.persona;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;


public class ClasePrincipal {

	public static void main(String[] args) {
		Producto p = new Producto();
		p.setApellido("Perez");
		p.setNombre("Manuel");
		Cliente d = new Cliente();
		d.setNombre_calle("Calle Pez");
		d.setNumero_calle(8);
		d.setPersona(p);
		p.setDireccion(d);
		
		StandardServiceRegistry s=new StandardServiceRegistryBuilder().configure().build();
		SessionFactory sf=new MetadataSources(s).buildMetadata().buildSessionFactory();
		Session sesion=sf.openSession();
		/*Transaction t = sesion.beginTransaction();
		sesion.save(d);
		sesion.save(p);
		t.commit();*/
		Query q = sesion.createQuery("From Persona");
		List<Producto> lista_personas = q.getResultList();
		for(Producto persona:lista_personas) {
			System.out.println(persona);
		}
	}
}
