package es.boart.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.UserComponent;
import es.boart.repository.UsuarioRepository;

@Controller
public class PerfilPropioController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UsuarioRepository userRepo;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/perfil_privado")
	public String perfil(Model modelo) {

		modelo.addAttribute("usuario", userRepo.findOne(userSession.getUser().getId()));

		return "perfil_privado_template";
	}
}
