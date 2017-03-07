package es.boart.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import es.boart.UserComponent;
import es.boart.model.Publication;
import es.boart.model.Tag;
import es.boart.repository.PublicationRepository;
import es.boart.repository.TagRepository;
import es.boart.repository.UserRepository;

@Controller
public class UploadController {

	@Autowired
	private PublicationRepository publicacionRepository;
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping("/upload")
	public String greeting(Model modelo, HttpSession session, HttpServletRequest request) {

		modelo.addAttribute("sesion_usuario", userSession.getUser());
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "upload_template";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam("file") MultipartFile file, @RequestParam("titulo") String titulo,
			@RequestParam("descripcion") String descripcion, @RequestParam("etiquetas") String etiquetas)
			throws IOException {
		Publication publicacion = new Publication("m0scar", titulo, descripcion, "/files/" + file.getOriginalFilename(), 0);
		publicacionRepository.save(publicacion);

		for (String s : etiquetas.split("\n")) {
			s = s.toLowerCase().trim();// Habria que hacer una función que quite
										// caracteres especiales??
			Tag tag = tagRepository.findByTag(s);
			if (tag == null) tag = new Tag(s);
			tag.getPublications().add(publicacion);
			tagRepository.save(tag);
			
			System.out.println(tag.getPublications().size());
			
		}

		Path rootLocation = Paths.get("src/main/resources/static/img/");
		Files.copy(file.getInputStream(), rootLocation.resolve(file.getOriginalFilename()));
		return "publication_template";
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
