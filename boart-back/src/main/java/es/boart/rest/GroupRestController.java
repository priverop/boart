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
import es.boart.services.GroupService;

@RestController
@RequestMapping("/api/group")
public class GroupRestController {

	@Autowired
	private GroupService groupService;
	
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
	
}
