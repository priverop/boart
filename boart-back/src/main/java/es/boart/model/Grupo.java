package es.boart.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grupo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String title;
	private String description;
	private String img;
	@OneToMany(mappedBy="grupo")
	private List<GroupMember> groupMembers;
	
	/**
	 * @param title
	 * @param description
	 * @param img
	 */
	public Grupo(String title, String description, String img){
		this.title = title;
		this.description = description;
		this.img = img;
	}
	
	public Grupo(){}
	
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String descripcion) {
		this.description = descripcion;
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
	public void setImg(String imgPerfil) {
		this.img = imgPerfil;
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
	
	
}
