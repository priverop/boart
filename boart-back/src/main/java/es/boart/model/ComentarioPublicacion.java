package es.boart.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ComentarioPublicacion extends Comentario {
	
	private Publicacion publicacion;

	public ComentarioPublicacion(Usuario usuario, String text, Timestamp fechaPublicacion, Publicacion publicacion) {
		super(usuario, text, fechaPublicacion);
		// TODO Auto-generated constructor stub
		this.publicacion = publicacion; 
	}

}
