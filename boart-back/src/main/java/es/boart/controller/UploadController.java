package es.boart.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

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
import es.boart.boartUtils;
import es.boart.model.Publication;
import es.boart.model.Tag;
import es.boart.model.User;
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
	public String upload(@RequestParam(value="file",required=false) MultipartFile file, @RequestParam("titulo") String titulo,
			@RequestParam("descripcion") String descripcion, @RequestParam("etiquetas") String etiquetas,
			@RequestParam("optionsRadios") String tipo, @RequestParam(value="audio",required=false) String audio, @RequestParam(value="video",required=false) String video)
			throws IOException {		
		User oscar = new User("m0scar", "Oscar", "Romero", "m0scar");
		userRepository.save(oscar);
		String media ="";		
		switch (tipo){
			case "img": 
				Path rootLocation = Paths.get("src/main/resources/static/img/");
				String timeStamp = Long.toString(System.currentTimeMillis());
				Files.copy(file.getInputStream(), rootLocation.resolve(timeStamp + "-" + file.getOriginalFilename()));
				media = boartUtils.getImgEmbedLeft() + timeStamp + "-" + file.getOriginalFilename() + boartUtils.getImgEmbedRight();
				break;
			case "audio":
				URL url = new URL("http://soundcloud.com/oembed?format=json&url=https://soundcloud.com/"+ audio +"&iframe=true");//Llamada a webservice de soundclound para coger el id del audio
				StringBuffer sb = new StringBuffer();
				try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
				    for (String line; (line = reader.readLine()) != null;) {
				        sb.append(line);
				    }
				}			
				media = sb.toString(); //Hay que ver si consigo que el JSON devuelve el iframe como quiero para coger el iframe de el directametne
				media = media.substring(media.indexOf("tracks%2F") + "tracks%2F".length(), media.indexOf("\\u0026show_artwork"));
				media = boartUtils.getAudioEmbedLeft() + media + boartUtils.getAudioEmbedRight();
				break;
			case "video":
				media = boartUtils.getVideoEmbedLeft() + video + boartUtils.getVideoEmbedRight();
				break;
		}
		
		
		Publication publication = new Publication(oscar, titulo, descripcion, media, 0);
		publicacionRepository.save(publication);

		for (String s : etiquetas.split("\n")) {
			s = s.toLowerCase().trim();// Habria que hacer una función que quite
										// caracteres especiales??
			Tag tag = tagRepository.findByTag(s);
			if (tag == null) tag = new Tag(s);
			tag.getPublications().add(publication);
			tagRepository.save(tag);						
		}


		return "redirect:/publication/"+publication.getId();
	}
	
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws MalformedURLException {
    	Path location = Paths.get("src/main/resources/static/img/" + filename);
        Resource file = new UrlResource(location.toUri());
                
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+(file).getFilename()+"\"")
                .body(file);
    }

}
