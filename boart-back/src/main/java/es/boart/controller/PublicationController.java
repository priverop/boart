package es.boart.controller;

import java.util.List;

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
import es.boart.model.User;
import es.boart.repository.PublicationRepository;
import es.boart.repository.UserRepository;

@Controller
public class PublicationController {

	@Autowired
	private PublicationRepository publicationRepository;	
	
	@Autowired
	private UserRepository userRepository;	
	
	@Autowired
	private UserComponent userSession;

	@PostConstruct
	public void init(){
	}
	
	@RequestMapping("/publication/{IDPublication}")
	public String publication(Model modelo, HttpSession session, @PathVariable long IDPublication, HttpServletRequest request) {
	
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		Publication publication = publicationRepository.findOne(IDPublication);
		
		User user = userRepository.findById(userSession.getUser().getId());
		
		boolean canDelete = user == publication.getUser() ? true : false;
		
		modelo.addAttribute("publication", publication);
		modelo.addAttribute("reference", "publication");
		modelo.addAttribute("IDLocation", IDPublication);
		modelo.addAttribute("canDelete", canDelete);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "publication_template";
	}
	
	@PostMapping("/addComment/publication")
	public String addComment(@RequestParam String text, @RequestParam long idLocation){
	
		Comment newComment = new Comment(userSession.getUser(), text);
		
		Publication publication = publicationRepository.findOne(idLocation);
		publication.getComments().add(newComment);
		publication.setNumberOfComments(publication.getComments().size());
		publicationRepository.save(publication);

		return "redirect:/publication/"+idLocation;
	}

	
	@PostMapping("/publication/delete")
	public String deletePublication(@RequestParam String idPublication) {
	
		User user = userRepository.findById(userSession.getUser().getId());
		Publication publication = publicationRepository.findOne(Long.parseLong(idPublication));
		
		List<Publication> gallery = user.getGallery();
		gallery.remove(publication);
		user.setGallery(gallery);
		
		userRepository.save(user);
		userSession.setUser(user);
		publicationRepository.delete(publication);
		
		return "redirect:/private_profile";
	}
	
}
