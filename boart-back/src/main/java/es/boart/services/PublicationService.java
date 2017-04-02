package es.boart.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import es.boart.UserComponent;
import es.boart.model.Comment;
import es.boart.model.Publication;
import es.boart.model.Tag;
import es.boart.repository.PublicationRepository;

@Service
public class PublicationService {

	@Autowired
	private PublicationRepository publicationRepository;	
	@Autowired
	private UserComponent userSession;

	private final int DEFAULT_SIZE = 10;

	public Publication findOne(long id) {
		return publicationRepository.findOne(id);
	}

	public Page<Publication> findAll() {
		return publicationRepository.findAll(new PageRequest(0, 10, Sort.Direction.DESC, getSort("latest")));
	}

	public void save(Publication p) {
		publicationRepository.save(p);
	}

	public void delete(Publication p) {
		publicationRepository.delete(p);
	}

	public String getSort(String filter) {
		if (filter.equals("likes"))
			return "numberOfLikes";
		if (filter.equals("comments"))
			return "numberOfComments";
		return "date";
	}

	public Page<Publication> publicationsNoTag(int page, String filter) {
		return publicationRepository.findAll(new PageRequest(page, DEFAULT_SIZE, Sort.Direction.DESC, getSort(filter)));
	}

	public Page<Publication> publicationsOneTag(int page, String filter, String tag) {
		return (Page<Publication>) publicationRepository.findByTags(new Tag(tag), new PageRequest(page, DEFAULT_SIZE, Sort.Direction.DESC, getSort(filter)));
	}

	public List<Publication> publicationsMultipleTag(String filter, List<String> sTags) {
		Set<Publication> sPublications = new HashSet<>();
		for (String s : sTags) {
			sPublications.addAll(publicationRepository.findByTags(new Tag(s)));
		}

		ArrayList<Publication> lPublications = new ArrayList<Publication>(sPublications);
		ordernarPorFiltro(lPublications, filter);// Ordeno el set en una lista
		return lPublications;
	}

	public List<String> ParseTags(String tags) {
		Set<String> sTags = new HashSet<>();
		if (tags != null) {
			for (String s : Arrays.asList(tags.split(","))) {
				if (!s.equals(""))
					sTags.add(s);
			}
		}
		return new ArrayList<String>(sTags);
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
	
	public void addComment(String text, long idLocation){		
		if (!text.equals("")){
			Comment newComment = new Comment(userSession.getUser(), text);
			Publication publication = findOne(idLocation);
			publication.getComments().add(newComment);
			publication.setNumberOfComments(publication.getComments().size());
			save(publication);
		}
	}

}
