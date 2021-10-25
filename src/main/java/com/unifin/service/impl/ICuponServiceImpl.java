package com.unifin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifin.model.Cupon;
import com.unifin.repo.ICuponRepo;
import com.unifin.repo.IGenericRepo;
import com.unifin.service.ICuponService;

@Service
public class ICuponServiceImpl extends CRUDImpl<Cupon, Integer> implements ICuponService{

	@Autowired
	private ICuponRepo repo;	

	@Override
	protected IGenericRepo<Cupon, Integer> getRepo() {
		return repo;
	}

}
