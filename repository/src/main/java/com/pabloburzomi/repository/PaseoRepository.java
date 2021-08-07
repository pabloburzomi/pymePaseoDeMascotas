package com.pabloburzomi.repository;

import java.util.List;

import com.pabloburzomi.domain.Paseo;

public interface PaseoRepository {
	
	

	Paseo insertPaseo(Paseo paseo) throws Exception;

	List<Paseo> getAll() throws Exception;

}
