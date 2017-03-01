package es.boart.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.repository.GroupRepository;

@Controller
public class GrupoController {
	
	@Autowired
	private GroupRepository repository;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/grupo/{id}")
	public String greeting(Model modelo, @PathVariable long id ) {

		modelo.addAttribute("grupo", repository.findOne(id));
		
		return "grupo_template";
	}
}