package es.boart.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	private final int DEFAULT_SIZE = 10;
	private final int DEFAULT_PAGE = 0;

	@Autowired
	private UserComponent userSession;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PublicationRepository publicationRepository;

	@Autowired
	private BuildBBDD generateData;

	@PostConstruct
	public void init() {
	}

	@RequestMapping("/")
	public String portada(Model modelo, HttpServletRequest request) {

		modelo.addAttribute("sesion_usuario", userSession.getUser());
		modelo.addAttribute("publicaciones", publicationRepository.findAll(new PageRequest(DEFAULT_PAGE, DEFAULT_SIZE)));
		modelo.addAttribute("filter", "latest");

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());

		return "mainfront_template";
	}

	@GetMapping("/page")
	public String portadaPageable(Model modelo, @RequestParam("page") int page, HttpServletRequest request) {

		modelo.addAttribute("filter", "latest");

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());

		modelo.addAttribute("publications", publicationRepository.findAll(new PageRequest(page, DEFAULT_SIZE)));

		return "publicationPage";
	}
	
	public String getSort(String filter){
		if (filter.equals("likes"))
			return "numberOfLikes";
		if (filter.equals("comments"))
			return "numberOfComments";
		return "date";
	}
	
	public String changeFilter(Model model, String filter){
		model.addAttribute("filter", filter);
		model.addAttribute("publicaciones", publicationRepository.findAll(new PageRequest(0, DEFAULT_SIZE, Sort.Direction.DESC, getSort(filter))));
		return "mainfront_template";
	}

	@PostMapping("/")
	public String portadaFiltrada(Model modelo, HttpServletRequest request, @RequestParam(value = "tags", required = false) String tags, @RequestParam(value = "nTag", required = false) String nTag, @RequestParam(value = "type") String type,
			@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "page", required = false) Integer page) {

		Set<String> sTags = new HashSet<>();
		if (tags != null) {
			for (String s : Arrays.asList(tags.split(","))) {
				if (!s.equals(""))
				sTags.add(s);
			}
		}
		
		Set<Publication> sPublications = new HashSet<>(); 
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());

		switch (type) {
		case "addTag":
			sTags.add(nTag);
			break;
		case "remTag":
			sTags.remove(nTag);
			break;
		case "latestFilter":
			return changeFilter(modelo, "latest");
		case "likesFilter":
			return changeFilter(modelo, "likes");
		case "commentsFilter":
			return changeFilter(modelo, "comments");
		}

		if (page == null)
			page = 0;

		if (filter == null)
			filter = "latest";
			
			
		if 	(type.equals("pagination")){ //Llamadas Ajax
			if (sTags.size() == 0) 
				return publicationsNoTag(page, filter, modelo);
			else if (sTags.size() == 1) 
				return publicationsOneTag(page, filter,tags.split(",")[0], modelo);
		} else {
			
			for (String s : sTags) {
				sPublications.addAll(publicationRepository.findByTags(new Tag(s)));
			}
		
		ArrayList<Publication> lPublications = new ArrayList<Publication>(sPublications);
		ordernarPorFiltro(lPublications, filter);// Ordeno el set en una lista

		modelo.addAttribute("sTags", sTags);
		modelo.addAttribute("filter", filter);
		if (sTags.size() == 0)
			modelo.addAttribute("publicaciones", publicationRepository.findAll(new PageRequest(DEFAULT_PAGE, DEFAULT_SIZE, Sort.Direction.DESC, getSort(filter))));
		else if (sTags.size() == 1)
			modelo.addAttribute("publicaciones", publicationRepository.findByTags(new Tag(nTag), new PageRequest(DEFAULT_PAGE, DEFAULT_SIZE,Sort.Direction.DESC, getSort(filter))));
		else
			modelo.addAttribute("publicaciones", lPublications);
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		return "mainfront_template";
		} 
		return "";
	}
	
	
	public String publicationsNoTag(int page, String filter, Model model){
		model.addAttribute("publications", publicationRepository.findAll(new PageRequest(page, DEFAULT_SIZE,Sort.Direction.DESC, getSort(filter))));
		model.addAttribute("filter", filter);
		return "publicationPage";		
	}
	
	public String publicationsOneTag(int page, String filter, String tag, Model model){
		model.addAttribute("publications", publicationRepository.findByTags(new Tag(tag), new PageRequest(page, DEFAULT_SIZE,Sort.Direction.DESC, getSort(filter))));
		model.addAttribute("filter", filter);
		return "publicationPage";
	}

	public void ordernarPorFiltro(ArrayList<Publication> lPublications, String filter) {
		switch (filter) {
		default: // si llega un valor extraño tomamos el filtro latest por
					// defecto
			java.util.Collections.sort(lPublications, new Comparator<Publication>() {
				@Override
				public int compare(Publication p1, Publication p2) {
					return p2.getDate().compareTo(p1.getDate());
				}
			});
			break;
		case "likes":
			java.util.Collections.sort(lPublications, new Comparator<Publication>() {
				@Override
				public int compare(Publication p1, Publication p2) {
					return p2.getNumberOfLikes() - p1.getNumberOfLikes();
				}
			});
			break;
		case "comments":
			java.util.Collections.sort(lPublications, new Comparator<Publication>() {
				@Override
				public int compare(Publication p1, Publication p2) {
					return p2.getNumberOfComments() - p1.getNumberOfComments();
				}
			});
			break;
		}
	}

}
