package com.pabloburzomi.repository;

import java.util.List;

import com.pabloburzomi.domain.Dueño;

public interface DueñoRepository {

	Dueño insert(Dueño dueño) throws Exception;

	List<Dueño> findAll() throws Exception;

	Dueño getByName(String name) throws Exception;
	
	

}
