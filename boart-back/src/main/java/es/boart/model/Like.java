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
	private Usuario usuario;
	@ManyToOne
	private Publicacion publicacion;
	
	/**
	 * @param id
	 * @param usuario
	 * @param publicacion
	 */
	public Like(long id, Usuario usuario, Publicacion publicacion) {
		this.usuario = usuario;
		this.publicacion = publicacion;
	}
	/**
	 * @return the usuario
	 */
	public Usuario getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the publicacion
	 */
	public Publicacion getPublicacion() {
		return publicacion;
	}
	/**
	 * @param publicacion the publicacion to set
	 */
	public void setPublicacion(Publicacion publicacion) {
		this.publicacion = publicacion;
	}
	
	
	
}