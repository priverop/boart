package es.boart.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.model.Grupo;
import es.boart.repository.GrupoRepository;

@Controller
public class GrupoController {
	
	@Autowired
	private GrupoRepository repository;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/grupo/{titulo}")
	public String greeting(Model modelo, @PathVariable String titulo ) {

		Grupo grupo = repository.findByTitulo(titulo); 
		modelo.addAttribute("grupo", grupo);
		
		return "grupo_template";
	}
}