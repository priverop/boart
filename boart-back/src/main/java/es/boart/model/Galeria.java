package es.boart.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Galeria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String titulo;
	private String descripcion;
	private String imgPerfil;
	
	/**
	 * @param titulo
	 * @param descripcion
	 * @param imgPerfil
	 * @param miembroGrupo
	 */
	public Galeria(String titulo, String descripcion, String imgPerfil) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imgPerfil = imgPerfil;
	}

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
	 * @return the imgPerfil
	 */
	public String getImgPerfil() {
		return imgPerfil;
	}

	/**
	 * @param imgPerfil the imgPerfil to set
	 */
	public void setImgPerfil(String imgPerfil) {
		this.imgPerfil = imgPerfil;
	}

}