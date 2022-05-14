package com.spring.crudsystem.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.crudsystem.models.Usuario;
import com.spring.crudsystem.models.Veiculo;
import com.spring.crudsystem.repository.CrudSystemRepository;
import com.spring.crudsystem.repository.VeiculoSystemRepository;

@Controller
public class CrudController{
	
	@Autowired
	private CrudSystemRepository csr;
	
	@Autowired
	private VeiculoSystemRepository vsr;
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.GET)
	public String cadastrarUsuario() {
		return "crud/cadastrar-usuario";
	}
	
	@RequestMapping(value="/cadastrarUsuario", method=RequestMethod.POST)
	public String cadastrarUsuario(Usuario usuario) {
		csr.save(usuario);
		return "redirect:/";
	}
	
	@RequestMapping(value="/cadastrarVeiculo", method=RequestMethod.GET)
	public String cadastrarVeiculo() {
		return "crud/cadastrar-veiculo";
	}
	
	@RequestMapping(value="/cadastrarVeiculo", method=RequestMethod.POST)
	public String cadastrarVeiculo(Veiculo veiculo){
		vsr.save(veiculo);
		return "redirect:/listarVeiculos";
	}

	@RequestMapping("")
	public ModelAndView listarUsuarios() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Usuario> usuarios = csr.findAll();
		mv.addObject("usuarios", usuarios);
		return mv;
	}
	
	@RequestMapping("/listarVeiculos")
	public ModelAndView listarVeiculos() {
		ModelAndView mv = new ModelAndView("crud/veiculos");
		Iterable<Veiculo> veiculos = vsr.findAll();
		mv.addObject("veiculos", veiculos);
		return mv;
	}
	
	@RequestMapping(value="/alterarUsuario/{idUsuario}", method=RequestMethod.GET)
	public ModelAndView alterarUsuario(@PathVariable("idUsuario") long idUsuario) {
		Usuario usuario = csr.findByIdUsuario(idUsuario);
		ModelAndView mv = new ModelAndView("crud/atualizar-usuario");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping(value="/alterarVeiculo/{idVeiculo}", method=RequestMethod.GET)
	public ModelAndView alterarVeiculo(@PathVariable("idVeiculo") long idVeiculo) {
		Veiculo veiculo = vsr.findByIdVeiculo(idVeiculo);
		ModelAndView mv = new ModelAndView("crud/atualizar-veiculo");
		mv.addObject("veiculo", veiculo);
		return mv;
	}
	
	@RequestMapping(value="/alterarUsuario/{idUsuario}", method=RequestMethod.POST)
	public String atualizarUsuario(@Validated Usuario usuario, BindingResult result, RedirectAttributes attributes) {
		csr.save(usuario);
		return "redirect:/";
	}
	
	@RequestMapping(value="/alterarVeiculo/{idVeiculo}", method=RequestMethod.POST)
	public String atualizarVeiculo(@Validated Veiculo veiculo, BindingResult result, RedirectAttributes attributes) {
		vsr.save(veiculo);
		return "redirect:/listarVeiculos";
	}
	
	@RequestMapping("/confirmarExclusaoUsuario/{idUsuario}")
	public ModelAndView confirmarExclusaoUsuario(@PathVariable long idUsuario) {
		Usuario usuario = csr.findByIdUsuario(idUsuario);
		ModelAndView mv = new ModelAndView("crud/excluir-usuario");
		mv.addObject("usuario", usuario);
		return mv;
	}
	
	@RequestMapping("/confirmarExclusaoVeiculo/{idVeiculo}")
	public ModelAndView confirmarExclusaoVeiculo(@PathVariable long idVeiculo) {
		Veiculo veiculo = vsr.findByIdVeiculo(idVeiculo);
		ModelAndView mv = new ModelAndView("crud/excluir-veiculo");
		mv.addObject("veiculo", veiculo);
		return mv;
	}
	
	@RequestMapping("/excluirUsuario")
	public String excluirUsuario(long idUsuario) {
		Usuario usuario = csr.findByIdUsuario(idUsuario);
		csr.delete(usuario);
		return "redirect:/";
	}
	
	@RequestMapping("/excluirVeiculo")
	public String excluirVeiculo(long idVeiculo) {
		Veiculo veiculo = vsr.findByIdVeiculo(idVeiculo);
		vsr.delete(veiculo);
		return "redirect:/listarVeiculos";
	}
}
