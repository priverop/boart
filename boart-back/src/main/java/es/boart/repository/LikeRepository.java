package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.boart.model.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {
	
}
