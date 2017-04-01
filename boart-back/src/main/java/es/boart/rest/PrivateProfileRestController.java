package es.boart.rest;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.boart.UserComponent;
import es.boart.model.User;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api/private_profile")
public class PrivateProfileRestController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public ResponseEntity<User> getPrivateProfile(){
				
		if (userSession.getUser() != null) {
			
			User user = userService.findOne(userSession.getUser().getId());
						
			if (user != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 	
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
			
	}

}
