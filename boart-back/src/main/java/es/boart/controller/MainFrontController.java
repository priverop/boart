package es.boart.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import es.boart.BuildBBDD;
import es.boart.UserComponent;
import es.boart.model.Publication;
import es.boart.model.Tag;
import es.boart.repository.PublicationRepository;
import es.boart.repository.UserRepository;

@Controller
public class MainFrontController {
	
	@Autowired
	private UserComponent userSession;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	@Autowired
	private BuildBBDD generateData;

	@PostConstruct
	public void init(){
	}
	
	@RequestMapping("/")
	public String portada(Model modelo, HttpSession session, HttpServletRequest request) {
		
		if(session.isNew()){
			session.setAttribute("usuario", "invitado");
			userSession.setUser(userRepository.findByUsername("invitado"));
		}

		modelo.addAttribute("sesion_usuario", userSession.getUser());
		modelo.addAttribute("publicaciones", publicationRepository.findAll());
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "mainfront_template";
	}
	
	@PostMapping("/")
	public String portadaFiltrada(Model modelo, HttpSession session, HttpServletRequest request, @RequestParam(value="tags",required=false) String tags, 
			@RequestParam(value="nTag",required=false) String nTag, @RequestParam(value="type") String type) {
		// ¿Necesario?
		if (session.isNew()) {
			session.setAttribute("usuario", "invitado");
			userSession.setUser(userRepository.findByUsername("invitado"));
		}
		System.out.println(nTag);
		Set<String> sTags = new HashSet<>();
		if (tags != null) {
			for (String s: Arrays.asList(tags.split(","))){
				sTags.add(s);
			}
		}
		if (type.equals("addTag")){
			sTags.add(nTag);
		} else if (type.equals("remTag")) {
			sTags.remove(nTag);
		}
		if (sTags.size() == 0) 
			return portada(modelo, session, request);
		
		Set<Publication> lPublicaciones = new HashSet<>();				
		for (String s : sTags){
			 lPublicaciones.addAll(publicationRepository.findByTags(new Tag(s)));
		}
		
		modelo.addAttribute("sTags", sTags);
		// ¿Todo esto no es redundante? Se debe poder hacer sin duplicar código
		modelo.addAttribute("publicaciones", lPublicaciones);
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		return "mainfront_template";
	}

}
