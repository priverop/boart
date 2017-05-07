package es.boart.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import es.boart.UserComponent;
import es.boart.model.Grupo;
import es.boart.model.Publication;
import es.boart.model.Tag;
import es.boart.repository.TagRepository;

@Service
public class UploadService {
	private final static String IMG_PATH 					= "src/main/resources/static/img/";
	private final String SOUNDCLOUD_EMBED_URL 		= "http://soundcloud.com/oembed?format=json&url=https://soundcloud.com/";
	private final String SOUNDCLOUD_IFRAME_PARAM 	= "&iframe=true";
	private final int IMAGE_TYPE = 0;
	private final int AUDIO_TYPE = 1;
	private final int VIDEO_TYPE = 2;
	@Autowired
	private TagRepository tagRepository;

	@Autowired
	private PublicationService publicationService;
	@Autowired
	private UserComponent userSession;
	@Autowired
	private GroupService groupService;

	public String prepareMedia(int mediaType, Object media) throws MalformedURLException{
		switch(mediaType){
			case IMAGE_TYPE:
				return prepareImage((MultipartFile) media); // Return Media Param to embed the image content
			case AUDIO_TYPE:				
				return prepareAudio((String) media); // Return Media Param to embed the audio content
			case VIDEO_TYPE:
				return (String) media;
		}
		return null;
	}
	
	
	public long upload(String title,String description,String tags, String type,Long idGroup, Object media) throws IOException {		
		String mediaStr = prepareMedia(getMediaType(type), media);
		if (mediaStr == null)
			return -1;
		Publication publication = new Publication(userSession.getUser(), title, description, mediaStr, getMediaType(type));
		publicationService.save(publication);		
		// If any group is checked it will have the publication added
		if(idGroup != null && idGroup != 0){
			Grupo selectedGroup = groupService.findOne(idGroup);
			selectedGroup.addPublication(publication);
			groupService.save(selectedGroup);
		}
		// Split and Save each Tag if not exist
		manageTags(tags, publication);
		return publication.getId();
	}
	
	 private int getMediaType(String type){
	    	
	    	int mediaType = IMAGE_TYPE;
	    	
	    	switch(type){
	    		case "img":
	    			mediaType = IMAGE_TYPE;
				break;
	    		case "audio":
	    			mediaType = AUDIO_TYPE;
				break;
	    		case "video":
	    			mediaType = VIDEO_TYPE;
	    		break;
	    	}	    	
	    	return mediaType;
	    }
	    
		public String prepareImage(MultipartFile file){
			Path rootLocation = Paths.get(IMG_PATH);
			String media = Long.toString(System.currentTimeMillis()) + "-" + file.getOriginalFilename();
			try{
				Files.copy(file.getInputStream(), rootLocation.resolve(media));
			}
			catch(Exception e){
				System.out.println("Error copying image file to: "+rootLocation.resolve(media));
				media = null;
			}			
			return media;
		}
		
		private String prepareAudio(String audio) throws MalformedURLException{
			URL url = new URL(SOUNDCLOUD_EMBED_URL+ audio +SOUNDCLOUD_IFRAME_PARAM); // SoundCloud Webservice Call to get the ID
			StringBuffer sb = new StringBuffer();
			
			try (BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), "UTF-8"))) {
			    for (String line; (line = reader.readLine()) != null;) {
			        sb.append(line);
			    }
			}			
			catch(Exception e){
				System.out.println("Error reading SoundCloud URL.");
			}
			
			String media = sb.toString(); //Óscar: Hay que ver si consigo que el JSON devuelve el iframe como quiero para coger el iframe de el directametne
			media = media.substring(media.indexOf("tracks%2F") + "tracks%2F".length(), media.indexOf("\\u0026show_artwork"));
			
			return media;
		}
		
	    private void manageTags(String tags, Publication publication){
	    	for (String s : tags.split(",")) {
				s = s.toLowerCase().trim();
				if (!s.equals(""))
				saveTag(s, publication);
			}
	    	
	    }
	    
	    private void saveTag(String clean_tag, Publication publication){
	    	Tag tag = tagRepository.findByTag(clean_tag);
			if (tag == null) tag = new Tag(clean_tag);
			publication.getTags().add(tag);
			tag.addPublication(publication);
			tagRepository.save(tag);
	    }


}
