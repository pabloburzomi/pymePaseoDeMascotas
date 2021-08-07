package com.pabloburzomi.services.impl;

import java.util.List;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.repository.DueñoRepository;
import com.pabloburzomi.repository.Impl.DueñoRepositoryImpl;
import com.pabloburzomi.services.DueñoServices;

public class DueñoServicesImpl implements DueñoServices {

	private DueñoRepository dueñoRepository;
	
	public DueñoServicesImpl() {
		
		this.dueñoRepository = new DueñoRepositoryImpl();
	}
	
	public Dueño crearDueño(Dueño dueño) throws Exception {
		
		return this.dueñoRepository.insert(dueño);
	}

	@Override
	public List<Dueño> findDueño() throws Exception {
		return this.dueñoRepository.findAll();
	}

	@Override
	public Dueño getDueñoByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return this.dueñoRepository.getByName(name);
	}
}
