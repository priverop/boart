package es.boart.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
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
import es.boart.services.PublicationService;

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
	PublicationService publicationService;

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

	public String getSort(String filter) {
		if (filter.equals("likes"))
			return "numberOfLikes";
		if (filter.equals("comments"))
			return "numberOfComments";
		return "date";
	}

	public String changeFilter(Model model, String filter) {
		model.addAttribute("filter", filter);
		model.addAttribute("publicaciones", publicationRepository.findAll(new PageRequest(0, DEFAULT_SIZE, Sort.Direction.DESC, getSort(filter))));
		return "mainfront_template";
	}

	@PostMapping("/")
	public String portadaFiltrada(Model model, HttpServletRequest request, @RequestParam(value = "tags", required = false) String tags, @RequestParam(value = "nTag", required = false) String nTag, @RequestParam(value = "type") String type,
			@RequestParam(value = "filter", required = false) String filter, @RequestParam(value = "page", required = false) Integer page) {
		List<String> lTags = publicationService.ParseTags(tags);
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		model.addAttribute("token", token.getToken());
		switch (type) {
		case "addTag":
			lTags.add(nTag);
			break;
		case "remTag":
			lTags.remove(nTag);
			break;
		case "latestFilter":
			return changeFilter(model, "latest");
		case "likesFilter":
			return changeFilter(model, "likes");
		case "commentsFilter":
			return changeFilter(model, "comments");
		}
		
		if (page == null)
			page = 0;
		if (filter == null)
			filter = "latest";
		
		if (type.equals("pagination")) { // Llamadas Ajax
			model.addAttribute("filter", filter);
			if (lTags.size() == 0){
				model.addAttribute("publications", publicationService.publicationsNoTag(page, filter));
				return "publicationPage";
			}
			else if (lTags.size() == 1){
				model.addAttribute("publications", publicationService.publicationsOneTag(page, filter, lTags.get(0)));
				return "publicationPage";
			}			
		} else {
			List<Publication> lPublications = publicationService.publicationsMultipleTag(filter, lTags);
			model.addAttribute("sTags", lTags);
			if (lTags.size() == 0)
				model.addAttribute("publicaciones", publicationService.publicationsNoTag(page, filter));
			else if (lTags.size() == 1)
				model.addAttribute("publicaciones", publicationService.publicationsOneTag(page, filter, lTags.get(0)));
			else
				model.addAttribute("publicaciones", lPublications);
			model.addAttribute("sesion_usuario", userSession.getUser());
			return "mainfront_template";
		}
		return "";
	}
}
