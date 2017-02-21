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
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String nombreUsuario;
	private String nombre;
	private String apellido;
	private String contraseña;
	private String img;
	private int visitas; 
	private int nivelSeguridad;
	private Timestamp fechaRegistro;
	private Timestamp fechaUltimoLogin;
	@OneToMany(mappedBy="usuario")
	@OrderColumn
	private List<Like> likes;
	@OneToMany(mappedBy="usuario")
	@OrderColumn
	private List<MiembroGrupo> miembroGrupos;
	@OneToMany(mappedBy="usuario")
	@OrderColumn
	private List<ComentarioPerfil> comentariosEscritos;
	@OneToMany(mappedBy="usuarioDestino")
	@OrderColumn
	private List<ComentarioPerfil> comentariosRecibidos;
	
	/**
	 * @param nombreUsuario
	 * @param nombre
	 * @param apellido
	 * @param contraseña
	 * @param img
	 * @param visitas
	 * @param nivelSeguridad
	 * @param fechaRegistro
	 * @param fechaUltimoLogin
	 * @param likes
	 */
	public Usuario(String nombreUsuario, String nombre, String apellido, String contraseña, String img, int visitas,
			int nivelSeguridad, Timestamp fechaRegistro, Timestamp fechaUltimoLogin) {
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.img = img;
		this.visitas = visitas;
		this.nivelSeguridad = nivelSeguridad;
		this.fechaRegistro = fechaRegistro;
		this.fechaUltimoLogin = fechaUltimoLogin;
	}

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
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
	 * @return the contraseña
	 */
	public String getContraseña() {
		return contraseña;
	}

	/**
	 * @param contraseña the contraseña to set
	 */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
	
	

}
