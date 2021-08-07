package com.pabloburzomi.services;

import java.util.List;

import com.pabloburzomi.domain.Paseo;

public interface PaseoServices {
	
	public Paseo insert(Paseo paseo) throws Exception;
	
	public List<Paseo> getAll() throws Exception;

}
