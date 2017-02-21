package es.boart.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.repository.PerfilRepository;

@Controller
public class PerfilController {
	
	@Autowired
	private PerfilRepository repository;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/perfil_publico")
	public String greeting() {

		//modelo.addAttribute("", repository.findAll());
		
		return "perfil_publico_template";
	}
}