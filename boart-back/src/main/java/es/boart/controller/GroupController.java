package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.repository.GroupRepository;

@Controller
public class GroupController {
	
	@Autowired
	private GroupRepository groupRepo;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/grupo/{id}")
	public String greeting(Model modelo, @PathVariable long id, HttpServletRequest request) {

		modelo.addAttribute("grupo", groupRepo.findOne(id));
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "group_template";
	}
}