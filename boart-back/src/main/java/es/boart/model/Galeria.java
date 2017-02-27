package es.boart.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Galeria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String titulo;
	private String descripcion;
	private List<String> imgs;
	
	/**
	 * @param titulo
	 * @param descripcion
	 * @param imgs
	 */
	public Galeria(String titulo, String descripcion) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imgs = new ArrayList<String>();
	}

	public Galeria(){}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/**
	 * @return the descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * @return the imgs
	 */
	public List<String> getImgs() {
		return imgs;
	}

	/**
	 * @param imgs the imgs to set
	 */
	public void setImgs(List<String> imgs) {
		this.imgs = imgs;
	}



}