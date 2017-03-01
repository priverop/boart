package es.boart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String login(HttpSession sesion, @RequestParam String username, @RequestParam String password){
		
		User usuario = usuarioRepository.findByUsernameAndPassword(username, password);
				
		if(usuario.getNombreUsuario() != null){
			sesionUsuario.setUser(usuario);
			sesion.setAttribute("usuario", usuario.getNombreUsuario());
		}
		
		return "redirect:/perfil_privado"; 
	}
	
	@PostMapping("/register")
	public String register(HttpSession sesion){
		
		return "redirect:/"; //+referer
	}
}
