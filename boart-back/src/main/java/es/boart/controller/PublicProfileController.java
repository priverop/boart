package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.boart.UserComponent;
import es.boart.model.Comment;
import es.boart.model.User;
import es.boart.repository.PublicationRepository;
import es.boart.services.UserService;

@Controller
public class PublicProfileController {
	
	private final int DEFAULT_SIZE = 3;
	private final int DEFAULT_PAGE = 0;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private PublicationRepository publicationRepo;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/public_profile/{nombreUsuario}")
	public String publicProfile(Model modelo, @PathVariable String nombreUsuario, HttpServletRequest request) {
		
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		User profile_user = userService.findByUsername(nombreUsuario);
		
		if(userSession.getUser() != null){
			modelo.addAttribute("hasFollower", profile_user.hasFollower(userService.findOne(userSession.getUser().getId())));
		}
		else{
			modelo.addAttribute("guest", true);
		}
		
		modelo.addAttribute("usuario", profile_user);
		modelo.addAttribute("reference", "profile");
		modelo.addAttribute("IDLocation", profile_user.getId());
		
		modelo.addAttribute("user_publications", publicationRepo.findByUser(new PageRequest(DEFAULT_PAGE, DEFAULT_SIZE), profile_user));
		modelo.addAttribute("showMore", profile_user.getPublications().size() > DEFAULT_SIZE);
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "public_profile_template";
	}	
	
	@GetMapping("/public_profile/pagination")
	public String userPublicationPageable(Model modelo, @RequestParam("page") int page, @RequestParam("userId") long userId, HttpServletRequest request){
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		User profile_user = userService.findOne(userId); 
		
		modelo.addAttribute("user_publications", publicationRepo.findByUser(new PageRequest(page, DEFAULT_SIZE), profile_user));
		modelo.addAttribute("IDLocation", profile_user.getId());

		return "userPublicationPage";
	}
	
	@PostMapping("/addComment/profile")
	public String addComment(@RequestParam String text, @RequestParam long idLocation){
	
		Comment newComment = new Comment(userSession.getUser(), text);
		
		User user = userService.findOne(idLocation);
		user.getComments().add(newComment);
		
		userService.save(user);

		return "redirect:/public_profile/"+user.getUsername();
	}
	
	@RequestMapping("/follow/{idUser}")
	public String addFollower(@PathVariable long idUser){
		
		User myUser = userService.findByUsername(userSession.getUser().getUsername()); 

		myUser.addFollowing(userService.findOne(idUser));
		
		userService.save(userSession.getUser());
		
		return "redirect:/public_profile/"+userService.findOne(idUser).getUsername();
	}
	
	@RequestMapping("/unfollow/{idUser}")
	public String removeFollower(@PathVariable long idUser){
		
		User myUser = userService.findByUsername(userSession.getUser().getUsername()); 

		myUser.removeFollowing(userService.findOne(idUser));
		userService.save(userSession.getUser());

		return "redirect:/public_profile/"+userService.findOne(idUser).getUsername();
	}
}