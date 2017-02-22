package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.boart.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	Usuario findByNombreUsuario(String nombreUsuario);

}
