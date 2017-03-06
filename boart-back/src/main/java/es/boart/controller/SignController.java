package es.boart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.boart.UserComponent;
import es.boart.model.User;
import es.boart.repository.UserRepository;

@Controller
public class SignController {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private UserComponent userSession;
	
	@RequestMapping("/login")
	public String loginPage(Model modelo, HttpServletRequest request){
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());

		return "login_template";
	}
	
	@PostMapping("/register")
	public String register(HttpSession sesion, @ModelAttribute User usuario){
		
		userRepo.save(usuario);
		userSession.setUser(usuario);
		sesion.setAttribute("usuario", usuario.getUsername());

		return "redirect:/private_profile";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();

		return "redirect:/";
	}
}
