package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.UserComponent;
import es.boart.model.Publication;
import es.boart.repository.PublicationRepository;
import es.boart.repository.UserRepository;

@Controller
public class PublicationController {

	@Autowired
	private PublicationRepository publicationRepo;	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void init(){
	}
	
	@RequestMapping("/publication/{id}")
	public String greeting(Model modelo, HttpSession session, @PathVariable long id, HttpServletRequest request) {

		if(session.isNew()){
			session.setAttribute("usuario", "invitado");
			userSession.setUser(userRepository.findByUsername("invitado"));
		}

		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		Publication publicacion = publicationRepo.findOne(id);
		
		modelo.addAttribute("publicacion", publicacion);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "publication_template";
	}
}
