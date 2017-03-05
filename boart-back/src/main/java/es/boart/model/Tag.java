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
	private Set<Publication> publicaciones;
	
	public Tag(){
		
	}
	
	public Tag(String tag) {
		super();
		this.tag = tag;
		this.publicaciones = new HashSet<Publication>();
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	
	public Set<Publication> getPublicaciones() {
		return publicaciones;
	}
	public void setPublicaciones(Set<Publication> publicaciones) {
		this.publicaciones = publicaciones;
	}

	

}