package com.unifin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.unifin.model.Usuario;

public interface IUsuarioRepo extends IGenericRepo<Usuario, Integer>{

	@Query(value = "SELECT * FROM usuarios u where u.email = :email", nativeQuery = true)
	List <Usuario> validarCorreo(@Param("email") String email);
}
