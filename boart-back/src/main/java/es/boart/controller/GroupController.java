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
import es.boart.repository.GroupRepository;
import es.boart.repository.UserRepository;

@Controller
public class GroupController {
	
	@Autowired
	private GroupRepository groupRepo;
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/group/{id}")
	public String greeting(Model modelo, HttpSession session, @PathVariable long id, HttpServletRequest request) {
				
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		modelo.addAttribute("grupo", groupRepo.findOne(id));
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "group_template";
	}
}