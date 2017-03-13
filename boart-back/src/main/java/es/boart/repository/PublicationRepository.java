package es.boart.repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import es.boart.model.Publication;
import es.boart.model.Tag;

public interface PublicationRepository extends JpaRepository<Publication, Long> {
	
//	@Query( "FROM Publication as t1 INNER JOIN t1.tags as tag WHERE tag IN :tags" )
//	Page<Object> findByTags(@Param("tags") Set<Tag> tags, Pageable pageable);
	
	Page<Publication> findAll(Pageable pageable);
	List<Publication> findByTags(Tag tag);
	Publication findById(long id);
}
