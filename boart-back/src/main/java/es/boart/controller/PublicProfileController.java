package es.boart.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.repository.UserRepository;

@Controller
public class PublicProfileController {
	
	@Autowired
	private UserRepository userRepository;
	
	
	@PostConstruct
	public void init(){}
	
	@RequestMapping("/perfil_publico/{nombreUsuario}")
	public String greeting(Model modelo, @PathVariable String nombreUsuario) {

		User usuario = userRepository.findByUsername(nombreUsuario);
		modelo.addAttribute("usuario", usuario);
		
		
		
		return "perfil_publico_template";
	}
}