package es.boart.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class MiembroGrupo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User usuario;
	@ManyToOne
	private Grupo grupo;
	private Timestamp fechaUnion;
	
	/**
	 * @param usuario
	 * @param grupo
	 * @param fechaUnion
	 */
	public MiembroGrupo(User usuario, Grupo grupo, Timestamp fechaUnion) {
		this.usuario = usuario;
		this.grupo = grupo;
		this.fechaUnion = fechaUnion;
	}
	
	public MiembroGrupo(){}
	
	/**
	 * @return the usuario
	 */
	public User getUsuario() {
		return usuario;
	}
	/**
	 * @param usuario the usuario to set
	 */
	public void setUsuario(User usuario) {
		this.usuario = usuario;
	}
	/**
	 * @return the grupo
	 */
	public Grupo getGrupo() {
		return grupo;
	}
	/**
	 * @param grupo the grupo to set
	 */
	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}
	/**
	 * @return the fechaUnion
	 */
	public Timestamp getFechaUnion() {
		return fechaUnion;
	}
	/**
	 * @param fechaUnion the fechaUnion to set
	 */
	public void setFechaUnion(Timestamp fechaUnion) {
		this.fechaUnion = fechaUnion;
	}
	
}
