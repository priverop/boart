package es.boart.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import es.boart.model.Publication;
import es.boart.model.Tag;
import es.boart.model.User;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
	
//		@Query( "FROM Publication as t1 INNER JOIN t1.tags as tag WHERE tag IN :tags" )
//		Page<Object> findByTags(@Param("tags") Set<Tag> tags, Pageable pageable);
		
	Page<Publication> findAll(Pageable pageable);
	List<Publication> findByTags(Tag tag);
	List<Publication> findByTags(Tag tag, Pageable pageable);
    Page<Publication> findByUser(Pageable pageable, User user);

}
