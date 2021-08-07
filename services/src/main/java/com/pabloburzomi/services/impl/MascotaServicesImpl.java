package com.pabloburzomi.services.impl;

import java.util.List;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.domain.Mascota;
import com.pabloburzomi.repository.MascotaRepository;
import com.pabloburzomi.repository.Impl.MascotaRepositoryImpl;
import com.pabloburzomi.services.MascotaServices;

public class MascotaServicesImpl implements MascotaServices{
	
	private MascotaRepository mascotaRepository;
	
	public MascotaServicesImpl() {
		
		this.mascotaRepository = new MascotaRepositoryImpl();
		
	}

	@Override
	public Mascota crearMascota(Mascota mascota) throws Exception {
		
		return this.mascotaRepository.insert(mascota);
	}
	
	@Override
	public List<Mascota> getMascotaById(Dueño idCliente) throws Exception {
	
		return this.mascotaRepository.getMascotaById(idCliente);
	}

	@Override
	public Mascota getIdMascotaByNombre(String nombre) throws Exception {
		
		return this.mascotaRepository.getIdMascotaByNombre(nombre);
	}


}
