package es.boart.rest;

import java.util.List;

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
import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.services.PublicationService;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api")
public class PublicationRestController {
	
	private final int DEFAULT_PAGE = 0;

	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	PublicationService publicationService;
		
	@GetMapping("/publications")
	public Object getPublications(@RequestParam(value="page",required=false) Integer page, @RequestParam(value="filter",required=false) String filter, @RequestParam(value="tags",required=false) String tags){
		if (filter == null) filter = "latest";
		if (page == null) page = DEFAULT_PAGE;
		List<String> lTags = publicationService.ParseTags(tags);
		if (lTags.size() == 0)
			return publicationService.publicationsNoTag(page, filter);
		if (lTags.size() == 1)
			return publicationService.publicationsOneTag(page, filter, lTags.get(0));
		return publicationService.publicationsMultipleTag(filter, lTags);
	}	
	
	@GetMapping("/publication/{id}")
	public ResponseEntity<Publication> getPublication(@PathVariable long id) {

		Publication p = publicationService.findOne(id);
		if (p != null) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/publication/comment")
	public ResponseEntity<Publication> addComment(@RequestParam(value="id") long id, @RequestParam(value="comment") String comment) {
		
		if (userSession.getUser() != null) {
			
			User user = userService.findOne(userSession.getUser().getId());
															
			publicationService.addComment(comment, id);

			return getPublication(id);
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
	}
	
	@PostMapping("/publication/{id}")
	public ResponseEntity<Publication> postComment(@PathVariable long id, @RequestParam(value="comment") String comment) {
		publicationService.addComment(comment, id);
		return getPublication(id);
	}
	
	@DeleteMapping("/publication/{id}")
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
