package com.spring.crudsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.spring.crudsystem.models.Veiculo;

public interface VeiculoSystemRepository extends CrudRepository<Veiculo, String> {
	Veiculo findByIdVeiculo(Long idVeiculo);
	Veiculo deleteByIdVeiculo(Long idVeiculo);

}
