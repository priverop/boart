package es.boart.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User user;
	private String text;
	private Timestamp date;
	
	/**
	 * @param user
	 * @param text
	 * @param date
	 * @param publicationDestiny
	 */
	public Comment(User usuario, String text) {
		this.user = usuario;
		this.text = text;
		this.date = new Timestamp(new Date().getTime());
	}

	public Comment(){}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User usuario) {
		this.user = usuario;
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

	

}