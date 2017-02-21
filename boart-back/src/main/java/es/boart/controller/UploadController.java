package es.boart.controller;

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
import es.boart.repository.UploadRepository;

@Controller
public class UploadController {
	
	

	@Autowired
	private UploadRepository repository;

	@RequestMapping("/subir")
	public String greeting(Model modelo) {
		// modelo.addAttribute("", repository.findAll());
		System.out.println("No pulsado");
		return "subir_template";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("titulo") String titulo,@RequestParam("descripcion") String descripcion) {
		// modelo.addAttribute("", repository.findAll());
		Publicacion publicacion = new Publicacion("m0scar", titulo, descripcion, file.getOriginalFilename(), 0, new Date(), 0);
		System.out.println(publicacion.getAutor() + " " + publicacion.getTitulo() + " " + publicacion.getDescripcion() + " " + publicacion.getMedia());
		repository.save(publicacion);
		return "publicacion_template";
	}

}
