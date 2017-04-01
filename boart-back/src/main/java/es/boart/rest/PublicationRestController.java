package es.boart.rest;

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

import es.boart.UserComponent;
import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.services.PublicationService;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api/publication")
public class PublicationRestController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserService userService;
	
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
	
	@PostMapping("/list/{page}")
	public Object getPublications(@PathVariable int page, @RequestParam(value="filter",required=false) String filter, @RequestParam(value="tags",required=false) String tags){
		if (filter == null) filter = "latest";
		List<String> lTags = publicationService.ParseTags(tags);
		if (lTags.size() == 0)
			return publicationService.publicationsNoTag(page, filter);
		if (lTags.size() == 1)
			return publicationService.publicationsOneTag(page, filter, lTags.get(0));
		return publicationService.publicationsMultipleTag(filter, lTags);
	}
	
	@PostMapping("/list")
	public Object getPublications(@RequestParam(value="filter",required=false) String filter, @RequestParam(value="tags",required=false) String tags){
		return  getPublications(0, filter, tags);
	}
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Publication> getPublication(@PathVariable long id) {

		Publication p = publicationService.findOne(id);
		if (p != null) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> DeletePublication(@PathVariable String id) {
		
		if (userSession.getUser() != null) {
					
			User user = userService.findOne(userSession.getUser().getId());
			
			Publication publication = publicationService.findOne(Long.parseLong(id));

			List<Publication> gallery = user.getGallery();
			
			if (gallery.remove(publication)) {
				
				user.setGallery(gallery);
			
				userService.save(user);
				userSession.setUser(user);
			
				publicationService.delete(publication);
				
				return new ResponseEntity<>(HttpStatus.OK);
				
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}	 		

			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}

	}
	
}
