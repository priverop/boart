package es.boart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String description;
	private String img;
	@ManyToMany
	private List<User> groupMembers = new ArrayList<>();
	@OneToMany(cascade=CascadeType.ALL)
	private List<Publication> publications = new ArrayList<>();
	
	/**
	 * @param title
	 * @param description
	 * @param img
	 */
	public Grupo(String title, String description, String img){
		this.title = title;
		this.description = description;
		this.img = img;
	}
	
	public Grupo(){}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String descripcion) {
		this.description = descripcion;
	}
	/**
	 * @return the img
	 */
	@JsonIgnore
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String imgPerfil) {
		this.img = imgPerfil;
	}
	/**
	 * @return the miembroGrupos
	 */
	public List<User> getMiembroGrupos() {
		return groupMembers;
	}	

	/**
	 * @return the publications
	 */
	public List<Publication> getPublications() {
		return publications;
	}
	
	/**
	 * @param publications the publications to set
	 */
	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}
	
	/* CUSTOM METHODS */

	public void addMember(User user){
		this.groupMembers.add(user);
	}
	
	public void removeMember(User user){
		this.groupMembers.remove(user);
	}
	
	public boolean hasUser(User user){
		return this.groupMembers.contains(user);
	}
	
	public void addPublication(Publication p){
		this.getPublications().add(p);
	}
	
	@JsonProperty("img")
	public String getImgJSON(){
		return getImg();
	}
	
}
