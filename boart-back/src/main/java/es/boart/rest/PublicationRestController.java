package es.boart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@GetMapping("/")
	public List<Publication> getPublications(){
		return publicationService.findAll();
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
