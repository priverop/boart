package es.boart.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tag {
	
	@Id
	private String tag;
	@OneToMany(mappedBy="id")
	private List<Publicacion> publicaciones;
	
	public Tag(){
		
	}
	
	public Tag(String tag) {
		super();
		this.tag = tag;
		this.publicaciones = new ArrayList<Publicacion>();
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public List<Publicacion> getPublicaciones() {
		return publicaciones;
	}
	public void setPublicaciones(List<Publicacion> publicaciones) {
		this.publicaciones = publicaciones;
	}

	

}
