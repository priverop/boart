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
	private UserComponent sesionUsuario;
	
	@RequestMapping("/login")
	public String loginPage(Model modelo, HttpServletRequest request){
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());

		return "login_template";
	}
	
	/*@PostMapping("/login")
	public String login(HttpSession sesion, @RequestParam String username, @RequestParam String password){;

		//String passwordEncrypted = new BCryptPasswordEncoder().encode(password);
				
		User usuario = userRepo.findByUsername(username);
		
		if(usuario.getUsername() == null){
			return "Usuario no encontrado";
		}
		
		boolean matchPassword = new BCryptPasswordEncoder().matches(password, usuario.getPassword());
				
		if(matchPassword){
			sesionUsuario.setUser(usuario);
			sesion.setAttribute("usuario", usuario.getUsername());
		}
		
		return "Contraseña errónea";
		
	}*/
	
	@PostMapping("/register")
	public String register(HttpSession sesion, @ModelAttribute User usuario){
		
		userRepo.save(usuario);
		sesionUsuario.setUser(usuario);
		sesion.setAttribute("usuario", usuario.getUsername());

		return "redirect:/perfil_privado";
	}
}
