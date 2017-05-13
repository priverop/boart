package es.boart.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PutMapping("/")
	public ResponseEntity<User> updateProfile(
			@RequestParam(value="name", required=false) String name,
			@RequestParam(value="surname", required=false) String surname,
			@RequestParam(value="username", required=false) String username,
			@RequestParam(value="description", required=false) String description,
			@RequestParam(value="password", required=false) String password,
			@RequestParam(value="inputImage", required=false) MultipartFile file){
		
		System.out.println("Description: "+description);
		User modifiedUser = new User(username, name, surname, description);
		
		if (userSession.getUser() != null) {
			
			long id = userSession.getUser().getId();
			
			User user = userService.findOne(id); 

			if (user != null) {
				userService.setUser(id, modifiedUser, file);
				User resultUser = userService.findOne(id);
				return new ResponseEntity<>(resultUser, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			} 	
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
			
	}

}
