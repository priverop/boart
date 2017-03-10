package es.boart;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import es.boart.model.Comment;
import es.boart.model.Grupo;
import es.boart.model.Publication;
import es.boart.model.Tag;
import es.boart.model.User;
import es.boart.repository.GroupRepository;
import es.boart.repository.PublicationRepository;
import es.boart.repository.TagRepository;
import es.boart.repository.UserRepository;

@Controller
public class BuildBBDD {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PublicationRepository publicationRepository;
	
	@Autowired
	private GroupRepository groupRepository;
	
	@Autowired
	private TagRepository tagRepository;
	
	@PostConstruct
	public void init(){
				
		/* USUARIOS */
				
		User usuario = new User("usuario1", "prueba", "prueba",	"pass", "ROLE_USER");
				
		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", 
				boartUtils.getImgEmbedLeft() + "imgEjemplo2.jpg" + boartUtils.getImgEmbedRight(), 
				1));
		
		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", 
				boartUtils.getAudioEmbedLeft() + "113585294" + boartUtils.getAudioEmbedRight(), 
				1));
		
		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", 
				boartUtils.getVideoEmbedLeft() + "gw5LxIOsaBo" + boartUtils.getVideoEmbedRight(), 
				1));
		
		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", 
				boartUtils.getImgEmbedLeft() + "imgEjemplo4.jpg" + boartUtils.getImgEmbedRight(), 
				1));
		
		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", 
				boartUtils.getImgEmbedLeft() + "imgEjemplo3.jpg" + boartUtils.getImgEmbedRight(), 
				1));
		
		userRepository.save(usuario);
		
		User juan = new User("juan", "Juan", "Cuesta", "juanjuan", "ROLE_USER");
		
		juan.getComments().add(new Comment(usuario, "Váyase señor Juan!!"));
		
		userRepository.save(juan);
		
		/* PUBLICACIONES */
		Publication publication = new Publication(juan, "Holacar2acola", "Descr2ipcion1", 
				boartUtils.getImgEmbedLeft() + "imgEjemplo1.jpg" + boartUtils.getImgEmbedRight(), 1);
				
		publication.getComments().add(new Comment(usuario, "Gabri no me espies"));

		publicationRepository.save(publication);
		
		/* GRUPOS */
		groupRepository.save(new Grupo("Fotógrafos de Vallecas",
				"http://i.imgur.com/WZ9qZwH.jpg",
				"Loren ipsun dolor sit amet"));

		Tag t1 = new Tag("tag1");
		Tag t2 = new Tag("tag2");
		Tag t3 = new Tag("tag3");

		for (Publication p : publicationRepository.findAll()) {
			if (p.getId() % 2 == 0)
				t1.getPublications().add(p);
			//	p.getTags().add(t1);
			if (p.getId() % 2 == 1)
				t2.getPublications().add(p);
				//p.getTags().add(t2);
			if (p.getId() % 2 == 2)
				t3.getPublications().add(p);
				//p.getTags().add(t3);
		}
		
		tagRepository.save(t1);
		tagRepository.save(t2);
		tagRepository.save(t3);
	}
}
