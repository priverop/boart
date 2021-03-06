package es.boart.model;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import es.boart.boartUtils;

@Entity
public class Publication {

	private final int DEFAULT_VISITS = 0;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User user;
	private String title;
	
	@Column( length = 512 )
	private String description;
	
	private String media;
	
	private int media_type;
	private Timestamp date;
	private String stringDate;
	private int num_visits;
	private int numberOfLikes;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="publication")
	private List<PublicationLike> likes = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER, mappedBy="publications") 
	private Set<Tag> tags;
	private int numberOfComments;


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
		this.numberOfLikes = 0;
		this.stringDate = "Publicado el " + new SimpleDateFormat("dd/MM/yyyy").format(date) + " a las " + new SimpleDateFormat("HH:mm").format(date);
		this.numberOfComments = comments.size();
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
	@JsonIgnore
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
	@JsonIgnore
	public String getMedia() {
		switch (media_type) {
			case 0:
				return boartUtils.getImgEmbedLeft() + media + boartUtils.getImgEmbedRight();
			case 1:
				return boartUtils.getAudioEmbedLeft() + media + boartUtils.getAudioEmbedRight();
			case 2:
				return boartUtils.getVideoEmbedLeft() + media + boartUtils.getVideoEmbedRight();
		}
		return "Error. Multimedia no encontrado";		
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
		this.stringDate = "Publicado el " + new SimpleDateFormat("dd/MM/yyyy").format(date) + " a las " + new SimpleDateFormat("HH:mm").format(date);
	}

	public String getStringDate() {
		return stringDate;
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
	@JsonIgnore
	public List<PublicationLike> getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(List<PublicationLike> likes) {
		this.likes = likes;
	}
	
	public void addLike(PublicationLike like) {
		this.likes.add(like);
		this.setNumberOfLikes(this.getNumberOfLikes() + 1);
	}
	
	public void removeLike(PublicationLike like) {
		this.likes.remove(like);
		this.setNumberOfLikes(this.getNumberOfLikes() - 1);
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
	
	@JsonIgnore
	public Set<Tag> getTags() {
		return tags;
	}

	public void setTags(Set<Tag> tags) {
		this.tags = tags;
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
	

	public int getNumberOfComments() {
		return numberOfComments;
	}

	public void setNumberOfComments(int numberOfComments) {
		this.numberOfComments = numberOfComments;
	}	
	
	/* CUSTOM METHOD */
	
	public boolean checkUserLikesThis(User user){
				
		for(PublicationLike like:this.getLikes()){
			if(like.getUser() == user){
				return true;
			}
		}
		
		return false;
	}
	
	
	
	 @JsonProperty("user")
	 public String getGalleryJSON(){
	    	return user.getUsername();
	 }
	
	 @JsonProperty("likes")
	 public List<String> getLikesJSON(){
	    	ArrayList<String> likeList = new ArrayList<String>();
	    	for (PublicationLike l : likes){
	    		likeList.add("@" + l.getUser().getUsername());
	    	}
	    	return likeList;
	 }
	
	 @JsonProperty("tags")
	 public List<String> gettagsJSON(){
	    	ArrayList<String> tagList = new ArrayList<String>();
	    	for (Tag t : tags){
	    		tagList.add(t.getTag());
	    	}
	    	return tagList;
	 }
	 
	 @JsonProperty("media")
	 public String getMediaJSON(){
		 	String aux = getMedia();
		 	aux = aux.substring(aux.indexOf("src=\"") + "src=\"".length());		 	
	    	return aux.substring(0, aux.indexOf("\""));
	 }
}
		
	