package es.boart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class PublicationLike {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private User user;
	@ManyToOne
	private Publication publication;
	
	/**
	 * @param id
	 * @param user
	 * @param publication
	 */
	public PublicationLike(User user, Publication publication) {
		this.user = user;
		this.publication = publication;
	}
	
	public PublicationLike(){}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * @param usuario the user to set
	 */
	public void setUser(User user) {
		this.user = user;
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