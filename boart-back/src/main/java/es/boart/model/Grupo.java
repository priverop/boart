package es.boart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String titulo;
	private String descripcion;
	private String imgPerfil;
	private String miembroGrupo;
	
	public Grupo(String titulo, String descripcion, String imgPerfil, String miembroGrupo) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imgPerfil = imgPerfil;
		this.miembroGrupo = miembroGrupo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImgPerfil() {
		return imgPerfil;
	}

	public void setImgPerfil(String imgPerfil) {
		this.imgPerfil = imgPerfil;
	}

	public String getMiembroGrupo() {
		return miembroGrupo;
	}

	public void setMiembroGrupo(String miembroGrupo) {
		this.miembroGrupo = miembroGrupo;
	}
}
