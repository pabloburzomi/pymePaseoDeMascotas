package com.pabloburzomi.repository;

import java.util.List;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.domain.Mascota;

public interface MascotaRepository {
	
	public Mascota insert(Mascota mascota) throws Exception;
	
	public List<Mascota> getMascotaById(Dueño idCliente) throws Exception;

	public Mascota getIdMascotaByNombre(String nombre) throws Exception;


}
