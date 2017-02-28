package es.boart.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.UserComponent;
import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.repository.PublicationRepository;
import es.boart.repository.UserRepository;

@Controller
public class MainFrontController {
	
	@Autowired
	private UserComponent sesionUsuario;
	
	@Autowired
	private UserRepository usuarioRepository;
	
	@Autowired
	private PublicationRepository publicacionRepository;

	@PostConstruct
	public void init(){
		
		Date date = new Date();
		
		// Creamos Usuarios
		User invitado = new User("invitado", "Guest", "Guest", "¡Hola! Soy el invitado de prueba, registrate amigo",
				"invitado", "http://www.drlaurelshaler.com/wp-content/uploads/2014/11/Guest.gif",
				0, 0, new Timestamp(date.getTime()), new Timestamp(date.getTime()));
		
		invitado.getGaleria().add(new Publication("Pepe", "Holacaracola", "Descripcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				new Timestamp(date.getTime()), 0));
		
		usuarioRepository.save(invitado);

		// Creamos Publicaciones
		publicacionRepository.save(new Publication("Juan", "Holacar2acola", "Descr2ipcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				new Timestamp(date.getTime()), 0));
	}
	
	@RequestMapping("/")
	public String portada(Model modelo, HttpSession sesion) {
		
		if(sesion.isNew()){
			System.out.println("Sesión Nueva");
			sesion.setAttribute("usuario", "invitado");
			sesionUsuario.setUser(usuarioRepository.findByNombreUsuario("invitado"));
		}
		
		modelo.addAttribute("publicaciones", publicacionRepository.findAll());
		modelo.addAttribute("sesion_usuario", sesionUsuario.getUser());
		System.out.println("Portada:"+sesionUsuario.getUser());
		return "portada_template";
	}
	
	@RequestMapping("/logout")
	public String logout(Model modelo, HttpSession sesion){
		sesion.invalidate();
		modelo.addAttribute("publicaciones", publicacionRepository.findAll());

		return "portada_template";
	}
	
}
