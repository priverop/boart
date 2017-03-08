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
import es.boart.model.User;
import es.boart.repository.UserRepository;

@Controller
public class PublicProfileController {
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserComponent userSession;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/public_profile/{nombreUsuario}")
	public String greeting(Model modelo, HttpSession session, @PathVariable String nombreUsuario, HttpServletRequest request) {

		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		User usuario = userRepo.findByUsername(nombreUsuario);
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("reference", "profile");
		modelo.addAttribute("IDLocation", usuario.getId());
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "public_profile_template";
	}	
	
	@PostMapping("/addComment/profile")
	public String addComment(@RequestParam String text, @RequestParam long idLocation){
	
		Comment newComment = new Comment(userSession.getUser(), text);
		
		User user = userRepo.findOne(idLocation);
		user.getComments().add(newComment);
		
		userRepo.save(user);

		return "redirect:/public_profile/"+user.getUsername();
	}
}