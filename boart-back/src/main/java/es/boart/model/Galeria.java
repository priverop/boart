// package es.boart.model;

// import java.sql.Timestamp;

// import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
// import javax.persistence.Id;

// @Entity
// public class Galeria {
	
// 	@Id
// 	@GeneratedValue(strategy = GenerationType.AUTO)
// 	private long id;
	
// 	private Usuario usuario;
// 	private Publicacion publicacion;
	
// 	public Galeria(Usuario usuario, Publicacion publicacion) {
// 		super();
// 		this.usuario = usuario;
// 		this.publicacion = publicacion;
// 	}

// 	public Usuario getUsuario() {
// 		return usuario;
// 	}

// 	public void setUsuario(Usuario usuario) {
// 		this.usuario = usuario;
// 	}

// 	public Publicacion getPublicacion() {
// 		return publicacion;
// 	}

// 	public void setPublicacion(Publicacion publicacion) {
// 		this.publicacion = publicacion;
// 	}
// }
