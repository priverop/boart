package es.boart.controller;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.BuildBBDD;
import es.boart.UserComponent;
import es.boart.repository.PublicationRepository;
import es.boart.repository.UserRepository;

@Controller
public class MainFrontController {
	
	@Autowired
	private UserComponent sesionUsuario;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	@Autowired
	private BuildBBDD generateData;

	@PostConstruct
	public void init(){
	}
	
	@RequestMapping("/")
	public String portada(Model modelo, HttpSession sesion) {
		
		if(sesion.isNew()){
			System.out.println("Sesión Nueva");
			sesion.setAttribute("usuario", "invitado");
			sesionUsuario.setUser(userRepository.findByUsername("invitado"));
		}
		
		modelo.addAttribute("publicaciones", publicationRepository.findAll());
		modelo.addAttribute("sesion_usuario", sesionUsuario.getUser());
		System.out.println("Portada:"+sesionUsuario.getUser());
		return "portada_template";
	}
	
	@RequestMapping("/logout")
	public String logout(Model modelo, HttpSession sesion){
		sesion.invalidate();
		modelo.addAttribute("publicaciones", publicationRepository.findAll());

		return "portada_template";
	}
	
}
