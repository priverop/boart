package es.boart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	
	@RequestMapping("/login/{error}")
	public String loginErrors(Model modelo, HttpServletRequest request, @PathVariable String error){
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		modelo.addAttribute("error", error);

		return "login_template";
	}
	
	@PostMapping("/register")
	public String register(@ModelAttribute User usuario){
		System.out.println("--Controlador--"); //No llega aquí
		System.out.println("Registro: "+usuario);
		
		userRepo.save(usuario);
		userSession.setUser(usuario);

		return "redirect:/private_profile";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();

		return "redirect:/";
	}
}
