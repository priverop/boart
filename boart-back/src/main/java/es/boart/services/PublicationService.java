package es.boart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.boart.model.Publication;
import es.boart.repository.PublicationRepository;

@Service
public class PublicationService {
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	public Publication findOne(long id){
		return publicationRepository.findOne(id);
	}
	
	public List<Publication> findAll(){
		return publicationRepository.findAll();
	}
	
	public void save(Publication p){
		publicationRepository.save(p);
	}

	public void delete(Publication p){
		publicationRepository.delete(p);
	}
	
}
