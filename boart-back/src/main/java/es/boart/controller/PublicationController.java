package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
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
	public String greeting(Model modelo, @PathVariable long id, HttpServletRequest request) {

		Publication publicacion = repository.findOne(id);
		
		modelo.addAttribute("publicacion", publicacion);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "publicacion_template";
	}
}
