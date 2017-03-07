package es.boart.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Tag {
	
	@Id
	private String tag;
	@ManyToMany
	private Set<Publication> publications;
	
	public Tag(){
		
	}
	
	public Tag(String tag) {
		super();
		this.tag = tag;
		this.publications = new HashSet<Publication>();
	}
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

}