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
@Table(name = "usuarios")
public class Usuario {

	@Id
	@Column(name= "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;		
	@Column(name= "email", nullable = false)
	private String email;
	@Column(name= "nombre", nullable = false)
	private String nombre;
	@Column(name= "a_paterno", nullable = false)
	private String aPaterno;
	@Column(name= "a_materno", nullable = true)
	private String aMaterno;
	@Column(name= "password", nullable = false)
	private String password;	
	@ManyToOne
	@JoinColumn(name = "idUsuarioRefirio", nullable = true, foreignKey = @ForeignKey(name = "FK_usuario_refirio"))
	private Usuario usuarioRefirio;


}
