package com.unifin.model;

import java.time.LocalDate;

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
@Table(name = "cupones")
public class Cupon {

	@Id
	@Column(name= "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;		
	@Column(name= "descripcion", nullable = false)
	private String descripcion;
	@Column(name= "fecha_caducidad", nullable = true)
	private LocalDate fechaCaducidad;
	@ManyToOne
	@JoinColumn(name = "id_restaurante", nullable = true, foreignKey = @ForeignKey(name = "FK_cupon_restaurante"))
	private Restaurante restaurante;

}
