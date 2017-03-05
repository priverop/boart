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
	private UserComponent sesionUsuario;
	
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
	public String portada(Model modelo, HttpSession sesion, HttpServletRequest request) {
		
		if(sesion.isNew()){
			System.out.println("Sesión Nueva");
			sesion.setAttribute("usuario", "invitado");
			sesionUsuario.setUser(userRepository.findByUsername("invitado"));
		}
		
		modelo.addAttribute("publicaciones", publicationRepository.findAll());
		modelo.addAttribute("sesion_usuario", sesionUsuario.getUser());
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		System.out.println("Portada:"+sesionUsuario.getUser());
		return "portada_template";
	}
	
	@RequestMapping("/logout")
	public String logout(Model modelo, HttpSession sesion){
		sesion.invalidate();
		modelo.addAttribute("publicaciones", publicationRepository.findAll());

		return "portada_template";
	}
	
	@PostMapping("/")
	public String portadaFiltrada(Model modelo, HttpSession sesion, HttpServletRequest request, @RequestParam(value="tags",required=false) String tags, @RequestParam(value="nTag",required=false) String nTag) {
		if (sesion.isNew()) {
			System.out.println("Sesión Nueva");
			sesion.setAttribute("usuario", "invitado");
			sesionUsuario.setUser(userRepository.findByUsername("invitado"));
		}
		System.out.println(nTag);
		List<Tag> lTags = new ArrayList<>();
		if (tags != null) {
			for (String s: Arrays.asList(tags.split(","))){
				lTags.add(new Tag(s));
			}
		}
		lTags.add(new Tag(nTag));
		
		Set<Publication> lPublicaciones = new HashSet<>();				
		for (Tag t: lTags){
			 lPublicaciones.addAll(publicationRepository.findByTags(t));
		}
		
		modelo.addAttribute("lTags", lTags);
		modelo.addAttribute("publicaciones", lPublicaciones);
		modelo.addAttribute("sesion_usuario", sesionUsuario.getUser());
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		return "portada_template";
	}

}
