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
				"https://iso.500px.com/wp-content/uploads/2016/03/pedroquintela.jpg", 
				1));
		
		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", 
				"http://images1.fanpop.com/images/image_uploads/Photography-photography-1201911_1024_768.jpg", 
				1));
		
		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", 
				"http://wallpaperspicturesphotos.com/wp-content/uploads/2015/03/photography-images..jpg", 
				1));
		
		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", 
				"https://www.nobackgroundimages.com/wp-content/uploads/2014/12/digital-camera-349873_640.jpg", 
				1));
		
		usuario.getGallery().add(new Publication(usuario, "Titulo", "Descripcion", 
				"http://images5.fanpop.com/image/photos/31600000/Dandelion-Art-photography-31606827-2560-1706.jpg", 
				1));
		
		userRepository.save(usuario);
		
		User juan = new User("juan", "Juan", "Cuesta", "juanjuan", "ROLE_USER");
		
		juan.getComments().add(new Comment(usuario, "Váyase señor Juan!!"));
		
		userRepository.save(juan);
		
		/* PUBLICACIONES */
		Publication publication = new Publication(juan, "Holacar2acola", "Descr2ipcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1);
				
		publication.getComments().add(new Comment(usuario, "Gabri no me espies"));

		publicationRepository.save(publication);
		
		/* GRUPOS */
		groupRepository.save(new Grupo("Fotógrafos de Vallecas",
				"http://i.imgur.com/WZ9qZwH.jpg",
				"Loren ipsun dolor sit amet"));

		Tag t1 = new Tag("Tag1");
		Tag t2 = new Tag("Tag2");
		Tag t3 = new Tag("Tag3");

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
