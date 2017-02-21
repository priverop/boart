package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.boart.model.Usuario;

public interface PerfilPropioRepository extends JpaRepository<Usuario, Long> {

}
