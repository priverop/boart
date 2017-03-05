package es.boart.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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
	private int visitas; 
	private int nivelSeguridad;
	private Timestamp fechaRegistro;
	private Timestamp fechaUltimoLogin;
	@OneToMany(cascade=CascadeType.ALL)
	private List<Publication> galeria = new ArrayList<>();
	@OneToMany(mappedBy="usuario")
	private List<Like> likes;
	@OneToMany(mappedBy="usuario")
	private List<MiembroGrupo> miembroGrupos;
	@OneToMany(mappedBy="usuario")
	private List<ComentarioPerfil> comentariosEscritos;
	@OneToMany(mappedBy="usuarioDestino")
	private List<ComentarioPerfil> comentariosRecibidos;
	
	/**
	 * @param username
	 * @param name
	 * @param surname
	 * @param password
	 * @param img
	 * @param visitas
	 * @param nivelSeguridad
	 * @param date
	 * @param date2
	 * @param likes
	 * @param galeria
	 */
	public User(String username, String name, String surname, String password, Boolean guest) {
		this.username = username;
		this.name = name;
		this.surname = surname;
		this.password = password;
		this.guest = guest;
		// Descripción nuevo usuario
		this.description = DEFAULT_DESCRIPTION;
		// Imagen por defecto
		this.img = DEFAULT_IMG;
		// Fecha actual
		Date date = new Date();
		
		this.fechaRegistro = new Timestamp(date.getTime());
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
	 * @return the visitas
	 */
	public int getVisitas() {
		return visitas;
	}

	/**
	 * @param visitas the visitas to set
	 */
	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}

	/**
	 * @return the nivelSeguridad
	 */
	public int getNivelSeguridad() {
		return nivelSeguridad;
	}

	/**
	 * @param nivelSeguridad the nivelSeguridad to set
	 */
	public void setNivelSeguridad(int nivelSeguridad) {
		this.nivelSeguridad = nivelSeguridad;
	}

	/**
	 * @return the fechaRegistro
	 */
	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	/**
	 * @param fechaRegistro the fechaRegistro to set
	 */
	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	/**
	 * @return the fechaUltimoLogin
	 */
	public Timestamp getFechaUltimoLogin() {
		return fechaUltimoLogin;
	}

	/**
	 * @param fechaUltimoLogin the fechaUltimoLogin to set
	 */
	public void setFechaUltimoLogin(Timestamp fechaUltimoLogin) {
		this.fechaUltimoLogin = fechaUltimoLogin;
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
	public List<MiembroGrupo> getMiembroGrupos() {
		return miembroGrupos;
	}

	/**
	 * @param miembroGrupos the miembroGrupos to set
	 */
	public void setMiembroGrupos(List<MiembroGrupo> miembroGrupos) {
		this.miembroGrupos = miembroGrupos;
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
	public List<Publication> getGaleria() {
		return galeria;
	}

	/**
	 * @param galeria the galeria to set
	 */
	public void setGaleria(List<Publication> galeria) {
		this.galeria = galeria;
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
	
	


}
