package com.pabloburzomi.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.domain.Mascota;
import com.pabloburzomi.repository.hibernate.HibernateUtils;

public class Prueba {

	public static void main(String[] args) {
	
		SessionFactory sf = HibernateUtils.getSessionFactory();
		
		Mascota p = new Mascota();
		p.setNombre("pupi");
		p.setCaracteristicas("mansito");
		p.setRaza("ninguna");
		p.setPaseosDiarios(2);
		
//		Dueño jota = new Dueño();
//		jota.setDni("24.444.127");
//		jota.setDomicilio("Lafinur 247");
//		jota.setNombre("Jose Ramirez");
//		jota.setTelefono("4456-1247");
	
		
//		p.setDueño(jota);
		
		Session session = sf.getCurrentSession();
		
		session.beginTransaction();
		
		session.saveOrUpdate(p);
		
		session.getTransaction().commit();

	}

}
