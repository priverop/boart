package es.boart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import es.boart.UserComponent;
import es.boart.model.Grupo;
import es.boart.model.User;
import es.boart.services.GroupService;
import es.boart.services.UploadService;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api/group")
public class GroupRestController {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UploadService uploadService;
	
	@Autowired
	private UserComponent userSession;
	
	@GetMapping("/")
	public List<Grupo> getGroups(){
		return groupService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Grupo> getGroup(@PathVariable long id) {

		Grupo g = groupService.findOne(id);
		if (g != null) {
			return new ResponseEntity<>(g, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/join")
	public ResponseEntity<Grupo> joinGroup(@RequestParam("id") long idGroup){
		
		if (userSession.getUser() != null) {
			
			User user = userService.findOne(userSession.getUser().getId());
			
			Grupo g = groupService.findOne(idGroup);
			
			groupService.joinGroup(user, g);
			
			if (g != null && user != null) {
				return new ResponseEntity<>(g, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		

	}
	
	@DeleteMapping("/leave/{idGroup}")
	public ResponseEntity<Grupo> leaveGroup(@PathVariable long idGroup){
		
		if (userSession.getUser() != null) {
			
			User user = userService.findOne(userSession.getUser().getId());
			
			Grupo g = groupService.findOne(idGroup);
			
			groupService.leaveGroup(user, g);
			
			if (g != null && user != null) {
				return new ResponseEntity<>(g, HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
			
		} else {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
			
	}
	
	@PostMapping("/create")
	public ResponseEntity<Grupo> createGroup(Grupo group, @RequestParam("inputImage") MultipartFile file){		
		if (groupService.createGroup(group, file) != null){
			User user = userService.findOne(userSession.getUser().getId());
			groupService.joinGroup(user, group);
			return new ResponseEntity<>(group, HttpStatus.OK);
		}
			
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
