package es.boart.model;

import java.security.acl.Group;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class User {

	private final String DEFAULT_DESCRIPTION = "¡Hola! Soy un usuario nuevo, puedes cambiar la descripción desde el perfil";
	private final String DEFAULT_IMG = "http://s3.amazonaws.com/37assets/svn/765-default-avatar.png";
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	private String name;
	private String surname;
	private String description;
	private String password;
	private String img;
	private int visits; 
	private Timestamp signInDate;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Publication> gallery = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="user")
	private List<PublicationLike> likes = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<Comment> comments = new ArrayList<>();
	
	@ManyToMany
	private List<User> following = new ArrayList<>();
	
	@ManyToMany(mappedBy="following")
	private List<User> followers = new ArrayList<>();
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<SocialNet> RRSS = new ArrayList<>();
	
	@ManyToMany(mappedBy="groupMembers")
	private List<Grupo> groups = new ArrayList<>();
	
	@OneToMany(mappedBy="user")
	private List<Publication> userPublications = new ArrayList<>();
	
	
	/**
	 * @param username
	 * @param name
	 * @param surname
	 * @param password
	 * @param roles
	 */
	public User(String username, String name, String surname, String password, String img, String... roles) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
		// Descripción nuevo usuario
		this.description = DEFAULT_DESCRIPTION;
		// Imagen por defecto
		this.img = img;
		// Fecha actual
		Date date = new Date();
		
		this.signInDate = new Timestamp(date.getTime());
	}
	/**
	 * @param username
	 * @param name
	 * @param surname
	 * @param password
	 */
	public User(String username, String name, String surname, String password) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>();
		this.roles.add("ROLE_USER");
		// Descripción nuevo usuario
		this.description = DEFAULT_DESCRIPTION;
		// Imagen por defecto
		this.img = DEFAULT_IMG;
		// Fecha actual
		Date date = new Date();
		
		this.signInDate = new Timestamp(date.getTime());
	}
	
	public User(){}

	
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
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
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * return the descripcion
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param descripcion the descripcion to set
	 */
	public void setDescription(String descripcion) {
		this.description = descripcion;
	}

	/**
	 * @return the password
	 */
	@JsonIgnore
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}

	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}

	/**
	 * @return the visits
	 */
	public int getVisits() {
		return visits;
	}

	/**
	 * @param visitas the visits to set
	 */
	public void setVisits(int visitas) {
		this.visits = visitas;
	}

	/**
	 * @return the signInDate
	 */
	public Timestamp getSignInDate() {
		return signInDate;
	}

	/**
	 * @param signInDate the signInDate to set
	 */
	public void setSignInDate(Timestamp fechaRegistro) {
		this.signInDate = fechaRegistro;
	}

	/**
	 * @return the likes
	 */
	public List<PublicationLike> getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(List<PublicationLike> likes) {
		this.likes = likes;
	}

	/**
	 * @return the comments
	 */
	@JsonIgnore
	public List<Comment> getComments() {
		return comments;
	}

	/**
	 * @param comments the comments to set
	 */
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	/**
	 * @return the galeria
	 */
	@JsonIgnore
	public List<Publication> getGallery() {
		return gallery;
	}

	/**
	 * @param galeria the galeria to set
	 */
	public void setGallery(List<Publication> galeria) {
		this.gallery = galeria;
	}
	
	/**
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	/**
	 * @return the following
	 */
	@JsonIgnore
	public List<User> getFollowing() {
		return following;
	}

	/**
	 * @return the followers
	 */
	@JsonIgnore
	public List<User> getFollowers() {
		return followers;
	}
	
	/**
	 * @return the groups
	 */
	@JsonIgnore
	public List<Grupo> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<Grupo> groups) {
		this.groups = groups;
	}
	
	/**
	 * @return the publications
	 */
	@JsonIgnore
	public List<Publication> getPublications() {
		return userPublications;
	}
	/**
	 * @param publications the publications to set
	 */
	public void setPublications(List<Publication> publications) {
		this.userPublications = publications;
	}
	/* -------------- /*
	/* CUSTOM METHODS */
	/* -------------- /*
	
	/* Followers */
	public void addFollowing(User following){
		this.following.add(following);
	}
	
	public void removeFollowing(User following){
		this.following.remove(following);
	}
	
	public void addFollower(User follower){
		this.followers.add(follower);
	}
	
	public boolean hasFollowing(User myUser){
		return this.getFollowing().contains(myUser);
	}
	
	public boolean hasFollower(User myUser){
		return this.getFollowers().contains(myUser);
	}

	/* Gallery */
	public void addGallery(Publication p){
		this.getGallery().add(p);
	}
	
	 @JsonProperty("gallery")
	 public List<String> getGalleryJSON(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	for (Publication p : gallery) list.add(p.getTitle());
	    	return list;
	 }
	 @JsonProperty("likes")
	 public List<String> getGalleryLikesJSON(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	for (PublicationLike l : likes) list.add(l.getPublication().getTitle());
	    	return list;
	 }
	 @JsonProperty("comments")
	 public List<String> getCommentsJSON(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	for (Comment c : comments) list.add("@"+ c.getUser().getUsername()+ ":" + c.getText());
	    	return list;
	 }
	 @JsonProperty("following")
	 public List<String> getFollowingJSON(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	for (User u : following) list.add("@"+ u.getUsername());
	    	return list;
	 }
	 @JsonProperty("followers")
	 public List<String> getFollowersJSON(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	for (User u : followers) list.add("@"+ u.getUsername());
	    	return list;
	 }
	 @JsonProperty("groups")
	 public List<String> getGroupsJSON(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	for (Grupo g : groups) list.add(g.getTitle());
	    	return list;
	 }
	 @JsonProperty("publications")
	 public List<String> getPublicationsJSON(){
	    	ArrayList<String> list = new ArrayList<String>();
	    	for (Publication p : userPublications) list.add(p.getTitle());
	    	return list;
	 }

}
