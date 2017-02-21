package es.boart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import es.boart.model.Publicacion;

public interface SubirRepository extends JpaRepository <Publicacion, Long>{

}
