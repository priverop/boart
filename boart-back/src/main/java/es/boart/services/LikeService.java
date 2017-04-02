package es.boart.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.boart.model.PublicationLike;
import es.boart.repository.LikeRepository;

@Service
public class LikeService {
	
	@Autowired
	private LikeRepository likeRepository;
	
	public PublicationLike findByPublicationIdAndUserId(long publicationId, long userId){
		return likeRepository.findByPublicationIdAndUserId(publicationId, userId);
	}
	
	public void save(PublicationLike like) {
		likeRepository.save(like);
	}
	
	public void delete(PublicationLike like) {
		likeRepository.delete(like);
	}
	

}
