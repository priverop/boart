package es.boart;

import java.sql.Timestamp;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
		
		Date date = new Date();
		
		/* USUARIOS */
		User invitado = new User("invitado", "Guest", "Guest", "invitado", true, "ROLE_GUEST");
		
		invitado.getGallery().add(new Publication("Pepe", "Holacaracola", "Descripcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				new Timestamp(date.getTime()), 0));
				
		User usuario = new User("usuario1", "prueba", "prueba",	"pass", false, "ROLE_USER");
				
		usuario.getGallery().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"https://iso.500px.com/wp-content/uploads/2016/03/pedroquintela.jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		usuario.getGallery().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"http://images1.fanpop.com/images/image_uploads/Photography-photography-1201911_1024_768.jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		usuario.getGallery().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"http://wallpaperspicturesphotos.com/wp-content/uploads/2015/03/photography-images..jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		usuario.getGallery().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"https://www.nobackgroundimages.com/wp-content/uploads/2014/12/digital-camera-349873_640.jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		usuario.getGallery().add(new Publication("usuario1", "Titulo", "Descripcion", 
				"http://images5.fanpop.com/image/photos/31600000/Dandelion-Art-photography-31606827-2560-1706.jpg", 
				1, new Timestamp(date.getTime()), 0));
		
		userRepository.save(invitado);
		userRepository.save(usuario);
		userRepository.save(new User("juan", "Juan", "Cuesta", "juanjuan", false, "ROLE_USER"));
		
		/* PUBLICACIONES */
		publicationRepository.save(new Publication("Juan", "Holacar2acola", "Descr2ipcion1", 
				"http://wallpapermad.com/wp-content/uploads/2016/05/art-nouveau-wallpaper8.jpg", 1, 
				new Timestamp(date.getTime()), 0));
		
		/* GRUPOS */
		groupRepository.save(new Grupo("Fotógrafos de Vallecas", "Loren ipsun dolor sit amet", "https://scontent-lht6-1.xx.fbcdn.net/v/t1.0-9/16427482_1954388194577132_4182519892385252043_n.jpg?oh=798521399440066d618abe05bc535b27&oe=592DAC5D"));


		Tag t1 = new Tag("Tag1");
		Tag t2 = new Tag("Tag2");
		Tag t3 = new Tag("Tag3");

		for (Publication p : publicationRepository.findAll()) {
			if (p.getId() % 2 == 0)
				t1.getPublicaciones().add(p);
			//	p.getTags().add(t1);
			if (p.getId() % 2 == 1)
				t2.getPublicaciones().add(p);
				//p.getTags().add(t2);
			if (p.getId() % 2 == 2)
				t3.getPublicaciones().add(p);
				//p.getTags().add(t3);
		}
		
		tagRepository.save(t1);
		tagRepository.save(t2);
		tagRepository.save(t3);
	}
}
