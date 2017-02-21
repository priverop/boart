package es.boart.model;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Publicacion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String autor;
	private String titulo;
	private String descripcion;
	private String media;
	private int tipo_media;
	private Timestamp fecha;
	private int num_visitas;
	
	public Publicacion(){}
	
	public Publicacion(String autor, String titulo, String descripcion, String media, int tipo_media, java.util.Date date, int num_visitas){
		this.autor = autor;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.media = media;
		this.tipo_media = tipo_media;
		this.fecha = new Timestamp(date.getTime());
		this.num_visitas = num_visitas;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMedia() {
		return media;
	}

	public void setMedia(String media) {
		this.media = media;
	}

	public int getTipo_media() {
		return tipo_media;
	}

	public void setTipo_media(short tipo_media) {
		this.tipo_media = tipo_media;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public int getNum_visitas() {
		return num_visitas;
	}

	public void setNum_visitas(int num_visitas) {
		this.num_visitas = num_visitas;
	}
	
	
}
