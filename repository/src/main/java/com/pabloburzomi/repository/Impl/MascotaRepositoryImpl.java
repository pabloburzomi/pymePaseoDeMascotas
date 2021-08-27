package com.pabloburzomi.repository.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.domain.Mascota;
import com.pabloburzomi.repository.MascotaRepository;
import com.pabloburzomi.repository.hibernate.HibernateBaseRepository;

public class MascotaRepositoryImpl extends HibernateBaseRepository implements MascotaRepository {

	public MascotaRepositoryImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Mascota insert(Mascota mascota) throws Exception {
		
		
		
		try(Session session = factory.getCurrentSession()){
			
			try {
				
				session.getTransaction().begin();
				
				session.saveOrUpdate(mascota);
				
				session.getTransaction().commit();
				
			} catch(Exception e) {
			
				session.getTransaction().rollback();
				throw new Exception("La causa del error fue: "+e.getCause()+ " Mensaje: " + e.getMessage());
		} 

		return mascota;
		}
	}

	@Override
	public List<Mascota> getMascotaById(Dueño idCliente) throws Exception{

		

		List<Mascota> mascotas = new ArrayList<>();
		
		try (Session session = factory.getCurrentSession()){
			
			try {
				
				session.getTransaction().begin();
				
				String sql = "Select e from " + Mascota.class.getName() + " e where e.idcliente like :idCliente";
				
				Query<Mascota> query = session.createQuery(sql);
				
				query.setParameter("idCliente", idCliente);
				
				mascotas = query.getResultList();
				
				session.getTransaction().commit();
			} catch(Exception e) {
				session.getTransaction().rollback();
				throw new Exception("La causa del error fue: "+e.getCause()+ " Mensaje: " + e.getMessage());
		}


		return mascotas;
		}
	}

	@Override
	public Mascota getIdMascotaByNombre(String nombre) throws Exception {
		
		

		Mascota mascota = null;
		
		try (Session session = factory.getCurrentSession()){
			
			try {
				
				session.getTransaction().begin();
				
				String sql = "Select e from " + Mascota.class.getName() + " e where e.nombre like :nombre";
				
				Query<Mascota> query = session.createQuery(sql);
				
				query.setParameter("nombre", nombre);
				
				Optional<Mascota> employees = query.uniqueResultOptional();
				
				if (employees.isPresent()) {
					
					mascota = employees.get();
				}
				
				session.getTransaction().commit();
			} catch(Exception e) {
			
			session.getTransaction().rollback();
			throw new Exception("La causa del error fue: "+e.getCause()+ " Mensaje: " + e.getMessage());
			
		} 

		return mascota;
		}
	}

}
