// package es.boart.model;

// import java.sql.Timestamp;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// @Entity
// public abstract class Comentario {

// 	@Id
// 	@GeneratedValue(strategy = GenerationType.AUTO)
// 	private long id;
	
// 	private Usuario usuario;
// 	private String text;
// 	private Timestamp fechaPublicacion;
	
// 	public Comentario(Usuario usuario, String text, Timestamp fechaPublicacion) {
// 		this.usuario = usuario;
// 		this.text = text;
// 		this.fechaPublicacion = fechaPublicacion;
// 	}
	
// 	public Usuario getUsuario() {
// 		return usuario;
// 	}

// 	public void setUsuario(Usuario usuario) {
// 		this.usuario = usuario;
// 	}

// 	public String getText() {
// 		return text;
// 	}

// 	public void setText(String text) {
// 		this.text = text;
// 	}

// 	public Timestamp getFechaPublicacion() {
// 		return fechaPublicacion;
// 	}

// 	public void setFechaPublicacion(Timestamp fechaPublicacion) {
// 		this.fechaPublicacion = fechaPublicacion;
// 	}
	
	
	
// }
