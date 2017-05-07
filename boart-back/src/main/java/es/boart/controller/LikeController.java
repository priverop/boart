package es.boart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.boart.UserComponent;
import es.boart.model.Publication;
import es.boart.model.PublicationLike;
import es.boart.model.User;
import es.boart.repository.LikeRepository;
import es.boart.repository.PublicationRepository;
import es.boart.repository.UserRepository;
import es.boart.services.LikeService;

@RestController
public class LikeController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private LikeService likeService;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/like", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<String> likeManager(@RequestParam String publicationId, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		User user = userSession.getUser();
				
		if(user == null) {
			return new ResponseEntity<>("Forbidden.", HttpStatus.FORBIDDEN);
		}
		
		if(publicationId == null) {
			return new ResponseEntity<>("Empty publication id.", HttpStatus.BAD_REQUEST);
		}
		
		String status = "";
		
		Publication publication = publicationRepository.findOne(Long.parseLong(publicationId));
		
		status = likeService.hasLike(publication, user) ? "deleted" : "added";	
		
		return new ResponseEntity<>(status, HttpStatus.OK);
 }

	// Return true if the User has liked the publication
	@GetMapping("/like/check")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@ResponseBody
	public ResponseEntity<String> checkLike(@RequestParam("id") long idPublication){
		Publication p = publicationRepository.findOne(idPublication);
		User u = userRepository.findOne(userSession.getUser().getId());
		
		if(userSession.getUser() != null){ 
			boolean check = p.checkUserLikesThis(u);
		
			if(check){
				return new ResponseEntity<>("true", HttpStatus.OK);
			}
			else{
				return new ResponseEntity<>("false", HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("Forbidden.", HttpStatus.FORBIDDEN);
	}

}
