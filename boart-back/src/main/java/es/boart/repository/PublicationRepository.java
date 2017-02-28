package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.boart.model.Publication;

public interface PublicationRepository extends JpaRepository<Publication, Long> {

}
