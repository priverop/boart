package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.boart.model.Grupo;

public interface GroupRepository extends JpaRepository<Grupo, Long> {
	Grupo findByTitulo(String titulo);
}
