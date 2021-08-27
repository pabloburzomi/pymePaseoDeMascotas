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
@Table(name="paseos")
public class Paseo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPaseo;
	
	@ManyToOne
	@JoinColumn(name = "idmascota", referencedColumnName = "idmascota")
	private Mascota idMascota;
	

	@ManyToOne
	@JoinColumn(name = "idpaseador", referencedColumnName = "idpaseador")
	private Paseador idpaseador;
		
	@Column(name = "fechapaseo", nullable = false, length = 50)
	private String fecha;
	
	@Column(name="horapaseo", nullable = false, length = 50)
	private String hora;
	
	

	@Override
	public String toString() {
		return "id Paseo: " + idPaseo + " - Mascota: " + idMascota + " - Paseador: " + idpaseador + " - Fecha: "
				+ fecha + " - Hora: " + hora;
	}

	public int getIdPaseo() {
		return idPaseo;
	}

	public void setIdPaseo(int idPaseo) {
		this.idPaseo = idPaseo;
	}

	public Mascota getIdMascota() {
		return idMascota;
	}

	public void setIdMascota(Mascota idMascota) {
		this.idMascota = idMascota;
	}

	public Paseador getIdpaseador() {
		return idpaseador;
	}

	public void setIdpaseador(Paseador idpaseador) {
		this.idpaseador = idpaseador;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}


	
	
	


}
