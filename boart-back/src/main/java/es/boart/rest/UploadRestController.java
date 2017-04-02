package es.boart.rest;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.boart.UserComponent;
import es.boart.model.Grupo;
import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.services.PublicationService;
import es.boart.services.UploadService;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api/upload")
public class UploadRestController {
	
	@Autowired
	private PublicationRestController publicationRestController;	
	
	@Autowired
	private UploadService uploadService;
	
	@Autowired
	PublicationService publicationService;
	
	@GetMapping("/list")
	public Page<Publication> getPublications(){
		return getPublications(0);
	}
	
	@GetMapping("/list/{page}")
	public Page<Publication> getPublications(@PathVariable int page){
		return publicationService.publicationsNoTag(page, "latest");
	}
	
	@PostMapping("/")
	public Object upload(@RequestParam("media") Object media, @RequestParam(value="title",required=false) String title,
			@RequestParam(value="description",required=false) String description, @RequestParam(value="tags",required=false) String tags,
			@RequestParam("type") String type, @RequestParam(value="idGroup", required=false) Long idGroup) throws IOException {
		if (title == null) title = "";
		if (description == null) description = "";
		if (tags == null) tags = "";
		long idPub = uploadService.upload(title, description, tags, type, idGroup, media);
		if (idPub > -1)
			return publicationRestController.getPublication(idPub);
		return new ResponseEntity<>("Error while uploading, try it again", HttpStatus.BAD_REQUEST);				 
	}
	
	
	
	
}
