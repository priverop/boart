package es.boart.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ProfileComment  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User username;
	private String text;
	private Timestamp date;
	@ManyToOne
	private User usernameDestiny;
	/**
	 * @param username
	 * @param text
	 * @param date
	 * @param usernameDestiny
	 */
	public ProfileComment(User usuario, String text, Timestamp fechaPublicacion, User usuarioDestino) {
		this.username = usuario;
		this.text = text;
		this.date = fechaPublicacion;
		this.usernameDestiny = usuarioDestino;
	}
	
	public ProfileComment(){}
	
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
	 * @return the usernameDestiny
	 */
	public User getUsernameDestiny() {
		return usernameDestiny;
	}
	/**
	 * @param usernameDestiny the usernameDestiny to set
	 */
	public void setUsernameDestiny(User usuarioDestino) {
		this.usernameDestiny = usuarioDestino;
	}


}