package es.boart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import es.boart.model.Publication;
import es.boart.model.PublicationLike;
import es.boart.model.User;
import es.boart.repository.LikeRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	
	@Autowired
	private PublicationService publicationService;
	
	public PublicationLike findByPublicationIdAndUserId(long publicationId, long userId){
		return likeRepository.findByPublicationIdAndUserId(publicationId, userId);
	}
	
	public void save(PublicationLike like) {
		likeRepository.save(like);
	}
	
	public void delete(PublicationLike like) {
		likeRepository.delete(like);
	}
	
	public boolean hasLike(Publication publication, User user) {
		
		PublicationLike like = this.findByPublicationIdAndUserId(publication.getId(), user.getId());
		
		if(like == null) {
			PublicationLike newLike = new PublicationLike(user, publication);
			publication.addLike(newLike);
			this.save(newLike);
			publicationService.save(publication);
			return false;
		} else {
			publication.removeLike(like);
			this.delete(like);
			publicationService.save(publication);
			return true;
		} 
		
	}
	

}
