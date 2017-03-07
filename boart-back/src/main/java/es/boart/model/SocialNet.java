package es.boart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SocialNet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	private String media;
	private String url;
	
	/**
	 * @param media
	 * @param url
	 */
	public SocialNet(String media, String url) {
		this.media = media;
		this.url = url;
	}
	
	public SocialNet(){}

	/**
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
