package es.boart.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ComentarioPerfil extends Comentario {
	
	private Usuario usuarioDestino;

	public ComentarioPerfil(Usuario usuario, String text, Timestamp fechaPublicacion, Usuario usuarioDestino) {
		super(usuario, text, fechaPublicacion);
		// TODO Auto-generated constructor stub
		this.usuarioDestino = usuarioDestino; 
	}

}