package es.boart.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
	
	public Usuario(String nombreUsuario, String nombre, String apellido, String contraseña, String img, int visitas,
			int nivelSeguridad, java.util.Date date) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.contraseña = contraseña;
		this.img = img;
		this.visitas = visitas;
		this.nivelSeguridad = nivelSeguridad;
		this.fechaRegistro = new Timestamp(date.getTime());;
		this.fechaUltimoLogin = null;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getVisitas() {
		return visitas;
	}

	public void setVisitas(int visitas) {
		this.visitas = visitas;
	}

	public int getNivelSeguridad() {
		return nivelSeguridad;
	}

	public void setNivelSeguridad(int nivelSeguridad) {
		this.nivelSeguridad = nivelSeguridad;
	}

	public Timestamp getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Timestamp fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public Timestamp getFechaUltimoLogin() {
		return fechaUltimoLogin;
	}

	public void setFechaUltimoLogin(Timestamp fechaUltimoLogin) {
		this.fechaUltimoLogin = fechaUltimoLogin;
	}

}
