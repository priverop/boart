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

@Controller
public class PublicationController {

	@Autowired
	private PublicationRepository publicationRepo;	
	@Autowired
	private UserComponent userSession;

	@PostConstruct
	public void init(){
	}
	
	@RequestMapping("/publication/{IDPublication}")
	public String publication(Model modelo, HttpSession session, @PathVariable long IDPublication, HttpServletRequest request) {
	
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		Publication publication = publicationRepo.findOne(IDPublication);
		
		modelo.addAttribute("publication", publication);
		modelo.addAttribute("reference", "publication");
		modelo.addAttribute("IDLocation", IDPublication);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "publication_template";
	}
	
	@PostMapping("/addComment/publication")
	public String addComment(@RequestParam String text, @RequestParam long idLocation){
	
		Comment newComment = new Comment(userSession.getUser(), text);
		
		Publication publication = publicationRepo.findOne(idLocation);
		publication.getComments().add(newComment);
		publication.setNumberOfComments(publication.getComments().size());
		publicationRepo.save(publication);

		return "redirect:/publication/"+idLocation;
	}

	
}
