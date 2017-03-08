package es.boart.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class GroupMember {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@ManyToOne
	private User user;
	@ManyToOne
	private Grupo group;
	private Timestamp dateIn;
	
	/**
	 * @param user
	 * @param group
	 * @param dateIn
	 */
	public GroupMember(User user, Grupo group) {
		this.user = user;
		this.group = group;
		this.dateIn = new Timestamp(new Date().getTime());
	}
	
	public GroupMember(){}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User usuario) {
		this.user = usuario;
	}
	/**
	 * @return the group
	 */
	public Grupo getGroup() {
		return group;
	}
	/**
	 * @param group the group to set
	 */
	public void setGroup(Grupo grupo) {
		this.group = grupo;
	}
	/**
	 * @return the dateIn
	 */
	public Timestamp getDateIn() {
		return dateIn;
	}
	/**
	 * @param dateIn the dateIn to set
	 */
	public void setDateIn(Timestamp fechaUnion) {
		this.dateIn = fechaUnion;
	}
	
}
