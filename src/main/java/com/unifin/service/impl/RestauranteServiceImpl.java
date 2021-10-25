package com.unifin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifin.model.Restaurante;
import com.unifin.repo.IGenericRepo;
import com.unifin.repo.IRestauranteRepo;
import com.unifin.service.IRestauranteService;

@Service
public class RestauranteServiceImpl extends CRUDImpl<Restaurante, Integer> implements IRestauranteService{

	@Autowired
	private IRestauranteRepo repo;	

	@Override
	protected IGenericRepo<Restaurante, Integer> getRepo() {
		return repo;
	}

}
