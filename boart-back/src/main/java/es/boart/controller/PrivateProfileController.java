package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		User myUser = userRepo.findOne(userSession.getUser().getId());

		modelo.addAttribute("usuario", myUser);
		modelo.addAttribute("followings", myUser.getFollowing());
		modelo.addAttribute("followers", myUser.getFollowers());
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());

		return "private_profile_template";
	}
}
