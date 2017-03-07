package es.boart.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Publication {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	private String title;
	private String description;
	private String media;
	private int media_type;
	private Timestamp date;
	private int num_visitas;
	@OneToMany(mappedBy="publication")
	private List<Like> likes;
	private int numberOfLikes;
	@OneToMany(mappedBy="publicationDestiny")
	private List<PublicationComment> comentariosPublicacion;
	
	@ManyToMany(mappedBy="publicaciones")
	private Set<Tag> tags;
	
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

	public Publication(){}

	/**
	 * @param username
	 * @param title
	 * @param description
	 * @param media
	 * @param media_type
	 * @param date
	 * @param num_visitas
	 * @param likes
	 */
	public Publication(String autor, String titulo, String descripcion, String media, int tipo_media, Timestamp fecha,
			int num_visitas) {
		this.username = autor;
		this.title = titulo;
		this.description = descripcion;
		this.media = media;
		this.media_type = tipo_media;
		this.date = fecha;
		this.num_visitas = num_visitas;
		this.tags = new HashSet<>();
		this.numberOfLikes = 0;
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String autor) {
		this.username = autor;
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
	public void setTitle(String titulo) {
		this.title = titulo;
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
	 * @return the media_type
	 */
	public int getMedia_type() {
		return media_type;
	}

	/**
	 * @param media_type the media_type to set
	 */
	public void setMedia_type(int tipo_media) {
		this.media_type = tipo_media;
	}

	/**
	 * @return the date
	 */
	public Timestamp getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Timestamp fecha) {
		this.date = fecha;
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
	
	public void addLike(Like like) {
		this.likes.add(like);
		this.setNumberOfLikes(this.getNumberOfLikes() + 1);
	}
	
	public void removeLike(Like like) {
		this.likes.remove(like);
		this.setNumberOfLikes(this.getNumberOfLikes() - 1);
	}

	/**
	 * @return the comentariosPublicacion
	 */
	public List<PublicationComment> getComentariosPublicacion() {
		return comentariosPublicacion;
	}

	/**
	 * @param comentariosPublicacion the comentariosPublicacion to set
	 */
	public void setComentariosPublicacion(List<PublicationComment> comentariosPublicacion) {
		this.comentariosPublicacion = comentariosPublicacion;
	}

	/**
	 * @return the numberOfLikes
	 */
	public int getNumberOfLikes() {
		return numberOfLikes;
	}

	/**
	 * @param numberOfLikes the numberOfLikes to set
	 */
	public void setNumberOfLikes(int numberOfLikes) {
		this.numberOfLikes = numberOfLikes;
	}

}
		
	