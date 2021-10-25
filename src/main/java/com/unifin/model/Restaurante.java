package com.unifin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "restaurantes")
public class Restaurante {

	@Id
	@Column(name= "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;		
	@Column(name= "restaurante", nullable = false)
	private String restaurante;
	@Column(name= "direccion", nullable = true)
	private String direccion;
	@Column(name= "rfc", nullable = false)
	private String rfc;
	

}
