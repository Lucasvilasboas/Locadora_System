package com.spring.crudsystem.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Veiculo implements Serializable{
	

	private static final long serialVersionUTD = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idVeiculo;
	private String fabricante;
	private String modelo;
	private String ano;
	private String cor;
	private String cambio;
	private int portas;
	public  Veiculo() {
		
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getModelo() {
		return modelo;
	}
	
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	
	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}
	
	public int getPortas() {
		return portas;
	}
	
	public void setPortas(int portas) {
		this.portas = portas;
	}
	
	
	
	
	
	
}
