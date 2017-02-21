package es.boart.controller;

import java.util.Calendar;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import es.boart.model.Publicacion;
import es.boart.repository.PortadaRepository;

@Controller
public class PortadaController {
	
	@Autowired
	private PortadaRepository repository;

	@PostConstruct
	public void init(){

		// Creamos los datos iniciales
		
		repository.save(new Publicacion("Pepe", "Holacaracola", "Descripcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				Calendar.getInstance().getTime(), 0));
		repository.save(new Publicacion("Juan", "Holacar2acola", "Descr2ipcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				Calendar.getInstance().getTime(), 0));
	}
	
	@RequestMapping("/")
	public String greeting(Model modelo) {

		modelo.addAttribute("publicaciones", repository.findAll());
		
		return "portada_template";
	}
}
