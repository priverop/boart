package es.boart.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Tag {
	
	@Id
	private String tag;
	@ManyToMany
	private Set<Publication> publications;
	
	public Tag(){}
	
	public Tag(String tag) {
		this.tag = tag;
		this.publications = new HashSet<Publication>();
	}
	
	/* GETTERS & SETTERS */
	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Set<Publication> getPublications() {
		return publications;
	}
	public void setPublications(Set<Publication> publicaciones) {
		this.publications = publicaciones;
	}
	
	/* CUSTOM METHODS */
	
	public void addPublication(Publication p){
		this.getPublications().add(p);
	}

}