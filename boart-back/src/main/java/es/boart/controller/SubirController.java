package es.boart.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.boart.model.Publicacion;
import es.boart.model.Tag;
import es.boart.repository.PublicacionRepository;
import es.boart.repository.SubirRepository;
import es.boart.repository.TagRepository;

@Controller
public class SubirController {

	@Autowired
	private PublicacionRepository publicacionRepository;
	@Autowired
	private TagRepository tagRepository;


	@RequestMapping("/subir")
	public String greeting(Model modelo) {
		return "subir_template";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("titulo") String titulo,@RequestParam("descripcion") String descripcion, @RequestParam("etiquetas") String etiquetas) {
		// modelo.addAttribute("", repository.findAll());
		Publicacion publicacion = new Publicacion("m0scar", titulo, descripcion, file.getOriginalFilename(), 0, new Timestamp(new Date().getTime()), 0);
		publicacionRepository.save(publicacion);
		System.out.println(publicacion.getId()+ " " +publicacion.getAutor() + " " + publicacion.getTitulo() + " " 
				+ publicacion.getDescripcion() + " " + publicacion.getMedia()  + etiquetas);
		Tag tag = new Tag(etiquetas);
		tag.getPublicaciones().add(publicacion);
		tagRepository.save(tag);
		return "publicacion_template";
	}

}
