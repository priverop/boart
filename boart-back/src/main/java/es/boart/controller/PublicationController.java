package es.boart.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.model.Publication;
import es.boart.repository.PublicationRepository;

@Controller
public class PublicationController {

	@Autowired
	private PublicationRepository repository;

	@PostConstruct
	public void init(){
	}
	
	@RequestMapping("/publicacion/{id}")
	public String greeting(Model modelo, @PathVariable long id) {

		Publication publicacion = repository.findOne(id);
		
		modelo.addAttribute("publicacion", publicacion);
		
		return "publicacion_template";
	}
}
