package es.boart.controller;

import java.io.IOException;
import java.net.MalformedURLException;
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

import es.boart.repository.UserRepository;
import es.boart.services.UploadService;

@Controller
public class UploadController {
	
	private final static String IMG_PATH 					= "src/main/resources/static/img/";
	@Autowired
	private UserComponent userSession;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UploadService uploadService;

	
	

	@RequestMapping("/upload")
	public String upload_front(Model modelo, HttpSession session, HttpServletRequest request) {
		
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		modelo.addAttribute("user_groups", userRepository.findOne(userSession.getUser().getId()).getGroups());
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "upload_template";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam(value="file", required=false) MultipartFile file, @RequestParam("titulo") String title,
			@RequestParam("descripcion") String description, @RequestParam("etiquetas") String tags,
			@RequestParam("optionsRadios") String type, @RequestParam(value="idGroup", required=false) Long idGroup, @RequestParam(value="audio", required=false) String audio, 
			@RequestParam(value="video",required=false) String video) throws IOException {
		Object media = null;
		if (type.equals("audio")) media = (Object) audio;
		if (type.equals("img")) media = (Object) file;
		if (type.equals("video")) media = (Object) video;

		long idPub = uploadService.upload(title, description, tags.replace("\n", ","), type, idGroup, media);
		if (idPub > -1)					
			return "redirect:/publication/"+ Long.toString(idPub);
		return "redirect:/upload_template/";
	}
		
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws MalformedURLException {
    	
    	Path location = Paths.get(IMG_PATH + filename);
        Resource file = new UrlResource(location.toUri());
                
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+(file).getFilename()+"\"")
                .body(file);
    }
}
