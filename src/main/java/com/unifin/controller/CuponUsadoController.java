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
import com.unifin.model.CuponUsado;
import com.unifin.service.ICuponUsadoService;

@RestController
@RequestMapping("/cupones/usados") 
public class CuponUsadoController {
	
	@Autowired
	private ICuponUsadoService service;
	
	@GetMapping
	public ResponseEntity<List<CuponUsado>> listar() throws Exception{
		List<CuponUsado> lista = service.listar();
		return new ResponseEntity<List<CuponUsado>>(lista, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CuponUsado> listarPorId(@PathVariable("id") Integer id) throws Exception{
		CuponUsado obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<CuponUsado>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CuponUsado> registrar(@Valid @RequestBody CuponUsado cu) throws Exception{
		CuponUsado obj = service.registrar(cu);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<CuponUsado> modificar(@Valid @RequestBody CuponUsado cu) throws Exception{
		CuponUsado obj = service.modificar(cu);
		return new ResponseEntity<CuponUsado>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		CuponUsado obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
