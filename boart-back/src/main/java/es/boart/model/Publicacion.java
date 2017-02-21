package es.boart.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;

@Entity
public class Publicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String autor;
	private String titulo;
	private String descripcion;
	private String media;
	private int tipo_media;
	private Timestamp fecha;
	private int num_visitas;
	@OneToMany(mappedBy="publicacion")
	private List<Like> likes;
	@OneToMany(mappedBy="publicacion")
	private List<ComentarioPublicacion> comentariosPublicacion;
	
	public Publicacion(){}

	/**
	 * @param autor
	 * @param titulo
	 * @param descripcion
	 * @param media
	 * @param tipo_media
	 * @param fecha
	 * @param num_visitas
	 * @param likes
	 */
	public Publicacion(String autor, String titulo, String descripcion, String media, int tipo_media, Timestamp fecha,
			int num_visitas) {
		this.autor = autor;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.media = media;
		this.tipo_media = tipo_media;
		this.fecha = fecha;
		this.num_visitas = num_visitas;
	}
	
	/**
	 * @return the autor
	 */
	public String getAutor() {
		return autor;
	}

	/**
	 * @param autor the autor to set
	 */
	public void setAutor(String autor) {
		this.autor = autor;
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
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}

	/**
	 * @return the tipo_media
	 */
	public int getTipo_media() {
		return tipo_media;
	}

	/**
	 * @param tipo_media the tipo_media to set
	 */
	public void setTipo_media(int tipo_media) {
		this.tipo_media = tipo_media;
	}

	/**
	 * @return the fecha
	 */
	public Timestamp getFecha() {
		return fecha;
	}

	/**
	 * @param fecha the fecha to set
	 */
	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	/**
	 * @return the num_visitas
	 */
	public int getNum_visitas() {
		return num_visitas;
	}

	/**
	 * @param num_visitas the num_visitas to set
	 */
	public void setNum_visitas(int num_visitas) {
		this.num_visitas = num_visitas;
	}

	/**
	 * @return the likes
	 */
	public List<Like> getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(List<Like> likes) {
		this.likes = likes;
	}

	/**
	 * @return the comentariosPublicacion
	 */
	public List<ComentarioPublicacion> getComentariosPublicacion() {
		return comentariosPublicacion;
	}

	/**
	 * @param comentariosPublicacion the comentariosPublicacion to set
	 */
	public void setComentariosPublicacion(List<ComentarioPublicacion> comentariosPublicacion) {
		this.comentariosPublicacion = comentariosPublicacion;
	}
	
	

}
		
	