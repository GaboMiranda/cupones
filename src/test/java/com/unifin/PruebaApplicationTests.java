package com.unifin;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unifin.model.Usuario;
import com.unifin.service.impl.UsuarioServiceImpl;

@SpringBootTest
class PruebaApplicationTests {
	
	 @Autowired
	 private UsuarioServiceImpl service;

	@Test
	void verificarCorreo() {
		Usuario u = new Usuario();
		Usuario usr = new Usuario();
		usr.setId(1);
		u.setNombre("Gabriel");
		u.setAPaterno("Miranda");
		u.setAMaterno("Avilés");
		u.setPassword("123");
		u.setEmail("jogamiav@gmail.com");
		u.setUsuarioRefirio(usr);
		
		assertTrue(!service.validarCorreo(u.getEmail()));
	}

}
