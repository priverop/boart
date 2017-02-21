package es.boart.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.model.Usuario;
import es.boart.repository.PerfilRepository;

@Controller
public class PerfilController {
	
	@Autowired
	private PerfilRepository repository;
	
	@PostConstruct
	public void init(){
		Date date = new Date();
		
		repository.save(new Usuario("usuario1", "prueba", "prueba", 
				"Aficionado a la fotografía, me gusta fotografiar naturaleza, en especial aves.",
				"pass", 
				"https://yt3.ggpht.com/-9lTuNU-MLtM/AAAAAAAAAAI/AAAAAAAAAAA/SjXmBhMb9PA/s176-c-k-no-mo-rj-c0xffffff/photo.jpg",
				0, 0, new Timestamp(date.getTime()), new Timestamp(date.getTime())));
	}
	
	@RequestMapping("/perfil_publico/{nombreUsuario}")
	public String greeting(Model modelo, @PathVariable String nombreUsuario) {

		Usuario usuario = repository.findByNombreUsuario(nombreUsuario);
		modelo.addAttribute("usuario", usuario);
		
		return "perfil_publico_template";
	}
}