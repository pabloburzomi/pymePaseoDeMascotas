package com.pabloburzomi.repository.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.domain.Paseo;
import com.pabloburzomi.repository.PaseoRepository;
import com.pabloburzomi.repository.hibernate.HibernateBaseRepository;

public class PaseoRepositoryImpl extends HibernateBaseRepository implements PaseoRepository {
	
	public PaseoRepositoryImpl(){
		
		super();
		
	}

	@Override
	public Paseo insertPaseo(Paseo paseo) throws Exception{

		
		
		try(Session session = factory.getCurrentSession()) {
			
			try {
				
				session.getTransaction().begin();
				
				session.saveOrUpdate(paseo);
				
				session.getTransaction().commit();
				
			} catch(Exception e) {
				
			session.getTransaction().rollback();
			
			throw new Exception("Causa: " + e.getCause() + "Mensaje: " + e.getMessage());
		} 


		} catch(Exception e){
			 throw new Exception(e.getMessage());	
			}
		return paseo;
	}

	@Override
	public List<Paseo> getAll() throws Exception {
		
		
		
		List<Paseo> paseos = new ArrayList<>();
		
		try (Session session = factory.getCurrentSession()){
			
			try {
				
				session.getTransaction().begin();
				
				String sql = "Select e from " + Paseo.class.getName() + " e ";
				
				Query<Paseo> query = session.createQuery(sql);
				
				paseos = query.getResultList();
				
				
				session.getTransaction().commit();
				
			} catch( Exception e) {
				
				session.getTransaction().rollback();
				
				throw new Exception("Causa: " + e.getCause() + "Mensaje: " + e.getMessage());
			} 	
		
	
		} catch(Exception e){
			 throw new Exception(e.getMessage());	
			}
		
		return paseos;
	}

}
