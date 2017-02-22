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
	public void init(){
		repository.save(new Grupo("Fotógrafos de Vallecas", "Loren ipsun dolor sit amet", "https://scontent-lht6-1.xx.fbcdn.net/v/t1.0-9/16427482_1954388194577132_4182519892385252043_n.jpg?oh=798521399440066d618abe05bc535b27&oe=592DAC5D"));
	}
	
	@RequestMapping("/grupo/{id}")
	public String greeting(Model modelo, @PathVariable long id ) {

		modelo.addAttribute("grupo", repository.findOne(id));
		
		return "grupo_template";
	}
}