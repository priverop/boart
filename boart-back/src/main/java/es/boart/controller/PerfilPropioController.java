package es.boart.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.UserComponent;

@Controller
public class PerfilPropioController {
	
	@Autowired
	private UserComponent sesionUsuario;
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/perfil_privado")
	public String perfil(Model modelo) {

		modelo.addAttribute("usuario", sesionUsuario.getUser());
		System.out.println(sesionUsuario.getUser());
		
		return "perfil_privado_template";
	}
}
