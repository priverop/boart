package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ErrorController {

	private final String LOGIN_FAILURE = "loginfailure";
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/loginfailure")
	public String errors(Model modelo, HttpServletRequest request) {
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "redirect:/login/"+LOGIN_FAILURE;
	}
}
