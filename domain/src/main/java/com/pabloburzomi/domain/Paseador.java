package com.pabloburzomi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="paseadores")
public class Paseador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idpaseador;
	
	@Column(name = "dni", nullable = false, length = 50)
	private String dni;
	
	@Column(name = "nombreyapellido", nullable = false, length = 50)
	private String nombre;
	
	public Paseador() {
		
	}
	
	public Paseador(int idpaseador, String dni, String nombre) {
		super();
		this.idpaseador = idpaseador;
		this.dni = dni;
		this.nombre = nombre;
		
	}
	
	

	@Override
	public String toString() {
		return nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
