package com.pabloburzomi.services.impl;

import java.util.List;

import com.pabloburzomi.domain.Paseador;
import com.pabloburzomi.repository.PaseadorRepository;
import com.pabloburzomi.repository.Impl.PaseadorRepositoryImpl;
import com.pabloburzomi.services.PaseadorServices;

public class PaseadorServicesImpl implements PaseadorServices {
	
	private PaseadorRepository paseadorRepository;
	
	public PaseadorServicesImpl() {

		this.paseadorRepository = new PaseadorRepositoryImpl();
	
	}

	@Override
	public Paseador insert(Paseador paseador) throws Exception {
		
		return this.paseadorRepository.insert(paseador);
	}

	@Override
	public List<Paseador> getAllPaseadores() throws Exception {
		
		return this.paseadorRepository.getAllPaseadores();
	}

	@Override
	public Paseador getIdPaseadorByNombre(String nombrePaseador) throws Exception {
		return paseadorRepository.getIdPaseadorByNombre(nombrePaseador);
	}

}
