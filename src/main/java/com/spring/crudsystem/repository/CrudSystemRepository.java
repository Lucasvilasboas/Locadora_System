package com.spring.crudsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.crudsystem.models.Usuario;

public interface CrudSystemRepository extends CrudRepository<Usuario, String> {
	Usuario findByIdUsuario(Long idUsuario);
	Usuario deleteByIdUsuario(Long idUsuario);
}
