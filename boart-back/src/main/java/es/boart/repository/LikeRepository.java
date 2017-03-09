package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.boart.model.PublicationLike;

public interface LikeRepository extends JpaRepository<PublicationLike, Long> {
	
}
