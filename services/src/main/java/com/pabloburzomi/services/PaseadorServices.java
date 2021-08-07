package com.pabloburzomi.services;

import java.util.List;

import com.pabloburzomi.domain.Paseador;

public interface PaseadorServices {
	
	public Paseador insert(Paseador paseador) throws Exception;
	
	public List<Paseador> getAllPaseadores() throws Exception;

	public Paseador getIdPaseadorByNombre(String nombrePaseador) throws Exception;

}
