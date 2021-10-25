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
import com.unifin.model.Restaurante;
import com.unifin.service.IRestauranteService;

@RestController
@RequestMapping("/restaurantes") 
public class RestauranteController {
	
	@Autowired
	private IRestauranteService service;
	
	@GetMapping
	public ResponseEntity<List<Restaurante>> listar() throws Exception{
		List<Restaurante> lista = service.listar();
		return new ResponseEntity<List<Restaurante>>(lista, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Restaurante> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Restaurante obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Restaurante>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Restaurante> registrar(@Valid @RequestBody Restaurante r) throws Exception{
		Restaurante obj = service.registrar(r);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Restaurante> modificar(@Valid @RequestBody Restaurante r) throws Exception{
		Restaurante obj = service.modificar(r);
		return new ResponseEntity<Restaurante>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Restaurante obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
