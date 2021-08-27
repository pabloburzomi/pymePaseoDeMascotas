package com.pabloburzomi.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.domain.Mascota;
import com.pabloburzomi.domain.Paseador;
import com.pabloburzomi.repository.PaseadorRepository;
import com.pabloburzomi.repository.hibernate.HibernateBaseRepository;

public class PaseadorRepositoryImpl extends HibernateBaseRepository implements PaseadorRepository {

	@Override
	public Paseador insert(Paseador paseador) throws Exception{

		
		
		try(Session session = factory.getCurrentSession()) {
			
			try {
				
				session.getTransaction().begin();
				
				session.saveOrUpdate(paseador);
				
				session.getTransaction().commit();
			} catch(Exception e) {
			
			session.getTransaction().rollback();
			throw new Exception("La causa del error fue: "+e.getCause()+ " Mensaje: " + e.getMessage());
		} 

		} catch(Exception e){
			 throw new Exception(e.getMessage());	
			}
		return paseador;
	}

	@Override
	public List<Paseador> getAllPaseadores() throws Exception {
		
		
		
		List<Paseador> paseadores = new ArrayList<>();
		
		try (Session session = factory.getCurrentSession()){
			
			try {
				
				session.getTransaction().begin();
				
				String sql = "Select e from " + Paseador.class.getName() + " e ";
				
				Query<Paseador> query = session.createQuery(sql);
				
				paseadores = query.getResultList();
				
				
				session.getTransaction().commit();
			} catch(Exception e) {
			
				session.getTransaction().rollback();
				throw new Exception("La causa del error fue: "+e.getCause()+ " Mensaje: " + e.getMessage());
		} 
		
		} catch(Exception e){
			 throw new Exception(e.getMessage());	
			}
		return paseadores;
		
	}

	@Override
	public Paseador getIdPaseadorByNombre(String nombrePaseador) throws Exception {
		
		
		

		Paseador paseador = null;
		
		try (Session session = factory.getCurrentSession()){
			
			try {
				
				session.getTransaction().begin();
				
				String sql = "Select e from " + Paseador.class.getName() + " e where e.nombre like :nombrePaseador";
				
				Query<Paseador> query = session.createQuery(sql);
				
				query.setParameter("nombrePaseador", nombrePaseador);
				
				Optional<Paseador> employees = query.uniqueResultOptional();
				
				if (employees.isPresent()) {
					
					paseador = employees.get();
				}
				
				session.getTransaction().commit();
			} catch(Exception e) {
				session.getTransaction().rollback();
				throw new Exception("La causa del error fue: "+e.getCause()+ " Mensaje: " + e.getMessage());
		} 

		} catch(Exception e){
			 throw new Exception(e.getMessage());	
			}
		return paseador;
	}

}
