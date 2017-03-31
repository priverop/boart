package es.boart.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.boart.model.Publication;
import es.boart.services.PublicationService;

@RestController
@RequestMapping("/api/publication")
public class PublicationRestController {
	
	@Autowired
	PublicationService publicationService;
	
	@GetMapping("/")
	public List<Publication> getPublications(){
		return publicationService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Publication> getPublication(@PathVariable long id) {

		Publication p = publicationService.findOne(id);
		if (p != null) {
			return new ResponseEntity<>(p, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
