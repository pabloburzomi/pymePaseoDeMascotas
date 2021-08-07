package com.pabloburzomi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="mascotas")
public class Mascota {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idmascota;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column(name = "raza", nullable = false, length = 50)
	private String raza;
	
	@Column(name = "caracteristicas", nullable = false, length = 50)
	private String caracteristicas;
	
	@Column(name = "cantpaseosdiarios", nullable = false)
	private int paseosDiarios;
	
	@ManyToOne
	@JoinColumn(name = "idcliente", referencedColumnName = "idcliente")
	private Dueño idcliente;
	


	public Mascota() {
		super();
	}

	
		public Mascota(String nombre, String raza, String caracteristicas, int paseosDiarios, int id) {
		this.nombre = nombre;
		this.raza = raza;
		this.caracteristicas = caracteristicas;
		this.paseosDiarios = paseosDiarios;
		
		Dueño nuevoCliente = new Dueño();
		nuevoCliente.setIdcliente(id);
		this.idcliente = nuevoCliente;
		
		
	}
		
	

	@Override
		public String toString() {
			return nombre;
		}


	public int getIdmascota() {
			return idmascota;
		}


		public void setIdmascota(int idmascota) {
			this.idmascota = idmascota;
		}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getCaracteristicas() {
		return caracteristicas;
	}

	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}

	public int getPaseosDiarios() {
		return paseosDiarios;
	}

	public void setPaseosDiarios(int paseosDiarios) {
		this.paseosDiarios = paseosDiarios;
	}


	public Dueño getIdcliente() {
		return idcliente;
	}


	public void setIdcliente(Dueño idcliente) {
		this.idcliente = idcliente;
	}
	
	
	
	
	
}
