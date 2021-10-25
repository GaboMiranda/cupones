package com.unifin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifin.model.CuponUsado;
import com.unifin.repo.ICuponUsadoRepo;
import com.unifin.repo.IGenericRepo;
import com.unifin.service.ICuponUsadoService;

@Service
public class ICuponUsadoServiceImpl extends CRUDImpl<CuponUsado, Integer> implements ICuponUsadoService{

	@Autowired
	private ICuponUsadoRepo repo;	

	@Override
	protected IGenericRepo<CuponUsado, Integer> getRepo() {
		return repo;
	}

}
