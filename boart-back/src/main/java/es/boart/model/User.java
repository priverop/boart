package es.boart.model;

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
import javax.persistence.OneToMany;

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
	private Boolean guest;
	private String img;
	private int visits; 
	private Timestamp signInDate;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Publication> gallery = new ArrayList<>();
	@OneToMany(mappedBy="username")
	private List<Like> likes;
	@OneToMany(mappedBy="usuario")
	private List<GroupMember> groupMembers;
	@OneToMany(mappedBy="usuario")
	private List<ComentarioPerfil> comentariosEscritos;
	@OneToMany(mappedBy="usuarioDestino")
	private List<ComentarioPerfil> comentariosRecibidos;
	@ElementCollection(fetch = FetchType.EAGER)
	 private List<String> roles;
	@OneToMany(cascade=CascadeType.ALL)
	private List<SocialNet> RRSS = new ArrayList<>();
	
	/**
	 * @param username
	 * @param name
	 * @param surname
	 * @param password
	 * @param img
	 * @param visits
	 * @param nivelSeguridad
	 * @param date
	 * @param date2
	 * @param likes
	 * @param gallery
	 */
	public User(String username, String name, String surname, String password, Boolean guest, String... roles) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.guest = guest;
		this.roles = new ArrayList<>(Arrays.asList(roles));
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
	 * @return the miembroGrupos
	 */
	public List<GroupMember> getMiembroGrupos() {
		return groupMembers;
	}

	/**
	 * @param groupMembers the miembroGrupos to set
	 */
	public void setMiembroGrupos(List<GroupMember> groupMembers) {
		this.groupMembers = groupMembers;
	}

	/**
	 * @return the comentariosEscritos
	 */
	public List<ComentarioPerfil> getComentariosEscritos() {
		return comentariosEscritos;
	}

	/**
	 * @param comentariosEscritos the comentariosEscritos to set
	 */
	public void setComentariosEscritos(List<ComentarioPerfil> comentariosEscritos) {
		this.comentariosEscritos = comentariosEscritos;
	}

	/**
	 * @return the comentariosRecibidos
	 */
	public List<ComentarioPerfil> getComentariosRecibidos() {
		return comentariosRecibidos;
	}

	/**
	 * @param comentariosRecibidos the comentariosRecibidos to set
	 */
	public void setComentariosRecibidos(List<ComentarioPerfil> comentariosRecibidos) {
		this.comentariosRecibidos = comentariosRecibidos;
	}

	/**
	 * @return the galeria
	 */
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
	 * @return the guest
	 */
	public Boolean getGuest() {
		return guest;
	}

	/**
	 * @param guest the guest to set
	 */
	public void setGuest(Boolean guest) {
		this.guest = guest;
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



}
