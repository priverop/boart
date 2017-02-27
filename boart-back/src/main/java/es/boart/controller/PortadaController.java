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
import es.boart.model.Galeria;
import es.boart.model.Publicacion;
import es.boart.model.Usuario;
import es.boart.repository.PublicacionRepository;
import es.boart.repository.UsuarioRepository;

@Controller
public class PortadaController {
	
	@Autowired
	private UserComponent sesionUsuario;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PublicacionRepository publicacionRepository;

	@PostConstruct
	public void init(){
		
		Date date = new Date();
		
		// Creamos Usuarios
		Usuario invitado = new Usuario("invitado", "Guest", "Guest", "¡Hola! Soy el invitado de prueba, registrate amigo",
				"invitado", "http://www.drlaurelshaler.com/wp-content/uploads/2014/11/Guest.gif",
				0, 0, new Timestamp(date.getTime()), new Timestamp(date.getTime()), new Galeria());
		
		usuarioRepository.save(invitado);

		// Creamos Publicaciones
		publicacionRepository.save(new Publicacion("Pepe", "Holacaracola", "Descripcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				new Timestamp(date.getTime()), 0));
		
		publicacionRepository.save(new Publicacion("Juan", "Holacar2acola", "Descr2ipcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				new Timestamp(date.getTime()), 0));
	}
	
	@RequestMapping("/")
	public String portada(Model modelo, HttpSession sesion) {
		
		if(sesion.isNew()){
			sesion.setAttribute("usuario", "invitado");
			sesionUsuario.setUser(usuarioRepository.findByNombreUsuario("invitado"));
		}
		
		modelo.addAttribute("publicaciones", publicacionRepository.findAll());
		modelo.addAttribute("sesion_usuario", sesionUsuario.getUser());
		return "portada_template";
	}
	
	@RequestMapping("/logout")
	public String logout(Model modelo, HttpSession sesion){
		sesion.invalidate();
		modelo.addAttribute("publicaciones", publicacionRepository.findAll());

		return "portada_template";
	}
	
}
