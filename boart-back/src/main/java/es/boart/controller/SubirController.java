package es.boart.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.repository.SubirRepository;

@Controller
public class SubirController {
	
	@Autowired
	private SubirRepository repository;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/subir")
	public String greeting() {

		//modelo.addAttribute("", repository.findAll());
		
		return "subir_template";
	}
}
