package com.pabloburzomi.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="valores")
public class Valor {
	
	@Id
	private int idValor;
	
	@Column(name = "fecha", nullable = false, length = 50)
	private Date Fecha;
	
	@Column(name = "importepaseo", nullable = false, length = 50)
	private Double importePaseo;
	

}
