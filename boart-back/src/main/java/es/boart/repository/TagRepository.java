package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.boart.model.Tag;

public interface TagRepository extends JpaRepository <Tag, Long>{
	Tag findByTag(String tag);
}