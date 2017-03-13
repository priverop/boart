package es.boart.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import es.boart.UserComponent;
import es.boart.model.Grupo;
import es.boart.model.Publication;
import es.boart.model.Tag;
import es.boart.repository.GroupRepository;
import es.boart.repository.PublicationRepository;
import es.boart.repository.TagRepository;
import es.boart.repository.UserRepository;

@Controller
public class UploadController {
	
	private final String IMG_PATH 					= "src/main/resources/static/img/";
	private final String SOUNDCLOUD_EMBED_URL 		= "http://soundcloud.com/oembed?format=json&url=https://soundcloud.com/";
	private final String SOUNDCLOUD_IFRAME_PARAM 	= "&iframe=true";
	private final int IMAGE_TYPE = 0;
	private final int AUDIO_TYPE = 1;
	private final int VIDEO_TYPE = 2;

	@Autowired
	private PublicationRepository publicacionRepository;
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private UserComponent userSession;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private GroupRepository groupRepository;

	@RequestMapping("/upload")
	public String upload_front(Model modelo, HttpSession session, HttpServletRequest request) {
		
		modelo.addAttribute("sesion_usuario", userSession.getUser());
		modelo.addAttribute("user_groups", userRepository.findOne(userSession.getUser().getId()).getGroups());
		
		CsrfToken token = (CsrfToken) request.getAttribute("_csrf");
		modelo.addAttribute("token", token.getToken());
		
		return "upload_template";
	}

	@PostMapping("/upload")
	public String upload(@RequestParam(value="file", required=false) MultipartFile file, @RequestParam("titulo") String title,
			@RequestParam("descripcion") String description, @RequestParam("etiquetas") String tags,
			@RequestParam("optionsRadios") String type, @RequestParam(value="idGroup", required=false) Long idGroup, @RequestParam(value="audio", required=false) String audio, 
			@RequestParam(value="video",required=false) String video) throws IOException {
				
		int mediaType = getMediaType(type);
		String media = "";
		
		switch(mediaType){
		
			case IMAGE_TYPE:
				media = prepareImage(file, type); // Return Media Param to embed the image content
			break;
			
			case AUDIO_TYPE:
				URL url = new URL(SOUNDCLOUD_EMBED_URL+ audio +SOUNDCLOUD_IFRAME_PARAM); // SoundCloud Webservice Call to get the ID
				media = prepareAudio(file, type, url); // Return Media Param to embed the audio content
			break;
			
			case VIDEO_TYPE:
				media = video;
			break;
			
		}
		
		Publication publication = new Publication(userSession.getUser(), title, description, media, mediaType);
		publicacionRepository.save(publication);
		
		// If any group is checked it will have the publication added
		if(idGroup != null){
			System.out.println("Grupo seleccionado: "+idGroup);
			Grupo selectedGroup = groupRepository.findOne(idGroup);
			selectedGroup.addPublication(publication);
			groupRepository.save(selectedGroup);
		}

		// Split and Save each Tag if not exist
		manageTags(tags, publication);

		return "redirect:/publication/"+publication.getId();
	}
	
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws MalformedURLException {
    	
    	Path location = Paths.get(IMG_PATH + filename);
        Resource file = new UrlResource(location.toUri());
                
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+(file).getFilename()+"\"")
                .body(file);
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
    
	private String prepareImage(MultipartFile file, String type){
		
		Path rootLocation = Paths.get(IMG_PATH);
		
		String media = Long.toString(System.currentTimeMillis()) + "-" + file.getOriginalFilename();
		
		try{
			Files.copy(file.getInputStream(), rootLocation.resolve(media));
		}
		catch(Exception e){
			System.out.println("Error copying image file to: "+rootLocation.resolve(media));
		}
		
		return media;
	}
	
	private String prepareAudio(MultipartFile file, String type, URL url){
		
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
    	
    	for (String s : tags.split("\n")) {
			s = s.toLowerCase().trim();
			saveTag(s, publication);
		}
    	
    }
    
    private void saveTag(String clean_tag, Publication publication){
    	Tag tag = tagRepository.findByTag(clean_tag);
		if (tag == null) tag = new Tag(clean_tag);
		tag.addPublication(publication);
		tagRepository.save(tag);
    }

}
