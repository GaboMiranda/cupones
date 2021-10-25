package com.unifin.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "cupon_usado")
public class CuponUsado {

	@Id
	@Column(name= "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;		
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = true, foreignKey = @ForeignKey(name = "FK_cupon_usado_usuario"))
	private Usuario usuario;
	@ManyToOne
	@JoinColumn(name = "id_cupon", nullable = true, foreignKey = @ForeignKey(name = "FK_cupon_usado_cupon"))
	private Cupon cupon;
	
}
