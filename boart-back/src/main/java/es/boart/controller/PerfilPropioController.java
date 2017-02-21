package es.boart.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.repository.PerfilPropioRepository;

@Controller
public class PerfilPropioController {
	
	@Autowired
	private PerfilPropioRepository repository;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/perfil_privado/")
	public String greeting() {

		//SESIÓN DEL USUARIO
		
		return "perfil_privado_template";
	}
}
