//package es.boart.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Gallery {
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private long id;
//	
//	@OneToOne
//	private User user;
//	
//	@OneToMany(mappedBy="gallery")
//	private List<Publication> publications = new ArrayList<>();
//
//	/**
//	 * @param user
//	 * @param publications
//	 */
//	public Gallery(User user, List<Publication> publications) {
//		this.user = user;
//		this.publications = publications;
//	}
//
//	/**
//	 * @return the id
//	 */
//	public long getId() {
//		return id;
//	}
//
//	/**
//	 * @param id the id to set
//	 */
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	/**
//	 * @return the user
//	 */
//	public User getUser() {
//		return user;
//	}
//
//	/**
//	 * @param user the user to set
//	 */
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	/**
//	 * @return the publications
//	 */
//	public List<Publication> getPublications() {
//		return publications;
//	}
//
//	/**
//	 * @param publications the publications to set
//	 */
//	public void setPublications(List<Publication> publications) {
//		this.publications = publications;
//	}
//	
//	
//
//}
