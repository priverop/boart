package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.boart.UserComponent;
import es.boart.model.Comment;
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
	public String publication(Model modelo, HttpSession session, @PathVariable long id, HttpServletRequest request) {
		//DEBUG
		System.out.println("Sesión del usuario: "+userSession.getUser());
		//DEBUG
		
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		Publication publication = publicationRepo.findOne(id);
		
		modelo.addAttribute("publication", publication);
		modelo.addAttribute("reference", "publication");
		modelo.addAttribute("id", publication.getId());
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "publication_template";
	}
	
	@PostMapping("/addComment/publication")
	public String addComment(@RequestParam String text, @RequestParam long id){
		System.out.println("Llegamos al controlador");
		Comment newComment = new Comment(userSession.getUser(), text);
		
		Publication publication = publicationRepo.findOne(id);
		publication.getComments().add(newComment);
		publicationRepo.save(publication);
		System.out.println("Guardamos y redirigimos");
		return "redirect:/publication/"+id;
	}
	
}
