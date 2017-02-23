package es.boart.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.core.io.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import es.boart.model.Publicacion;
import es.boart.model.Tag;
import es.boart.repository.PublicacionRepository;
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
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("titulo") String titulo,@RequestParam("descripcion") String descripcion, @RequestParam("etiquetas") String etiquetas) throws IOException {
		// modelo.addAttribute("", repository.findAll());
		Publicacion publicacion = new Publicacion("m0scar", titulo, descripcion,"/files/" + file.getOriginalFilename(), 0, new Timestamp(new Date().getTime()), 0);
		publicacionRepository.save(publicacion);
		System.out.println(publicacion.getId()+ " " +publicacion.getAutor() + " " + publicacion.getTitulo() + " " 
				+ publicacion.getDescripcion() + " " + publicacion.getMedia()  + etiquetas);
		Tag tag = new Tag(etiquetas);
	    Path rootLocation = Paths.get("src/main/resources/static/img/");
		Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
		tag.getPublicaciones().add(publicacion);
		tagRepository.save(tag);
		return "publicacion_template";
	}
	
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws MalformedURLException {
    	System.out.println(filename);
    	Path location = Paths.get("src/main/resources/static/img/" + filename);
        Resource file = new UrlResource(location.toUri());
                
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+(file).getFilename()+"\"")
                .body(file);
    }

}
