package es.boart.rest;

import java.util.List;

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
import es.boart.model.User;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserComponent userSession;
	
	@GetMapping("/")
	public List<User> getUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id) {

		User u = userService.findOne(id);
		if (u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{username}")
	public ResponseEntity<User> getUserByName(@PathVariable String username) {

		User u = userService.findByUsername(username);
		if (u != null) {
			return new ResponseEntity<>(u, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/following")
	public ResponseEntity<User> followUser(@RequestParam("id") long userToFollowId){
		
		if (userSession.getUser() != null) {
			
			User user = userService.findOne(userSession.getUser().getId());
						
			User userToFollow = userService.findOne(userToFollowId);
			
			userService.followUser(user, userToFollow);
			
			if (user != null && userToFollow != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
	}
	
	@DeleteMapping("/following/{userToUnFollowId}")
	public ResponseEntity<User> unfollowUser(@PathVariable long userToUnFollowId){
		
		if (userSession.getUser() != null) {
			
			User user = userService.findOne(userSession.getUser().getId());
						
			User userToUnFollow = userService.findOne(userToUnFollowId);
			
			userService.unfollowUser(user, userToUnFollow);
			
			if (user != null && userToUnFollow != null) {
				return new ResponseEntity<>(user, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
	}
	
	@PostMapping("")
	public ResponseEntity<User> newUser(User nUser){
		
		User newUser = userService.registerUser(nUser.getUsername(), nUser.getName(), nUser.getSurname(), nUser.getPassword(), nUser.getMail());
				
		if (newUser != null) {
			return new ResponseEntity<>(newUser, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/comment")
	public ResponseEntity<User> addComment(@RequestParam(value="username") String username, @RequestParam(value="comment") String comment) {
		
		if (userSession.getUser() != null) {
			
			User user = userService.findOne(userSession.getUser().getId());
			
			User u = userService.findByUsername(username);
			
			userService.addComment(comment, u.getId());
			
			return getUser(u.getId());
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
	}
	
//	@PostMapping("/{username}")
//	public ResponseEntity<User> addComment(@PathVariable String username, @RequestParam("comment") String comment) {
//		User u = userService.findByUsername(username);
//		userService.addComment(comment, u.getId());
//		return getUser(u.getId());
//	}	
}
