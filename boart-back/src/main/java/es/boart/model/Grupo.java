package es.boart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String titulo;
	private String descripcion;
	private String imgPerfil;
	@OneToMany(mappedBy="grupo")
	private List<MiembroGrupo> miembroGrupos;
	
	/**
	 * @param titulo
	 * @param descripcion
	 * @param imgPerfil
	 */
	public Grupo(String titulo, String descripcion, String imgPerfil) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.imgPerfil = imgPerfil;
	}
	
	public Grupo(){}
	
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
	/**
	 * @return the miembroGrupos
	 */
	public List<MiembroGrupo> getMiembroGrupos() {
		return miembroGrupos;
	}
	/**
	 * @param miembroGrupos the miembroGrupos to set
	 */
	public void setMiembroGrupos(List<MiembroGrupo> miembroGrupos) {
		this.miembroGrupos = miembroGrupos;
	}
	
	
}
