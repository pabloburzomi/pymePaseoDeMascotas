package com.pabloburzomi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clientes")
public class Dueño {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idcliente;
	
	@Column(name = "nombreyapellidos", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "dni", nullable = true, length = 50)
	private String dni;
	
	@Column(name = "domicilio", nullable = false, length = 50)
	private String domicilio;
	
	@Column(name = "telefono", nullable = false, length = 50)
	private String telefono;
	


	public Dueño() {
		super();
	}

	public Dueño(String nombre, String dni, String domicilio, String telefono) {
		super();
		this.nombre = nombre;
		this.dni = dni;
		this.domicilio = domicilio;
		this.telefono = telefono;
	}
	
	


	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

	public int getIdcliente() {
		return idcliente;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	
	
}
