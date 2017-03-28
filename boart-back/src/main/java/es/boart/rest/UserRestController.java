package es.boart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.boart.model.User;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/")
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {

		User u = userService.findOne(id);
		if (u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
