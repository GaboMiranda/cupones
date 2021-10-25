package com.unifin.service;

import java.util.List;

import com.unifin.model.Usuario;

public interface IUsuarioService extends ICRUD<Usuario, Integer>{
	
	boolean validarCorreo(String email);

}
