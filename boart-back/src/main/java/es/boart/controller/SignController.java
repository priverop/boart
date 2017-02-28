package es.boart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import es.boart.UserComponent;
import es.boart.model.User;
import es.boart.repository.UserRepository;

@Controller
public class SignController {

	@Autowired
	private UserRepository usuarioRepository;
	
	@Autowired
	private UserComponent sesionUsuario;
	
	@PostMapping("/login")
	public String login(HttpSession sesion){
		// Consultamos el usuario en bbdd
		//Usuario usuario = usuarioRepository.findByNombreUsuario(nombreUsuario);
		// Si existe se le asigna a la sesión (nombreUsuario) y al componente
		//sesion.setAttribute("usuario", nombreUsuario);
		//sesionUsuario.setUser(usuario);
		// Redirigimos a donde estábamos
		return "redirect:/"; //+referer
	}
	
	@PostMapping("/register")
	public String register(HttpSession sesion){
		
		return "redirect:/"; //+referer
	}
}
