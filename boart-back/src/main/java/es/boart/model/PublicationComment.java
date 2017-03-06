package es.boart.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PublicationComment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User username;
	private String text;
	private Timestamp date;
	@ManyToOne
	private Publication publicationDestiny;
	
	/**
	 * @param username
	 * @param text
	 * @param date
	 * @param publicationDestiny
	 */
	public PublicationComment(User usuario, String text, Timestamp fechaPublicacion, Publication publicacion) {
		this.username = usuario;
		this.text = text;
		this.date = fechaPublicacion;
		this.publicationDestiny = publicacion;
	}

	public PublicationComment(){}

	/**
	 * @return the username
	 */
	public User getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(User usuario) {
		this.username = usuario;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Timestamp fechaPublicacion) {
		this.date = fechaPublicacion;
	}
	/**
	 * @return the publicationDestiny
	 */
	public Publication getPublicationDestiny() {
		return publicationDestiny;
	}
	/**
	 * @param publicationDestiny the publicationDestiny to set
	 */
	public void setPublicationDestiny(Publication publicacion) {
		this.publicationDestiny = publicacion;
	}

	

}