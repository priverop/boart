package es.boart.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Comparator;

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
	public void init() {
	}

	@RequestMapping("/")
	public String portada(Model modelo, HttpServletRequest request) {

		modelo.addAttribute("sesion_usuario", userSession.getUser());
		modelo.addAttribute("publicaciones", publicationRepository.findAll());
		modelo.addAttribute("filter", "latest");

		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());

		return "mainfront_template";
	}

	@PostMapping("/")
	public String portadaFiltrada(Model modelo, HttpServletRequest request, @RequestParam(value = "tags", required = false) String tags, @RequestParam(value = "nTag", required = false) String nTag, @RequestParam(value = "type") String type,
			@RequestParam(value = "filter", required = false) String filter) {

		Set<String> sTags = new HashSet<>();
		if (tags != null) {
			for (String s : Arrays.asList(tags.split(","))) {
				sTags.add(s);
			}
		}
		switch (type) {
		case "addTag":
			sTags.add(nTag);
			break;
		case "remTag":
			sTags.remove(nTag);
			break;
		case "latestFilter":
			filter = "latest";
			break;
		case "likesFilter":
			filter = "likes";
			break;
		case "commentsFilter":
			filter = "comments";
			break;
		}

		if (type.equals("addTag")) {
		} else if (type.equals("remTag")) {

			return portada(modelo, request);
		}

		Set<Publication> sPublications = new HashSet<>();
		if (sTags.size() == 0) {
			sPublications.addAll(publicationRepository.findAll());
		} else {
			for (String s : sTags) {
				sPublications.addAll(publicationRepository.findByTags(new Tag(s)));
			}
		}

		ArrayList<Publication> lPublications = new ArrayList<Publication>(sPublications);
		if (filter == null)
			filter = "latest";
		switch (filter) {
		default: //si llega un valor extraño tomamos el filtro latest por defecto
			modelo.addAttribute("filter", "latest");
			java.util.Collections.sort(lPublications, new Comparator<Publication>() {
				@Override
				public int compare(Publication p1, Publication p2) {
					return p1.getDate().compareTo(p2.getDate());
				}
			});
			break;
		case "likes":
			modelo.addAttribute("filter", "likes");
			java.util.Collections.sort(lPublications, new Comparator<Publication>() {
				@Override
				public int compare(Publication p1, Publication p2) {
					return p2.getNumberOfLikes() - p1.getNumberOfLikes();
				}
			});
			break;
		case "comments":
			modelo.addAttribute("filter", "comments");
			java.util.Collections.sort(lPublications, new Comparator<Publication>() {
				@Override
				public int compare(Publication p1, Publication p2) {
					return p2.getNumberOfComments() - p1.getNumberOfComments();
				}
			});
			break;
		}

//		sPublications = new HashSet<>(lPublications);

		modelo.addAttribute("sTags", sTags);
		modelo.addAttribute("filter", filter);
		// ¿Todo esto no es redundante? Se debe poder hacer sin duplicar código
		modelo.addAttribute("publicaciones", lPublications);
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		return "mainfront_template";
	}

}
