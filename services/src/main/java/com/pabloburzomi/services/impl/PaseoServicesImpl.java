package com.pabloburzomi.services.impl;

import java.util.List;

import com.pabloburzomi.domain.Paseo;
import com.pabloburzomi.repository.PaseoRepository;
import com.pabloburzomi.repository.Impl.PaseoRepositoryImpl;
import com.pabloburzomi.services.PaseoServices;

public class PaseoServicesImpl implements PaseoServices{
	
	private PaseoRepository paseoRepository;
	
	public PaseoServicesImpl() {
		
		this.paseoRepository = new PaseoRepositoryImpl();
		
	}

	@Override
	public Paseo insert(Paseo paseo) throws Exception {
		
		return this.paseoRepository.insertPaseo(paseo);
		
	}

	@Override
	public List<Paseo> getAll() throws Exception {
		
		return this.paseoRepository.getAll();
	}

}
