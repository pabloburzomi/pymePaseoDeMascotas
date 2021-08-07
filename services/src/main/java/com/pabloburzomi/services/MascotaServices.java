package com.pabloburzomi.services;

import java.util.List;

import com.pabloburzomi.domain.Dueño;
import com.pabloburzomi.domain.Mascota;

public interface MascotaServices {

	public Mascota crearMascota(Mascota mascota) throws Exception;
	
	public List<Mascota> getMascotaById(Dueño idCliente) throws Exception;
	
	public Mascota getIdMascotaByNombre(String nombre) throws Exception;
	
	
}
