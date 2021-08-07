package com.pabloburzomi.repository;

import java.util.List;

import com.pabloburzomi.domain.Paseador;

public interface PaseadorRepository {

	Paseador insert(Paseador paseador) throws Exception;

	List<Paseador> getAllPaseadores() throws Exception;

	Paseador getIdPaseadorByNombre(String nombrePaseador) throws Exception;

}
