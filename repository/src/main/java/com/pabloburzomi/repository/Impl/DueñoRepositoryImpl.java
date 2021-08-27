package com.pabloburzomi.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.repository.DueñoRepository;
import com.pabloburzomi.repository.hibernate.HibernateBaseRepository;

public class DueñoRepositoryImpl extends HibernateBaseRepository implements DueñoRepository {
	
	
	public DueñoRepositoryImpl() {
		super();
	}

	@Override
	public Dueño insert(Dueño dueño) throws Exception  {
		
		
		
		try (Session session = factory.getCurrentSession()){
			
			try {
		
				session.getTransaction().begin();
				
				session.saveOrUpdate(dueño);
				
				session.getTransaction().commit();
				
			} catch (Exception ex) {
				
				session.getTransaction().rollback();
				
				throw new Exception("Causa: " + ex.getCause() + "Mensaje: " + ex.getMessage());
			}
				
		} catch(Exception e){
		 throw new Exception(e.getMessage());	
		}
		
		return dueño;
		
	}

	@Override
	public List<Dueño> findAll() throws Exception {
		
		
		
		List<Dueño> dueños = new ArrayList<Dueño>();
		
		try (Session session = factory.getCurrentSession()){
			
			try {
				
				session.getTransaction().begin();
				
				String sql = "Select e from " + Dueño.class.getName() + " e ";
				
				Query<Dueño> query = session.createQuery(sql);
				
				dueños = query.getResultList();
				
				
				session.getTransaction().commit();
				
			} catch(Exception ex) {
				
				session.getTransaction().rollback();
				throw new Exception("Causa: " + ex.getCause() + "Mensaje: " + ex.getMessage());
			}
		
		}  catch(Exception e){
			 throw new Exception(e.getMessage());	
			} 
		
		
		return dueños;
		
	}

	@Override
	public Dueño getByName(String nombre) throws Exception {
		
		

		Dueño dueño = null;
		
		try (Session session = factory.getCurrentSession()) {
			
			try {
				
				session.getTransaction().begin();
				
				// Create an HQL statement, query the object.
				String sql = "Select dueño from " + Dueño.class.getName() + " dueño where dueño.nombre =:nombre";
				
				Query<Dueño> query = session.createQuery(sql);
				
				query.setParameter("nombre", nombre);
				
				Optional<Dueño> employees = query.uniqueResultOptional();
				
				if (employees.isPresent()) {
					dueño = employees.get();
				}
				
				session.getTransaction().commit();
				
				
			} catch(Exception e) {
				session.getTransaction().rollback();
				throw new Exception("Causa: " + e.getCause() + "Mensaje: " + e.getMessage());
		} 
		
		} catch(Exception e){
			 throw new Exception(e.getMessage());	
			}	
		return dueño;

	}
}
