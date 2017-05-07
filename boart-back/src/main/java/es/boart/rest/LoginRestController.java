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
import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api/login")
public class LoginRestController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("")
	public ResponseEntity<?> login(){
		
		if (!userSession.isLoggedUser()) {
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		} else {
			User loggedUser = userService.findByUsername(userSession.getUser().getUsername());
			if (loggedUser != null) {
				return new ResponseEntity<>(loggedUser, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
	}

}
