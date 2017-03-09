package es.boart.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import es.boart.model.Publication;
import es.boart.model.Tag;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
	List<Publication> findByTags(Tag tag);
	Publication findById(long id);
}
