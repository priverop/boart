package es.boart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Like {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private User usuario;
	@ManyToOne
	private Publication publicacion;
	
	/**
	 * @param id
	 * @param usuario
	 * @param publicacion
	 */
	public Like(long id, User usuario, Publication publicacion) {
		this.usuario = usuario;
		this.publicacion = publicacion;
	}
	
	public Like(){}
	
	/**
	 * @return the usuario
	 */
	public User getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the publicacion
	 */
	public Publication getPublicacion() {
		return publicacion;
	}
	/**
	 * @param publicacion the publicacion to set
	 */
	public void setPublicacion(Publication publicacion) {
		this.publicacion = publicacion;
	}
	
	
	
}