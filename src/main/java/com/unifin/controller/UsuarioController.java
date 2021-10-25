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
import com.unifin.model.Usuario;
import com.unifin.service.IUsuarioService;

@RestController
@RequestMapping("/usuarios") 
public class UsuarioController {
	
	@Autowired
	private IUsuarioService service;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> listar() throws Exception{
		List<Usuario> lista = service.listar();
		return new ResponseEntity<List<Usuario>>(lista, HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> listarPorId(@PathVariable("id") Integer id) throws Exception{
		Usuario obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Usuario> registrar(@Valid @RequestBody Usuario u) throws Exception{
		if(service.validarCorreo(u.getEmail())) {
			throw new ModeloNotFoundException("El correo "+ u.getEmail() +"ya ha sido registrado.");
		}
		Usuario obj = service.registrar(u);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<Usuario> modificar(@Valid @RequestBody Usuario u) throws Exception{
		Usuario obj = service.modificar(u);
		return new ResponseEntity<Usuario>(obj, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable("id") Integer id) throws Exception{
		Usuario obj = service.listarPorId(id);
		if(obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		service.eliminar(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
	
}
