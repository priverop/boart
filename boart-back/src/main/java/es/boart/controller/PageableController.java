package es.boart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import es.boart.UserComponent;
import es.boart.model.CustomResponse;
import es.boart.model.PublicationLike;
import es.boart.model.Publication;
import es.boart.model.User;
import es.boart.repository.LikeRepository;
import es.boart.repository.PublicationRepository;

@RestController
public class PageableController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	
	@RequestMapping(value = "/pageable", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ResponseEntity<Page<Publication>> publicationManager(@RequestParam int lastIndex, HttpServletRequest request, HttpServletResponse response, HttpSession session) {		
		int page = lastIndex / 10;
		Page<Publication> data = publicationRepository.findAll(new PageRequest(page, 10));
		return new ResponseEntity<>(data, HttpStatus.OK);
 }


}
