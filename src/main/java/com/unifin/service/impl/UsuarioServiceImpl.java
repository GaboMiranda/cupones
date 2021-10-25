package com.unifin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifin.model.Usuario;
import com.unifin.repo.IGenericRepo;
import com.unifin.repo.IUsuarioRepo;
import com.unifin.service.IUsuarioService;

@Service
public class UsuarioServiceImpl extends CRUDImpl<Usuario, Integer> implements IUsuarioService{

	@Autowired
	private IUsuarioRepo repo;	

	@Override
	protected IGenericRepo<Usuario, Integer> getRepo() {
		return repo;
	}
	
	@Override
	public boolean validarCorreo(String email) {
		List<Usuario> list = repo.validarCorreo(email);
		if(list.isEmpty()) {
			return false;
		}else {
			return true;
		}
	}
	
}
