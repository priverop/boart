package es.boart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping("/{user1}/follow/{user2}")
	public ResponseEntity<User> followUser(@PathVariable long user1, @PathVariable long user2){
		User userA = userService.findOne(user1);
		User userB = userService.findOne(user2);
		userService.followUser(userA, userB);
		
		if (userA != null && userB != null) {
			return new ResponseEntity<>(userA, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{user1}/unfollow/{user2}")
	public ResponseEntity<User> unfollowUser(@PathVariable long user1, @PathVariable long user2){
		User userA = userService.findOne(user1);
		User userB = userService.findOne(user2);
		userService.unfollowUser(userA, userB);
		
		if (userA != null && userB != null) {
			return new ResponseEntity<>(userA, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/new")
	public ResponseEntity<User> newUser(User nUser){
		
		User newUser = userService.registerUser(nUser.getUsername(), nUser.getName(), nUser.getSurname(), nUser.getPassword());
		
		if (newUser != null) {
			return new ResponseEntity<>(newUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<User> addComment(@PathVariable long id, @RequestParam("comment") String comment) {
		userService.addComment(comment, id);
		return getUser(id);
	}	
}
