package com.unifin.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.unifin.exception.ModeloNotFoundException;
import com.unifin.model.Cupon;
import com.unifin.service.ICuponService;

@RestController
@RequestMapping("/cupones") 
public class CuponController {
	
	@Autowired
	private ICuponService service;
	
	@GetMapping
	public ResponseEntity<List<Cupon>> listar() throws Exception{
		List<Cupon> lista = service.listar();
		return new ResponseEntity<List<Cupon>>(lista, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cupon> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Cupon obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Cupon>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Cupon> registrar(@Valid @RequestBody Cupon c) throws Exception{
		Cupon obj = service.registrar(c);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Cupon> modificar(@Valid @RequestBody Cupon c) throws Exception{
		Cupon obj = service.modificar(c);
		return new ResponseEntity<Cupon>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Cupon obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
