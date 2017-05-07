package es.boart.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
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
import es.boart.model.PublicationLike;
import es.boart.model.User;
import es.boart.services.LikeService;
import es.boart.services.PublicationService;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api/like")
public class LikeRestController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private PublicationService publicationService;
	
	@PostMapping("")
	public ResponseEntity<PublicationLike> addLike(@RequestParam String publicationId){		
				
		if (userSession.getUser() != null) {
			
			User user = userService.findOne(userSession.getUser().getId());
						
			if (user != null) {
				
				Publication publication = publicationService.findOne(Long.parseLong(publicationId));
				
				if(likeService.hasLike(publication, user)) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				} else {
					likeService.addLike(publication, user);
					return new ResponseEntity<>(HttpStatus.OK);
				}
				
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 	
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
			
	}
	
	@DeleteMapping("/{publicationId}")
	public ResponseEntity<PublicationLike> deleteLike(@PathVariable String publicationId){		
				
		if (userSession.getUser() != null) {
			
			User user = userService.findOne(userSession.getUser().getId());
						
			if (user != null) {
				
				Publication publication = publicationService.findOne(Long.parseLong(publicationId));

				if(likeService.hasLike(publication, user)) {
					likeService.deleteLike(publication, user, likeService.getLike(publication, user));
					return new ResponseEntity<>(HttpStatus.OK);
				} else {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}				
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 	
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
			
	}

}