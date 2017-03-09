package es.boart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.boart.UserComponent;
import es.boart.model.CustomResponse;
import es.boart.model.Like;
import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.repository.LikeRepository;
import es.boart.repository.PublicationRepository;

@RestController
public class LikeController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	@Autowired
	private LikeRepository likeRepository;
	
	@RequestMapping(value = "/like/increase", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<String> likeManager(@RequestParam Boolean manager, @RequestParam String publicationId, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		
		User user = userSession.getUser();
		
		System.out.println(user);
		
		if(user == null) {
			return new ResponseEntity<>("Forbidden.", HttpStatus.FORBIDDEN);
		}
		
		if(publicationId == null) {
			return new ResponseEntity<>("Empty publication id.", HttpStatus.BAD_REQUEST);
		}
		
		Publication publication = publicationRepository.findById(Long.parseLong(publicationId));
		
		if(manager) {
			Like like = new Like(user, publication);
			publication.addLike(like);
			likeRepository.save(like);
			publicationRepository.save(publication);
		} else {
			//remove like
		} 		
		
		return new ResponseEntity<>("Success", HttpStatus.OK);
 }


}
