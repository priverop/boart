package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.UserComponent;
import es.boart.model.User;
import es.boart.repository.UserRepository;

@Controller
public class PrivateProfileController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserRepository userRepo;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/private_profile")
	public String perfil(Model modelo, HttpSession session, HttpServletRequest request) {

		modelo.addAttribute("sesion_usuario", userSession.getUser());

		modelo.addAttribute("usuario", userRepo.findOne(userSession.getUser().getId()));
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());

		return "private_profile_template";
	}
	
	@PostMapping("/edit_profile")
	public String register(User usuario){
		
		User user = userRepo.findById(usuario.getId());
		
		if(usuario.getName() != null){
			user.setName(usuario.getName());
		}
		
		if(usuario.getSurname() != null){
			user.setSurname(usuario.getSurname());
		}
		
		if(usuario.getUsername() != null){
			user.setUsername(usuario.getUsername());
		}
		
		if(usuario.getPassword() != null){
			user.setPassword(usuario.getPassword());
		}
		
		if(usuario.getDescription() != null){
			user.setDescription(usuario.getDescription());
		}		
		
		userRepo.save(user);
		userSession.setUser(user);

		return "redirect:/private_profile";
	}
}
