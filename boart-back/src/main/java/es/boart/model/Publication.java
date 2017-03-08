package es.boart.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Publication {

	private final int DEFAULT_VISITS = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User user;
	private String title;
	private String description;
	private String media;
	private int media_type;
	private Timestamp date;
	private int num_visits;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	
	@OneToMany(mappedBy="publication")
	private List<Like> likes;

	@ManyToMany(mappedBy="publications") 
	private Set<Tag> tags;

	public Publication(){}

	/**
	 * @param user
	 * @param title
	 * @param description
	 * @param media
	 * @param media_type
	 * @param date
	 * @param num_visits
	 * @param likes
	 */
	public Publication(User author, String title, String description, String media, int media_type) {
		this.user = author;
		this.title = title;
		this.description = description;
		this.media = media;
		this.media_type = media_type;
		this.date = new Timestamp(new Date().getTime());
		this.num_visits = DEFAULT_VISITS;
		this.tags = new HashSet<>();
	}
	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUsername(User autor) {
		this.user = autor;
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
	 * @return the num_visits
	 */
	public int getNum_visits() {
		return num_visits;
	}

	/**
	 * @param num_visits the num_visits to set
	 */
	public void setNum_visits(int num_visitas) {
		this.num_visits = num_visitas;
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
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comentariosPublicacion the comentariosPublicacion to set
	 */
	public void setComments(List<Comment> comentariosPublicacion) {
		this.comments = comentariosPublicacion;
	}
	
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
	}

}
		
	