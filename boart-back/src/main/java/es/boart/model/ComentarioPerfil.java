package es.boart.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ComentarioPerfil  {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@ManyToOne
	private User usuario;
	private String text;
	private Timestamp fechaPublicacion;
	@ManyToOne
	private User usuarioDestino;


}