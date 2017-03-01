package es.boart.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import javax.persistence.CascadeType;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String username;
	private String nombre;
	private String apellido;
	private String descripcion;
	private String password;
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
	 * @param nombreUsuario
	 * @param nombre
	 * @param apellido
	 * @param contraseña
	 * @param img
	 * @param visitas
	 * @param nivelSeguridad
	 * @param date
	 * @param date2
	 * @param likes
	 * @param galeria
	 */
	public User(String nombreUsuario, String nombre, String apellido, String descripcion, String contraseña, String img, 
			int visitas, int nivelSeguridad, Timestamp fechaRegistro, Timestamp fechaLogin) {
		this.username = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.descripcion = descripcion;
		this.password = contraseña;
		this.img = img;
		this.visitas = visitas;
		this.nivelSeguridad = nivelSeguridad;
		this.fechaRegistro = fechaRegistro;
		this.fechaUltimoLogin = fechaLogin;
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
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return username;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.username = nombreUsuario;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	/**
	 * return the descripcion
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
	 * @return the contraseña
	 */
	public String getContraseña() {
		return password;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.password = contraseña;
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


}
