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
	private User username;
	@ManyToOne
	private Publication publication;
	
	/**
	 * @param id
	 * @param username
	 * @param publication
	 */
	public Like(long id, User usuario, Publication publication) {
		this.username = usuario;
		this.publication = publication;
	}
	
	public Like(){}
	
	/**
	 * @return the username
	 */
	public User getUsername() {
		return username;
	}
	
	/**
	 * @param usuario the username to set
	 */
	public void setUsername(User usuario) {
		this.username = usuario;
	}
	
	/**
	 * @return the publication
	 */
	public Publication getPublication() {
		return publication;
	}
	
	/**
	 * @param publication the publication to set
	 */
	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	
	
}