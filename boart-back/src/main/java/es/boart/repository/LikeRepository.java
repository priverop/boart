package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.boart.model.PublicationLike;
import es.boart.model.User;

public interface LikeRepository extends JpaRepository<PublicationLike, Long> {
	PublicationLike findByPublicationIdAndUserId(Long publicationId, Long userId);
}
