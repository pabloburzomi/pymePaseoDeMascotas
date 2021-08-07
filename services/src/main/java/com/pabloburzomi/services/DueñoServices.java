package com.pabloburzomi.services;

import java.util.List;

import com.pabloburzomi.domain.Dueño;

public interface DueñoServices {
	
	public Dueño crearDueño(Dueño dueño) throws Exception;
	
	public List<Dueño> findDueño() throws Exception;
	
	public Dueño getDueñoByName(String name) throws Exception;

}
