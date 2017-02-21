package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.boart.model.Usuario;

public interface PerfilRepository extends JpaRepository<Usuario, Long> {

}
