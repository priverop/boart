package es.boart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.boart.model.Grupo;
import es.boart.model.User;
import es.boart.services.GroupService;
import es.boart.services.UserService;

@RestController
@RequestMapping("/api/group")
public class GroupRestController {

	@Autowired
	private GroupService groupService;
	
	@Autowired
	private UserService userService;
	
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
	
	@GetMapping("/{idGroup}/join/{idUser}")
	public ResponseEntity<Grupo> joinGroup(@PathVariable long idGroup, @PathVariable long idUser){
		Grupo g = groupService.findOne(idGroup);
		User u  = userService.findOne(idUser);
		groupService.joinGroup(u, g);
		
		if (g != null && u != null) {
			return new ResponseEntity<>(g, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{idGroup}/leave/{idUser}")
	public ResponseEntity<Grupo> leaveGroup(@PathVariable long idGroup, @PathVariable long idUser){
		Grupo g = groupService.findOne(idGroup);
		User u  = userService.findOne(idUser);
		groupService.leaveGroup(u, g);
		
		if (g != null && u != null) {
			return new ResponseEntity<>(g, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
